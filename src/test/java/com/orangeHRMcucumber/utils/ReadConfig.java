package com.orangeHRMcucumber.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	String path = System.getProperty("user.dir") + "/src/test/resources/Properties/config.properties";
	Properties prop;

	public ReadConfig() {
		try {
		prop = new Properties();
		FileInputStream fs = new FileInputStream(path);
		prop.load(fs);
		}catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public String GetUsername() {
		String username = prop.getProperty("Username");
		if (username != null) {
			return username;
		} else
			throw new RuntimeException("Value doesn't found");
	}
	
	public String GetPassword() {
		String password = prop.getProperty("Password");
		if(password!=null) {
			return password;
		}else 
			throw new RuntimeException("Value doesn't found");
	}
	
	public String GetBrowser() {
		String browser = prop.getProperty("Browser");
		if(browser!=null) {
			return browser;
		}else {
			throw new RuntimeException();
		}
	}

}
