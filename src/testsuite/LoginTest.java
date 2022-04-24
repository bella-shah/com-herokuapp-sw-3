package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginWithValidCredential(){
        //sending username and password field to elements
        sendTextToElement(By.name("username"),"tomsmith");
       sendTextToElement(By.id("password"),"SuperSecretPassword!");
       //click on login button
       clickOnElement(By.className("radius"));
       String expectedMessage = "Secure Area";
       String actualMessage=getTextFromElement(By.xpath("//div[@class='example']//h2"));
    }

    @Test
    public void verifyTheUsernameErrorMessage(){
        // Enter “tomsmith1” invalid username
        sendTextToElement(By.name("username"),"tomsmith1");
        //Enter “SuperSecretPassword!” password
        sendTextToElement(By.id("password"),"SuperSecretPassword!");
        // Click on ‘LOGIN’ button
        clickOnElement(By.className("radius"));
        //verifying message
        String expectedMessage = "Your username is invalid!\n×";
        String actualMessage=getTextFromElement(By.id("flash"));
    }
    @Test
    public void verifyThePasswordErrorMessage() {
        //Enter “tomsmith” valid username
        sendTextToElement(By.name("username"),"tomsmith");
        // Enter “SuperSecretPassword” invalid password
        sendTextToElement(By.id("password"),"SuperSecretPassword");
        //Click on ‘LOGIN’ button
        clickOnElement(By.className("radius"));
        //Verify the error message “Your password is invalid!"
        String expectedMessage = "Your password is invalid!\n×";
        String actualMessage=getTextFromElement(By.id("flash"));
    }
    @After
    //close the driver
    public void tearDown() {
        closeBrowser();
    }
}
