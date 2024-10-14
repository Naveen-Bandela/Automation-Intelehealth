package com.intelehealth.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.intelehealth.base.BasePage;
import com.intelehealth.listeners.ExtentReportListener;
import com.intelehealth.util.ElementActions;

import io.qameta.allure.Step;

public class HelpSupportLogoutPage extends BasePage{
	WebDriver driver;
	ElementActions elementActions;
	WebDriverWait wait;
	ExtentReportListener extentReport = new ExtentReportListener();

	By logoutLink = By.xpath("//a[@data-test-id='linkLogout']");
	By logoutYesBtn = By.xpath("//button[@data-test-id='btnSubmit']");
	By logoutNoBtn = By.xpath("//button[@data-test-id='btnCancel']");
	By logoutClose = By.xpath("//button[@data-test-id='btnClose']");
	By Username = By.xpath("//input[@data-test-id='etUsername']");
	
	// Constructor of page class:
	public HelpSupportLogoutPage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(this.driver);
	}

	/*
	 * Author: Rajesh HS Created: 31/10/2023 
	 * Description: Verify the Logout functionality
	 */
	@Step("Verify the Logout functionality")
	public void logoutConfirmDialog() throws InterruptedException {
		elementActions.doClick(logoutLink);
		extentReport.logToExtentReport("Clicked on Logout link from side panel");
		elementActions.doIsDisplayed(logoutYesBtn);
		extentReport.logToExtentReport("Yes button is displayed on logout confirmation dialog");
		elementActions.doIsDisplayed(logoutNoBtn);
		extentReport.logToExtentReport("No button is displayed on logout confirmation dialog");
		elementActions.doIsDisplayed(logoutClose);
		extentReport.logToExtentReport("Close button is displayed on logout confirmation dialog");
		elementActions.doClick(logoutClose);
		extentReport.logToExtentReport("Clicked on Close button");
	}

	/*
	 * Author: Rajesh HS Created: 31/10/2023 
	 * Description: Verify the User can logout from app if clicking yes
	 */
	@Step("Verify the User can logout from app if clicking yes")
	public void logoutFunctionality() throws InterruptedException {
		elementActions.doClick(logoutLink);
		extentReport.logToExtentReport("Clicked on Logout link from side panel");
		elementActions.doClick(logoutYesBtn);
		extentReport.logToExtentReport("Yes button is displayed on logout confirmation dialog");
		elementActions.doIsDisplayed(Username);
		extentReport.logToExtentReport("No button is displayed on logout confirmation dialog");
		
	}
}
