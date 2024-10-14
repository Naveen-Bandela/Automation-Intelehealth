package com.intelehealth.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.intelehealth.base.BasePage;
import com.intelehealth.listeners.ScreenshotListener;
import com.intelehealth.pages.DashboardPage;
import com.intelehealth.pages.HelpSupportLogoutPage;
import com.intelehealth.pages.LoginPage;
import com.intelehealth.util.Credentials;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class HelpSupportLogoutTest {

	Properties prop;
	WebDriver driver;
	BasePage basePage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	HelpSupportLogoutPage helpSupportLogoutPage;
	Credentials credentials;

	@BeforeMethod
	public void setUp() throws Exception {
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
		credentials = new Credentials(prop.getProperty("username"), prop.getProperty("password"));
		dashboardPage = loginPage.doLogin(credentials);
		helpSupportLogoutPage = new HelpSupportLogoutPage(driver);
		ScreenshotListener.setDriver(driver);
	}

	@Test(priority = 1, description = "IDA4_1648_Verify the Logout functionality", enabled = true)
	@Description("Verify the Logout functionality")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1648_HelpSupport() throws InterruptedException {
		
		//System.out.println("Started execution of IDA4_1648");
		helpSupportLogoutPage.logoutConfirmDialog();
	}
	
	@Test(priority = 2, description = "IDA4_1650_Verify the User can logout from app if clicking yes", enabled = true)
	@Description("Verify the User can logout from app if clicking yes")
	@Severity(SeverityLevel.BLOCKER)
	public void IDA4_1650_HelpSupport() throws InterruptedException {
		
		//System.out.println("Started execution of IDA4_1650");
		helpSupportLogoutPage.logoutFunctionality();
	}
	
	@AfterMethod
	public void tearDown() throws Throwable {
		driver.quit();
		System.gc();
	}
}
