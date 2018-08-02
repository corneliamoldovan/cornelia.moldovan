package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.BasePage;

public class BaseTest extends BasePage {

	@BeforeClass
	public void beforeClassTest() {
		initSetP();
	}

	@AfterClass
	public void afterClassTest() {
		tearDownP();
	}
}
