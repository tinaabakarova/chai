import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import pages.SecondPage;

/**
 * Created by student on 03.11.2018.
 */
public class ChaihonaTest {
    MainPage mainPage = new MainPage();
    SecondPage secondPage = new SecondPage();

    @Before
    public void before(){
        mainPage.startUp();
    }

    @After
    public void after(){
        mainPage.endTest();
    }


    @Test
    public void myTest() throws InterruptedException {
        if (mainPage.popupIsPresent())
            mainPage.click(mainPage.popup);
        mainPage.click(mainPage.mainMenu);
        mainPage.clickMenu("Салаты и Закуски");
        secondPage.waitForVisible(By.xpath("//div[@class='catalog-products']"));
        //secondPage.orderItem("202");
        //secondPage.orderItem("203");
        //secondPage.orderItem("76");
    }
}
