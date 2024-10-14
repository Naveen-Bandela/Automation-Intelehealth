package com.intelehealth.pages;

import static org.junit.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.intelehealth.base.BasePage;
import com.intelehealth.listeners.ExtentReportListener;
import com.intelehealth.util.ElementActions;

import io.qameta.allure.Step;

public class DashboardPage extends BasePage {

	WebDriver driver;
	ElementActions elementActions;
	VisitSummaryPage vstsum;
	ExtentReportListener extentReport = new ExtentReportListener();

	By loggedInUserName = By.xpath("//div[@data-test-id='navProfile']/..//h6[@class='user-title mb-0']");
	By addtohomescreenClosePrompt = By.xpath("//button[@data-test-id='btnClose']");
	By dashboardLink = By.xpath("//a[@data-test-id='linkDashboard']");
	By messagesLink = By.xpath("//a[@data-test-id='linkMessages']");
	By appointmentLink = By.xpath("//a[@data-test-id='linkAppointments']");
	By calendarLink = By.xpath("//a[@data-test-id='linkCalendar']");
	By prescriptionLink = By.xpath("//a[@data-test-id='linkPrescription']");
	By helpsupportLink = By.xpath("//a[@data-test-id='linkHelp']");
	By logoutLink = By.xpath("//a[@data-test-id='linkLogout']");
	By logoutConfirmYesBtn = By.xpath("//button[@data-test-id='btnSubmit']");
	By searchpatientTextbox = By.xpath("//input[@data-test-id='etSearchPatient']");
	By searchpatientIcon = By.xpath("//span[@data-test-id='spanSearchPatient']");
	By helpChatBot = By.xpath("//button[@data-test-id='btnHelpMenu']");
	By notificationIcon = By.xpath("//button[@data-test-id='btnNotification']");
	By kebabMenu = By.xpath("//button[@data-test-id='btnProfileDropdown']");
	By appointmentsLabel = By.xpath("//div[@title='Appointments']");
	By priorityvisitLabel = By.xpath("//div[@title='Priority visits']");
	By awaitingvisitLabel = By.xpath("//div[@title='Awaiting visits']");
	By inprogressvisitLabel = By.xpath("//div[@title='In-progress visits']");

	// Locators of Appointment field in Dashboard Page
	By aptPatientField = By
			.xpath("//mat-paginator[@data-test-id='matPaginatorAppointment']/..//th[text()=' Patient ']");
	By aptAgeField = By.xpath("//mat-paginator[@data-test-id='matPaginatorAppointment']/..//th[text()=' Age ']");
	By aptStartsInField = By
			.xpath("//mat-paginator[@data-test-id='matPaginatorAppointment']/..//th[text()=' Starts in ']");
	By aptLocationField = By
			.xpath("//mat-paginator[@data-test-id='matPaginatorAppointment']/..//th[text()=' Location ']");
	By aptChiefComplaintField = By
			.xpath("//mat-paginator[@data-test-id='matPaginatorAppointment']/..//th[text()=' Chief Complaint ']");
	By aptActionsField = By
			.xpath("//mat-paginator[@data-test-id='matPaginatorAppointment']/..//th[text()=' Actions ']");
	By apPatient1Name = By.xpath("//td[@data-test-id='apPatient0']");

	// Locator for getting the count of Appointment field patients
	By aptCount = By.xpath("//td[contains(@data-test-id,'apPatient')]");
	By aptCountLabel = By.xpath("//mat-icon[@data-test-id='matIcoHelpAppointment']/..//h6");
	By aptCountAtPaginator = By.xpath(
			"//mat-paginator[@data-test-id='matPaginatorAppointment']/..//div[@class='mat-paginator-range-label']");

	// Locators of Priority Visit
	By prvstPatientField = By.xpath("//td[@data-test-id=\"prPatient0\"]/../../..//th[text()=' Patient ']");
	By prvstAgeField = By.xpath("//td[@data-test-id=\"prPatient0\"]/../../..//th[text()=' Age ']");
	By prvstLocationField = By.xpath("//td[@data-test-id=\"prPatient0\"]/../../..//th[text()=' Location ']");
	By prvstChiefComplaintField = By
			.xpath("//td[@data-test-id=\"prPatient0\"]/../../..//th[text()=' Chief Complaint ']");
	By prvstVisitUploadedField = By.xpath("//td[@data-test-id=\"prPatient0\"]/../../..//th[text()=' Visit Uploaded ']");
	By prvstPatient1Name = By.xpath("//td[@data-test-id='prPatient0']");

