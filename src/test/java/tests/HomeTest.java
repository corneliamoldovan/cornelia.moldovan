package tests;

import org.testng.annotations.Test;

import pages.HomePage;

public class HomeTest extends BaseTest {
	HomePage home = new HomePage();

	@Test(priority = 1)
	public void navigateToHomeTest() {
		home.navigateToHome();
	}

	@Test(priority = 2)
	public void navigateToDemoTabsTest() {
		home.navigateToDemoTabs();
	}

}
