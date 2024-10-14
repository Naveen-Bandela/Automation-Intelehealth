package com.intelehealth.base;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {

	public ChromeOptions co;
	public FirefoxOptions fo;
	public EdgeOptions eo;
	Properties prop;

	// Constructor to initialize the class with properties
	public OptionsManager(Properties prop) {
		this.prop = prop;
	}

	// Get ChromeOptions based on properties
	public ChromeOptions getChromeOptions() {
		co = new ChromeOptions();
		co.addArguments("--use-fake-ui-for-media-stream"); // Automatically allow or block camera and															// microphone
		co.addArguments("--disable-media-stream"); // Disable media stream

		// Check if "headless" property is set to true, and if so, add the "--headless"
		// argument
		if (Boolean.parseBoolean(prop.getProperty("headless"))) {
			co.addArguments("--headless");
			co.addArguments("--window-size=1920,1080");
			return co;
		}

		// Check if "incognito" property is set to true, and if so, add the
		// "--incognito" argument
		if (Boolean.parseBoolean(prop.getProperty("incognito"))) {
			co.addArguments("--incognito");
			co.addArguments("--window-size=1920,1080");
		}

		return co; // Return the configured ChromeOptions
	}

	// Get FirefoxOptions based on properties
	public FirefoxOptions getFirefoxOptions() {
		fo = new FirefoxOptions();

		// Check if "headless" property is set to true, and if so, add the "--headless"
		// argument
		if (Boolean.parseBoolean(prop.getProperty("headless"))) {
			fo.addArguments("--headless");
			fo.addArguments("--window-size=1920,1080");
		}

		return fo; // Return the configured FirefoxOptions
	}

	// Get EdgeOptions based on properties
	public EdgeOptions getEdgeOptions() {
		eo = new EdgeOptions();

		// Check if "headless" property is set to true, and if so, add the "--headless"
		// argument
		if (Boolean.parseBoolean(prop.getProperty("headless"))) {
			eo.addArguments("--headless");
			eo.addArguments("--window-size=1920,1080");
		}

		return eo; // Return the configured EdgeOptions
	}
}
