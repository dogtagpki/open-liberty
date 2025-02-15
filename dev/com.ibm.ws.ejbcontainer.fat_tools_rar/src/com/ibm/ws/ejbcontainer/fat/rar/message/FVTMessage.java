/*******************************************************************************
 * Copyright (c) 2013, 2021 IBM Corporation and others.
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

package com.ibm.ws.ejbcontainer.fat.rar.message;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Logger;

import com.ibm.ws.ejbcontainer.fat.rar.core.FVTXAResourceImpl;

/**
 * <p>An object of this class represents an FVT specific message. This instance can be used
 * to send different combinations of messages to one more endpoint applications. Also,
 * via this object, test applications can also set the test result object for different
 * endpoint instance. Refer to the example 3 for how to set multiple test results for
 * one endpoint instance.</p>
 *
 * <p>Several examples of how to use this FVTMessage object are provided as below. </p>
 *
 * <p>The first example is sending a simple message to an endpoint application. Firstly,
 * a FVTMessage object is constructed, and then method addTestResult is called to add
 * a test result for the default instance. After the test result is added to the endpoint
 * instance, a message "message1" is added to the FVTMessage object. Then we call
 * sendMessage() to send the message to the endpoint instance. After the message delivery
 * is completed, the users can call getEndpints() of messageProvider and then call
 * getTestResult() to get the test result for validation. </p>
 *
 * <pre>
 * String deliveryId = "delivery 1";
 *
 * FVTMessage message = new FVTMessage();
 *
 * message.addTestResult("FVTEndpoint1");
 * message.addMessage("FVTEndpoint1", "message1");
 *
 * messageProvider.sendMessage(deliveryId, message, null);
 *
 * Hashtable endpoints = messageProvider.getEndpoints();
 *
 * [iterate the endpoints Hashtable] {
 * // get the test result
 * endpoint.getTestResult();
 *
 * // Validate the test result.
 * }
 * </pre>
 *
 * <p>Here is another example of how to use this object to send an option A transacted
 * message to an endpoint application. In this example, the message deliveries are
 * transacted message deliveries because the endpoint application with name "FVTEndpoint1"
 * is configured with transaction attribute "Required". Firstly, a test result is added to
 * the endpoint instance 1 and then the message1 is delivered to endpoint instance
 * 1. After that, a test result is added to another endpoint instance 2 of the same
 * endpoint factory and then the message2 is delivered to the endpoint instance 2 .
 * At last, a new test result is added to the endpoint instance 1, the same instance
 * to which message1 is delivered and then the message3 is delivered to the endpoint
 * instance 1.</p>
 *
 * <p>After the message is delivered, the test applications can get the endpoints and then
 * get test results from the endpoints for validation.</p>
 *
 * <pre>
 * String deliveryId = "delivery 2";
 *
 * FVTMessage message = new FVTMessage();
 *
 * message.addTestResult("FVTEndpoint1", 1);
 * message.add("FVTEndpoint1", "message1", 1);
 *
 * message.addTestResult("FVTEndpoint1", 2);
 * message.add("FVTEndpoint1", "message2", 2);
 *
 * message.addTestResult("FVTEndpoint1", 1);
 * message.add("FVTEndpoint1", "message3", 1);
 *
 * messageProvider.sendMessage(deliveryId, message, null);
 *
 * Hashtable endpoints = messageProvider.getEndpoints();
 *
 * // get the endpoint 1 instance.
 * // get the test result
 * MessageEndpointTestResult result1 = endpoint1.getTestResult(1);
 * MessageEndpointTestResult result2 = endpoint1.getTestResult(2);
 *
 * // Validate the test result.
 * </pre>
 *
 *
 * <p>Here is another example of how to use this object to send an option B transacted
 * message to an endpoint application. In this example, the message delivery is option
 * B transacted message delivery. Firstly, a test result is added to the object. Secondly,
 * a beforeDelivery is called. Thirdly, a message is delivered to the endpoint application.
 * Fourthly, the afterDelivery is called to finish the delivery. At last, a release call
 * will be called to this endpoint instance. Also , we provide an XAResource object for
 * this delivery.</p>
 *
 * <pre>
 * String deliveryId = "delivery 2";
 *
 * FVTMessage message = new FVTMessage();
 * message.addTestResult("FVTEndpoint1", 1);
 * message.add("FVTEndpoint1", FVTMessage.BEFORE_DELIVERY, method);
 * message.add("FVTEndpoint1", "message1", 1);
 * message.add("FVTEndpoint1", FVTMessage.AFTER_DELIVERY, methodName);
 *
 * message.addRelease("FVTEndpoint1", 1);
 *
 * FVTXAResourceImpl xaResource = new FVTXAResourceImpl();
 * message.addXAResource("FVTEndpoint1", 1, xaResource);
 *
 * messageProvider.sendMessage(deliveryId, message, null);
 * </pre>
 *
 * <p>The other way to send an option B transacted message to an endpoint application is
 * use method addOptionBDelivery. Here is the example which uses method addOptionBDelivery
 * to achieve the same purpose as in the last example. <p>
 *
 * <pre>
 * String deliveryId = "delivery 2";
 *
 * FVTMessage message = new FVTMessage();
 * message.addTestResult("FVTEndpoint1", 1);
 * message.addOptionBDelivery("FVTEndpoint1", method, 1);
 *
 * message.addRelease("FVTEndpoint1", 1);
 *
 * FVTXAResourceImpl xaResource = new FVTXAResourceImpl();
 * message.addXAResource("FVTEndpoint1", 1, xaResource);
 *
 * messageProvider.sendMessage(deliveryId, message, null);
 * </pre>
 *
 * <p>Notice that the order of add method calls is important. The message firstly added
 * to the FVTMessage object is the message firstly being delivered.</p>
 *
 * <p>There are some restrictions about the name of the endpoint. The endpoint name
 * should not be one of the following:</p>
 * <OL>
 * <LI>beforeDelivery</li>
 * <LI>afterDelivery</li>
 * <LI>release</LI>
 * <LI>TestResult</LI>
 * </OL>
 */
