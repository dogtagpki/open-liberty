/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.cxf.rt.security.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Level; // Liberty Change
import java.util.logging.Logger;

import javax.security.auth.callback.CallbackHandler;

import org.apache.cxf.common.classloader.ClassLoaderUtils;
import org.apache.cxf.common.classloader.ClassLoaderUtils.ClassLoaderHolder;
import org.apache.cxf.common.logging.LogUtils;
import org.apache.cxf.common.util.PropertyUtils;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.PhaseInterceptorChain;
import org.apache.cxf.resource.ResourceManager;

import com.ibm.websphere.ras.annotation.Trivial; // Liberty Change


/**
 * Some common functionality
 */
public final class SecurityUtils {
    private static final Logger LOG = LogUtils.getL7dLogger(SecurityUtils.class);
    private static boolean doDebug = LOG.isLoggable(Level.FINE); // Liberty Change

    private SecurityUtils() {
        // complete
    }

    public static CallbackHandler getCallbackHandler(Object o) throws InstantiationException,
        IllegalAccessException, ClassNotFoundException {
        CallbackHandler handler = null;
        if (o instanceof CallbackHandler) {
		    // Liberty Change Start
            if (doDebug) {
                LOG.fine("CallbackHandler type object is in use!");
            }
            // Liberty Change End
            handler = (CallbackHandler)o;
        } else if (o instanceof String) {
		    // Liberty Change Start
            if (doDebug) {
                LOG.fine("cbh is a string, need to load the class!");
            }
            // Liberty Change End
            handler = (CallbackHandler)ClassLoaderUtils.loadClass((String)o,
                                                                  SecurityUtils.class).newInstance();
        }
        return handler;
    }
    @Trivial // Liberty Change
    public static URL getConfigFileURL(Message message, String configFileKey, String configFileDefault) {
        LOG.entering("SecurityUtils.getConfigFileURL", "message, configFileKey, configFileDefault"); // Liberty Change
        Object o = message.getContextualProperty(configFileKey);
        if (o == null) {
            o = configFileDefault;
        }
        LOG.exiting("SecurityUtils.getConfigFileURL", "message, configFileKey, configFileDefault"); // Liberty Change

        return loadResource(message, o);
    }

    public static URL loadResource(Object o) {
        return loadResource((Message)null, o);
    }

    @Trivial // Liberty Change
    public static URL loadResource(Message message, Object o) {
        LOG.entering("SecurityUtils.loadResource", "message, Object"); // Liberty Change
        Message msg = message;
        if (msg == null) {
            msg = PhaseInterceptorChain.getCurrentMessage();
        }
        ResourceManager manager = null;
        if (msg != null && msg.getExchange() != null && msg.getExchange().getBus() != null) {
            manager = msg.getExchange().getBus().getExtension(ResourceManager.class);
        }
        LOG.exiting("SecurityUtils.loadResource", "Message, Object"); // Liberty Change
        return loadResource(manager, o);
    }

    public static URL loadResource(ResourceManager manager, Object o) {

        if (o instanceof String) {
            URL url = ClassLoaderUtils.getResource((String)o, SecurityUtils.class);
            if (url != null) {
                return url;
            }
            ClassLoaderHolder orig = null;
            try {
                if (manager != null) {
                    ClassLoader loader = manager.resolveResource((String)o, ClassLoader.class);
                    if (loader != null) {
                        orig = ClassLoaderUtils.setThreadContextClassloader(loader);
                    }
                    url = manager.resolveResource((String)o, URL.class);
                }
                if (url == null) {
                    try {
                        url = new URL((String)o);
                    } catch (IOException e) {
                        // Do nothing
                    }
                }
                if (url == null) {
                    try {
                        URI propResourceUri = URI.create((String)o);
                        if (propResourceUri.getScheme() != null) {
                            url = propResourceUri.toURL();
                        } else {
                            File f = new File(propResourceUri.toString());
                            if (f.exists()) {
                                url = f.toURI().toURL();
                            }
                        }
                    } catch (IOException ex) {
                        // Do nothing
                    }
                }
                return url;
            } finally {
                if (orig != null) {
                    orig.reset();
                }
            }
        } else if (o instanceof URL) {
            return (URL)o;
        }
        return null;
    }

    public static Properties loadProperties(Object o) {
        return loadProperties(null, o);
    }

    public static Properties loadProperties(ResourceManager manager, Object o) {
        if (o instanceof Properties) {
            return (Properties)o;
        }

        URL url = null;
        if (o instanceof String) {
            url = SecurityUtils.loadResource(manager, o);
        } else if (o instanceof URL) {
            url = (URL)o;
        }

        if (url != null) {
            Properties properties = new Properties();
            try {
                InputStream ins = url.openStream();
                properties.load(ins);
                ins.close();
            } catch (IOException e) {
                LOG.fine(e.getMessage());
                properties = null;
            }
            return properties;
        }

        return null;
    }

    /**
     * Get the security property value for the given property. It also checks for the older "ws-"* property
     * values.
     */
    @Trivial // Liberty Change
    public static Object getSecurityPropertyValue(String property, Message message) {
        LOG.entering("SecurityUtils.getSecurityPropertyValue", property); // Liberty Change
        Object value = message.getContextualProperty(property);
        if (value != null) {
            return value;
        }
        LOG.exiting("SecurityUtils.getSecurityPropertyValue", "String, Message"); // Liberty Change
        return message.getContextualProperty("ws-" + property);
    }

    /**
     * Get the security property boolean for the given property. It also checks for the older "ws-"* property
     * values. If none is configured, then the defaultValue parameter is returned.
     */
    @Trivial // Liberty Change
    public static boolean getSecurityPropertyBoolean(String property, Message message, boolean defaultValue) {
        LOG.entering("SecurityUtils.getSecurityPropertyBoolean", property); // Liberty Change
        Object value = getSecurityPropertyValue(property, message);

        if (value != null) {
            LOG.exiting("SecurityUtils.getSecurityPropertyBoolean", "String, Message, boolean"); // Liberty Change
            return PropertyUtils.isTrue(value);
        }
        LOG.exiting("SecurityUtils.getSecurityPropertyBoolean", "String, Message, boolean"); // Liberty Change
        return defaultValue;
    }
}
