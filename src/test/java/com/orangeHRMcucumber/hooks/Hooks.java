package com.orangeHRMcucumber.hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.orangeHRMcucumber.Base.Base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	private Base base;

	public Hooks(Base base) {
		this.base = base;
	}

	@Before
	public void setUp() {
		base.init();
		Base.getDriver().get("https://opensource-demo.orangehrmlive.com/");
		Base.getDriver().manage().window().maximize();
	}

	@After
	public void quit(Scenario scenario) {	
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) base.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot,"image/png", "Failed_Screenshot_"+scenario.getName());
		}
		base.tearDown();
	}

}
