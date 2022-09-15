package p09_09_2022;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloSelenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); //redosled bitan,prva linija
		WebDriver driver = new ChromeDriver(); //startuje chrome
		driver.get("https://google.com/"); // ocitaj ovu stranicu, url unutar yagrada
	}

}
