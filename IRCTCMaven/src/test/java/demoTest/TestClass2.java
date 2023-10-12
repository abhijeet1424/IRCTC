package demoTest;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.IRCTCNextGenerationE_TicketingSystem;

public class TestClass2 {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		
		IRCTCNextGenerationE_TicketingSystem irctcNextGenerationE_TicketingSystem=new IRCTCNextGenerationE_TicketingSystem(driver);
		
		irctcNextGenerationE_TicketingSystem.sendTo();

	}

}
