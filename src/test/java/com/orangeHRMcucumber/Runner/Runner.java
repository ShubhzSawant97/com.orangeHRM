package com.orangeHRMcucumber.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Feature",
		glue = {"com.orangeHRMcucumber"},
		dryRun = false ,
		tags = "@smoke",
		monochrome = false,
		plugin = {"pretty", 
        "html:target/cucumber-report.html",
        "json:target/cucumber.json"}
		)

public class Runner {

}