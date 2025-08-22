package TestBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	public Properties properties;
	
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({"os", "browser"})
	public void setup(@Optional("windows") String os,
            @Optional("chrome") String browser) throws IOException {
		
		//Loading config.properties file
		FileReader file = new FileReader("./src//test//resources//config.properties");
		properties = new Properties();
		properties.load(file);
		
		logger = LogManager.getLogger(this.getClass());
		
		if(properties.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();
			
			//os
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN10);
			}
			else if(os.equalsIgnoreCase("linux"))
			{
				capabilities.setPlatform(Platform.LINUX);
				
			}
			else if (os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching os");
				return;
			}
			//browser
			switch(browser.toLowerCase())
			{
			case "chrome": capabilities.setBrowserName("chrome"); 
			break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge"); 
			break;
			case "firefox": capabilities.setBrowserName("firefox"); 
			break;
			default: System.out.println("No matching browser"); 
			return;
			}
			
			driver = new RemoteWebDriver(URI.create("http://localhost:4444/wd/hub").toURL(), capabilities);
			
		}
		
		if(properties.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			switch (browser.toLowerCase()) {
	        case "chrome": driver = new ChromeDriver();
	        break;
	        case "firefox": driver = new FirefoxDriver();
	        break;
	        case "edge": driver = new EdgeDriver();
	        break;
	        default: System.out.println("Invalid Browser Name..");
	        return;
			
		}
				
    }
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(properties.getProperty("webUrl_1"));
		driver.manage().window().maximize();
	}
	@AfterClass(groups= {"Sanity","Regression","Master"})
	public void tearDown() {
		driver.quit();
	}
		
	public String randomString(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        }
        return sb.toString();
    }

    // Generate random alphanumeric string
    public String randomAlphaNumeric(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        }
        return sb.toString();
    }

    // Generate random numeric string
    public String randomNumber(int length) {
        String numbers = "0123456789";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(numbers.charAt(rnd.nextInt(numbers.length())));
        }
        return sb.toString();
    }
	
	public String captureScreen(String tName) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tName + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}

}
