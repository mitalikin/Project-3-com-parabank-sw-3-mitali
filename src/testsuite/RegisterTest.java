package testsuite;

import com.google.common.base.Verify;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.Zip;
import utilities.Utility;

public class RegisterTest extends Utility {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatSigningUpPageDisplay() {
//click on the ‘Register’ link
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        //* Verify the text ‘Signing up is easy!
        String expectedMessage = "Signing up is easy!";

        //Find the text element and get the text
        WebElement actualTextMessageElement = driver.findElement(By.xpath("//h1[text()='Signing up is easy!']"));
        String actualMessage = actualTextMessageElement.getText();

        // Validate actual and expected message
        Assert.assertEquals("Not navigate to Register page", expectedMessage, actualMessage);

    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        // click on the ‘Register’ link
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        // Enter First name
        sendTextToElement(By.name("customer.firstName"), "Mita");
       //* Enter Last name
        sendTextToElement(By.id("customer.lastName"), "patel");
        //* Enter Address
        sendTextToElement(By.name("customer.address.street"), "14,crofts road");
        //* Enter City
        sendTextToElement(By.id("customer.address.city"), "London");
        //* Enter State
        sendTextToElement(By.id("customer.address.state"), "U.K");
        //* Enter Zip Code
        sendTextToElement(By.id("customer.address.zipCode"), "Wd12 2tr");
        //  * Enter Phone
        sendTextToElement(By.id("customer.phoneNumber"), "78965488882");
        //* Enter SSN
        sendTextToElement(By.id("customer.ssn"), "345677892");
        //* Enter Username
        sendTextToElement(By.id("customer.username"), "Mita23");
        // * Enter Password
        sendTextToElement(By.id("customer.password"), "test123");

        // * Enter Confirm
        sendTextToElement(By.id("repeatedPassword"), "test123");
        // * Click on REGISTER button
        clickOnElement(By.xpath("//input[@value='Register']"));
        //* Verify the text 'Your account was created successfully. You are now logged in.’
        String expectedMessage = "Your account was created successfully. You are now logged in.";
        String actualmessage = getTextFromElement(By.xpath("//p[text()='Your account was created successfully. You are now logged in.']"));
        Assert.assertEquals("Message not displayed", expectedMessage, actualmessage);


    }
    public void teardown(){
        closeBrowser();
    }


}