public class FVTMessage {
    private final static String CLASSNAME = FVTMessage.class.getName();
    private final static Logger svLogger = Logger.getLogger(CLASSNAME);

    public static final int BEFORE_DELIVERY = 0;
    public static final int AFTER_DELIVERY = 1;

    public static final String RELEASE_STRING = "release",
                    BEFORE_DELIVERY_STRING = "beforeDelivery",
                    AFTER_DELIVERY_STRING = "afterDelivery",
                    TEST_RESULT_STRING = "TestResult";

    /** The vector storing all the messages */
    private final Vector messages;

    /** The hashmap which stores the FVTXAResourceImpl objects */
    private final HashMap resources;

    /** reserved words which should not be used as endpoint name */
    private static final String[] reservedWords = { "beforeDelivery", "afterDelivery", "TestResult", "release" };

    /**
     * Constructor
     */
    public FVTMessage() {
        messages = new Vector(5);
        resources = new HashMap(3);
        svLogger.entering(CLASSNAME, "<init>", this);
    }

    /**
     * <p>Add a message which is sent to the endpoint application with default instanceID
     * 0.</p>
     *
     * @param endpointName the name of the endpoint application
     * @param message the message going to be sent to the endpoint application
     */
    public void add(String endpointName, String message) {
        add(endpointName, message, null);
    }

    /**
     * <p>Add a message which is sent to the endpoint application with an instanceID.</p>
     *
     * @param endpointName the name of the endpoint application
     * @param message the message going to be sent to the endpoint application
     * @param instanceID the instance ID of the endpoint application
     */
    public void add(String endpointName, String message, int instanceID) {
        add(endpointName, message, null, instanceID);
    }

    /**
     * <p>Add a message which is sent to the endpoint application with default instanceID
     * 0.</p>
     *
     * @param endpointName the name of the endpoint application
     * @param message the message going to be sent to the endpoint application
     * @param m the target method this message is supposed to send to. If m is set to
     *            null, the message will be delivered to onMessage method.
     */
    public void add(String endpointName, String message, Method m) {
        svLogger.entering(CLASSNAME, "add", new Object[] { this, endpointName, message, m });
        checkEndpointName(endpointName);
        messages.add(endpointName + ":" + message + ":0");
        messages.add(m);
        svLogger.exiting(CLASSNAME, "add");
    }

