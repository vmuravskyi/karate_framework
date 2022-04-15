package com.api.automation;

import com.intuit.karate.Runner;
import com.intuit.karate.Runner.Builder;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ParallelRunnerWithTags {

    private static final String CLASS_PATH = "classpath:";
    private static final String DELIMITER = ",";

    @Test
    public void executeKarateTests() {
        Builder aRunner = new Builder();
        // getting location and tags as properties through maven command
        aRunner.path(getLocation());
        aRunner.tags(getTags());

        // hardcoded properties
        // aRunner.path("classpath:com/api/automation");
        // aRunner.tags("@crud");

        aRunner.parallel(5);
        Runner.parallel(aRunner);
    }

    // Step 1 - Provide the values for location and tags property. All the values will be separate by ","
    // Read the values , split them using the "," and create a list out of it.

	/*private List<String> getTags() {
		String aTags = System.getProperty("tags", "@Confidence");
		List<String> aTagList = Arrays.asList(aTags);
		return aTagList;
	}

	private List<String> getLocation() {
		String aLocation = System.getProperty("location", "com/api/automation");
		List<String> aLocationList = Arrays.asList(CLASS_PATH + aLocation);
		return aLocationList;
	} */

    private List<String> getTags() {
        String aTags = System.getProperty("tags", "@crud");
        List<String> aTagList = Collections.emptyList();
        // First check for the delimiter (,)
        // if the aTags has the delimiter then split the string using the delimiter
        // And create the list out of it
        // if aTags does not have delimiter, the use the old logic
        if (aTags.contains(DELIMITER)) {
            String[] tagArray = aTags.split(DELIMITER);
            aTagList = Arrays.asList(tagArray);
            return aTagList;
        }
        aTagList = List.of(aTags);
        return aTagList;
    }

    private List<String> getLocation() {
        String aLocation = System.getProperty("location", "com/api/automation");
        List<String> aLocationList;
        if (aLocation.contains(DELIMITER)) {
            String[] locationArray = aLocation.split(DELIMITER);
            aLocationList = Arrays.asList(locationArray);
            aLocationList.replaceAll((entry) -> CLASS_PATH + entry);
            return aLocationList;
        }
        aLocationList = List.of(CLASS_PATH + aLocation);
        return aLocationList;
    }

}
