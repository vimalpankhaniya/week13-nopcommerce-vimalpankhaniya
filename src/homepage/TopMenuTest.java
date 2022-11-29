package homepage;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    public void selectMenu(String menu) {
    String a = getTextFromElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a"));

        if (menu.contains(a)){

            clickElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a"));
        }
    }
    @Test
    public void  verifyPageNavigation (){
        String menu = getTextFromElement(By.xpath("//body/div[6]/div[2]"));

      selectMenu(menu);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
