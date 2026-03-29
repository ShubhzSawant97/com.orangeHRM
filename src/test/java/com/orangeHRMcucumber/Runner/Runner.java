package com.orangeHRMcucumber.Runner;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = "src/test/resources/Feature",
		glue = {"com.orangeHRMcucumber"},
		dryRun = false ,
		tags = "@test",
		monochrome = false,
		plugin = {"pretty", 
        "html:target/cucumber-report.html",
        "json:target/cucumber.json"}
		)

public class Runner extends AbstractTestNGCucumberTests {
	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}