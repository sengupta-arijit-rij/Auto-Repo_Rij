package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class base {
	
	public WebDriver driver;
	public String userDir=System.getProperty("user.dir");
	public Properties prop;
	
	

	public WebDriver initializeDriver() throws IOException{
		
		prop= new Properties();
		FileInputStream fis= new FileInputStream(userDir+"\\src\\main\\java\\resources\\data.properties");	
		try {
			prop.load(fis);	
		}catch(Exception e) {
			
		}
			
		String browserName=prop.getProperty("browser");
		if(browserName.toLowerCase().contains("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", userDir+"\\src\\main\\java\\resources\\chromedriver.exe");
			if(browserName.toLowerCase().contains("headless")) {
				ChromeOptions options=new ChromeOptions();
				options.addArguments("headless");
				driver=new ChromeDriver(options);
			}else {
				driver=new ChromeDriver();
			}
			
			
		}else if(browserName=="IE") {
			
			System.setProperty("webdriver.internetexplorer.driver", userDir+"\\src\\main\\java\\resources\\internetexplorerdriver.exe");
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
		
		

	}
	
	public void getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=userDir+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		
	}

	

	

}
