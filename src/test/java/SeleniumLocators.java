import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SeleniumLocators {
    WebDriver driver;
    //before -setUp()
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://ilcarro-1578153671498.web.app/registration?url=%2Fsearch\n");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void startFindLocators() {
        //id
        driver.findElement(By.id("name"));
        //className
        driver.findElement(By.className("input-container"));
        //name
        driver.findElement(By.name("viewport"));
        //linkText
        WebElement phone = driver.findElement(By.linkText("866-720-5721"));
        System.out.println(phone.getText());
        //parLinkText
        WebElement car = driver.findElement(By.partialLinkText("car"));
        System.out.println(car.getText());

    }

    @Test
    public void startFindCss(){
        //tag ->
        driver.findElement(By.cssSelector("label"));
        //id -> #
        driver.findElement(By.cssSelector("#name"));
        //className -> .
        driver.findElement(By.cssSelector(".login-registration-container"));
        //attribute -> []
        driver.findElement(By.cssSelector("[autocomplete='name']"));
        driver.findElement(By.cssSelector("[href='/search']"));
        //contains -> "ssw"
        driver.findElement(By.cssSelector("[for*='ssw']"));
        //start with -> "pas"
        driver.findElement(By.cssSelector("[for^='pas']"));
        //end with -> "rd"
        driver.findElement(By.cssSelector("[for$='rd']"));
        //tag+class
        driver.findElement(By.cssSelector("label.input-label"));

    }

    @Test
    public void startFindXPath() {
        //driver.findElement(By.tagName("label"));
        driver.findElement(By.xpath("//label"));
        //id -> "//tag[@id='value']"
        driver.findElement(By.xpath("//input[@id='name']"));
        //className ->"//tag[@class='value']"
        driver.findElement(By.xpath("//div[@class='login-registration-container']"));
        //attribute
        driver.findElement(By.xpath("//*[@autocomplete='name']"));
        //contains
        driver.findElement(By.xpath("//*[contains(.,'ssw')]"));
        driver.findElement(By.xpath("//h2[contains(.,'Type your data and hit Yalla!')]"));

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}


