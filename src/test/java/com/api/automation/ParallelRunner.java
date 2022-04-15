package com.api.automation;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParallelRunner {

    @Test
    public void executeKarateTests() {
//		Runner at top level package will run all nested .feature files
        Results parallelRun = Runner.parallel(getClass(), 5);

        // Builder send as a parameter to Runner with 'classpath' and count of threads
//		Builder aRunner = new Builder();
//		aRunner.path("classpath:com/api/automation");
//		aRunner.path("classpath:com/api/automation/getrequest");
//		aRunner.parallel(5);
//      Results parallel = Runner.parallel(aRunner);

        Assertions.assertEquals(0, parallelRun.getFailCount(), "There are failed scenarios");
    }

}
