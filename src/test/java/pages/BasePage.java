package pages;

import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import constante.ConstantsIdentifiers;

public class BasePage {
	public static WebDriver driver;
	public static WebDriverWait wait;

	public void initSetP() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\resourses\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 30);
	}

	public WebElement findObject(String type_by_element, String value_element, Boolean mandatory_element) {
		By locator = null;
		WebElement elem = null;
		if (type_by_element.equals(ConstantsIdentifiers.ID)) {
			locator = By.id(value_element);
		} else if (type_by_element.equals(ConstantsIdentifiers.CLASSNAME)) {
			locator = By.className(value_element);
		} else if (type_by_element.equals(ConstantsIdentifiers.CSSSELECTOR)) {
			locator = By.cssSelector(value_element);
		} else if (type_by_element.equals(ConstantsIdentifiers.XPATH)) {
			locator = By.xpath(value_element);
		}
		try {
			elem = driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("Element is not found");
		}
		if (mandatory_element == true && elem == null) {
			System.out.println("You have a problem");
		}
		return elem;
	}

	public WebElement clickable(String type_by_element, String value_element, boolean modatory_element) {
		WebElement a = null;
		try {
			a = findObject(type_by_element, value_element, true);
			if (a.isDisplayed())
				a.click();
		} catch (NoSuchElementException e) {
			System.out.println("Element is not vizible");
		}

		return null;
	}

	public WebElement assertMet(String element, String test_value, boolean modatory_element) {

		try {
			if (element == "title")
				Assert.assertEquals(driver.getTitle(), test_value);

			else if (element == "url")
				Assert.assertEquals(driver.getCurrentUrl(), test_value);
		} catch (Exception e) {
			System.out.println("Your condition is not valid");
		}
		return null;

	}

	public void tearDownP() {
		driver.close();
		if (!driver.equals(null))
			driver.quit();
	}
}
