package testsuite;

import com.google.common.base.Verify;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //* Enter valid username
        sendTextToElement(By.id("customer.username"), "Mita23");
        // * Enter valid password
        sendTextToElement(By.id("customer.password"), "test123");
        //* Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@value='Log In']"));
        // * Verify the ‘Accounts Overview’ text is display
        String expectedMessage = "Accounts Overview";

        WebElement actualTextFromElement = driver.findElement(By.xpath("//a[contains(text(),'Accounts Overview')]"));
        String actualMessage = actualTextFromElement.getText();

        Assert.assertEquals("Accounts Overview", expectedMessage, actualMessage);

    }

    public void verifyTheErrorMessage() {
        //  * Enter invalid username
        sendTextToElement(By.name("username"), "jaypatel32");
        //        * Enter invalid password
        sendTextToElement(By.name("password"), "jaypatel1234");
        //* Click on Login button
        clickOnElement(By.xpath("//input[@value='Log In']"));
        // * Verify the error message ‘The username and password could not be verified.’

    }


    @Test
    public void userShouldLogOutSuccessfully() {
        //* Enter valid username
        sendTextToElement(By.name("username"), "Mita23");
        //              * Enter valid password
        sendTextToElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[2]/input[1]"), "test123");
        //* Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@value='Log In'and @type='submit']"));

        //      * Click on ‘Log Out’ link

        //    * Verify the text ‘Customer Login’
    }

    public void teardown() {
        closeBrowser();
    }

}
