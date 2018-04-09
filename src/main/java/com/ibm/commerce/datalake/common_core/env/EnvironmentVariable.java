package com.ibm.commerce.datalake.common_core.env;


public class EnvironmentVariable {

    public static String checkForEmptyValueInEnvVariables(String configuredValue, String environmentVariable) {
        String modifiedValue = null;

        if (configuredValue != null) {
            modifiedValue = configuredValue.trim();
            if ((modifiedValue != null) && (modifiedValue.length() > 0)) {
                return modifiedValue;
            }
        }

        return null;
    }

    public static boolean checkForIntegerValue(String configuredValue, String environmentVariable) {
        String modifiedValue = null;
        Long valueCheck = 0L;
        boolean integerValue = false;

        try {
            if (configuredValue != null) {
                modifiedValue = configuredValue.trim();
                if ((modifiedValue != null ) && (modifiedValue.length() > 0)) {
                    valueCheck = Long.parseLong(configuredValue);
                    integerValue = true;
                }
            }
        } catch(Exception genExp) {
            integerValue = false;
            throw genExp;
        }

        return integerValue;
    }



    /**
     * Get an environment variable as a Boolean.
     * 
     * @param defaultValue
     * @return The value of the variable as a Boolean
     */
    public static Boolean getBooleanValue(String envVariable, Boolean defaultValue) {
        Boolean result = defaultValue;
        String value = System.getenv(envVariable);
        if (value != null) {
            result = Boolean.valueOf(value);
        }
        return result;
    }

    /**
     * Get an environment variable as an Integer.
     *
     * @param defaultValue
     * @return The value of the variable as an Integer
     */
    public static Integer getIntegerValue(String envVariable, Integer defaultValue) {
        Integer result = defaultValue;
        String value = System.getenv(envVariable);
        if (value != null) {
            result = Integer.valueOf(value);
        }
        return result;
    }

    /**
     * Get an environment variable as an Long.
     *
     * @param defaultValue
     * @return The value of the variable as an Integer
     */
    public static Long getLongValue(String envVariable, Long defaultValue) {
        Long result = defaultValue;
        String value = System.getenv(envVariable);
        if (value != null) {
            result = Long.valueOf(value);
        }
        return result;
    }

    /**
     * Get an environment variable as a String.
     * 
     * @param defaultValue
     * @return The value of the variable as a String
     */
    public static String getStringValue(String envVariable, String defaultValue) {
        String value = System.getenv(envVariable);
        if (value == null) {
            value = defaultValue;
        }
        return value;
    }

}
