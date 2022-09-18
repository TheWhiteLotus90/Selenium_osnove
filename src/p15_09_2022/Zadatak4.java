package p15_09_2022;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		Ucitava stranicu https://demoqa.com/login
//			Loginuje se sa usename itbootcamp i lozinkom ITBootcamp2021!
//			Zatim ceka 5sekundi da se korisnik uloguje
//			Proverava da li se korisnik ulogovao, tako sto se proverava postojanje dugmeta Logout.
//			Ispisati odgovarajucu poruku u konzoli za rezultat loginovanja.
//			Klikce na dugme za logout
//			Gasi stranicu

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // deo svakog zadatka isto
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30)); // i to
		driver.manage().window().maximize(); 
		
		driver.get("https://demoqa.com/login");
		
		driver.findElement(By.id("userName")).sendKeys("Itbootcamp");
		driver.findElement(By.id("password")).sendKeys("Itbootcamp2021!");
		driver.findElement(By.id("login")).click();
		
//		Thread.sleep(5000);
//		
//		try {
//			driver.findElement(By.tagName("a"));	
//		}catch(NoSuchElementException error) {
//			System.out.println("Greska");
//		}
//		
		
		boolean logoutExist = driver.findElements(By.id("submit")).size() > 0; //?
		
		if (logoutExist) {
			System.out.println("Uspesno!");
		} else {
			System.out.println("Neuspesno!");
		}
		
		Thread.sleep(5000); 
		driver.quit();
		
	}

}
