package Tests;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class HomeTest {

	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;

	@BeforeTest
	public void LaunchBrowser() throws InterruptedException {
		ExtentSparkReporter reporter =  new ExtentSparkReporter("./Reports/HomePageReport.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		test = extent.createTest("Home Page Execution Started Successfully...");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);
	}

	@Test
	public void HomeTestCases_001() throws InterruptedException {
		HomePage home = new HomePage(driver);
		test.pass("Browser Opened Successfully...");
		
		home.search_TextField("IPhone 17");
		test.pass("Entered product name in search box");
		Thread.sleep(1000);
		
		home.search_btn();
		test.pass("Clicked Search Button");
		Thread.sleep(1000);	
		
		home.select_product();
		test.pass("Moved to the product and Clicked the product.");
		Thread.sleep(000);
			
		String parent = driver.getWindowHandle();
		System.out.println("Parent page "+ parent);
		test.pass("Got the parent Window.");
		Thread.sleep(1000);
		
		Set<String> allPages = driver.getWindowHandles();
		for (String page : allPages) {
		    if (!page.equals(parent)) {
		        driver.switchTo().window(page);
		        break;
		    }
		}
		
		test.pass("Switched to the Child Window");
		Thread.sleep(1000);
		
		System.out.println(driver.getCurrentUrl());
		test.pass("Got the CurrentURL");
		Thread.sleep(1000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(@class,\"LS5qY1\")]")));

		List<WebElement> products = driver.findElements(By.xpath("//li[contains(@class,\"LS5qY1\")]"));

		System.out.println("Total product highlights: " + products.size());

		for (WebElement p : products) {
		    System.out.println(p.getText());
		}
		
		Thread.sleep(3000);
		test.pass("Got the Product Higlights as Text.");
		
		home.cart_btn();
		test.pass("Clicked Add To Cart Button.");
		Thread.sleep(1000);
	
		WebElement textElement = driver.findElement(By.xpath("//a[text()=\"Apple iPhone 17 Pro (Cosmic Orange, 1 TB)\"]"));	
		Assert.assertTrue("Product Is Not Added to the Cart Page.", textElement.isDisplayed());
		test.pass("The product added in the Cart Page");
		Thread.sleep(1000);
		
		driver.navigate().back();
		Thread.sleep(1000);
		
		driver.switchTo().window(parent);
		test.pass("Switched back to Parent Window");
		Thread.sleep(1000);
		
		driver.navigate().back();
		test.pass("Switched to the Home Page");
		Thread.sleep(1000);		
	}
	@AfterTest
	public void CloseBrowser() throws InterruptedException {
		test.info("Browser Closed Successfully...");
		Thread.sleep(1000);
		extent.flush();
		driver.quit();
	}











































}
