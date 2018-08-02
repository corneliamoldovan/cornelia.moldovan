package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import constante.ConstantsFind;
import constante.ConstantsIdentifiers;

public class HomePage extends BasePage {
	BasePage base=new BasePage();
	
	public void navigateToHome()
	{	
		driver.get("https://demoqa.com/");		
	}
	public void navigateToDemoTabs()
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ConstantsFind.Demo)));
		clickable(ConstantsIdentifiers.XPATH, ConstantsFind.Demo , true);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ConstantsFind.Tabs)));
		clickable(ConstantsIdentifiers.XPATH, ConstantsFind.Tabs , true);
		WebElement element =findObject(ConstantsIdentifiers.ID, ConstantsFind.Tab1, true);
		String tab =element.getText();			
		Assert.assertEquals("Tab 1", tab);
	}
	

}
