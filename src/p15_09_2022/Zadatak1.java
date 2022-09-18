package p15_09_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		Napisati program koji prijavljivanju na stranicu
//		http://cms.demo.katalon.com/my-account/, cekira Remember me checkbox.
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); 

		driver.navigate().to("https://cms.demo.katalon.com/my-account/");
		
		driver.findElement(By.name("rememberme")).click();
		
		if (driver.findElement(By.name("rememberme")).isSelected()) {
			System.out.println("CHecked!");
		} else {
			System.out.println("Unchecked");
		}
		
//drugi nacin
//		driver.get("http://cms.demo.katalon.com/my-account/");
		
//		WebElement element = driver.findElement(By.name("rememberme"));
//		element.click();
//		element.isSelected(); 
				
//		boolean isSelected = false;
//		
//		if(isSelected == true) {
//			isSelected = driver.findElement(By.tagName("input")).isSelected();
//			System.out.println("Checked");
//		}else {
//			System.out.println("Unchecked");
//		}


		Thread.sleep(5000); 
		driver.quit();
		
	}

}
