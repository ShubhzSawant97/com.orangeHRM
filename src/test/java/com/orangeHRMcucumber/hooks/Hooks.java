package com.orangeHRMcucumber.hooks;

import com.orangeHRMcucumber.Base.Base;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	private Base base;

	public Hooks(Base base) {
		this.base = base;
	}

	@Before
	public void setUp() {
		base.init();
		base.getDriver().get("https://opensource-demo.orangehrmlive.com/");
		base.getDriver().manage().window().maximize();
	}

	@After
	public void quit() {
		base.tearDown();
	}

}
