package com.api.automation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.intuit.karate.Results;
import com.intuit.karate.Runner.Builder;

public class ParallelBuilder {
	
	@Test
	public void executeKarateTest() {
		Builder aRunner = new Builder();
//		aRunner.path("classpath:com/api/automation");
		aRunner.path("classpath:com/api/automation/getrequest");
		Results result = aRunner.parallel(5);
		// print results
		System.out.println("Total Feature => " + result.getFeatureCount());
		System.out.println("Total Scenarios => " + result.getScenarioCount());
		System.out.println("Passed Scenarios => " + result.getPassCount());
		
		Assertions.assertEquals(0, result.getFailCount(), "There are Failed Scenarios ");
		
	}

}
