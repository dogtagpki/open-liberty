/*******************************************************************************
 * Copyright (c) 2019 IBM Corporation and others.
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
package com.ibm.ws.jaxws.ejbinwar.ejb;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.jws.WebService;

@WebService(serviceName = "SayHelloSingletonService",
            portName = "SayHelloSingletonPort")
@Singleton
@Startup
public class SayHelloSingletonBean implements SayHelloLocal {
    @EJB(name = "ejb/singletondef/stateless", beanName = "SayHelloBean")
    SayHelloLocal stateless;

    /*
     * (non-Javadoc)
     *
     * @see com.ibm.ws.jaxws.ejbinwar.ejb.SayHelloLocal#invokeOther()
     */
    @Override
    public String invokeOther() {
        return stateless.sayHello("StatelessSessionBeanClient");
    }

    /*
     * (non-Javadoc)
     *
     * @see com.ibm.ws.jaxws.ejbinwar.ejb.SayHelloLocal#sayHello(java.lang.String)
     */
    @Override
    public String sayHello(String name) {
        return "Hello, " + name + " from " + getClass().getSimpleName();
    }

}
