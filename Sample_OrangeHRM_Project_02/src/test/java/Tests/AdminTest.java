package Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Pages.AdminPage;



public class AdminTest {
	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;

	@BeforeClass
	public void generateReport(ITestContext context) {

		driver = (WebDriver) context.getAttribute("driver");
		ExtentSparkReporter reports = new 	ExtentSparkReporter("./Reports/AdminTestcasesReports.html");
		extent = new ExtentReports();
		extent.attachReporter(reports);
		test = extent.createTest("HomePage Execution Started Successfully..");	


	}

	@Test(priority = 2,dependsOnMethods = "Tests.LoginTest.LoginPageTestcases")
	public void AdminTestCases() throws InterruptedException {
		AdminPage admin = new AdminPage(driver);

		Thread.sleep(2000);

		//Click Admin Button
		admin.Click_Admin();
		test.pass("Clicked Admin Button.");
		Thread.sleep(1000);

		// To get the Admin text in the Admin page
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()=\"Admin\"]")));
		test.pass("The Admin page is displayed.");


		//***************************************** USER MANAGEMENT *******************************************// 

		// Click User Mangement
		admin.Click_User_Management();
		test.pass("Clicked User Management button in Admin Page.");
		Thread.sleep(1000);

		// Click Users
		admin.Click_User();
		test.pass("Clicked Users link.");
		Thread.sleep(1000);

		//To get the System users text in the Admin page
		WebDriverWait wait_for_System_User_txt = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait_for_System_User_txt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()=\"System Users\"]")));
		test.pass("The System User is displayed.");
		Thread.sleep(1000);

		//Enter Username
		admin.Enter_Username("Admin");
		test.pass("Entered Username.");
		Thread.sleep(1000);

		//User Role 
		admin.Click_UserRole_DownArrow();
		test.pass("Clicked User Role Down Arrow icon.");
		Thread.sleep(1000);

		//click Admin in UserRole Dropdown
		admin.Click_Admin_in_UserRole_Dropdown();
		test.pass("Clicked Admin in User Role Dropdown.");

		//		//Status
		//		admin.Click_Status_DownArrow();
		//		test.pass("Clicked Status Down Arrow icon.");
		//		Thread.sleep(1000);

		//To Click the Status Arrow icon
		WebDriverWait sarrow = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			sarrow.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//i[contains(@class,'oxd-select-text--arrow')]"))); 


			admin.Click_Status_DownArrow();
			test.pass("Clicked Status Down Arrow icon successfully.");

		} catch (TimeoutException e) {
			test.fail("Status Down Arrow icon is NOT clickable.");
		}
		Thread.sleep(1000);


		//Select Enabled
		WebDriverWait click_enabled = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			click_enabled.until(ExpectedConditions.elementToBeClickable(
					By.xpath("(//div[@role='option']//span[text()='Enabled'])[1]"))); 


			admin.Click_Enabled_in_Status_Dropdown();
			test.pass("Selected Enabled in Status Dropdown.");

		} catch (TimeoutException e) {
			test.fail("Enabled is NOT Selectable.");
		}

		Thread.sleep(1000);

		//Search Button
		admin.Click_Search_button();
		test.pass("Clicked search button");
		Thread.sleep(1000);

		//TO check Whether the searched user is avilable or not
		//		WebDriverWait a = new WebDriverWait(driver,Duration.ofSeconds(10));
		//		a.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()=\"Admin\"])[2]")));
		//		test.pass("The Searched user is Available.");
		//		Thread.sleep(1000);
		WebDriverWait a = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			a.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("(//div[text()='Admin'])[2]")));

			test.pass("The searched user is available.");

		} catch (TimeoutException e) {
			test.fail("The searched user is Not Available.");
		}
		Thread.sleep(1000);


		//Reset Button
		admin.Click_Reset_Button();
		test.pass("Clicked Reset button.");
		Thread.sleep(2000);

		//Add Button +
		admin.Click_Add_Button();
		test.pass("Clicked Add + Button.");
		Thread.sleep(1000);

		//Clicking User Role
		admin.Click_UserRole_Icon();
		test.pass("Clicked User Role Dropdown.");
		Thread.sleep(1000);

		//Select ESS
		WebDriverWait click_ess = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			click_ess.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//div[@role='option']//span[text()='ESS']"))); 


			admin.Select_Ess();
			test.pass("Selected ESS in USer Role Dropdown.");

		} catch (TimeoutException e) {
			test.fail("ESS is NOT Selectable.");
		}
		Thread.sleep(1000);


		//To Enter and Choose the Employee Name
		WebDriverWait empName = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement empInput = empName.until(
				ExpectedConditions.elementToBeClickable(
						By.xpath("//input[@placeholder='Type for hints...']")
						)
				);

		//To enter half name to check whether the name is visible or not
		empInput.sendKeys("James Butl");

		Thread.sleep(3000);

		By suggestions = By.xpath("//div[@role='listbox']//div");

		// Wait until suggestions are visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(suggestions));

		//  Click first suggestion
		driver.findElements(suggestions).get(0).click();

		Thread.sleep(1000);

		//To Click the Status arrow icon in Add User Page
		admin.Click_StatusArrow_in_AddUserPage();
		test.pass("Clicked Status arrow icon in Add User page.");
		Thread.sleep(1000);

		//Select Enabled
		WebDriverWait select_enabled = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			select_enabled.until(ExpectedConditions.elementToBeClickable(
					By.xpath("(//div[@role='option']//span[text()='Enabled'])[1]"))); 


			admin.Click_Enabled_in_Status_Dropdown();
			test.pass("Selected Enabled in Status Dropdown.");

		} catch (TimeoutException e) {
			test.fail("Enabled is NOT Selectable.");
		}
		Thread.sleep(1000);

		//Enter USer name in Add USer
		admin.Click_userName_In_AddUser("james12345678910");
		test.pass("Entered username");
		Thread.sleep(1000);

		//Enter password  in Add USer
		admin.Click_pwd_In_AddUser("james12345");
		test.pass("Entered password");
		Thread.sleep(3000);

		//Enter conf password  in Add USer
		admin.Click_Conf_pwd_In_AddUser("james12345");
		test.pass("Entered Confirm password");
		Thread.sleep(3000);

		admin.Click_Save_btn();
		test.pass("Clicked the Save Button.");
		Thread.sleep(4000);

		// To get the Admin text in the Admin page
		WebDriverWait Admin_wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		Admin_wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()=\"Admin\"]")));
		test.pass("The Admin page is displayed.");


		//Reset Button again
		admin.Click_Reset_Button();
		test.pass("Clicked Reset button.");
		Thread.sleep(2000);

		//Enter Username to check whether the created user is available
		admin.Enter_uname_again("james12345678910");
		test.pass("Entered Username.");
		Thread.sleep(1000);

		//User Role for created user
		admin.Click_UserRole_DownArrow();
		test.pass("Clicked User Role Down Arrow icon.");
		Thread.sleep(1000);

		//click ESS in UserRole Dropdown
		admin.Select_Ess();
		test.pass("Clicked Ess in User Role Dropdown.");

		//To Click the Status Arrow icon
		WebDriverWait sarrow_again = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			sarrow_again.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//i[contains(@class,'oxd-select-text--arrow')]"))); 


			admin.Click_Status_DownArrow();
			test.pass("Clicked Status Down Arrow icon successfully.");

		} catch (TimeoutException e) {
			test.fail("Status Down Arrow icon is NOT clickable.");
		}
		Thread.sleep(1000);


		//Select Enabled Again
		WebDriverWait click_enabled_again = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			click_enabled_again.until(ExpectedConditions.elementToBeClickable(
					By.xpath("(//div[@role='option']//span[text()='Enabled'])[1]"))); 


			admin.Click_Enabled_in_Status_Dropdown();
			test.pass("Selected Enabled in Status Dropdown.");

		} catch (TimeoutException e) {
			test.fail("Enabled is NOT Selectable.");
		}

		Thread.sleep(1000);

		//Search Button again
		admin.Click_Search_button();
		test.pass("Clicked search button");
		Thread.sleep(1000);

		//To get the Checked user is available or not
		WebDriverWait wait_for_created_user_txt = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait_for_created_user_txt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=\"james12345678910\"]")));
		test.pass("The Created user is available.");
		Thread.sleep(3000);

		WebDriverWait d_wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		d_wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=\"james12345678910\"]")));
		try {
			//Delete created user
			admin.CLick_Delete_Icon();
			test.pass("Deleted the User.");
			//Click Yes Delete Option
			admin.Click_Yes_Delete();
			test.pass("Clicked Yes Delete button.");
			Thread.sleep(1000);
		}catch(Exception e) {
			test.fail("Invalid User. Unable to Delete.");
		}
		Thread.sleep(2000);

		test.info("Testing the User Management Feature Successfully Completed. And Navigation to Job Feature. ");

		//***************************************** USER MANAGEMENT *******************************************//


		//********************************************** JOB *************************************************//

		//Click Job
		admin.Click_Job();
		test.pass("Clicked Job Button.");
		Thread.sleep(1000);

		//Getting all the job list in order as a text
		List<WebElement> Job_lst = driver.findElements(By.xpath("//a[@class=\"oxd-topbar-body-nav-tab-link\"]"));
		System.out.println("Total elements in Job List: " + Job_lst.size());
		for (WebElement jl : Job_lst) {
			System.out.println(jl.getText());
		}
		System.out.println();
		test.pass("Got all the elements from Job List.");
		Thread.sleep(1000);

		//Click Job Title
		admin.Click_Job_Title();
		test.pass("Clicked Job Title Button.");
		Thread.sleep(1000);

		// To get the Job Title text in the Job Title page
		WebDriverWait jb_title = new WebDriverWait(driver,Duration.ofSeconds(10));
		jb_title.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()=\"Job Titles\"]")));
		test.pass("The Job Title page is displayed.");


		//Click Add in Job Title
		admin.Click_Add_in_Job_Title();
		test.pass("Clicked Add in Job title.");
		Thread.sleep(1000);

		// To get the Add Job Title text in the Job Title page
		WebDriverWait add_jb_title = new WebDriverWait(driver,Duration.ofSeconds(10));
		add_jb_title.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()=\"Add Job Title\"]")));
		test.pass("The Add Job Title page is displayed.");

		//Enter Job Title
		admin.Enter_Job_Title("QA Intern");
		test.pass("Entered Job Title.");
		Thread.sleep(1000);

		//Enter Description
		admin.Enter_Description("Automation");
		test.pass("Entered Job Desscription.");
		Thread.sleep(1000);

		//Click Save Button in the Job Title
		admin.Click_Save_Button_in_JobTitle();
		test.pass("Clicked Save Button in the Job Title.");
		Thread.sleep(4000);

		// To get the Job Title text again in the Job Title page
		WebDriverWait jb_title_again = new WebDriverWait(driver,Duration.ofSeconds(10));
		jb_title_again.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()=\"Job Titles\"]")));
		test.pass("The Job Title page is displayed.");
		Thread.sleep(1000);

		WebDriverWait d = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Click Delete icon for QA Intern
		By deleteIcon = By.xpath(
				"//div[text()='QA Intern']/ancestor::div[@role='row']//button"
				);

		WebElement deleteBtn = d.until(
				ExpectedConditions.elementToBeClickable(deleteIcon)
				);
		deleteBtn.click();

		// Click Yes, Delete on confirmation popup
		By yesDeleteBtn = By.xpath("//button[normalize-space()='Yes, Delete']");

		d.until(
				ExpectedConditions.elementToBeClickable(yesDeleteBtn)
				).click();
		Thread.sleep(1000);

		//Click Job again
		admin.Click_Job();
		test.pass("Clicked Job Button again.");
		Thread.sleep(1000);

		//Click Pay Grades
		admin.Click_Pay_grades();
		test.pass("Clicked Pay Greades button.");
		Thread.sleep(1000);

		//Click Add Button in Pay Grades
		admin.Click_Add_btn_in_Pay_grades();
		test.pass("Clicked Add button in Pay Greades button.");
		Thread.sleep(1000);

		//Enter Pay Grades
		admin.Enter_Pay_Grades("Jr QA Analyst");
		test.pass("Entered Pay Greades.");
		Thread.sleep(1000);

		//Click Save Button in Pay Grades
		admin.Click_Save_btn_in__Pay_Grades();
		test.pass("Clicked Save Button in Pay Greades.");
		Thread.sleep(1000);

		//		WebDriverWait wait_for_cancel_btn = new WebDriverWait(driver,Duration.ofSeconds(10));
		//		wait_for_cancel_btn.until(ExpectedConditions.visibilityOf(deleteBtn))

		//		//Click Cancel Button in Edit Pay Grades
		//		admin.Click_Cancel__btn_in_Edit_Pay_Grades();
		//		test.pass("Clicked Cancel Button in Edit Pay Greades.");
		//		Thread.sleep(1000);

		//h6[text()="Edit Pay Grade"]
		WebDriverWait wait_for_edit_paygrade_text = new WebDriverWait(driver,Duration.ofSeconds(10));
		try {
			wait_for_edit_paygrade_text.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()=\"Edit Pay Grade\"]")));
			test.pass("The Edit Pay Grade Page is dispalyed.");
			admin.Click_Cancel__btn_in_Edit_Pay_Grades();
			test.pass("Clicked Cancel Button in Edit Pay Grades.");
			Thread.sleep(1000);
		}catch(Exception e) {
			test.fail("The Edit Pay Grade Page is Not Displayed.");
		}
		Thread.sleep(1000);

		//To wait for getting the Jr QA Analyst
		WebDriverWait dpg = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Click Delete icon for Jr QA Analyst
		By deleteIcons = By.xpath(
				"//div[text()='Jr QA Analyst']/ancestor::div[@role='row']//button"
				);

		WebElement pgdeleteBtn = dpg.until(
				ExpectedConditions.elementToBeClickable(deleteIcons)
				);
		pgdeleteBtn.click();
		test.pass("Clicked Delete Button in Pay Grades");
		Thread.sleep(2000);

		// Click Yes, Delete on confirmation popup
		By pg_yesDeleteBtn = By.xpath("//button[normalize-space()='Yes, Delete']");

		d.until(
				ExpectedConditions.elementToBeClickable(pg_yesDeleteBtn)
				).click();
		test.pass("Clicked Yes, Delete button in Pay Grades.");
		Thread.sleep(1000);








		test.info("Testing the Job Feature Successfully Completed. And Navigation to Organization Feature. ");

		//********************************************** JOB *************************************************//

		//********************************************** ORGANIZATION *************************************************//

		//Click Organization
		admin.Click_Organization();
		test.pass("Clicked Organization Button.");
		Thread.sleep(1000);

		//Getting all the job list in order as a text
		List<WebElement> Organization_lst = driver.findElements(By.xpath("//a[@class=\"oxd-topbar-body-nav-tab-link\"]"));
		System.out.println("Total elements in Organization List: " + Organization_lst.size());
		for (WebElement or_l : Organization_lst) {
			System.out.println(or_l.getText());
		}
		System.out.println();
		test.pass("Got all the elements from Organization List.");
		Thread.sleep(1000);

		//Click General Organization
		admin.Click_General_Organization();
		test.pass("Clicked Genaral Organization.");
		Thread.sleep(1000);

		//Click Organization Again
		admin.Click_Organization();
		test.pass("Clicked Organization Button again.");
		Thread.sleep(1000);

		//Click Locations
		admin.Click_Locations();
		test.pass("Clicked Locations.");
		Thread.sleep(1000);

		//h5[text()="Locations"]
		// To get weather the Created Job is available in the records
		WebDriverWait location_txt = new WebDriverWait(driver,Duration.ofSeconds(10));
		location_txt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()=\"Locations\"]")));
		try {
			test.pass("The Location page is Visible.");
			Thread.sleep(1000);
		}catch(Exception e) {
			test.fail("The Location page is not Visible.");
		}

		//Click Add button in Locations
		admin.Click_Add_in_Locations();
		test.pass("Clicked Add Button in Locations.");
		Thread.sleep(1000);

		//Enter Location Name
		admin.Enter_Location_Name("TNagar");
		test.pass("Entered Location Name.");
		Thread.sleep(1000);

		//Enter City Name
		admin.Enter_Location_City("Chennai");
		test.pass("Entered City Name");
		Thread.sleep(1000);

		//To Click the Country Arrow icon
		WebDriverWait carrow = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			carrow.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//i[@class=\"oxd-icon bi-caret-down-fill oxd-select-text--arrow\"]"))); 


			admin.Click_CountryArrowIcon();
			test.pass("Clicked Country Down Arrow icon in Add location page");
			Thread.sleep(2000);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			admin.Select_India();
			test.pass("Selected India in Country dropdown list.");
			Thread.sleep(1000);

		} catch (TimeoutException e) {
			test.fail("Country Down Arrow icon is NOT clickable.");
		}
		Thread.sleep(2000);

		//Click Save Button in Add Location
		admin.Click_Save_in_AddLocation();
		test.pass("Clicked Save Button in Add Location.");
		Thread.sleep(4000);

		//To check is the page is Locations page?
		WebDriverWait chk_again_loc_txt = new WebDriverWait(driver,Duration.ofSeconds(10));
		chk_again_loc_txt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()=\"Locations\"]")));
		try {
			test.pass("The Locations page is vislble");
		}catch(Exception e) {
			test.fail("The Locations page is not visible.");
		}
		Thread.sleep(1000);

		//Enter the Location Name to search
		admin.Enter_Location_name_to_search("TNagar");
		test.pass("Entered Location.");
		Thread.sleep(1000);

		//		//Enter the City Name to search
		//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//		admin.Enter_Location_name_to_search("Chennai");
		//		Thread.sleep(1000);


		//TO select arrow icon for selecting India	
		WebDriverWait carrow_again = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			carrow_again.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//i[@class=\"oxd-icon bi-caret-down-fill oxd-select-text--arrow\"]"))); 


			admin.Click_CountryArrowIcon();
			test.pass("Clicked Country Down Arrow icon in Add location page");
			Thread.sleep(2000);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			admin.Select_India();
			test.pass("Selected India in Country dropdown list.");
			Thread.sleep(1000);

		} catch (TimeoutException e) {
			test.fail("Country Down Arrow icon is NOT clickable.");
		}
		Thread.sleep(2000);

		//Click Search in location Page
		admin.Click_Search_in_loc();
		test.pass("Clicked search button in location.");
		Thread.sleep(1000);


		// To get Created Location and delete the data	
		WebDriverWait dl = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Click Delete icon for T Nagar
		By jb_deleteIcons = By.xpath(
				"//div[text()=\"TNagar\"]/ancestor::div[@role='row']//button"
				);

		WebElement deleteBtns = dl.until(
				ExpectedConditions.elementToBeClickable(jb_deleteIcons)
				);
		deleteBtns.click();
		test.pass("Clicked Delete button in location.");
		Thread.sleep(2000);

		// Click Yes, Delete on confirmation popup
		By yesDeleteBtns = By.xpath("//button[normalize-space()='Yes, Delete']");

		dl.until(
				ExpectedConditions.elementToBeClickable(yesDeleteBtns)
				).click();
		test.pass("Clicked Yes, Delete Button in location.");
		Thread.sleep(1000);


		test.info("Testing the Locations in Oranization feature is  Successfully Completed.");




		//********************************************** ORGANIZATION *************************************************//






	}

	@AfterClass
	public void CloseReport() throws InterruptedException {
		test.info("Admin Page Execution testing successfully Competed... And Navigating to PIM Page");
		extent.flush();
		Thread.sleep(3000);
		driver.quit();
	}

}



















