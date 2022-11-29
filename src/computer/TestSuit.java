package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;

public class TestSuit extends Utility {


    String baseUrl = "https://demo.nopcommerce.com/";
    private String C;

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        // 1.1 Click on Computer Menu
        clickElement(By.xpath("(//a[normalize-space()='Computers'])[1]"));
        // 1.2Click on Desktop
        clickElement(By.xpath("//body/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));
        //1.3 Select Sort By position "Name: Z to A"
        clickElement(By.name("products-orderby"));
        selectValueFromDropDown(By.xpath("//*[@id=products-orderby]"),"Z to A ");
        String expectedMessage="Name: Z to A";

        String actualMessage = getTextFromElement(By.xpath("//select[@id='products-orderby']"));
       // Assert.assertEquals("Product will arrange in Descending order",actualMessage);

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
       {
            // 2.1 Click on Computer Menu
            clickElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Computers ')]"));
            // 2.2 Click on Desktop
            clickElement(By.partialLinkText("Desktops"));
            clickElement(By.name("products-orderby"));
            driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]")).click();
            //2.3 Select Sort By position "Name: A to Z"
            selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: A to Z");
            String expectedMessage = "Build your own computer";
            String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Build your own computer')]"));
            Assert.assertEquals("Build your own computer", expectedMessage, actualMessage);
           //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class

           driver.findElement(By.xpath("//option[@value='1']")).click();

           // 2.7.Select "8GB [+$60.00]" using Select class.
           driver.findElement(By.xpath("//option[@value='5']")).click();

           //2.8 Select HDD radio "400 GB [+$100.00]"
           driver.findElement(By.xpath("//input[@id='product_attribute_3_7']")).click();

           //2.9 Select OS radio "Vista Premium [+$60.00]"
           driver.findElement(By.xpath("//input[@id='product_attribute_4_9']")).click();

           //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander

           driver.findElement(By.xpath("//input[@id='product_attribute_5_12']")).click();
           //driver.findElement(By.xpath("")).click();
           //driver.findElement(By.xpath("//label[contains(text(),'Microsoft Office [+$50.00]")).click();

           Thread.sleep(1500);
           //2.11 Verify the price "$1,475.00"
           String actualMsg2 = verifyText(By.xpath("//span[@id='price-value-1']"));
           Assert.assertEquals("$1,475.00", actualMsg2);
           Thread.sleep(1500);


            // 2.12 Click on "ADD TO CARD" Button.
            driver.findElement(By.xpath("//button[@id='add-to-cart-button-1']")).click();
            // 2.13 Verify the Message "The product has been added to your shopping cart" on Top
           //green Bar
            String actualMessage2 = getTextFromElement(By.xpath("//p[@class='content']"));
            Assert.assertEquals("The product has been added to your shopping cart", actualMessage2);
            clickElement(By.xpath("//*[@id=bar-notification]/div/span"));
            // 2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.

            //mouseHoverToElementAndClick(By.xpath("//button[@class='button-1 cart-button']"));
            mouseHoverToElementAndClick(By.xpath("//span[contains(text(),'Shopping cart')]"));
            String actualMessage3 = getTextFromElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
             // 2.15 Verify the message "Shopping cart"
            Assert.assertEquals("Shopping cart",actualMessage3);
            clickElement(By.xpath("//span[contains(text(),'Shopping cart')]"));

            // 2.16 Change the Qty to "2" and Click on "Update shopping cart"
            driver.findElement(By.xpath("//td[@class='quantity']//input[@value='1']")).clear();
            sendTextToElement(By.xpath("//td[@class='quantity']//input[@value='1']"),"2");
            clickElement(By.xpath("//button[@class='button-2 update-cart-button']"));

            // 2.17 Verify the Total"$2,950.00"
            String actualMessage4= getTextFromElement(By.xpath("//input[@id='product_enteredQuantity_20']]"));
            Assert.assertEquals("$2,950.00", actualMessage4);

            //2.18 click on checkbox “I agree with the terms of service”
            driver.findElement(By.xpath("//label[contains(text(),'I agree with the terms of service and I adhere to ')]")).click();
            //2.19 Click on “CHECKOUT”
           driver.findElement(By.xpath("//button[@id='checkout']")).click();
           //2.20 Verify the Text “Welcome, Please Sign In!”
           String actualMessage5 = " Verify the Text “Welcome, Please Sign In!”";
           Assert.assertEquals(" Verify the Text “Welcome, Please Sign In!",actualMessage5);
            // 2.21Click on “CHECKOUT AS GUEST” Tab
           driver.findElement(By.xpath(".button-1.checkout-as-guest-button")).click();

           // 2.22 Fill the all mandatory field
           sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"),"Vimal");
           sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"),"Pankhaniya");
           sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"),"V@hotmail.co.uk");
           sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Company']"),"PPLtd");
           sendTextToElement(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"United Kingdom");

           sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "London UK");
           sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "56 Highfield NW4 3DT");
           sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "25251");
           sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "07868114545");

           //2.23 Click on “CONTINUE”
          clickElement(By.xpath("//button[@onclick='Billing.save()']"));
          //2.24 Click on Radio Button “Next Day Air($0.00)”
           clickElement(By.xpath("//label[normalize-space()='Next Day Air ($0.00)']"));

           //2.25 Click on “CONTINUE”
           clickElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));

            //2.26 Select Radio Button “Credit Card”
            clickElement(By.xpath("//label[text()='Credit Card']"));

           //2.27 Select “Master card” From Select credit card dropdown

           clickElement(By.xpath("//label[contains(text(),'Select credit card:')]"));
            // 2.28 Fill all the details
           sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Vimal Pankhaniya");
           sendTextToElement(By.xpath("//input[@id='CardNumber']"), "12256356458578961");
           sendTextToElement(By.xpath("//select[@id='ExpireMonth']"), "02");
           sendTextToElement(By.xpath("//select[@id='ExpireYear']"), "2023");
           sendTextToElement(By.xpath("//input[@id='CardCode']"), "123");

           // 2.29 Click on “CONTINUE”
           clickElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));
            //2.30 Verify “Payment Method” is “Credit Card”
           verifyTextFromElements(By.xpath("//li[@class='payment-method']"), "Payment Method: Credit Card");

           //   2.32 Verify “Shipping Method” is “Next Day Air”
           Thread.sleep(1500);
           //   2.33 Verify Total is “$2,950.00”
           verifyTextFromElements(By.xpath("//tr[@class='order-total']/td[2]"), "$2,950.00");
           //  2.34 Click on “CONFIRM”
           clickElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button']"));
           //  2.35 Verify the Text “Thank You”
           verifyTextFromElements(By.xpath("//h1[contains(text(),'Thank you')]"), "Thank you");

           //  2.36 Verify the message “Your order has been successfully processed!”
           verifyTextFromElements(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"), "Your order has been successfully processed!");

           //  2.37 Click on “CONTINUE”
           clickElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));

           //  2.37 Verify the text “Welcome to our store”
           verifyTextFromElements(By.xpath("//h2[contains(text(),'Welcome to our store')]"), "Welcome to our store");

       }
        }

    @After
    public void tearDown(){
        closeBrowser();
    }
}


