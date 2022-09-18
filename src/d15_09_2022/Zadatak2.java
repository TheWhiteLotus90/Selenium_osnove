package d15_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		Napisati program koji ucitava stranicu https://geodata.solutions/
//			Bira Country, State i City po vasoj zelji
//			Pritom potrebno je izvrsiti cekanje da se povaje State-ovi nakon izbora Country-a
//			I takodje je potrebno izvrsiti cekanje da se ucitaju gradovi nakon izbora State-a
//			Izabrerit Country, State i City tako da imate podatke da selektujete!
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.plus2net.com/jquery/msg-demo/dropdown3.php");
		
		Select country = new Select(driver.findElement(By.id("country_code")));
		
		boolean choosenCounty = true;
		
		try {
			country.selectByVisibleText("INDIA");
		}catch(Exception e) {
			choosenCounty = false;
		}
		if(choosenCounty) {
			System.out.println("Selektovana drzava.");
		}else {
			System.out.println("Drzava nije selektovana.");
		}
		
		Select state = new Select(driver.findElement(By.id("state_id")));
		boolean choosenState = true;
		try {
			state.selectByVisibleText("2:Delhi");
		}catch(Exception e) {
			choosenState = false;
		}
		if(choosenState) {
			System.out.println("State selektovan.");
		}else {
			System.out.println("State nije selektovan.");
		}
		
		Select city = new Select(driver.findElement(By.id("city_id")));
		boolean choosenCity = true;
		try {
			city.selectByVisibleText("Delhi");
		}catch(Exception e) {
			choosenCity = false;
		}
		if(choosenCity) {
			System.out.println("Grad selektovan.");
		}else {
			System.out.println("Grad nije selektovan.");
		}
		
		Thread.sleep(5000);
		driver.quit();
	}

}
