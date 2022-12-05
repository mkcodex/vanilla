package amazon.pageObjects;

import org.openqa.selenium.By;

public class SearchResultsPageObj {
    public static By filterLink = By.id("a-autoid-0-announce");
    public static By priceHLLink = By.id("s-result-sort-select_2");
    public static By secondProductLink = By.xpath("(//span[@data-component-type='s-search-results']/div/div[3]//a)[2]");
    
}
