/*******************************************************************************
 * IBM Confidential
 * OCO Source Materials
 * 5725-S87, 5725-W69
 * © Copyright IBM Corp. 2017
 * The source code for this program is not published or otherwise
 * divested of its trade secrets, irrespective of what has been
 * deposited with the U.S. Copyright Office.
 *******************************************************************************/
package com.ibm.commerce.datalake.common_core.exception;

/**
 * WCIRuntimeException
 * 
 */
public class WCIRuntimeException extends RuntimeException
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WCIRuntimeException()
    {
        super();
    }

    public WCIRuntimeException(String reason)
    {
        super(reason);
    }

    public WCIRuntimeException(Throwable cause)
    {
        super(cause);
    }

    public WCIRuntimeException(String reason, Throwable cause)
    {
        super(reason, cause);
    }
}
