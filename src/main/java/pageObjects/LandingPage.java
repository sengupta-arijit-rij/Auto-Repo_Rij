package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;

	By signIn = By.xpath("//a[contains(@href,\"sign_in\")]");
	By pageTitle = By.xpath("//*[contains(text(),\"Featured Courses\")]");
	By navigationLabel = By.xpath("//ul[@class=\"nav navbar-nav navbar-right\"]");

	public LandingPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public LoginPage getLogin() {		
		driver.findElement(signIn).click();
		LoginPage login= new LoginPage(driver);
		return login;
	}

	public WebElement getTitle() {
		return driver.findElement(pageTitle);
	}

	public WebElement navigationLabel() {
		return driver.findElement(navigationLabel);
	}

}
