import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FindElementsHomework {

    WebDriver driver;

    //before -setUp()
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.notino.de");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


    public void closeCookieModal(WebElement button) {
        button.click();
    }

    @Test
    public void findElementsByCss() {
        //id
        WebElement buttonCss = driver.findElement(By.cssSelector("#onetrust-accept-btn-handler"));
        closeCookieModal(buttonCss);
        //attribute
        driver.findElement(By.cssSelector("[aria-label='Wishlist']"));
        driver.findElement(By.cssSelector("[href='/parfums/']"));
        driver.findElement(By.cssSelector("[title='Warenkorb']"));
        driver.findElement(By.cssSelector("[aria-label='Menü einblenden']"));
        //className
        driver.findElement(By.cssSelector(".footer-phoneWrapper"));
        driver.findElement(By.cssSelector(".footer-email"));
        //tag
        driver.findElement(By.cssSelector("header"));
        driver.findElement(By.cssSelector("footer"));
        //tag+class
        driver.findElement(By.cssSelector("button.footer-subscribeGenderButton"));
    }

    @Test
    public void findElementsByXpath() {
        //id
        WebElement buttonXpath = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        closeCookieModal(buttonXpath);
        //attribute
        driver.findElement(By.xpath("//*[@aria-label='Wishlist']"));
        driver.findElement(By.xpath("//*[@href='/parfums/']"));
        driver.findElement(By.xpath("//*[@title='Warenkorb']"));
        driver.findElement(By.xpath("//*[@aria-label='Menü einblenden']"));
        //className
        driver.findElement(By.xpath("//div[@class='footer-phoneWrapper']"));
        driver.findElement(By.xpath("//a[@class='footer-email']"));
        //tag
        driver.findElement(By.xpath("//header"));
        driver.findElement(By.xpath("//footer"));
        //tag+class
        driver.findElement(By.xpath("//button[@class='footer-subscribeGenderButton']"));


    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