    /**
     * <p>Add a message which is sent to the endpoint application with an instanceID.</p>
     *
     * @param endpointName the name of the endpoint application
     * @param message the message going to be sent to the endpoint application
     * @param instanceID the instance ID of the endpoint application
     * @param m the target method this message is supposed to send to. If m is set to
     *            null, the message will be delivered to onMessage method.
     */
    public void add(String endpointName, String message, Method m, int instanceID) {
        svLogger.entering(CLASSNAME, "add", new Object[] { this, endpointName, message, m, new Integer(instanceID) });

        if (instanceID < 1) {
            throw new MessageException("instance number can only be a positive number");
        }

        checkEndpointName(endpointName);

        messages.add(endpointName + ":" + message + ":" + instanceID);
        messages.add(m);
    }

    /**
     * <p>Add a transaction option B delivery call to the message array. This delivery
     * call will be called to the default instance 0.</p>
     *
     * @param endpointName the name of the endpoint application
     * @param deliveryMethod either FVTMessage.BEFORE_DELIVERY or FVTMessage.AFTER_DELIVERY.
     *            If you want to add a "beforeDelivery" call to the endpoint instance, use
     *            FVTMessage.BEFORE_DELIVERY; If you want to add an "afterDelivery" call to the
     *            endpoint instance, use FVTMessage.AFTER_DELIVERY.
     * @param method name for beforeDelivery method. If you add an "afterDelivery" call,
     *            this parameter will be ignored.
     */
    public void addDelivery(String endpointName, int deliveryMethod, Method method) {

        addDelivery(endpointName, deliveryMethod, method, 0);
    }

    /**
     * <p>Add a transaction option B delivery call to the message array.</p>
     *
     * @param endpointName the name of the endpoint application
     * @param deliveryMethod either FVTMessage.BEFORE_DELIVERY or FVTMessage.AFTER_DELIVERY.
     *            If you want to add a "beforeDelivery" call to the endpoint instance, use
     *            FVTMessage.BEFORE_DELIVERY; If you want to add an "afterDelivery" call to the
     *            endpoint instance, use FVTMessage.AFTER_DELIVERY.
     * @param method name for beforeDelivery method. If you add an "afterDelivery" call,
     *            this parameter will be ignored.
     * @param instanceID the instance ID of the endpoint application
     */
    public void addDelivery(String endpointName, int deliveryMethod, Method method, int instanceID) {
        svLogger.entering(CLASSNAME, "addDelivery", new Object[] { this, endpointName, new Integer(deliveryMethod), method, new Integer(instanceID) });
        checkEndpointName(endpointName);

        if (instanceID < 0) {
            svLogger.exiting(CLASSNAME, "addDelivery", "MessageException -- instance ID " + instanceID + "is not a positive number");
            throw new MessageException("instance number can only be a non-positive number");
        }

        switch (deliveryMethod) {
            case BEFORE_DELIVERY:
                messages.add(BEFORE_DELIVERY_STRING + ":" + endpointName + ":" + instanceID);
                messages.add(method);
                break;
            case AFTER_DELIVERY:
                messages.add(AFTER_DELIVERY_STRING + ":" + endpointName + ":" + instanceID);
                break;
            default:
                svLogger.exiting(CLASSNAME, "addDelivery", "Exception");
                throw new MessageException("The only permitted values are FVTMessage.BEFORE_DELIVERY and FVTMessage.BEFORE_DELIVERY");
        }

        svLogger.exiting(CLASSNAME, "addDelivery");
    }

    /**
     * <p>Add a release call to the default endpoint instance 0.</p>
     *
     * @param endpointName Endpoint name.
     */
    public void addRelease(String endpointName) {
        addRelease(endpointName, 0);
    }

