package testNG_Test;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.IRCTCNextGenerationE_TicketingSystem;

public class VarifyTicketBookingSection {
	
	private WebDriver driver;
	private IRCTCNextGenerationE_TicketingSystem irctcNextGenerationE_TicketingSystem;
	
	@Parameters ("browser")
	@BeforeTest
	public void browserLaunch(String browserName)
	{
		if(browserName.contains("Chrome"))
		{
			driver=Browser.launchChrome();
		}
		
		if(browserName.contains("Edge"))
		{
			driver=Browser.launchEdge();
		}
	}
	
	@BeforeClass
	public void launchBrowser()
	{
		irctcNextGenerationE_TicketingSystem=new IRCTCNextGenerationE_TicketingSystem(driver);
	}
	
	@BeforeMethod
	public void launchAppicationHomePage()
	{
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	}
	
	@Test
	public void varifyTicketBookingFields() throws InterruptedException, EncryptedDocumentException, IOException
	{
		
		irctcNextGenerationE_TicketingSystem.sendFrom();
		irctcNextGenerationE_TicketingSystem.sendTo();
		irctcNextGenerationE_TicketingSystem.sendDate();
		//irctcNextGenerationE_TicketingSystem.sendDay();
		irctcNextGenerationE_TicketingSystem.generalDropDownBox();
		irctcNextGenerationE_TicketingSystem.allClassesDropDownBox();
		irctcNextGenerationE_TicketingSystem.clickSearchButton();
	}
	
	
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("after method");
	}
	
	@AfterClass
	public void closeTheBrowser()
	{
		irctcNextGenerationE_TicketingSystem=null;
	}
	
	@AfterTest
	public void afterTest()
	{
		driver.quit();
		driver=null;
		System.gc();
	}
	

}
