/*******************************************************************************
 * Copyright (c) 2012 IBM Corporation and others.
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
package com.ibm.ws.sib.msgstore.gbs;

/**
 * This is the comparator that is used when we want to find the first
 * record in the index whose value is exactly equal to the
 * supplied key.
 *
 * @author Stewart L. Palmer
 */

class SearchComparatorEQ extends SearchComparator
{

  SearchComparatorEQ(
    java.util.Comparator   comparator)
  { super(comparator); }

  public int compare(
    Object     o1,
    Object     o2)
  {
    int result = super.internalCompare(o1, o2);
    return result;
  }

  public int type()
  { return SearchComparator.EQ; }

}
