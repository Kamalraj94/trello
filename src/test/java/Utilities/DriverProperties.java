package Utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverProperties {

	static ConfigFileReader config = null;
	static String url = null;
	public static WebDriver driver;

	public DriverProperties() {

	}

	public static void start_session() throws IOException {
		
		config = new ConfigFileReader();

		if (config.getBrowser().equals("MOZILLA")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		if (config.getBrowser().equals("CHROME")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
	}

	public static void stop_session() {
		driver.close();
		driver.quit();
	}

}
