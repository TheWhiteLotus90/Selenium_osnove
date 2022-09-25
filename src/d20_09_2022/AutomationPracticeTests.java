package d20_09_2022;

import java.awt.Dimension;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AutomationPracticeTests {
	private WebDriver driver;
	private WebDriverWait wait;
	private String baseUrl = "http://automationpractice.com/";
	private SoftAssert softAssert;

	private BuyBoxPage buyBoxPage;
	private LayerCartPage layerCartPage;
	private TopMenuPage topMenuPage;
	private HeaderPage headerPage;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		softAssert = new SoftAssert();
		buyBoxPage = new BuyBoxPage(driver, wait);
		layerCartPage = new LayerCartPage(driver, wait);
		topMenuPage = new TopMenuPage(driver, wait);
		headerPage = new HeaderPage(driver, wait);	
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get(baseUrl);
	}

	@Test(priority = 10)
	public void addingProductToTheCart() throws InterruptedException {
		this.driver.get(baseUrl + "/index.php?id_product=1&controller=product");
		buyBoxPage.getScrollToTableElement();

		double priceForOnePiece = Double.valueOf(buyBoxPage
				.getPriceForOnePieceElement().getText().substring(1));

		buyBoxPage.getQuantityInput().clear();
		buyBoxPage.getQuantityInput().sendKeys("3");

		Select selectSize = new Select(buyBoxPage.getSizeSelect());
		selectSize.selectByVisibleText("L");

		buyBoxPage.getLinkBasedOnColor("Blue").click();
		buyBoxPage.getAddToCartButton().click();

		layerCartPage.waitForDialogVisibility();
		Assert.assertTrue(layerCartPage.getContinueShoppingBtn()
				.isDisplayed(), "Cart dialog box should be displayed");

		Assert.assertEquals(layerCartPage.getQuantity().getText(),
				"3", "Total quantity should be 3");
		Assert.assertTrue(layerCartPage.getAttributesOfProduct().getText()
				.contains("L"), "Product size should be L");
		Assert.assertTrue(layerCartPage.getAttributesOfProduct().getText()
				.contains("Blue"), "Product color should be Blue");

		double priceForExpectedQuantity = Double
				.valueOf(layerCartPage.getTotalPrice()
				.getText().substring(1));

		Assert.assertEquals(priceForExpectedQuantity, (priceForOnePiece*3),
				"Expected price should be " + (priceForOnePiece*3));

		layerCartPage.getContinueShoppingBtn().click();
		layerCartPage.waitForDialogVisibility();

		buyBoxPage.getQuantityInput().clear();
		buyBoxPage.getQuantityInput().sendKeys("1");
		selectSize.selectByVisibleText("S");
		buyBoxPage.getLinkBasedOnColor("Orange").click();
		buyBoxPage.getAddToCartButton().click();

		layerCartPage.waitForDialogInvisibility();
		layerCartPage.getProcedToCheckoutBtn().click();

		Assert.assertTrue(driver.getTitle().equals("Order - My Store"),
				"Page Title should be 'Order - My Store'");
	}

	@Test(priority = 20)
	public void topMenuMouseOver() throws InterruptedException {
		new Actions(driver).moveToElement(topMenuPage.getWomenLink()).perform();
		topMenuPage.getWomenDropdown();
		softAssert.assertTrue(topMenuPage.getWomenDropdown()
				.isDisplayed(), "Women submenu should be displayed");

		new Actions(driver).moveToElement(topMenuPage.getDressesLink()).perform();
		topMenuPage.getDressesDropdown();
		softAssert.assertTrue(topMenuPage.getDressesDropdown()
				.isDisplayed(), "Dresses submenu should be displayed");

		new Actions(driver).moveToElement(topMenuPage.getTshirtsLink()).perform();
		topMenuPage.getDressesDropdown();
		softAssert.assertTrue(!topMenuPage.getDressesDropdown()
				.isDisplayed(), "Women submenu should be hidden");
		softAssert.assertTrue(!topMenuPage.getDressesDropdown()
				.isDisplayed(), "Dresses submenu should be hidden");

		softAssert.assertAll();
	}

	@Test(priority = 30)
	public void headerLinksCheck() throws InterruptedException {
		headerPage.getContactUsLink().click();
		softAssert.assertTrue(driver.getTitle()
				.equals("Contact us - My Store"), "Title should be Contact us - My Store");

		headerPage.getSignInLink().click();
		softAssert.assertTrue(driver.getTitle()
				.equals("Login - My Store"), "Title should be Login - My Store");

		softAssert.assertAll();
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
