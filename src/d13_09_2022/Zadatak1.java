package d13_09_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {
	
//	Maksimizirati prozor
//	Ucitati stranicu https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
//	Prijavite se na sistem 
//	Username: Admin
//	Password: admin123
//	Cekanje od 5s
//	U input za pretragu iz navigacije unesite tekst Me
//	Kliknite na prvi rezultat pretrage (to ce biti Time)
//	Cekanje od 1s
//	Kliknite u headeru na svog avatara (to ce biti na ime: Paul Collings)
//	Klinkite na logout
//	Cekanje od 5s
//	Zatvorite pretrazivac

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); //redosled bitan,prva linija
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin888");
		
		Thread.sleep(5000);

		driver.findElement(By.className("oxd-button")).click();
		driver.findElement(By.className("oxd-input")).sendKeys("Me");
		driver.findElement(By.className("oxd-main-menu-item")).click();

		Thread.sleep(1000);

		driver.findElement(By.className("oxd-userdropdown-tab")).click();
		driver.findElement(By.xpath("//*[text()='Logout']")).click();
		driver.findElement(By.className("oxd-button")).click();
		
		
		
		Thread.sleep(5000); 
		driver.quit();

	}

}
