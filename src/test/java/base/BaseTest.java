package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

//create base class to be used as setup and tear down and to be re-used in test cases

public class BaseTest {

	//define static variables to be accessed by test cases
	public static WebDriver driver;
	public static FileReader fr;
	public static Properties prop;

	@BeforeTest
	public void setUp() throws IOException {

		//use system properties to define path to the properties file

		//get user current dir
		String userDir = System.getProperty("user.dir");

		//get separator: can be different for windows/linux/mac users
		String spr = System.getProperty("file.separator");

		//get path to the properties file
		String propPath = userDir+spr+"src"+spr+"test"+spr+"resources"+spr+"config"+spr+"config.properties";

		//create new object of FileReader
		fr = new FileReader(propPath);

		//create new object of Properties file
		prop = new Properties();

		//load properties file
		prop.load(fr);

		//setup WebDriver if not yet done
		if (driver == null) {

			//setup appropriate driver depending on the value from properties file
			if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			else if (prop.getProperty("browser").equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
		}

		driver.get(prop.getProperty("testurl"));

	}

	@AfterTest
	public void tearDown() {

		//close browser
		driver.close();
		System.out.println("Tear down completed");
	}

}
