package d19_09_2022;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BootstrapTableTests {
//	Kreirati BootstrapTableTests klasu koja ima:
//		Base url: https://s.bootsnipp.com
//		Test #1: Edit Row
//		Podaci:
//		First Name: ime polaznika
//		Last Name: prezime polaznika
//		Middle Name: srednje ime polanzika
//		Koraci:
//		Ucitati stranu /iframe/K5yrx
//		Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//		Klik na Edit dugme prvog reda
//		Sacekati da dijalog za Editovanje bude vidljiv
//		Popuniti formu podacima. 
//		Bice potrebno da pre unosa tekst pobrisete tekst koji vec postoji, za to se koristi metoda clear. Koristan link
//		Klik na Update dugme
//		Sacekati da dijalog za Editovanje postane nevidljiv
//		Verifikovati da se u First Name celiji prvog reda tabele javlja uneto ime
//		Verifikovati da se u Last Name celiji prvog reda tabele javlja uneto prezime
//		Verifikovati da se u Middle Name celiji prvog reda tabele javlja uneto srednje ime
//		Za sve validacije ispisati odgovarajuce poruke u slucaju greske
//
//		Test #2: Delete Row
//		Podaci:
//		First Name: ime polaznika
//		Last Name: prezime polaznika
//		Middle Name: srednje ime polanzika
//		Koraci:
//		Ucitati stranu /iframe/K5yrx
//		Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//		Klik na Delete dugme prvog reda
//		Sacekati da dijalog za brisanje bude vidljiv
//		Klik na Delete dugme iz dijaloga 
//		Sacekati da dijalog za Editovanje postane nevidljiv
//		Verifikovati da je broj redova u tabeli za jedan manji
//		Za sve validacije ispisati odgovarajuce poruke u slucaju greske
//
//		Test #3: Take a Screenshot
//		Koraci:
//		Ucitati stranu  /iframe/K5yrx
//		Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//		Kreirati screenshot stranice. Koristan link https://www.guru99.com/take-screenshot-selenium-webdriver.html
//		Fajl cuvajte na putanji gde su vam bile slike od proslog domaceg. Na putanji: src/paket_za_domaci/nazivslike.png
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@BeforeClass
	public void setup() {
	System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	driver.manage().window().maximize(); 
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));	
	}
	
	@BeforeMethod
	public void beforeMethod() {
		driver.get("https://s.bootsnipp.com");
	}
	
	@Test(priority = 10)
	public void editRow() throws InterruptedException {
		driver.get("https://s.bootsnipp.com/iframe/K5yrx");
		String actualTitle = 
				driver.getTitle();
		String expectedTitle = 
				"Table with Edit and Update Data - Bootsnipp.com";
		Assert.assertEquals(actualTitle, expectedTitle,
				"Expected title should be: Table with Edit and Update Data - Bootsnipp.com");

		driver.findElement(By.xpath("//button[data-uid='d1']")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("up")));

		driver.findElement(By.id("fn")).clear();
		driver.findElement(By.id("ln")).clear();
		driver.findElement(By.id("mn")).clear();

		driver.findElement(By.id("fn")).sendKeys("Nevena");
		driver.findElement(By.id("ln")).sendKeys("Grujic");
		driver.findElement(By.id("mn")).sendKeys("Zivan");
		driver.findElement(By.id("up")).click();
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("up")));

		String actualFirstNameR1 = 
				driver.findElement(By.id("f1")).getText();
		String expectedFirstNameR1 = "Nevena";
		Assert.assertEquals(actualFirstNameR1, expectedFirstNameR1,
				"Expected First Name in Row 1 should be Nevena");

		String actualLastNameR1 = driver.findElement(By.id("l1")).getText();
		String expectedLastNameR1 = "Grujic";
		Assert.assertEquals(actualLastNameR1, expectedLastNameR1, 
				"Expected Last Name in Row 1 should be Grujic");

		String actualMiddleNameR1 = 
				driver.findElement(By.id("m1")).getText();
		String expectedMiddleNameR1 = "Zivan";
		Assert.assertEquals(actualMiddleNameR1, expectedMiddleNameR1,
				"Expected Middle Name in Row 1 should be Zivan");
	}

	@Test(priority = 20)
	public void deleteRow() throws InterruptedException {
		driver.navigate().to("https://s.bootsnipp.com/iframe/K5yrx");
		String actualTitle = driver.getTitle();
		String expectedTitle = 
				"Table with Edit and Update Data - Bootsnipp.com";
		Assert.assertEquals(actualTitle, expectedTitle, 
				"Expected title should be: Table with Edit and Update Data - Bootsnipp.com");

		driver.findElement(By.xpath("//tr[@id='d1']//button[contains(@class, 'delete')]")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("del")));
		driver.findElement(By.id("del")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("del")));
		
		boolean d1Red = driver.findElement(By.id("d1")).isDisplayed();
		Assert.assertEquals(d1Red, false, "Error: D1 row should be deleted");
	}

	@Test(priority = 30)
	public void takeAScreenshot() throws IOException {
		driver.get("https://s.bootsnipp.com/iframe/K5yrx");
		String actualTitle = driver.getTitle();
		String expectedTitle = 
				"Table with Edit and Update Data - Bootsnipp.com";
		Assert.assertEquals(actualTitle, expectedTitle, 
				"Expected title should be: Table with Edit and Update Data - Bootsnipp.com");

		TakesScreenshot srcShot = ((TakesScreenshot)driver);
		File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