    /**
     * <p>Add a release call to the specified endpoint instance.</p>
     *
     * @param endpointName Endpoint name.
     * @param instanceID the instance ID of the endpoint application
     */
    public void addRelease(String endpointName, int instanceID) {
        svLogger.entering(CLASSNAME, "addRelease", new Object[] { this, endpointName, new Integer(instanceID) });
        checkEndpointName(endpointName);

        if (instanceID < 0) {
            svLogger.exiting(CLASSNAME, "addRelease", "MessageException -- instance ID " + instanceID + "is not a positive number");
            throw new MessageException("instance number can only be a non-positive number");
        }

        messages.add("release:" + endpointName + ":" + instanceID);
        svLogger.exiting(CLASSNAME, "addRelease");
    }

    /**
     * <p>Add an option B transacted delivery call to the default endpoint instance 0. </p>
     *
     * <p>Users can use this method to send an option B transacted delivery to achieve
     * the same goal as using methods addDelivery and addMessage.</p>
     *
     * @param endpointName Endpoint name.
     * @param message the message going to be sent to the endpoint application
     * @param method name for beforeDelivery method. If you add an "afterDelivery" call,
     *            this parameter will be ignored.
     */
    public void addOptionBDelivery(String endpointName, String message, Method method) {
        addOptionBDelivery(endpointName, message, method, 0);
    }

    /**
     * <p>Add an option B transacted delivery call to a specific endpoint instance. </p>
     *
     * <p>Users can use this method to send an option B transacted delivery to achieve
     * the same goal as using methods addDelivery and addMessage.</p>
     *
     * @param endpointName Endpoint name.
     * @param method name for beforeDelivery method. If you add an "afterDelivery" call,
     *            this parameter will be ignored.
     * @param message the message going to be sent to the endpoint application
     * @param instanceID the instance ID of the endpoint application
     */
    public void addOptionBDelivery(String endpointName, String message, Method method, int instanceID) {
        svLogger.entering(CLASSNAME, "addOptionBDelivery", new Object[] { this, endpointName, message, method, new Integer(instanceID) });
        checkEndpointName(endpointName);

        if (instanceID < 0) {
            svLogger.exiting(CLASSNAME, "addTestResult", "MessageException -- instance ID " + instanceID + "is not a positive number");
            throw new MessageException("instance number can only be a non-positive number");
        }

        addDelivery(endpointName, FVTMessage.BEFORE_DELIVERY, method, instanceID);

        if (instanceID == 0) { // d174742
            add(endpointName, message, method);
        } else {
            add(endpointName, message, method, instanceID);
        }

        addDelivery(endpointName, FVTMessage.AFTER_DELIVERY, null, instanceID);
        svLogger.exiting(CLASSNAME, "addOptionBDelivery");
    }

    /**
     * <p>Add a test result to the default endpoint instance 0.</p>
     *
     * @param endpointName Endpoint name.
     */
    public void addTestResult(String endpointName) {
        addTestResult(endpointName, 0);
    }

    /**
     * <p>Add a test result to a specific endpoint instance.</p>
     *
     * @param endpointName Endpoint name.
     * @param instanceID the instance ID of the endpoint application
     */
    public void addTestResult(String endpointName, int instanceID) {
        svLogger.entering(CLASSNAME, "addTestResult", new Object[] { this, endpointName, new Integer(instanceID) });
        checkEndpointName(endpointName);

        if (instanceID < 0) {
            svLogger.exiting(CLASSNAME, "addTestResult", "MessageException -- instance ID " + instanceID + "is not a positive number");
            throw new MessageException("instance number can only be a non-positive number");
        }

        messages.add("TestResult:" + endpointName + ":" + instanceID);
        svLogger.exiting(CLASSNAME, "addTestResult");
    }

