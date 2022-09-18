package p15_09_2022;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak5 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		Ucitati stranicu https://demoqa.com/modal-dialogs
//			Kliknuti na dugme Large modal
//			Proverite da li se prikazao dijalog i ispisite u konzoli odgovarajuce poruke
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		driver.get("https://demoqa.com/modal-dialogs");
		
		Thread.sleep(5000);
		driver.quit();
	}

}
