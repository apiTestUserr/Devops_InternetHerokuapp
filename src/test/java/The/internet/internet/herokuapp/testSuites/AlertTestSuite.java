package The.internet.internet.herokuapp.testSuites;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertTestSuite {

	// Scenario 1 - Confirmer que l'utilisateur peut accepter une alerte de
	// confirmation et que la page affiche le message approprié.

	String url = "https://the-internet.herokuapp.com/";

	WebDriver driver = new ChromeDriver();

	@Before
	public void init() {

		driver.get(url);
		
		String cur_win = driver.getTitle();
		
		driver.manage().window().maximize();
		
		
	}

	@Test

	public void confirmationAlert() throws InterruptedException {

		// Acceder au JavaScript Alerts

		By jsAlertLocator = By.xpath("//a[normalize-space()='JavaScript Alerts']");
		
//		By jsAlertLocator = By.xpath("//a[normalize-space()='JavaScript Alerts']");


		WebElement jsAlertElement = driver.findElement(jsAlertLocator);

		jsAlertElement.click();

		// Cliquer sur le bouton Click for JS Confirm

		By jsConfirmBtnLocator = By.xpath("//button[normalize-space()='Click for JS Confirm']");

		WebElement jsConfirmBtnElement = driver.findElement(jsConfirmBtnLocator);

		jsConfirmBtnElement.click();
		
		// On utilise les attentes explicite pour permettre au DOM de se charger + de Valider une condition attendue
		
		// permettre au DOM de se charger + de Valider que l'Alert est presente
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.alertIsPresent());
		
		

		TargetLocator cible = driver.switchTo();

		Alert alert = cible.alert();
		
		alert.getText();
		
		// mettre une pause - juste pour debogage
		
		Thread.sleep(5000);
		

		alert.accept();
		
		// Validation du message de resultat
		
		 WebElement resultEelemt = driver.findElement(By.id("ii"));
		 
		 assertTrue(resultEelemt.isDisplayed());

				 
		 String actualResult =  resultEelemt.getText();
		 
		 
		 
//		 String expectedResult = "You clicked: Ok";
//		 
//		 Assert.assertEquals(expectedResult, actualResult);
//		
		
		

	}

}
