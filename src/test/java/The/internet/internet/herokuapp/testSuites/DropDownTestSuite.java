package The.internet.internet.herokuapp.testSuites;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownTestSuite {

	String url = "https://the-internet.herokuapp.com/";

	WebDriver driver = new ChromeDriver();

	@Before
	public void init() {

		driver.get(url);
	}

	@Test
	public void dropDown() {
		
		
		

		By dropdownPageLocator = By.xpath("//a[normalize-space()='Dropdown']");

		WebElement dropDownPageElement = driver.findElement(dropdownPageLocator);

		dropDownPageElement.click();

		// Nous allons localiser l'endroit du DropDown

		By dropDownLocator = By.id("dropdown");

		WebElement dropDownElement = driver.findElement(dropDownLocator);

		// Nous allons Selectionner le DropDown loaclisé

		Select sel = new Select(dropDownElement);

		// Nous allons selectionner l'option 1
		

		sel.selectByVisibleText("Option 1");
				
		
		// Nous allons comparer si l'option 1 est bien selectionnée

		WebElement firstSelectedOptionElement = sel.getFirstSelectedOption();
		
		
		Assert.assertTrue(!firstSelectedOptionElement.isSelected());

//		String actualOptionText = firstSelectedOptionElement.getText();
//
//		String expectedOptionText = "Option 1";
//
//		Assert.assertEquals(expectedOptionText, actualOptionText);

	}
	
	
	//@After
	public void cloturer() {
		
		driver.close();
		driver.quit();
		
		
		
	}

}
