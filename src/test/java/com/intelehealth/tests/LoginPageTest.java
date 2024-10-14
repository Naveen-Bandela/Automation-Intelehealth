package com.intelehealth.tests;

import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.intelehealth.base.BasePage;
import com.intelehealth.pages.LoginPage;
import com.intelehealth.pages.DashboardPage;
import com.intelehealth.util.Credentials;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("intelehealth application")
@Feature("login module - intelehealth application")
public class LoginPageTest {
	Properties prop;
	WebDriver driver;
	BasePage basePage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	Credentials credentials; // Declare as a member variable

	@BeforeMethod
	public void setUp() throws Throwable {
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		// Set implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		loginPage = new LoginPage(driver);
		credentials = new Credentials(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1, description = "IDA4_1420_Login_Verify that user can navigate to Login screen", enabled = true)
	@Description("Verify that user can navigate to Login screen")
	@Severity(SeverityLevel.NORMAL)

	public void IDA4_1420_Login() {

		loginPage.displayed();
		// System.out.println("All elements are displayed");
	}

	@Test(priority = 2, description = "IDA4_1421_Login_Verify if a user will be able to login with a valid username and valid password", enabled = true)
	@Description("Verify if a user will be able to login with a valid username and valid password")
	@Severity(SeverityLevel.BLOCKER)

	public void IDA4_1421_Login() {

		dashboardPage = loginPage.doLogin(credentials);
		String loggedInUserVal = dashboardPage.isUSerLoggedIn();
		// System.out.println("logged in user is : " + loggedInUserVal);
	}

	@Test(priority = 3, description = "IDA4_1431_Login_Verify that Terms & Conditions and privacy policy link navigates to respective pages ", enabled = true)
	@Description("Verify language drop down on login page")
	@Severity(SeverityLevel.NORMAL)
	public void IdA4_1431_Login() throws Throwable {

		loginPage.TermsandConditionsPrivacyPolicy();
	//	driver.quit();

	}

	@Test(priority = 4, description = "IDA4_1432_Login_Verify language drop down on login page", enabled = true)
	@Description("Verify language drop down on login page")
	@Severity(SeverityLevel.NORMAL)

	public void IDA4_1432_Login() throws InterruptedException {
		loginPage.selectlanguage();
	}

	@AfterMethod
	public void tearDown() throws Throwable {
		driver.quit();
		System.gc();
	}
}
