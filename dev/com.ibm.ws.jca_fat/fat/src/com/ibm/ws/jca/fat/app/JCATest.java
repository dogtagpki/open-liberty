/*******************************************************************************
 * Copyright (c) 2011, 2023 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ws.jca.fat.app;

import java.io.File;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.exporter.ZipExporter;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.ResourceAdapterArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.ibm.websphere.simplicity.ShrinkHelper;
import com.ibm.websphere.simplicity.config.JavaPermission;
import com.ibm.websphere.simplicity.config.ServerConfiguration;
import com.ibm.ws.jca.fat.FATSuite;

import componenttest.annotation.AllowedFFDC;
import componenttest.custom.junit.runner.FATRunner;
import componenttest.rules.repeater.JakartaEE10Action;
import componenttest.rules.repeater.JakartaEE9Action;
import componenttest.topology.impl.LibertyServer;
import componenttest.topology.utils.FATServletClient;

/**
 * General tests that don't involve updating configuration while the server is running.
 */
@RunWith(FATRunner.class)
public class JCATest extends FATServletClient {

    private static final String fvtapp = "fvtapp";
    private static final String fvtweb = "fvtweb";

    public static LibertyServer server;

    private void runTest() throws Exception {
        runTest(server, fvtweb, getTestMethodSimpleName());
    }

    private void runTest(String testName) throws Exception {
        runTest(server, fvtweb, testName);
    }

    @BeforeClass
    public static void setUp() throws Exception {
        server = FATSuite.getServer();

        // Build jars that will be in the RAR
        JavaArchive JCAFAT1_jar = ShrinkWrap.create(JavaArchive.class, "JCAFAT1.jar");
        JCAFAT1_jar.addPackage("fat.jca.resourceadapter.jar1");

        JavaArchive JCAFAT2_jar = ShrinkWrap.create(JavaArchive.class, "JCAFAT2.jar");
        JCAFAT2_jar.addPackage("fat.jca.resourceadapter.jar2");
        JCAFAT2_jar.add(JCAFAT1_jar, "/", ZipExporter.class);

        // Build the resource adapter
        ResourceAdapterArchive JCAFAT1_rar = ShrinkWrap.create(ResourceAdapterArchive.class, "JCAFAT1.rar");
        JCAFAT1_rar.as(JavaArchive.class).addPackage("fat.jca.resourceadapter");
        JCAFAT1_rar.addAsManifestResource(new File("test-resourceadapters/fvt-resourceadapter/resources/META-INF/ra.xml"));
        JCAFAT1_rar.addAsLibrary(JCAFAT2_jar);
        ShrinkHelper.exportToServer(server, "connectors", JCAFAT1_rar);

        // Build the web module and application
        WebArchive fvtweb_war = ShrinkWrap.create(WebArchive.class, fvtweb + ".war");
        fvtweb_war.addPackage("web");
        fvtweb_war.addPackage("web.mdb");
        fvtweb_war.addPackage("web.mdb.bindings");
        fvtweb_war.addAsWebInfResource(new File("test-applications/fvtweb/resources/WEB-INF/ibm-ejb-jar-bnd.xml"));
        fvtweb_war.addAsWebInfResource(new File("test-applications/fvtweb/resources/WEB-INF/ibm-web-bnd.xml"));
        fvtweb_war.addAsWebInfResource(new File("test-applications/fvtweb/resources/WEB-INF/web.xml"));

        EnterpriseArchive fvtapp_ear = ShrinkWrap.create(EnterpriseArchive.class, fvtapp + ".ear");
        fvtapp_ear.addAsModule(fvtweb_war);
        ShrinkHelper.addDirectory(fvtapp_ear, "lib/LibertyFATTestFiles/fvtapp");
        ShrinkHelper.exportAppToServer(server, fvtapp_ear);

        if (JakartaEE9Action.isActive() || JakartaEE10Action.isActive()) {
            /*
             * Need to update the destination type of the topic to ensure it matches the Jakarta FQN.
             */
            ServerConfiguration clone = server.getServerConfiguration().clone();
            clone.getJMSActivationSpecs().getById("FVTMessageDrivenBeanBindingOverride").getProperties_FAT1().get(0).setDestinationType("jakarta.jms.Topic");

            for (JavaPermission perm : clone.getJavaPermissions()) {
                if (perm.getSignedBy() != null && perm.getSignedBy().startsWith("javax.resource.spi")) {
                    perm.setSignedBy(perm.getSignedBy().replace("javax.", "jakarta."));
                }
                if (perm.getName() != null && perm.getName().startsWith("javax.resource.spi")) {
                    perm.setName(perm.getName().replace("javax.", "jakarta."));
                }
            }

            server.updateServerConfiguration(clone);
        }

        server.startServer();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        server.stopServer("CWWKE0701E.*com.ibm.ws.jca.resourceAdapter.properties", // occurs when Derby shutdown on FVTResourceAdapter.stop holds up deactivate for too long
                          "CWWKE0700W.*com.ibm.ws.jca.resourceAdapter.properties", // occurs when Derby shutdown on FVTResourceAdapter.stop holds up deactivate for too long
                          "WTRN0062E", //expected by testEnableSharingForDirectLookupsFalse
                          "J2CA0030E", //expected by testEnableSharingForDirectLookupsFalse
                          "J2CA0074E.*cf6"); //expected by testEnableSharingForDirectLookupsFalse
    }

    @Test
    public void testActivationSpec() throws Exception {
        runTest();
    }

    @Test
    public void testActivationSpecBindings() throws Exception {
        runTest();
    }

    @Test
    public void testDestinations() throws Exception {
        runTest();
    }

    @Test
    public void testLoginModuleInJarInJarInRar() throws Exception {
        runTest();
    }

    @Test
    public void testLoginModuleInJarInRar() throws Exception {
        runTest();
    }

    /**
     * Test calls runInServlet method twice because this test is related
     * to a defect where forgetting to close a connection caused an error
     * in a future transaction.
     */
    @Test
    public void testMissingCloseInServlet() throws Exception {
        runTest();
        runTest();
    }

    @AllowedFFDC({
                   "java.lang.IllegalStateException", // test intentionally uses multiple one-phase resources in order to verify lack of sharing
                   "javax.resource.ResourceException" // reported with chained IllegalStateException for multiple one-phase resources
    })
    @Test
    public void testEnableSharingForDirectLookupsFalse() throws Exception {
        runTest();
    }

    /**
     * Save an unsharable JMS connection handle from one servlet method for use in another.
     * With HandleList disabled, this should be possible.
     */
    @Test
    public void testSaveUnsharableConnectionForLater_HandleListDisabled() throws Exception {
        runTest("testSaveUnsharableConnectionForLater_HandleListDisabled");
        runTest("testUseUnsharableConnectionFromPreviousRequest_HandleListDisabled");
    }

    /**
     * Save an unsharable JMS connection handle from one servlet method for use in another.
     * With HandleList enabled, the connection should be closed automatically by the container,
     * preventing usage within the second servlet request.
     */
    @Test
    public void testSaveUnsharableConnectionForLater_HandleListEnabled() throws Exception {
        runTest("testSaveUnsharableConnectionForLater_HandleListEnabled");
        runTest("testUseUnsharableConnectionFromPreviousRequest_HandleListEnabled");
    }
}
