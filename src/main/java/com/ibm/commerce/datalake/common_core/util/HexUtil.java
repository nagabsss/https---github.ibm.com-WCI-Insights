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

/**
 * Utility for converting to/from hexadecimal
 * 
 * @author mkeefe
 *
 */
public class HexUtil {

    private HexUtil() {

    }

    public static byte[] bytesToHex(byte[] bytes) {
        int length = 0;
        if (bytes == null || (length = bytes.length) == 0) {
            throw new IllegalArgumentException("Argument must be non-null and non-empty");
        }

        final byte[] hex = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        byte[] characters = new byte[length * 2];
        int charIdx = 0;
        for (int i = 0; i < length; i++) {
            byte b = bytes[i];
            characters[charIdx++] = hex[(b & 0xF0) >> 4];
            characters[charIdx++] = hex[(b & 0x0F)];
        }

        return characters;
    }

    public static byte[] hexToBytes(String hex) {
        int length = 0;

        if (hex == null || (length = hex.length()) == 0 || length % 2 != 0) {
            throw new IllegalArgumentException("Argument must be non-null and even-length");
        }

        byte[] bytes = new byte[length / 2];

        int bIdx = 0;
        for (int i = 0; i < length; i += 2) {
            bytes[bIdx++] = (byte) (((Character.digit(hex.charAt(i), 16)) << 4) + Character.digit(hex.charAt(i + 1), 16));
        }

        return bytes;
    }
}
