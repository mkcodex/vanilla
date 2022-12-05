package amazon.pageObjects;

import org.openqa.selenium.By;

public class NavigationPageObj {
    public static By electronicsLink = By.xpath("//div[text()='TV, Appliances, Electronics']");
    public static By televisionLink = By.xpath("//a[text()='Televisions']");
    public static By samsungSideLink = By.xpath("//span[text()='Brands']//following::ul[1]//*[text()='Samsung']");
}
