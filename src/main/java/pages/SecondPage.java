package pages;

import org.openqa.selenium.By;

public class SecondPage extends BasePage {
    public static final String priceButtonFormat = "//button[@data-id='%s']";

    public void orderItem(String id){
        By itemLocator = By.xpath(String.format(priceButtonFormat, id));
        click(itemLocator);
    }
}
