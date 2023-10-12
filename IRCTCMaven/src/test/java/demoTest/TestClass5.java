package demoTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.IRCTCNextGenerationE_TicketingSystem;

public class TestClass5 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		
		IRCTCNextGenerationE_TicketingSystem irctcNextGenerationE_TicketingSystem=new IRCTCNextGenerationE_TicketingSystem(driver);
		
		irctcNextGenerationE_TicketingSystem.generalDropDownBox();

	}

}