	// Locator for getting the count of Priority Visit field patients
	By prVstCount = By.xpath("//td[contains(@data-test-id,'prPatient')]");
	By prVstCountLabel = By.xpath("//mat-icon[@data-test-id='matIcoHelpPriority']/..//h6");
	By prVstCountAtPaginator = By.xpath(
			"(//mat-paginator[@data-test-id='matPaginatorPriority']/..//div[@class='mat-paginator-range-label'])[2]");

	// Locators of Awaiting Patient field in Dashboard Page
	By awtvstPatientField = By.xpath("//td[@data-test-id=\"awPatient0\"]/../../..//th[text()=' Patient ']");
	By awtvstAgeField = By.xpath("//td[@data-test-id=\"awPatient0\"]/../../..//th[text()=' Age ']");
	By awtvstLocationField = By.xpath("//td[@data-test-id=\"awPatient0\"]/../../..//th[text()=' Location ']");
	By awtvstChiefComplaintField = By
			.xpath("//td[@data-test-id=\"awPatient0\"]/../../..//th[text()=' Chief Complaint ']");
	By awtvstVisitUploadedField = By
			.xpath("//td[@data-test-id=\"awPatient0\"]/../../..//th[text()=' Visit Uploaded ']");
	By awtvstPatient1Name = By.xpath("//td[@data-test-id='awPatient0']");

	// Locator for getting the count of Awaiting visit field patients
	By awtVstCount = By.xpath("//td[contains(@data-test-id,'awPatient')]");
	By awtVstCountLabel = By.xpath("//mat-icon[@data-test-id='matIcoHelpAwaiting']/..//h6");
	By awtVstCountAtPaginator = By.xpath(
			"(//mat-paginator[@data-test-id='matPaginatorAwaiting']/..//div[@class='mat-paginator-range-label'])[2]");

	// Locators of In Progress Patient field in Dashboard Page
	By inprvstPatientField = By.xpath("//td[@data-test-id='ipPatient0']/../../..//th[text()=' Patient ']");
	By inprvstAgeField = By.xpath("//td[@data-test-id='ipPatient0']/../../..//th[text()=' Age ']");
	By inprvstLocationField = By.xpath("//td[@data-test-id='ipPatient0']/../../..//th[text()=' Location ']");
	By inprvstChiefComplaintField = By
			.xpath("//td[@data-test-id='ipPatient0']/../../..//th[text()=' Chief Complaint ']");
	By inprvstPrescriptionStarted = By
			.xpath("//td[@data-test-id='ipPatient0']/../../..//th[text()=' Prescription Started ']");
	By inprvstPatient1Name = By.xpath("//td[@data-test-id='ipPatient0']");

	// Locator for getting the count of Awaiting visit field patients
	By inprVstCount = By.xpath("//td[contains(@data-test-id,'ipPatient')]");
	By inprVstCountLabel = By.xpath("//mat-icon[@data-test-id='matIcoHelpInprogress']/..//h6");
	By inprVstCountAtPaginator = By.xpath(
			"(//mat-paginator[@data-test-id='matPaginatorInprogress']/..//div[@class='mat-paginator-range-label'])[2]");
	By vstsumpatientSectionAge = By.xpath("//p[@data-test-id='etPatientAge']");
	By appointmentCountHeader = By.xpath("//h6[@data-test-id='apCount']");
	By priorityCountHeader = By.xpath("//h6[@data-test-id='prCount']");
	By awaitingCountHeader = By.xpath("//h6[@data-test-id='awCount']");
	By inProgressCountHeader = By.xpath("//h6[@data-test-id='ipCount']");

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(this.driver);
	}

	/*
	 * Author Name: Rajesh.H.S Created date: 08/09/2023 Description: This method is
	 * to verify if the user is logged in successfully
	 */
	public String isUSerLoggedIn() {
		elementActions.waitForElementPresent(loggedInUserName);
		extentReport.logToExtentReport("Clicked on Awaiting visit patient");
		if (elementActions.doIsDisplayed(loggedInUserName)) {
			return elementActions.doGetText(loggedInUserName);
		}
		return null;
	}

	/*
	 * Author Name: Rajesh.H.S Created date: 08/09/2023 Description: This method is
	 * to log out from application successfully
	 */
	@Step("Logout from application")
	public void dologout() {
		elementActions.doClick(logoutLink);
		extentReport.logToExtentReport("Clicked on Logout link from left panel");
		elementActions.doClick(logoutConfirmYesBtn);
		extentReport.logToExtentReport("Clicked on Yes button from Logout confirm popup");
	}

	/*
	 * Author Name: Rajesh.H.S Created date: 08/09/2023 Description: This method is
	 * to verify the elements displayed in Dashboard.
	 */