    /**
     * <p>Add an FVTXAResource object to the message object.</p>
     *
     * <p>Users can add a customized FVTXAResourceImpl object to the message object for a
     * particular endpoint instance. This FVTXAResourceImpl object will be used for transacted
     * delivery. If they don't add an FVTXAResourceImpl object for a particular transacted
     * message delivery, test resource adapter will treat it as null. </p>
     *
     * <p>Adding an FVTXAResourceImpl object to the message object has the following
     * advantages. Firstly, users can force a particular method, such as prepare() to
     * sleep for a while to test the crash recovery. Secondly, users can force
     * some methods to throw an XAException. Lastly, after the message delivery is
     * completed, users can call getExecutionPath() of FVTXAResourceImpl to get the
     * execution path of the FVTXAResource object. An execution path is a string
     * which has the information of which methods of FVTXAResourceImpl are called and in
     * which order. For more details, please refer to the JavaDoc of <code>FVTXAResourceImpl</code>
     * class.</p>
     *
     * @param endpointName the name of the endpoint application
     * @param instaceID the instance ID of the endpoint application
     * @param resource the object of FVTXAResource
     */
    public void addXAResource(String endpointName, int instanceID, FVTXAResourceImpl resource) {
        checkEndpointName(endpointName);
        resources.put(endpointName + instanceID, resource);
    }

    /**
     * <p>Add an FVTXAResource object to the message object. This FVTXAResource is used
     * for the default endpoint instance 0.</p>
     *
     * <p>Users can add a customized FVTXAResourceImpl object to the message object for a
     * particular endpoint instance. This FVTXAResourceImpl object will be used for transacted
     * delivery. If they don't add an FVTXAResourceImpl object for a particular transacted
     * message delivery, test resource adapter will treat it as null. </p>
     *
     * <p>Adding an FVTXAResourceImpl object to the message object has the following
     * advantages. Firstly, users can force a particular method, such as prepare() to
     * sleep for a while to test the crash recovery. Secondly, users can force
     * some methods to throw an XAException. Lastly, after the message delivery is
     * completed, users can call getExecutionPath() of FVTXAResourceImpl to get the
     * execution path of the FVTXAResource object. An execution path is a string
     * which has the information of which methods of FVTXAResourceImpl are called and in
     * which order. For more details, please refer to the JavaDoc of <code>FVTXAResourceImpl</code>
     * class.</p>
     *
     * @param endpointName the name of the endpoint application
     * @param resource the object of FVTXAResource
     */
    public void addXAResource(String endpointName, FVTXAResourceImpl resource) {
        checkEndpointName(endpointName);
        resources.put(endpointName + "0", resource);
    }

    /**
     * <p>Check whether the endpoint name is null or empty string. If it is, thrown an
     * MessageException.</p>
     *
     * @param endpointName the name of the endpoint application
     */
    private void checkEndpointName(String endpointName) throws MessageException {
        if (endpointName == null || endpointName.equals("") || endpointName.trim().equals("")) {
            throw new MessageException("Endpoint name cannot be null or an empty string");
        }

        for (int i = 0; i < reservedWords.length; i++) {
            if (endpointName.equals(reservedWords[i]))
                throw new MessageException("Endpoint name cannot be one of the following: "
                                           + "beforeDelivery, afterDelivery, release, TestResult.");
        }
    }

    /**
     * Get the message array.
     *
     * @return the message array
     */
    public Vector getMessages() {
        return messages;
    }

    /**
     * Returns the resources.
     *
     * @return HashMap
     */
    public HashMap getResources() {
        return resources;
    }

    /**
     * toString method.
     */
    public String introspectSelf() {
        String lineSeparator = System.getProperty("line.separator");

        StringBuffer str = new StringBuffer("Message:" + lineSeparator);
        for (int i = 0; i < messages.size(); i++) {
            str.append(messages.elementAt(i) + lineSeparator);
        }
        str.append(lineSeparator + "XA resources:" + lineSeparator);

        Collection factories = resources.entrySet();
        if (factories != null) {
            for (Iterator iter = factories.iterator(); iter.hasNext();) {
                Map.Entry map = (Map.Entry) iter.next();
                String iKey = (String) map.getKey();
                FVTXAResourceImpl resource = (FVTXAResourceImpl) map.getValue();
                str.append(iKey + ":" + resource + lineSeparator);
            }
        }

        return str.toString();
    }
}