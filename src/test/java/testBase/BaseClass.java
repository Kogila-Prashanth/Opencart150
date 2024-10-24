package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
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
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	@SuppressWarnings("deprecation")
	@BeforeClass(groups={"sanity","Regression","Master"})
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws IOException
	{
		//loading config.properties file
		FileReader file= new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		logger = LogManager.getLogger(this.getClass());
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();
			// os
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN10);

			}
			else if (os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else if (os.equalsIgnoreCase("linux"))
			{
				capabilities.setPlatform(Platform.LINUX);
			}
			else
			{
				System.out.println(" No matching os");
				return;
			}
			// Browser
			switch(br.toLowerCase())
			{
			case"chrome":capabilities.setBrowserName("chrome");break;
			case"edge":capabilities.setBrowserName("MicrosoftEdge");break;
			case"firefox":capabilities.setBrowserName("firefox");break;
			default:System.out.println("No matching browser");return;
			}
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		}
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{

			switch(br.toLowerCase())
			{
			case "chrome":  driver=new ChromeDriver();break;
			case "edge":    driver=new EdgeDriver();break;
			case "firefox": driver=new FirefoxDriver();break;
			default:System.out.println("Invalid browser name...");return;
			}
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//	driver.get("http://localhost/opencart/upload/");
		//	driver.get(p.getProperty("appURL1"));	//reading url from properties file
		driver.get(p.getProperty("appURL2"));
		driver.manage().window().maximize();
	}
	@AfterClass(groups= {"sanity","Regression","Master"})
	public void tearDown()
	{
		driver.quit();
	}
	private static final String ALPHABET="ABCDEGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private static final String NUMERIC = "0123456789";
	public String randomString( )
	{
		int length=5;
		return generateRandomString(ALPHABET, length);
	}
	public String randomNumber()
	{
		int length = 10;
		return generateRandomString(NUMERIC,length);
	}
	public String randomAlphanumeric()
	{
		String randomAlphabetic = generateRandomString(ALPHABET,3);
		String randomNumeric = generateRandomString(NUMERIC,3);
		return randomAlphabetic + "@" + randomNumeric;
	}
	private String generateRandomString(String characterSet,int length) 
	{
		Random random = new Random();
		StringBuilder sb=new StringBuilder(length);
		for(int i=0;i<length;i++)
		{
			sb.append(characterSet.charAt(random.nextInt(characterSet.length())));
		}
		return sb.toString();
	}
	public String captureScreen(String tname) throws IOException
	{
		String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
		File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png";
		File targetFile=new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}
}