//	@Step("verify dashboard page contents")
	public void verifyDashboardComponents() {
		extentReport.logToExtentReport("User Profile is displayed");
		elementActions.doIsDisplayed(loggedInUserName);
		extentReport.logToExtentReport("Logged in Username is displayed");
		elementActions.doIsDisplayed(dashboardLink);
		extentReport.logToExtentReport("Dashboard is displayed in left panel");
		extentReport.logToExtentReport("Dashboard link is displayed in left panel");
		elementActions.doIsDisplayed(messagesLink);
		extentReport.logToExtentReport("Messages link is displayed in left panel");
		elementActions.doIsDisplayed(appointmentLink);
		extentReport.logToExtentReport("Appointment link is displayed in left panel");
		elementActions.doIsDisplayed(calendarLink);
		extentReport.logToExtentReport("Claendar link is displayed in left panel");
		elementActions.doIsDisplayed(prescriptionLink);
		extentReport.logToExtentReport("Prescription link is displayed in left panel");
		elementActions.doIsDisplayed(helpsupportLink);
		extentReport.logToExtentReport("Help Support link is displayed");
		elementActions.doIsDisplayed(logoutLink);
		extentReport.logToExtentReport("Logout link is displayed");
		elementActions.doIsDisplayed(searchpatientTextbox);
		extentReport.logToExtentReport("Search Patient textbox is displayed");
		elementActions.doIsDisplayed(searchpatientIcon);
		extentReport.logToExtentReport("Search Patient icon is displayed");
		elementActions.doIsDisplayed(helpChatBot);
		extentReport.logToExtentReport("Help Chat bot is displayed");
		elementActions.doIsDisplayed(notificationIcon);
		extentReport.logToExtentReport("Notification icon is displayed");
		elementActions.doIsDisplayed(kebabMenu);
		extentReport.logToExtentReport("Menu is displayed");
		elementActions.doIsDisplayed(appointmentsLabel);
		extentReport.logToExtentReport("Appointment label is displayed");
		elementActions.doIsDisplayed(priorityvisitLabel);
		extentReport.logToExtentReport("Priority visit label is displayed");
		elementActions.doIsDisplayed(awaitingvisitLabel);
		extentReport.logToExtentReport("Awaiting visit label is displayed");
		elementActions.doIsDisplayed(inprogressvisitLabel);
		extentReport.logToExtentReport("In progress visit label is displayed");
	}

	/*
	 * Author Name: Rajesh.H.S Created date: 11/09/2023 Description: This method is
	 * to verify elements of Priority visit table
	 */
	@Step("verify dashboard page Priority Visits field")
	public void VerificationLog() {
		extentReport.logToExtentReport("All Dashboard components are displayed correctly");
	}

	/*
	 * Author Name: Rajesh.H.S Created date: 11/09/2023 Description: This method is
	 * to verify elements of Priority visit table
	 */
	@Step("verify dashboard page Priority Visits field")
	public void verifyDashboardPriorityVisitField() {
		elementActions.doIsDisplayed(prvstPatientField);
		extentReport.logToExtentReport("priority visit patient field is displayed");
		elementActions.doIsDisplayed(prvstAgeField);
		extentReport.logToExtentReport("priority visit age field is displayed");
		elementActions.doIsDisplayed(prvstLocationField);
		extentReport.logToExtentReport("priority visit location field is displayed");
		elementActions.doIsDisplayed(prvstChiefComplaintField);
		extentReport.logToExtentReport("priority visit Chief Complaint field is displayed");
		elementActions.doIsDisplayed(prvstVisitUploadedField);
		extentReport.logToExtentReport("priority visit Uploaded field is displayed");
	}

	/*
	 * Author Name: Rajesh.H.S Created date: 11/09/2023 Description: This method is
	 * to verify elements of Awaiting visit table
	 */
	@Step("verify dashboard page Priority Visits field")
	public void verifyDashboardAwaitingVisitField() {
		elementActions.doIsDisplayed(awtvstPatientField);
		extentReport.logToExtentReport("awaiting visit Uploaded field is displayed");
		elementActions.doIsDisplayed(awtvstAgeField);
		extentReport.logToExtentReport("awaiting visit age field is displayed");
		elementActions.doIsDisplayed(awtvstLocationField);
		extentReport.logToExtentReport("awaiting visit location field is displayed");
		elementActions.doIsDisplayed(awtvstChiefComplaintField);
		extentReport.logToExtentReport("awaiting visit Chief Complaint field is displayed");
		elementActions.doIsDisplayed(awtvstVisitUploadedField);
		extentReport.logToExtentReport("awaiting visit Uploaded field is displayed");
	}

	/*
	 * Author Name: Rajesh.H.S Created date: 11/09/2023 Description: This method is
	 * to verify elements of Appointment visit table
	 */
	@Step("verify dashboard page Appointments field contents")
	public void verifyDashboardAppointmentVisitField() {
		elementActions.doIsDisplayed(aptPatientField);
		extentReport.logToExtentReport("appointment patient field is displayed");
		elementActions.doIsDisplayed(aptAgeField);
		extentReport.logToExtentReport("appointment patient age field is displayed");
		elementActions.doIsDisplayed(aptStartsInField);
		extentReport.logToExtentReport("appointment patient Starts in field is displayed");
		elementActions.doIsDisplayed(aptLocationField);
		extentReport.logToExtentReport("appointment patient Location field is displayed");
		elementActions.doIsDisplayed(aptChiefComplaintField);
		extentReport.logToExtentReport("appointment patient Chief Complaint field is displayed");
		elementActions.doIsDisplayed(aptActionsField);
		extentReport.logToExtentReport("appointment patient Actions field is displayed");
	}

	/*
	 * Author Name: Rajesh.H.S Created date: 11/09/2023 Description: This method is
	 * to verify elements of InProgress visit table
	 */
	@Step("verify dashboard page Inprogress field contents")
	public void verifyDashboardInProgressVisitField() {
		elementActions.doIsDisplayed(inprvstPatientField);
		extentReport.logToExtentReport("in progress patient field is displayed");
		elementActions.doIsDisplayed(inprvstAgeField);
		extentReport.logToExtentReport("in progress patient Age field is displayed");
		elementActions.doIsDisplayed(inprvstLocationField);
		extentReport.logToExtentReport("in progress patient Location field is displayed");
		elementActions.doIsDisplayed(inprvstChiefComplaintField);
		extentReport.logToExtentReport("in progress patient Chief Complaint field is displayed");
		elementActions.doIsDisplayed(inprvstPrescriptionStarted);
		extentReport.logToExtentReport("in progress patient Prescriptions field is displayed");
	}

	/*
	 * Author Name: Rajesh.H.S Created date: 11/09/2023 Description: This method is
	 * to verify Appointment navigate to Visit summary page
	 */
	@Step("verify click on appointments Patient navigate to Visit summary page")
	public void verifyPatientCountHeader() {

		elementActions.doIsDisplayed(appointmentCountHeader);
		extentReport.logToExtentReport("Appointment Patient count is displayed in Header");
		elementActions.doIsDisplayed(priorityCountHeader);
		extentReport.logToExtentReport("Priority Visit Count is displayed in Header");
		elementActions.doIsDisplayed(awaitingCountHeader);
		extentReport.logToExtentReport("Awaiting visit count is displayed in Header");
		elementActions.doIsDisplayed(inProgressCountHeader);
		extentReport.logToExtentReport("In Progress Visit count is displayed in header");
	}

	/*
	 * Author Name: Rajesh.H.S Created date: 11/09/2023 Description: This method is
	 * to verify Appointment navigate to Visit summary page
	 */
	@Step("verify click on appointments Patient navigate to Visit summary page")
	public void clickAptPatient() {
		if (elementActions.doIsDisplayed(apPatient1Name) == true) {
			elementActions.doClick(apPatient1Name);
			extentReport.logToExtentReport("Clicked on 1st Appointment Patient");
			elementActions.doIsDisplayed(vstsumpatientSectionAge);
			extentReport.logToExtentReport("Visit Summary Patient page is displayed");
		} else {
			fail();
		}
	}

	/*
	 * Author Name: Rajesh.H.S Created date: 11/09/2023 Description: This method is
	 * to verify Appointments visit count displayed correctly
	 */
	@Step("Verify that Appointments visits header shows the correct count of Apointment visits")
	public void ApntmtsCount() {
		String AptCtAtPaginator = elementActions.getLastChar1(aptCountAtPaginator, 1);
		extentReport.logToExtentReport("Count displayed at Paginator" + AptCtAtPaginator);
		String aptCTAtLabel = elementActions.getLastChar(aptCountLabel, 1);
		extentReport.logToExtentReport("Count displayed at Label" + aptCTAtLabel);
		if (AptCtAtPaginator.equals(aptCTAtLabel)) {
			extentReport.logToExtentReport("Count is displayed correctly");
		} else {
			fail();
		}
	}

	/*
	 * Author Name: Rajesh.H.S Created date: 12/09/2023 Description: This method is
	 * to verify Priority visit patient navigate to visit summary page
	 */
	@Step("verify click on Priority Visit Patient navigate to Visit summary page")
	public void clickPrPatient() {
		if (elementActions.doIsDisplayed(prvstPatient1Name) == true) {
			elementActions.doClick(prvstPatient1Name);
			extentReport.logToExtentReport("Clicked on Priority visit 1st patient from the table");
			elementActions.doIsDisplayed(vstsumpatientSectionAge);
			extentReport.logToExtentReport("Visit Summary Patient page is displayed");
		} else {
			fail();
		}
	}

	/*
	 * Author Name: Rajesh.H.S Created date: 12/09/2023 Description: This method is
	 * to verify Priority visits header shows the correct count of Priority visits
	 */
	@Step("Verify that Priority visits header shows the correct count of Priority visits")
	public void PrVstCount() {
		String prVstCtAtPaginator = elementActions.getLastChar1(prVstCountAtPaginator, 1);
		extentReport.logToExtentReport("Count displayed at Paginator" + prVstCtAtPaginator);
		String prVstCTAtLabel = elementActions.getLastChar(prVstCountLabel, 1);
		extentReport.logToExtentReport("Count displayed at Label" + prVstCTAtLabel);
		if (prVstCtAtPaginator.equals(prVstCTAtLabel)) {
			extentReport.logToExtentReport("Count is displayed correctly");
		} else {
			fail();
		}
	}

	/*
	 * Author Name: Rajesh.H.S Created date: 12/09/2023 Description: This method is
	 * to verify Awaiting visits header shows the correct count of Awaiting visits
	 */
	@Step("Verify that Awaiting visits header shows the correct count of Awaiting visits")
	public void awVstCount() {
		String awtVstCtAtPaginator = elementActions.getLastChar1(awtVstCountAtPaginator, 1);
		extentReport.logToExtentReport("Count displayed at Paginator" + awtVstCtAtPaginator);
		String awtVstCTAtLabel = elementActions.getLastChar(awtVstCountLabel, 1);
		extentReport.logToExtentReport("Count displayed at Label" + awtVstCTAtLabel);
		if (awtVstCtAtPaginator.equals(awtVstCTAtLabel)) {
			extentReport.logToExtentReport("Count is displayed correctly");
		} else {
			fail();
		}
	}

	/*
	 * Author Name: Rajesh.H.S Created date: 12/09/2023 Description: This method is
	 * to verify Awaiting Visit Patient navigate to Visit summary page
	 */
	@Step("verify click on Awaiting Visit Patient navigate to Visit summary page")
	public void clickawtVstPatient() {
		if (elementActions.doIsDisplayed(awtvstPatient1Name) == true) {
			elementActions.doClick(awtvstPatient1Name);
			extentReport.logToExtentReport("Clicked on 1st Awaiting visit patient from the table");
			elementActions.doIsDisplayed(vstsumpatientSectionAge);
			extentReport.logToExtentReport("Visit summary page is displayed");
		} else {
			fail();
		}
	}

	/*
	 * Author Name: Rajesh.H.S Created date: 12/09/2023 Description: This method is
	 * to verify In-progress visits header shows the correct count of In-progress
	 * visits
	 */
	@Step("Verify that In-progress visits header shows the correct count of In-progress visits")
	public void inprVstCount() {
		String inprVstCtAtPaginator = elementActions.getLastChar1(inprVstCountAtPaginator, 1);
		extentReport.logToExtentReport("Count displayed at Paginator" + inprVstCtAtPaginator);
		String inprVstCTAtLabel = elementActions.getLastChar(inprVstCountLabel, 1);
		extentReport.logToExtentReport("Count displayed at Label" + inprVstCTAtLabel);
		if (inprVstCtAtPaginator.equals(inprVstCTAtLabel)) {
			extentReport.logToExtentReport("Count is displayed correctly");
		} else {
			fail();
		}
	}

	/*
	 * Author Name: Rajesh.H.S Created date: 12/09/2023 Description: This method is
	 * to verify in progress Visit Patient navigate to Visit summary page
	 */
	@Step("verify click on in progress Visit Patient navigate to Visit summary page")
	public void clickInprPatient() {
		if (elementActions.doIsDisplayed(inprvstPatient1Name) == true) {
			elementActions.doClick(inprvstPatient1Name);
			extentReport.logToExtentReport("Clicked on in progress Visit 1st patient");
			elementActions.doIsDisplayed(vstsumpatientSectionAge);
			extentReport.logToExtentReport("Visit summary page is displayed");
		} else {
			fail();
		}
	}
}