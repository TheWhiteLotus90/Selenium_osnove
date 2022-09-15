package p13_09_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class UvodSelenium {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); //redosled bitan,prva linija
		WebDriver driver = new ChromeDriver(); //startuje chrome
		driver.manage().window().maximize(); //uvecava stranicu
		
		driver.get("https://google.com/"); // ocita stranicu, url unutar zagrada
		
//lociramo element i dohvatimo:
//		WebElement searchInput = driver.findElement(By.xpath("//*[@name='q']")); //metoda vraca trazeni
		//element, objekat web element, u zagradama na koji nacin trazi
		// ovaj objketat vraca nam id elementa
		
//		searchInput.sendKeys("IT bootcamp"); // ukuca tekst String u chrome
		
// skraceni nacin za hvatanje elementa i davanje vrednosti:
		
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys("IT bootcamp");
		
		Thread.sleep(5000); //pravi pauzu posle izvrsenja, uvek add.. stopira program na 5 sek
//		searchInput.clear();
//		searchInput.sendKeys(Keys.ENTER); //specijalni karakter npr enter zato sto imaju heksadecimalnu vrednost
//		searchInput.sendKeys("1000"); // radi dopunu teksta gore
		
		
		//skraceni:
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.ENTER);
		
		WebElement firstResult = driver.findElement(By.xpath("//a[contains(@class, 'sVXRqc')]")); // dohvati element
		
		//klikni:
		firstResult.click();
		
		driver.quit(); // prekida operacije, zatvara chrome, sve ocisti prethodno
//		driver.close(); // parce prekida *razlika izmedju njih intervju pitanje
		// zatvra tab na kom je fokusiran driver, vraca na prethodni ovoreni tab ako ga ima

	}

}
