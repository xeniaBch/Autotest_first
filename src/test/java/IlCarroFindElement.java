import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class IlCarroFindElement {
    WebDriver driver;
    //before -setUp()
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://ilcarro-1578153671498.web.app/search");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    //test
    @Test
    public void findElementsByTag() {
        WebElement element_h1 = driver.findElement(By.tagName("h1"));
        System.out.println("element by tag h1 " + element_h1.getText());

        WebElement element_h2 = driver.findElement(By.tagName("h2"));
        System.out.println("element by tag h2 " + element_h2.getText());

        List<WebElement> elements = driver.findElements(By.tagName("a"));
        System.out.println("number of tags a " + elements.size());

    }

    @Test
    public void findElementByClassName() {
        WebElement telephone = driver.findElement(By.className("telephone"));
        System.out.println("element by class telephone " + telephone.getText());

        WebElement address = driver.findElement(By.className("address"));
        System.out.println("element by class address " + address.getText());

        WebElement inputLabel = driver.findElement(By.className("input-label"));
        System.out.println("element by class input-label " + inputLabel.getText());

        WebElement requiredMarker = driver.findElement(By.className("required-marker"));
        System.out.println("element by class required-marker " + requiredMarker.getText());
    }

    @Test
    public void findElementById() {
        WebElement byId_0 = driver.findElement(By.id("0"));
        System.out.println("element for id 0 " + byId_0.getText());

        WebElement byId_1 = driver.findElement(By.id("1"));
        System.out.println("element for id 1 " + byId_1.getText());

        WebElement byId_2 = driver.findElement(By.id("2"));
        System.out.println("element for id 2 " + byId_2.getText());
    }

    //after - tearDown()
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
