package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	WebDriver driver;

	By email = By.xpath("//input[@id=\"user_email\"]");
	By password = By.xpath("//input[@id=\"user_password\"]");
	By login = By.xpath("//input[contains(@value,\"Log In\")]");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getEmail() {

		return driver.findElement(email);

	}

	public WebElement getPassword() {
		return driver.findElement(password);

	}

	public WebElement getLoginButton() {
		return driver.findElement(login);

	}

}
