package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage {
	WebDriver driver;

	public AdminPage(WebDriver driver) {
		this.driver = driver;
	}

	//Admin Button
	By btn_admin = By.xpath("//span[text()=\"Admin\"]");

	//Admin Button
	public void Click_Admin() {
		driver.findElement(btn_admin).click();
	}

	//***************************************** USER MANAGEMENT *******************************************//

	//User Management Button
	By btn_userMAnagement = By.xpath("//span[text()=\"User Management \"]");
	//Users Link
	By link_Users  = By.xpath("//a[text()=\"Users\"]");

	//username Search field
	By txt_username = By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]");

	//User Role arrow icon
	By click_ur_down_arrow = By.xpath("(//i[@class=\"oxd-icon bi-caret-down-fill oxd-select-text--arrow\"])[1]");
	//CLick Admin
	By click_admin_in_UserRole = By.xpath("(//div[@role='option']//span[text()=\"Admin\"])[1]");

	//Status arrow icon
	By click_s_down_arrow = By.xpath("(//i[@class=\"oxd-icon bi-caret-down-fill oxd-select-text--arrow\"])[2]");
	//Click Enabled
	By click_Enabled_in_Status = By.xpath("(//div[@role='option']//span[text()='Enabled'])[1]");
	//Search Button
	By btn_serach = By.xpath("//button[text()=\" Search \"]");
	//Reset Button
	By btn_reset = By.xpath("//button[text()=\" Reset \"]");

	// Add Employee +
	By btn_Add = By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]");
	//User Role
	By user_role_icon = By.xpath("(//i[@class=\"oxd-icon bi-caret-down-fill oxd-select-text--arrow\"])[1]");

	//Select ESS
	By select_ess = By.xpath("//div[@role='option']//span[text()='ESS']");

	//Employee Name
	By txt_employee_name = By.xpath("//input[@placeholder=\"Type for hints...\"]");

	//Status arrow in Add User page
	By click_s_arrow_in_AddUser = By.xpath("(//i[@class=\"oxd-icon bi-caret-down-fill oxd-select-text--arrow\"])[2]");

	//Enter Username
	By txt_usname = By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]");

	//Enter password
	By txt_pswd = By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]");

	//Conf pwd
	By txt_conf_pwd = By.xpath("(//input[@type=\"password\"])[2]");

	//Save button
	By btn_save = By.xpath("//button[text()=\" Save \"]");

	//Delete Icon
	By icon_delete = By.xpath("//i[@class=\"oxd-icon bi-trash\"]");

	//Yes,Delete button
	By btn_Yes_Delete = By.xpath("//button[text()=\" Yes, Delete \"]");

	//Enter Username Again
	By enter_uname_again = By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]");



	//User Management
	public void Click_User_Management() {
		driver.findElement(btn_userMAnagement).click();
	}
	//User Link
	public void Click_User() {
		driver.findElement(link_Users).click();
	}

	//Enter Username
	public void Enter_Username(String usname) {
		driver.findElement(txt_username).sendKeys(usname);
	}
	//Click User Role Down Arrow
	public void Click_UserRole_DownArrow() {
		driver.findElement(click_ur_down_arrow).click();
	}
	//Click Admin in User Role DropDown
	public void Click_Admin_in_UserRole_Dropdown() {
		driver.findElement(click_admin_in_UserRole).click();
	}

	//Click Status Dropdown
	public void Click_Status_DownArrow() {
		driver.findElement(click_s_down_arrow).click();
	}
	//Click Enabled in Status DropDown
	public void Click_Enabled_in_Status_Dropdown() {
		driver.findElement(click_Enabled_in_Status).click();
	}
	//Search Button
	public void Click_Search_button() {
		driver.findElement(btn_serach).click();
	}
	//Reset Button
	public void Click_Reset_Button() {
		driver.findElement(btn_reset).click();
	}

	//Add Employee Button +
	public void Click_Add_Button() {
		driver.findElement(btn_Add).click();
	}
	//Click User Role icon
	public void Click_UserRole_Icon() {
		driver.findElement(user_role_icon).click();
	}
	//Select ESS
	public void Select_Ess() {
		driver.findElement(select_ess).click();
	}

	//Enter Employee Name
	public void Enter_Employee_Name(String ename) {
		driver.findElement(txt_employee_name).sendKeys(ename);
	}

	//Click Status Dropdown in Add User Page
	public void Click_StatusArrow_in_AddUserPage() {
		driver.findElement(click_s_arrow_in_AddUser).click();
	}

	//Enter Username
	public void Click_userName_In_AddUser(String usname) {
		driver.findElement(txt_usname).sendKeys(usname);
	}
	//Enter Password
	public void Click_pwd_In_AddUser(String pwd) {
		driver.findElement(txt_pswd).sendKeys(pwd);
	}
	//Enter Conf Password
	public void Click_Conf_pwd_In_AddUser(String cnf_pwd) {
		driver.findElement(txt_conf_pwd).sendKeys(cnf_pwd);
	}
	//Save Button
	public void Click_Save_btn() {
		driver.findElement(btn_save).click();
	}

	//Delete Icon
	public void CLick_Delete_Icon() {
		driver.findElement(icon_delete).click();
	}
	//Yes Delete Button
	public void Click_Yes_Delete() {
		driver.findElement(btn_Yes_Delete).click();
	}

	//Enter USername Again
	public void Enter_uname_again(String uname_again) {
		driver.findElement(enter_uname_again).sendKeys(uname_again);		
	}

	//***************************************** USER MANAGEMENT *******************************************//


	//********************************************** JOB *************************************************//

	//Job 
	By btn_job = By.xpath("//span[text()=\"Job \"]");
	//Job Title
	By btn_job_Title = By.xpath("//a[text()=\"Job Titles\"]");
	//Add Button in Job Title
	By btn_add_in_job_title = By.xpath("//button[text()=\" Add \"]");
	//Enter Job Title
	By txt_job_title = By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]");
	//Add Description
	By txt_add_description = By.xpath("//textarea[@placeholder=\"Type description here\"]");
	//Save Button in Job Title
	By btn_save_in_job_title = By.xpath("//button[text()=\" Save \"]");
	//Delete created job
	By btn_delete_created_job = By.xpath("(//i[@class=\"oxd-icon bi-trash\"])[19]");
	//Click YesDelete
	By yes_delete_btn = By.xpath("//button[text()=\" Yes, Delete \"]");

	//Pay Grades
	By btn_pay_grades = By.xpath("//a[text()=\"Pay Grades\"]");
	//Add Button in Pay grades
	By btn_add_in_PayGrades = By.xpath("//button[text()=\" Add \"]");
	//Enter the Pay Grade
	By txt_pay_grades = By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]");
	//Click Save Button in Pay Grades
	By btn_save_in_pay_grades = By.xpath("//button[text()=\" Save \"]");
	//Cancel Button in Edit Pay Grades
	By btn_cancel_in_edit_paygrades = By.xpath("//button[text()=\" Cancel \"]");


	//Job
	public void Click_Job() {
		driver.findElement(btn_job).click();
	}
	//Job Title
	public void Click_Job_Title() {
		driver.findElement(btn_job_Title).click();
	}
	//Add button in Job Title
	public void Click_Add_in_Job_Title() {
		driver.findElement(btn_add_in_job_title).click();
	}
	//Enter Job Title
	public void Enter_Job_Title(String jbTitle) {
		driver.findElement(txt_job_title).sendKeys(jbTitle);
	}
	//Add Description
	public void Enter_Description(String addDescription) {
		driver.findElement(txt_add_description).sendKeys(addDescription);
	}
	//Save button in Job Title
	public void Click_Save_Button_in_JobTitle() {
		driver.findElement(btn_save_in_job_title).click();
	}
	//Delete the Created Job
	public void Click_Delete_btn_in_JobTitle() {
		driver.findElement(btn_delete_created_job).click();
	}
	//Click YesDelete 
	public void Click_YesDelete_btn_in_JobTitle() {
		driver.findElement(yes_delete_btn).click();
	}

	//Click Pay Grades
	public void Click_Pay_grades() {
		driver.findElement(btn_pay_grades).click();
	}
	//Click Add button in Pay Grades
	public void Click_Add_btn_in_Pay_grades() {
		driver.findElement(btn_add_in_PayGrades).click();
	}
	//Enter the Pay Grades
	public void Enter_Pay_Grades(String pgrades) {
		driver.findElement(txt_pay_grades).sendKeys(pgrades);
	}
	//Click Save in Pay Grades
	public void Click_Save_btn_in__Pay_Grades() {
		driver.findElement(btn_save_in_pay_grades).click();
	}
	//Click Cancel Button in Edit Pay Grades
	public void Click_Cancel__btn_in_Edit_Pay_Grades() {
		driver.findElement(btn_cancel_in_edit_paygrades).click();
	}


	//********************************************** JOB *************************************************//

	//********************************************** ORGANIZATION *************************************************//

	//Organization Button
	By btn_organization = By.xpath("//span[text()=\"Organization \"]");
	//General Information
	By btn_general_organization = By.xpath("//a[text()=\"General Information\"]");
	//Locations
	By btn_locations = By.xpath("//a[text()=\"Locations\"]");
	//Add Button in Locations
	By btn_add_in_loc = By.xpath("//button[text()=\" Add \"]");
	//Enter Location Name
	By txt_location_name = By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]");
	//Enter location city
	By txt_location_city = By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[3]");
	//Click Country arrow icon
	By icon_carrow = By.xpath("//i[@class=\"oxd-icon bi-caret-down-fill oxd-select-text--arrow\"]");
	//Select India in Country Dropdown icon
	By select_india = By.xpath("//div[@role='listbox']//span[normalize-space()='India']");
	//Save Button in Add Locations
	By btn_save_in_addLocation = By.xpath("//button[text()=\" Save \"]");
	//Enter the location name to search
	By txt_loc_name_to_search = By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]");
	//Enter City to search
	By txt_city_to_search = By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[3]");
	//Select India to check
	By select_india_to_check = By.xpath("(//div[text()=\"India\"])[1]");
	//Click Search Button
	By click_search_button_in_loc = By.xpath("//button[text()=\" Search \"]");
	//Delete Loc data
	By delete_loc_data = By.xpath("//i[@class=\"oxd-icon bi-trash\"]");
	//Click yes,Delete in Location data
	By YesDelete_dataInLoc = By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin\"]");


	//Organization Button
	public void Click_Organization() {
		driver.findElement(btn_organization).click();
	}
	//General Organizatio Button
	public void Click_General_Organization() {
		driver.findElement(btn_general_organization).click();
	}
	//Click Locations
	public void Click_Locations() {
		driver.findElement(btn_locations).click();
	}
	//Click Add Button in Locations
	public void Click_Add_in_Locations() {
		driver.findElement(btn_add_in_loc).click();
	}
	//Enter Location Name
	public void Enter_Location_Name(String lname) {
		driver.findElement(txt_location_name).sendKeys(lname);
	}
	//Enter Location city
	public void Enter_Location_City(String cname) {
		driver.findElement(txt_location_city).sendKeys(cname);
	}
	//Click Down Arrow in Coutry page
	public void Click_CountryArrowIcon() {
		driver.findElement(icon_carrow).click();
	}
	//Select India
	public void Select_India() {
		driver.findElement(select_india).click();
	}
	//Save Button in Add Location
	public void Click_Save_in_AddLocation() {
		driver.findElement(btn_save_in_addLocation).click();
	}
	//Enter location name to search location is visible
	public void Enter_Location_name_to_search(String loc_name) {
		driver.findElement(txt_loc_name_to_search).sendKeys(loc_name);;
	}
	//Enter City name to search City is visible
	public void Enter_City_name_to_search(String city_name) {
		driver.findElement(txt_city_to_search).sendKeys(city_name);
	}
	//Select India to Check
	public void Select_India_To_Check() {
		driver.findElement(select_india_to_check).click();
	}
	//Click Search button in location
	public void Click_Search_in_loc() {
		driver.findElement(click_search_button_in_loc).click();
	}
	//Delete Location data
	public void Click_Delete_loc_data() {
		driver.findElement(delete_loc_data).click();
	}
	//Click Yes,Delete Location data
	public void Click_Yes_Delete_loc_data() {
		driver.findElement(YesDelete_dataInLoc).click();
	}

	//********************************************** ORGANIZATION *************************************************//











}





