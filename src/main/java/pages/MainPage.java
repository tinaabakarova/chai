package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.junit.Assert.*;

import java.util.List;

/**
 * Created by student on 03.11.2018.
 */
public class MainPage extends BasePage {
    @FindBy(xpath = "//*[@id='pw-confirm__close']")
    public WebElement popup;

    @FindBy(xpath = "//*[@id='desktopMenuMain']//a[contains(text(),'Меню доставки')]")
    public WebElement mainMenu;

    @FindBy(xpath = "//*[@id='desktopMenuMain']//a[@href='/catalog']/..//div[@class='main-menu__wrap']/ul[contains(@class, 'main-menu__list--double-column')]")
    public WebElement mainMenuList;

    public void clickMenu(String text){
        List<WebElement> href = driver.findElements(By.xpath("//*[@id='desktopMenuMain']//a[@href='/catalog']/..//li[@class='level-2__item']/a[contains(text(),'"+text+"')]"));

        assertNotEquals("", href.size(), 0);
        this.click(href.get(0));
    }

    public boolean isPageLoaded() {
        return false;
    }

    public boolean popupIsPresent(){
        boolean isPresent = driver.findElements(By.xpath("//*[@id='pw-confirm__close']")).size() > 0;
        return isPresent;
    }
}
