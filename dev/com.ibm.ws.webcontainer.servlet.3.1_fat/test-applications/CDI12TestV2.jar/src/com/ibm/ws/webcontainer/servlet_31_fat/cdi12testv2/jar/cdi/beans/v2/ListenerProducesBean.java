/*******************************************************************************
 * Copyright (c) 2015 IBM Corporation and others.
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
package com.ibm.ws.webcontainer.servlet_31_fat.cdi12testv2.jar.cdi.beans.v2;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

/**
 * CDI Testing: Listener produces bean.
 */
@ApplicationScoped
public class ListenerProducesBean extends CDIProducesBean implements Serializable {
    //
    private static final long serialVersionUID = 1L;

    //

    @Produces
    @ListenerProducesType
    String getProducesText() {
        return super.basicGetProducesText();
    }

    public void doDispose(@Disposes @ListenerProducesType String producesText) {
        super.basicDispose(producesText);
    }
}
