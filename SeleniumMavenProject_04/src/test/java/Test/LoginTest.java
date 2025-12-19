package Test;

import java.time.Duration;

//import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class LoginTest {
	
	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeTest
	public void LaunchBrowser(ITestContext context) throws InterruptedException {
		ExtentSparkReporter reporter = new ExtentSparkReporter("./Reports/LoginTestcasesReport.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		test = extent.createTest("Login Execution Started Successfully...");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		context.setAttribute("driver", driver);
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(4000);
		driver.manage().window().maximize();
		test.info("URL Opened successfully...");
		
	}
	
	@Test
	public void LoginTestcases_001() throws InterruptedException {
		
		LoginPage login = new LoginPage(driver);
		
		login.username("Admin");
		test.pass("Entered username.");
		Thread.sleep(1000);
		
		login.password("admin123");
		test.pass("Entered password.");
		Thread.sleep(1000);

		
		login.login_btn();
		test.pass("Cliked Login Button.");
		Thread.sleep(1000);

		Assert.assertTrue("Login Failed - Incorrect username/password",
			driver.getCurrentUrl().contains("dashboard"));
		
		Thread.sleep(3000);
		
//		Alert a = driver.switchTo().alert();
//		a.accept();
//		Thread.sleep(1000);

		
		login.profile_txt();
		test.pass("Profile Link text clicked..");	
		Thread.sleep(1000);
		
		login.logout_link();
		test.pass("Clicked Login link Successfully...");
		Thread.sleep(1000);
		
		driver.navigate().refresh();
		Thread.sleep(1000);
		
		login.forgot_pwd();
		test.pass("Clicked Forgot your password? link.");
		Thread.sleep(1000);
		driver.navigate().back();	

	}
	
	@AfterTest
	public void closeBrowser() throws InterruptedException {
		test.info("Browser closed successfully...");
		extent.flush();
		Thread.sleep(3000);
		driver.quit();
	}
	

}

















































