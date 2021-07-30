package Academy;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePageTest extends base {
	public static  Logger log= LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	
	@BeforeTest
	public void preRequisite() throws IOException {
		driver = initializeDriver();
		log.info("Driver instance initialized");
		//driver.get(prop.getProperty("url"));
	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String userName, String password) throws IOException {
		driver.get(prop.getProperty("url"));
		log.info("URL hit");
		LandingPage lp = new LandingPage(driver);
		LoginPage login = lp.getLogin();
		login.getEmail().sendKeys(userName);
		login.getPassword().sendKeys(password);
		login.getLoginButton().click();
		log.info("Successfully validated");
		

	}
	@AfterTest
	public void tearDown() {
		driver.close();
		log.info("Browser truncated");
	}

	@DataProvider
	public Object getData() {
		Object[][] data = new Object[2][2];
		data[0][0] = "abultabul";
		data[0][1] = "ablutablu";
		data[1][0] = "abultabul1";
		data[1][1] = "ablutablu1";

		return data;
	}

	

}
