package com.api.automation.configuration;

import com.intuit.karate.junit5.Karate;
import com.intuit.karate.junit5.Karate.Test;

public class TestConfigRunner {
	
//	@Test
//	public Karate runTest() {
//		return Karate.run("getGlobalConfig","createJobEntry","getRequest").relativeTo(getClass());
//	}

	@Test
	public Karate runTestGlobalConfig() {
		return Karate.run("getGlobalConfig").relativeTo(getClass());
	}
	
}
