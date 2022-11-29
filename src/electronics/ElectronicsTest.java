package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.Utility;

public class ElectronicsTest extends Utility {
    String baseurl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }

    public void selectMenu(By by, String menu) {
        WebElement click = driver.findElement(by);
        click.sendKeys(menu);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        //1.1 Mouse Hover on “Electronics” Tab
        Actions actions = new Actions(driver);
        WebElement electronic = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        actions.moveToElement(electronic).click().build().perform();
        //1.2 Mouse Hover on “Cell phones” and click
        WebElement cellphone = driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        actions.moveToElement(cellphone).click().build().perform();
        //1.3 Verify the text “Cell phones”
        verifyTextFromElements(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[1]"), "Cell phones");

    }
    @Test
    public void  verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException, StaleElementReferenceException {
        Actions actions = new Actions(driver);
        //2.1 Mouse Hover on “Electronics” Tab
        WebElement electronic = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        actions.moveToElement(electronic).click().build().perform();
        //2.2 Mouse Hover on “Cell phones” and click
        WebElement cellphone = driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        actions.moveToElement(cellphone).click().build().perform();
        //2.3 Verify the text “Cell phones”
        verifyTextFromElements(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[1]"), "Cell phones");
        //2.4 Click on List View Tab
        clickElement(By.xpath("//a[contains(text(),'List')]"));

        //2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(1500);
        clickElement(By.xpath("//a[contains(text(),'Nokia Lumia 1020')]"));

        //2.6 Verify the text “Nokia Lumia 1020”
        verifyTextFromElements(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"), "Nokia Lumia 1020");
        //2.7 Verify the price “$349.00”
        verifyTextFromElements(By.xpath("//span[@id='price-value-20']"), "$349.00");
        //2.8 Change quantity to 2
        clearTest(By.xpath("//input[@id='product_enteredQuantity_20']"));
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"), "2");

        //2.9 Click on “ADD TO CART” tab
        clickElement(By.xpath("//button[@id='add-to-cart-button-20']"));
        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green bar
        verifyTextFromElements(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"),"The product has been added to your shopping cart");
        //After that close the bar clicking on the cross button.
        clickElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));
        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Thread.sleep(1500);
        clickElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        //2.12 Verify the message "Shopping cart"
        verifyTextFromElements(By.xpath("//h1[contains(text(),'Shopping cart')]"),"Shopping cart");
        //2.13 Verify the quantity is 2
        Thread.sleep(1500);
        //verifyTextFromElements(By.xpath("//input[@id='itemquantity11226']"),"2");
        //2.14 Verify the Total $698.00
        verifyTextFromElements(By.xpath("//tbody/tr[1]/td[6]/span[1]"),"$698.00");
        //2.15 click on checkbox “I agree with the terms of service”
        clickElement(By.xpath("//input[@id='termsofservice']"));
        //2.16 Click on “CHECKOUT”
        clickElement(By.xpath("//button[@id='checkout']"));
        //2.17 Verify the Text “Welcome, Please Sign In!”
        verifyTextFromElements(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"),"Welcome, Please Sign In!");
        //2.18 Click on “REGISTER” tab
        clickElement(By.xpath("//button[contains(text(),'Register')]"));
        //2.19 Verify the text “Register”
        verifyTextFromElements(By.xpath("//h1[contains(text(),'Register')]"),"Register");
        //2.20 Fill the mandatory fields
        clickElement(By.xpath("//input[@id='gender-male']"));
        sendTextToElement(By.xpath("//input[@id='FirstName']"),"Vimal");
        sendTextToElement(By.xpath("//input[@id='LastName']"),"Pankhaniya");
        sendTextToElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[4]/div[1]/select[1]"),"2");
        sendTextToElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[4]/div[1]/select[2]"),"February");
        sendTextToElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[4]/div[1]/select[3]"),"1989");
        sendTextToElement(By.xpath("//input[@id='Email']"),"v@hotmail.co.uk");
        sendTextToElement(By.xpath("//input[@id='Company']"),"PPLTD");
        clickElement(By.xpath("//input[@id='Newsletter']"));
        sendTextToElement(By.xpath("//input[@id='Password']"),"Champ123");
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"),"Champ123");
        //2.21 Click on “REGISTER” Button
        clickElement(By.xpath("//button[@id='register-button']"));
        //2.22 Verify the message “Your registration completed”
        verifyTextFromElements(By.xpath("//div[contains(text(),'Your registration completed')]"),"Your registration completed");
        Thread.sleep(1500);
        //2.23 Click on “CONTINUE” tab
        clickElement(By.xpath("//a[contains(text(),'Continue')]"));
        //2.24 Verify the text “Shopping card”
        verifyTextFromElements(By.xpath("//h1[contains(text(),'Shopping cart')]"),"Shopping cart");
        //2.25 click on checkbox “I agree with the terms of service”
        clickElement(By.xpath("//input[@id='termsofservice']"));
        //2.26 Click on “CHECKOUT”
        clickElement(By.xpath("//button[@id='checkout']"));
        //2.27 Fill the Mandatory fields
        sendTextToElement(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"UK");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"London");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"56");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"),"Highfield");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"NW9 0PY");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"07534568520");
        //2.28 Click on “CONTINUE”
        clickElement(By.xpath("//div[@id='billing-buttons-container']"));
        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickElement(By.xpath("//input[@id='shippingoption_1']"));
        //2.30 Click on “CONTINUE”
        clickElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));
        //2.31 Select Radio Button “Credit Card”
        clickElement(By.xpath("//input[@id='paymentmethod_1']"));
        //2.32 Select “Visa” From Select credit card dropdown
        clickElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));
        //2.33 Fill all the details
        sendTextToElement(By.xpath("//select[@id='CreditCardType']"),"Visa");
        sendTextToElement(By.xpath("//input[@id='CardholderName']"),"Vimal  Pankhaniya");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"),"1236458596857412");
        sendTextToElement(By.xpath("//select[@id='ExpireMonth']"),"02");
        sendTextToElement(By.xpath("//select[@id='ExpireYear']"),"2023");
        sendTextToElement(By.xpath("//input[@id='CardCode']"),"123");
        //2.34 Click on “CONTINUE”
        clickElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));
        //2.35 Verify “Payment Method” is “Credit Card”
        verifyTextFromElements(By.xpath("//h2[contains(text(),'Payment method')]"),"Payment method");
        //2.36 Verify “Shipping Method” is “2nd Day Air”
        //verifyTextFromElements(By.xpath("//h2[contains(text(),'Shipping method')]"),"Next Day Air ($0.00)");
        //2.38 Click on “CONFIRM”
        clickElement(By.xpath("//button[contains(text(),'Confirm')]"));
        //2.39 Verify the Text “Thank You”
        verifyTextFromElements(By.xpath("//h1[contains(text(),'Thank you')]"),"Thank you");
        //2.40 Verify the message “Your order has been successfully processed!”
        verifyTextFromElements(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"),"Your order has been successfully processed!");
        //2.41 Click on “CONTINUE”
        clickElement(By.xpath("//button[contains(text(),'Continue')]"));
        //2.42 Verify the text “Welcome to our store”
        Thread.sleep(1500);
        // verifyTextFromElements(By.xpath("2.42 Verify the text “Welcome to our store”"),"Welcome to our store");
        //2.43 Click on “Logout” link
        clickElement(By.xpath("//a[contains(text(),'Log out')]"));
        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String actualURl=driver.getCurrentUrl();
        Assert.assertEquals("https://demo.nopcommerce.com/",actualURl);
    }
    @After
    public void tearDown(){
        closeBrowser();
}}