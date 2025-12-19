package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;

	}
	
	//********************************************* LOGIN PAGE **************************************************//

	//LoginPage
	//username Text field.
	By txt_username = By.xpath("//input[@name=\"username\"]");
	//Password text field.
	By txt_password = By.xpath("//input[@name=\"password\"]");
	//forgot password
	By link_forgot_pass = By.xpath("//p[@class=\"oxd-text oxd-text--p orangehrm-login-forgot-header\"]");
	//Login Button
	By btn_login_button = By.xpath("//button[text()=\" Login \"]");


	//Username
	public void Enter_Username(String uname) {
		driver.findElement(txt_username).sendKeys(uname);
	}
	//Password
	public void Enter_Password(String pass) {
		driver.findElement(txt_password).sendKeys(pass);
	}
	//Forgot Password
	public void CLick_Forgot_Password() {
		driver.findElement(link_forgot_pass).click();
	}
	//Login button
	public void CLick_Login_Button() {
		driver.findElement(btn_login_button).click();
	}
	
	//********************************************* LOGIN PAGE **************************************************//

}


