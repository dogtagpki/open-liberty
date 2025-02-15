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
package jsp.with.el;

import java.util.concurrent.atomic.AtomicInteger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Named;

@ApplicationScoped
@Named("asb")
public class ApplicationScopeBean {
    private static AtomicInteger constructCount = new AtomicInteger();

    public ApplicationScopeBean() {
        constructCount.incrementAndGet();
    }

    public void observeInit(@Observes @Initialized(ApplicationScoped.class) Object event) {
        System.out.println(getClass() + ": " + "Initializing application context");
    }

    public String getMessage() {
        String message = "ASB - TEST - " + constructCount.get();
        System.out.println(message);
        return message;
    }
}
