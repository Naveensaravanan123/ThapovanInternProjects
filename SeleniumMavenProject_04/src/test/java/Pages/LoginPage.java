package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By txt_username = By.xpath("//input[@name=\"username\"]");
	By txt_password = By.xpath("//input[@name=\"password\"]");
	By btn_login = By.xpath("//button[text()=\" Login \"]");
	By frgt_password = By.xpath("//p[text()=\"Forgot your password? \"]");
	By txt_profile = By.xpath("//p[text()=\"Minh Nguyen\"]");
	By link_logout = By.xpath("//a[text()=\"Logout\"]");
	
	public void username(String uname) {
		driver.findElement(txt_username).sendKeys(uname);
	}
	
	public void password(String pass) {
		driver.findElement(txt_password).sendKeys(pass);
	}
	
	public void login_btn() {
		driver.findElement(btn_login).click();
	}
	
	public void profile_txt() {
		driver.findElement(txt_profile).click();
	}
	
	public void logout_link() {
		driver.findElement(link_logout).click();
	}
	
	public void forgot_pwd() {
	driver.findElement(frgt_password).click();
}

}
