/*******************************************************************************
 * Copyright (c) 2017, 2022 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ws.transaction.test;

import org.junit.ClassRule;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.testcontainers.containers.JdbcDatabaseContainer;

import com.ibm.ws.transaction.test.tests.DupXidTest;
import com.ibm.ws.transaction.test.tests.Simple2PCCloudTest;

import componenttest.rules.repeater.FeatureReplacementAction;
import componenttest.rules.repeater.RepeatTests;
import componenttest.topology.database.container.DatabaseContainerType;

@RunWith(Suite.class)
@SuiteClasses({
                DupXidTest.class,
                Simple2PCCloudTest.class,
})
public class FATSuite {
    @ClassRule
    public static RepeatTests r = RepeatTests.withoutModification()
                    .andWith(FeatureReplacementAction.EE8_FEATURES().fullFATOnly())
                    .andWith(FeatureReplacementAction.EE9_FEATURES().fullFATOnly())
                    .andWith(FeatureReplacementAction.EE10_FEATURES().fullFATOnly());

    public static DatabaseContainerType type = DatabaseContainerType.Derby; // Default container type
    public static JdbcDatabaseContainer<?> testContainer;

    public static void beforeSuite() throws Exception {
    }

    public static void afterSuite() throws Exception {
    }
}
