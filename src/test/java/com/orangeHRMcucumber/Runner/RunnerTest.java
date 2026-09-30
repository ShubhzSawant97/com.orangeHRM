package com.orangeHRMcucumber.Runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = "src/test/resources/Feature",
		glue = {"com.orangeHRMcucumber"},
		dryRun = false ,
		// tags = "@test",
		monochrome = false,
		plugin = {"pretty", 
        "html:target/cucumber-report.html",
        "json:target/cucumber.json"}
		)

public class RunnerTest extends AbstractTestNGCucumberTests {
	@Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}