/*******************************************************************************
 * Copyright (c) 2021 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ws.jpa.tests.spec10.query;

import componenttest.rules.repeater.JakartaEE9Action;
import componenttest.rules.repeater.RepeatTestAction;

/**
 *
 */
public class RepeatWithJPA30 extends JakartaEE9Action implements RepeatTestAction {
    public static final String ID = "JPA30";

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "JPA 3.0";
    }

    @Override
    public void setup() throws Exception {
        super.setup();
        FATSuite.repeatPhase = "jpa30-cfg.xml";
    }

//    // Overriding this method will disable Jakarta EE9 transformer
//    @Override
//    public String getID() {
//        return ID;
//    }
}
