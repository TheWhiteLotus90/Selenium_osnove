package p15_09_2022;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		Napisati program koji:
//			Ucitava stranicu  https://www.ebay.com/
//			Zatim iz selekta za kategoriju povlaci sve opcije. Koristan link
//			Zatim bira random element iz niza opcija koristeci Random. Vodite racuna da random element bude u opsegu broja elemenata niza. Random podsetnik
//			Selektuje random kategoriju izabranu u koraku iznad
//			Zatvara pretrazivac


		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); 

		driver.get("https://www.ebay.com/");
		Thread.sleep(4000);
		
		
		
		Thread.sleep(5000); 
		driver.quit();

	}

}
