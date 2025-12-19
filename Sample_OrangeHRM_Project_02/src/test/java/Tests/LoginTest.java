package Tests;

//import java.io.File;
import java.io.IOException;
import java.time.Duration;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	public WebDriver driver;
	public ExtentReports extent;
	public ExtentTest test;

	@BeforeClass
	public void LaunchBrowser(ITestContext context) throws InterruptedException {

		ExtentSparkReporter reporter = new ExtentSparkReporter("./Reports/LoginTestReports.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		test = extent.createTest("Login Page Test Execution is Started.");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		context.setAttribute("driver", driver);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(1000);
		test.pass("URL Opened Successfully...");

	}

	@Test(priority = 1)
	public void LoginPageTestcases() throws InterruptedException, IOException {
		LoginPage login = new LoginPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()=\"Login\"]")));
		test.pass("The Login Page is displayed.");


		//Forgot password
		login.CLick_Forgot_Password();
		test.pass("Clicked Forgot Password.");
		Thread.sleep(1000);

		driver.navigate().back();
		Thread.sleep(1000);

		//Enter Username
		login.Enter_Username("Admin");
		test.pass("Entered Username.");
		Thread.sleep(1000);

		//Enter Password
		login.Enter_Password("admin123");
		test.pass("Entered Password.");
		Thread.sleep(1000);

		//		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//		FileUtils.copyFile(screenshotFile, new File("./Screenshots/LoginPageScreenshot.png"));


		//Login Button
		login.CLick_Login_Button();
		test.pass("Clicked Login Button");
		Thread.sleep(5000);




	}

	@AfterClass
	public void CloseBrowser() throws InterruptedException {
		test.info("Test Execution of Login Page Successfully Completed. And Navigated to Dashboard.");
		Thread.sleep(1000);
		extent.flush();
		Thread.sleep(1000);

	}



}
