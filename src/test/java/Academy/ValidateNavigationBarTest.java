package Academy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class ValidateNavigationBarTest extends base {
	public static  Logger log= LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	
	@BeforeTest
	public void preRequisite() throws IOException {
		driver = initializeDriver();
		log.info("Driver instance initialized");
		driver.get(prop.getProperty("url"));
		log.info("URL hit");
	}

	@Test
	public void basePageNavigation() throws IOException {
		LandingPage lp = new LandingPage(driver);
		Assert.assertTrue(lp.navigationLabel().isDisplayed());
		log.info("Successfully validated");

	}

	@AfterTest
	public void tearDown() {
		driver.close();
		log.info("Browser truncated");
	}

}
