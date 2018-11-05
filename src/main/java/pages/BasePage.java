package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.TestProps;

import java.util.concurrent.TimeUnit;

public class BasePage {
    WebDriver driver;
    String BASE_URL;
    JavascriptExecutor jse;
    WebDriverWait wait;


    public WebDriver getDriver() {
        return driver;
    }

    public void startUp(){
        System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
        jse = (JavascriptExecutor)driver;
        wait = new WebDriverWait(driver, 20);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        driver.get((String) TestProps.getInstance().getProperties().get("base.url"));
    }

    public void endTest(){
        //driver.quit();
    }

    public void waitForVisible(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForClicable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForClicable(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement findByXpath(String xpath){
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement findByLocator(By locator){
        return driver.findElement(locator);
    }

    public void click(By locator){
        findByLocator(locator).click();
    }

    public void click(String xpath){
        findByXpath(xpath).click();
    }

    public void click(WebElement element){
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void checkElementText(WebElement element, String expectedText){
        Assert.assertEquals("Значения текст не соотвествует ожидаемому",
                expectedText, element.getText());
    }

    public void scroll(WebElement element) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false);",element);
    }

}
