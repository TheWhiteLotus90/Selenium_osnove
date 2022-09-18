package p15_09_2022;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		Napisati program koji:
//			Ucitava stranicu  https://www.ebay.com/
//			Zatim iz selekta za kategoriju povlaci sve opcije. Koristan link
//			Zatim bira random element iz niza opcija koristeci Random.
//			Vodite racuna da random element bude u opsegu broja elemenata niza. Random podsetnik
//			Selektuje random kategoriju izabranu u koraku iznad
//			Zatvara pretrazivac

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); 	
		
		driver.navigate().to("https://www.ebay.com/");
		
		Select selectCategory = new Select(driver.findElement(By.id("gh-cat")));
			
//		selectCategory.getOptions()
		Random r = new Random();
		int randomOption = r.nextInt(selectCategory.getOptions().size());
//		selectCategory.selectByIndex(randomOption);
		String optionText = 
				selectCategory.getOptions().get(randomOption).getText();
		selectCategory.selectByVisibleText(optionText);
		
		Thread.sleep(5000); 
		driver.quit();

	}

}
