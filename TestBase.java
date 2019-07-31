package com.jbk.Base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase 
{
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() 
	{
		prop = new Properties();
		
		try 
		{
			FileInputStream fis = new FileInputStream("E:\\New folder\\Hybrid Using Maven\\AdminLTE\\src\\main\\java\\com\\jbk\\Config\\config.property");
		    prop.load(fis);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void setup()
	{
		String browser = prop.getProperty("browser");
		String chromepath = prop.getProperty("chromepath");
		String url =prop.getProperty("siteUrl");
		
		if (browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",chromepath);
			driver = new ChromeDriver();			
		}
		else if (browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to(url);
	}

}
