/*******************************************************************************
 * IBM Confidential
 * OCO Source Materials
 * 5725-S87, 5725-W69
 * © Copyright IBM Corp. 2017
 * The source code for this program is not published or otherwise
 * divested of its trade secrets, irrespective of what has been
 * deposited with the U.S. Copyright Office.
 *******************************************************************************/
package com.ibm.commerce.datalake.common_core.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Custom collectors
 *
 */
public class CollectorsUtil {

    /**
     * Return a memory-efficient List Collector of the specified initial size.
     * This avoids unnecessary ArrayList resizing that may occur when using the
     * default SDK toList collector. For small Lists, it avoids wasting memory
     * that would otherwise not be used due to an over-sized List initial
     * capacity. It is specifically intended for cases where the size of the
     * final list is known in advance.
     * 
     * Note that if a collection operation increases the size of the List beyond
     * the specified size then you will still suffer an ArrayList resize
     * operations. However, starting with a larger initial capacity can still
     * help to mitigate these issues.
     * 
     * @param size
     *            The initial size of the underlying list.
     * @return A collector backed by a List of the specified initial capacity.
     */
    public static <T, C> Collector<T, ?, List<T>> toList(final int size) {
        return Collectors.toCollection(() -> new ArrayList<T>(size));
    }

    /**
     * A List Collector that uses a LinkedList implementation. Useful in cases
     * where it is desirable to avoid resizing of an ArrayList.
     * 
     * @return A collector backed by a LinkedList
     */
    public static <T, C> Collector<T, ?, List<T>> toLinkedList() {
        return Collectors.toCollection(() -> new LinkedList<T>());
    }

}
