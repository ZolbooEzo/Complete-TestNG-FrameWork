package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	private static WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public static WebDriver getDriver() {

		if (driver == null) {
			String browser = Config.getRequiredData("browser");

			switch (browser) {

			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
				
			case "chrome-headless":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
				break;
				
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
				
			case "firefox-headless":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
				break;
				
			case "edge":
				if(!System.getProperty("os.name").toLowerCase().contains("windows")) {
					throw new WebDriverException("Your OS doesn't support edge!");
				}
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
				
			case "safari":
				if(!System.getProperty("os.name").toLowerCase().contains("mac")) {
					throw new WebDriverException("You OS doesn't support safari!");
				}
				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
				break;

			default:
				throw new IllegalArgumentException("Please prove correct browser name!");
			}

			driver.manage().window().maximize();
			driver.get(Config.getRequiredData("url"));
			PageInitializer.initializer();
		}
		return driver;
	}

	@AfterMethod(alwaysRun = true)
	public static void closeDriver() {
		if (driver != null) {
			driver.close();
			driver.quit();
			driver = null;
		}
	}

}
