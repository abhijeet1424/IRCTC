package pages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.This;
import utils.Utility;

public class IRCTCNextGenerationE_TicketingSystem {
	
	@FindBy (xpath = "//input[@aria-autocomplete='list']")private WebElement from;
	
	@FindBy (xpath = "(//input[@role='searchbox'])[2]")private WebElement to;
	
	@FindBy (xpath = "(//input[@type='text'])[3]")private WebElement date;
	
	//@FindBy (xpath = "//a[text()='30']")private WebElement day;
	
	@FindBy (xpath = "(//div[@style='width: 100%;'])[1]")private WebElement allClasses;
	
	@FindBy (xpath = "(//div[@style='width: 100%;'])[2]")private WebElement general;
	
	@FindBy (xpath = "//button[text()='Search']")private WebElement search;
	
	@FindBy (xpath = "//li[@role='option']//span")private List<WebElement>list;
	
	@FindBy (xpath = "//li[@role='option']//span")private List<WebElement>list1;
	
	private WebDriver driver;
	
	public IRCTCNextGenerationE_TicketingSystem(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void sendFrom() throws InterruptedException, EncryptedDocumentException, IOException
	{
		String fromData=Utility.getDataFromExcelSheet("Sheet1", 2, 0);
		String fromStationData=Utility.getDataFromExcelSheet("Sheet1", 2, 1);
		
		from.sendKeys(fromData);
		//List<WebElement>list=driver.findElements(By.xpath("//li[@role='option']//span"));
		System.out.println(list.size());
		for(int i=0;i< list.size();i++)
		{
			String result=list.get(i).getText();
			if(result.contains(fromStationData)) {
				list.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
	
	}
	
	public void sendTo() throws InterruptedException, EncryptedDocumentException, IOException
	{
		String toData=Utility.getDataFromExcelSheet("Sheet1", 2, 2);
		String toStationData=Utility.getDataFromExcelSheet("Sheet1", 2, 3);
		
		to.sendKeys(toData);
		//List<WebElement>list1=driver.findElements(By.xpath("//li[@role='option']//span"));
        System.out.println(list1.size());
        
        for(int i=0;i<list1.size();i++)
        {
        	String result=list1.get(i).getText();
        	
        	if(result.contains(toStationData))
        	{
        		list1.get(i).click();
        		break;
        	}
        }
        Thread.sleep(2000);
       // JavascriptExecutor js=(JavascriptExecutor)driver;
	    //js.executeScript("window.scrollBy(0,200);");
	}
	
	public void sendDate() throws InterruptedException, EncryptedDocumentException, IOException
	{
		date.sendKeys(Keys.CONTROL+"a");
		date.sendKeys(Keys.BACK_SPACE);
		Date dateData=Utility.getDateFromExcelsheet("Sheet1", 2, 4);
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
		String dateString=dateFormat.format(dateData);
		date.sendKeys(dateString);
		//date.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}
	
	//public void sendDay()
//	{
//		day.click();
//	}
	
	
	public void allClassesDropDownBox() throws InterruptedException
	{
		allClasses.click();
		Thread.sleep(2000);
		List<WebElement>list2=driver.findElements(By.xpath("//li[@role='option']//span"));
		for(int i=0;i<list2.size();i++)
		{
			String result=list2.get(i).getText();
			if(result.contains("AC First Class"))
			{
				list2.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
	}
	
	public void generalDropDownBox() throws InterruptedException
	{
		general.click();
		Thread.sleep(2000);
		List<WebElement>list3=driver.findElements(By.xpath("//li[@role='option']//span"));
		for(int i=0;i<list3.size();i++)
		{
			String result=list3.get(i).getText();
			if(result.contains("LADIES"))
			{
				list3.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
	}
	
	public void clickSearchButton()
	{
		search.click();
	}

	
	
	
	
	
	
	
	
}
