package com.testData.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/testData/stepDefs",
        dryRun = false,
        tags = "",
        plugin = {"pretty", "html:target/uiReport.html","rerun:target/uiFailedTests.txt"},
        publish = true
)

public class Runner {

}
