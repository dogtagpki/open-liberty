/*******************************************************************************
 * Copyright (c) 2019, 2021 IBM Corporation and others.
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
package com.ibm.ws.jaxrs.fat.restmetrics;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

/**
 * <code>RestMetricsApplication</code> is a {@link javax.ws.rs.core.Application} subclass which contains configuration information for the JAX-RS application.
 * Any JAX-RS resources or providers that are to be used must be returned in
 * either the {@link #getClasses()} or {@link #getSingletons()} methods. Note
 * that providers are always singletons according to the JavaDoc.
 */
public class RestMetricsApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(MetricsTestMonitorFilter.class);
        classes.add(RestMetricsResource.class);
        classes.add(MetricsCheckedExceptionMapper.class);
        classes.add(MetricsUncheckedExceptionMapper.class);
        return classes;
    }

}
