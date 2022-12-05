import amazon.config.EnvFactory;
import amazon.factories.DriverFactory;
import amazon.factories.ReusableFunc;
import amazon.pageObjects.MainPageObj;
import amazon.pageObjects.NavigationPageObj;
import amazon.pageObjects.ProductPageObj;
import amazon.pageObjects.SearchResultsPageObj;

import com.typesafe.config.Config;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;


public class TestSandbox extends ReusableFunc {
    private static Config config = EnvFactory.getInstance().getConfig();
    private static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");
    private static WebDriver driver = DriverFactory.getDriver();

    @Tag("smokeTest")
    @DisplayName("This Test is to validate the About Item in the Product page for Second ranked Samsung TV Sorted by price")
    @Test
    void checkAboutSecondSamsungTV() {
        try {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //Open Amazon.in URL and assert the Title
        driver.get(HOME_PAGE_URL);
        assertEquals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in", driver.getTitle());

        //Click on the Hamburger Icon on the Menu
        ClickElement(driver, MainPageObj.hamBurgerIdBy);

        //Navigate to Television section through Navigation Pane
        ClickElement(driver, NavigationPageObj.electronicsLink);
        ClickElement(driver, NavigationPageObj.televisionLink);
        ClickElement(driver, NavigationPageObj.samsungSideLink);

        //Sort the Products
        ClickElement(driver, SearchResultsPageObj.filterLink);
        ClickElement(driver, SearchResultsPageObj.priceHLLink);

        //Select the 2nd TV
        ClickElement(driver, SearchResultsPageObj.secondProductLink);

        //Switch to Child Window
        switchToChildWindow(driver);

        //Validate the About Item and Log it
        System.out.println(driver.findElement(ProductPageObj.aboutThisContent).getText());

        //Close the Child Window and switch back to Parent Window
        switchToParentWindow(driver);

        } catch (Exception e) {
            e.printStackTrace();
        }



    }


    @AfterAll
    static void tearDownAll() {
                //Closing the browser
                System.out.println("All Tests are complete hence closing the driver");
                driver.close();
    }

}
