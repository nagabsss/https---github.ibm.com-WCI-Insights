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

import org.apache.commons.lang3.StringUtils;

public class StringUtil {

	/**
     * Throw IllegalArgumentException if the argument is blank (null, empty, all white space)
     * @param str The argument to test
     * @param message A message used to construct the IllegalArgumentException when the test argument is null
     * @return The tested argument
     */
    public static String requireNonBlank(String str, String message){
        if(StringUtils.isBlank(str)){
            throw new IllegalArgumentException(message);
        }
        return str;
    }

    /**
	 * @param value The value to convert to string
	 * @return If value is null return null, else return the string representation
	 */
	public static String getStringValue (Object value) {
		return (value == null ? null : String.valueOf(value));
	}


    /**
     * Convert the input string to camelCase.
     * @param str The string to convert
     * @param leadingCapital true if the leading character should be capitalized, false for lower case.
     * @param delims The delimiting characters.  May be empty/null.
     * @return The converted string
     */
    public static String toCamelCase(final String str, final boolean leadingCapital, char...delims) {
        String result = null;

        if(str != null){
            final StringBuilder sb = new StringBuilder(str);

            if(leadingCapital && (delims == null || delims.length == 0)){
                // Optimize the special case where there are no delimiters, and we just want the first letter capitalized
                sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
            } else {

                if(delims == null){
                    delims = new char[]{};
                }

                boolean toLower = !leadingCapital;
                for(int i=0; i < sb.length(); i++){
                    final char currentChar = sb.charAt(i);

                    boolean isDelimiter = false;
                    for(int x=0; x < delims.length && !isDelimiter; x++){
                        isDelimiter = (currentChar == delims[x]);
                    }

                    if(isDelimiter){
                        toLower = false;    // Character following '.' is upper case
                        sb.deleteCharAt(i); // Remove the '.'
                        i--;                // Compensate for removed '.'
                    } else if(toLower){
                        sb.setCharAt(i, Character.toLowerCase(currentChar));
                    } else {
                        sb.setCharAt(i, Character.toUpperCase(currentChar));
                        toLower = true;
                    }
                }
            }

            result = sb.toString();
        }

        return result;
    }
}
