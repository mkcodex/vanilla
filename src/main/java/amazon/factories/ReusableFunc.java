package amazon.factories;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableFunc {

    private String parentId;

    public static void ClickElement(WebDriver driver, By locatorBy) {
        try {
            wdWaitForElement(driver, locatorBy);
            driver.findElement(locatorBy).click();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void wdWaitForElement(WebDriver driver, By locatorBy) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locatorBy));
    }

    public WebDriver switchToChildWindow(WebDriver driver) {

        // It will return the parent window name as a String
        parentId = driver.getWindowHandle();

        Set<String> s = driver.getWindowHandles();

        // Now iterate using Iterator
        Iterator<String> I1 = s.iterator();

        while (I1.hasNext()) {

            String child_window = I1.next();

            if (!parentId.equals(child_window))
                driver.switchTo().window(child_window);
        }
        return driver;
    }

    public WebDriver switchToParentWindow(WebDriver driver) {
        driver.close();
        //switch to the parent window
        driver.switchTo().window(parentId);
        return driver;
    }


}
