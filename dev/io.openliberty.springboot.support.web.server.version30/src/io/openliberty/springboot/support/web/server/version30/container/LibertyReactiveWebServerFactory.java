/*******************************************************************************
 * Copyright (c) 2023 IBM Corporation and others.
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
package io.openliberty.springboot.support.web.server.version30.container;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.reactive.server.AbstractReactiveWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ServletHttpHandlerAdapter;

import com.ibm.ws.springboot.support.web.server.initializer.ServerConfigurationFactory;

import jakarta.servlet.ServletRegistration;

@ConfigurationProperties(prefix = "server.liberty", ignoreUnknownFields = true)
public class LibertyReactiveWebServerFactory extends AbstractReactiveWebServerFactory implements ApplicationContextAware, LibertyFactoryBase {
    private boolean useDefaultHost = true;
    private ApplicationContext context;

    @Override
    public WebServer getWebServer(HttpHandler httpHandler) {
        String springVersion = SpringBootVersion.getVersion();
        if (springVersion != null) {
            // min <= v < max
            ServerConfigurationFactory.checkSpringBootVersion("3.0.0", "4.0.0", springVersion);
        }
        ServletContextInitializer[] initializers = { (c) -> {
            ServletHttpHandlerAdapter servlet = new ServletHttpHandlerAdapter(httpHandler);
            ServletRegistration.Dynamic registration = c.addServlet("http-handler-adapter", servlet);
            registration.setLoadOnStartup(1);
            registration.addMapping("/");
            registration.setAsyncSupported(true);
        } };
        return new LibertyWebServer(this, this, initializers);
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
    }

    String getApplicationID() {
        return context.getId();
    }

    public void setUseDefaultHost(boolean useDefaultHost) {
        this.useDefaultHost = useDefaultHost;
    }

    @Override
    public boolean shouldUseDefaultHost(LibertyWebServer container) {
        // only use default host if configured to and
        // we can acquire the default host
        return useDefaultHost && acquireDefaultHost(container);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.ibm.ws.springboot.support.web.server.version20.container.LibertyFactoryBase#getContextPath()
     */
    @Override
    public String getContextPath() {
        return "/";
    }
}
