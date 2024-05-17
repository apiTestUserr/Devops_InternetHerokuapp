package The.nternet.herokuapp.authentication;

import java.awt.RenderingHints.Key;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserAuthenticationTest {
	
	WebDriver driver = new ChromeDriver();  //  Polymorphisme

	
	/*
	 *  On rajoute l'annotation @Before pour que la methode init() puisse s'executer avant 
	 *  chaque methode marquée par  @Test
	 */
	
 	@Before
	public void init() {
		
		String url = "https://the-internet.herokuapp.com/";
		
		// Etape 1 - Consultation de l'application web https://the-internet.herokuapp.com
		
		driver.get(url);
		
		// Affichage du resultat dans console
		
		System.out.println("Le site s'ouvre correctement");			
		
	}
	
	
	
	
	
	@Test
	public void authenticationWithValidCredentials() {
		
		

		
		
		/* Etape 2 - Cliquer sur Form Authentication
		
		Nous avons besoin de rammener les elements HTML pour qu'on puisse agir sur ces elements la et effectuer une action */
		
		    // 2.1 Localiser l'element web a
		 
		
		By a21Locator =   By.xpath("//a[normalize-space()='Form Authentication']");
		
        WebElement  a21Element =  driver.findElement(a21Locator);
		
           //2.2 Cliquer dessus
       
       
         a21Element.click();
		
         // Etape 3 - Remplir les information du formulaire de connexion en utilisant les JDD indiqués dans la page web ( on commence par username ) 
         
              // 3.1 Localiser l'element web le champ de text
         
         By usernameLocator = By.xpath("//input[@id='username']");
         
         
         By username = By.cssSelector("#username");
         
         WebElement  usernameElement =   driver.findElement(usernameLocator);
         
            // 3.2 saisir le username = mettre le jdd username
         
         usernameElement.sendKeys("tomsmith" + Keys.CLEAR);

         // Etape 4 - Remplir les information du formulaire de connexion en utilisant les JDD indiqués dans la page web ( on continue avec password ) 
         
         By passwordLocator =  By.xpath("//input[@id='password']");
         
         WebElement passwordElement =  driver.findElement(passwordLocator);
         
         passwordElement.sendKeys("SuperSecretPassword!");
         
         
         
         // Etape 5 - Cliquer sur le bouton login pour acceder a la page d'acceuil 
         
         By loginLocator = By.xpath("//i[@class='fa fa-2x fa-sign-in']");
         
        WebElement loginElement = driver.findElement(loginLocator);
        
        
        loginElement.click();
        
        System.out.println("La connexion est bien etablie");
     
        // Nous allons utiliser un outil de validation du resultat attendu par rapport au resultat actuel
        
        String expectedResult = "https://the-internet.herokuapp.com/secure";
        
        String actualResult = driver.getCurrentUrl();
        
        
        // Etape de comparaison du resultat attendu par resultat actuel

		Assert.assertEquals(expectedResult, actualResult);
		
		
		
	}
	
	
	
	
	
	@Test
	public void authenticationWithValidCredentialsWay2() {
		
		
		
		
		/* Etape 2 - Cliquer sur Form Authentication
		
		Nous avons besoin de rammener les elements HTML pour qu'on puisse agir sur ces elements la et effectuer une action */
		
		    // 2.1 Localiser l'element web a
		 
		
		By a21Locator =   By.xpath("//a[normalize-space()='Form Authentication']");
		
        WebElement  a21Element =  driver.findElement(a21Locator);
		
           //2.2 Cliquer dessus
       
       
         a21Element.click();
		
         // Etape 3 - Remplir les information du formulaire de connexion en utilisant les JDD indiqués dans la page web ( on commence par username ) 
         
              // 3.1 Localiser l'element web le champ de text
         
         By usernameLocator = By.xpath("//input[@id='username']");
         
         WebElement  usernameElement =   driver.findElement(usernameLocator);
         
            // 3.2 saisir le username = mettre le jdd username
         
         usernameElement.sendKeys("tomsmith");

         // Etape 4 - Remplir les information du formulaire de connexion en utilisant les JDD indiqués dans la page web ( on continue avec password ) 
         
         By passwordLocator =  By.xpath("//input[@id='password']");
         
         WebElement passwordElement =  driver.findElement(passwordLocator);
         
         passwordElement.sendKeys("SuperSecretPassword!");
         
         
         
         // Etape 5 - Cliquer sur le bouton login pour acceder a la page d'acceuil 
         
         By loginLocator = By.xpath("//i[@class='fa fa-2x fa-sign-in']");
         
        WebElement loginElement = driver.findElement(loginLocator);
        
        
        loginElement.click();
        
        System.out.println("La connexion est bien etablie");
     
        // Nous allons utiliser un outil de validation du resultat attendu par rapport au resultat actuel
        
        String expectedResult = "secure";
        
        String actualResult = driver.getCurrentUrl();
        
        
        // Etape de comparaison du resultat attendu par resultat actuel

       
        Assert.assertTrue("la partie de l'url attendue ne fait pas partie de l'url actuelle", actualResult.contains(expectedResult));
		
		
	}
	
	
	
	@Test
	public void authenticationWithIvalidCredentials() {
		
		
		
		
		/* Etape 2 - Cliquer sur Form Authentication
		
		Nous avons besoin de rammener les elements HTML pour qu'on puisse agir sur ces elements la et effectuer une action */
		
		    // 2.1 Localiser l'element web a
		 
		
		By a21Locator =   By.xpath("//a[normalize-space()='Form Authentication']");
		
        WebElement  a21Element =  driver.findElement(a21Locator);
		
           //2.2 Cliquer dessus
       
       
         a21Element.click();
		
         // Etape 3 - Remplir les information du formulaire de connexion en utilisant les JDD indiqués dans la page web ( on commence par username ) 
         
              // 3.1 Localiser l'element web le champ de text
         
         By usernameLocator = By.xpath("//input[@id='username']");
         
         WebElement  usernameElement =   driver.findElement(usernameLocator);
         
            // 3.2 saisir le username = mettre le jdd username
         
         usernameElement.sendKeys("tomsmith");

         // Etape 4 - Remplir les information du formulaire de connexion en utilisant les JDD indiqués dans la page web ( on continue avec password ) 
         
         By passwordLocator =  By.xpath("//input[@id='password']");
         
         WebElement passwordElement =  driver.findElement(passwordLocator);
         
         passwordElement.sendKeys("Amira");
         
         
         
         // Etape 5 - Cliquer sur le bouton login pour acceder a la page d'acceuil 
         
         By loginLocator = By.xpath("//i[@class='fa fa-2x fa-sign-in']");
         
        WebElement loginElement = driver.findElement(loginLocator);
        
        
        loginElement.click();
        
        
        // Nous allons utiliser un outil de validation du resultat attendu par rapport au resultat actuel
        
        String expectedResult = "https://the-internet.herokuapp.com/secure";
        
        String actualResult = driver.getCurrentUrl();
        
        
        // Etape de comparaison du resultat attendu par resultat actuel

		Assert.assertNotEquals(expectedResult, actualResult);
		
         

		
		
		
		
	}
	
	
	
	

}
