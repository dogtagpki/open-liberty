/*******************************************************************************
 * Copyright (c) 2006, 2018 IBM Corporation and others.
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

package com.ibm.ws.ejbcontainer.injection.xml.ejbx;

/**
 * Basic Stateful Bean implementation for testing EJB Injection via XML
 **/
public class SFBean3 {
    private static final String CLASS_NAME = SFBean3.class.getName();

    /**
     * Verify injected EJB is a local interface
     **/
    public boolean isLocal() {
        return true;
    }

    /**
     * Verify injected EJB is a remote interface
     **/
    public boolean isRemote() {
        return true;
    }

    /**
     * Verify injected EJB is a field-level injection
     **/
    public boolean isFieldLevel() {
        return true;
    }

    /**
     * Verify injected EJB is a method-level injection
     **/
    public boolean isMethodLevel() {
        return true;
    }

    /**
     * Verify injected EJB is the expected bean
     **/
    public String getBeanName() {
        return CLASS_NAME;
    }

    public SFBean3() {
        // intentionally blank
    }
}
