package com.webtest.testCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

@Listeners(com.webtest.freemarker.GenerateReporter.class)
public class test1 extends BaseTest{

	@Test
	public void test111() {
		Assert.assertEquals(1, 2);
	}

}
