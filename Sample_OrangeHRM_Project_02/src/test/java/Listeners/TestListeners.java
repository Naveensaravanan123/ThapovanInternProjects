package Listeners;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener{

	public void onTestFailures(ITestResult result) {
		System.out.println("Test Failed : "+result.getName());

		WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");

		try {
			File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

			File dest = new File("./Screenshots/" + result.getName() + ".png");

			dest.getParentFile().mkdir();
			FileUtils.copyDirectory(screenshotFile, dest);

			System.out.println("Screenshot saved at "+ dest.getAbsolutePath());
		}catch(Exception e) {
			e.getStackTrace();
		}
	}

}
