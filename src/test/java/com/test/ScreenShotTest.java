package com.test;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class ScreenShotTest {

	WebDriver driver;

	@BeforeMethod

	public void setup() {

		System.setProperty("webdriver.chrome.driver","D:\\EclipseSecond\\chromedriver.exe");
		
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://nxtgenaiacademy.com/demo-site/");
	}

	@Test()

	public void getScreenShotTest() throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver; // typecasting webdriver instance into TakeScreenShot interface
		// instance so we can use its methods

		File file = ts.getScreenshotAs(OutputType.FILE); // actually taking screenshot and saving it is in file format
		// type

// copying taken screen shot in desired folder
		Files.copy(file,
				new File("D:\\EclipseSecond\\Eclipse-Workplace\\ReportExtentTest\\Output\\img.png"));

		System.out.println(driver.getTitle());

	}

	@AfterMethod

	public void tearDown() {

		driver.quit();

	}

}
