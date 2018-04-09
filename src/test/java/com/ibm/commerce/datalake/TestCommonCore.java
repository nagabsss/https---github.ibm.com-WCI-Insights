package com.ibm.commerce.datalake;

import com.ibm.commerce.datalake.common_core.env.EnvironmentVariable;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Created by nagabhushan on 28/03/18.
 */
public class TestCommonCore {

	@Test
	public void verifyEnvProperties() throws Exception {
		boolean checkForNonExistBooleanValue = EnvironmentVariable.getBooleanValue("SampleTest", false);
		Integer checkForNonExistIntValue = EnvironmentVariable.getIntegerValue("SampleTest", -1);
		String envVariableValue = EnvironmentVariable.getStringValue("SampleTest", "newValue");

		Assert.assertTrue(!checkForNonExistBooleanValue);
		Assert.assertTrue(checkForNonExistIntValue == -1);
		Assert.assertSame(envVariableValue, "newValue", "newValue");


	}

}
