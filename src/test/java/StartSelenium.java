import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class StartSelenium {

    WebDriver wd;
    //before -setUp()
    @BeforeMethod
    public void setUp(){
        wd = new ChromeDriver();
        wd.get("https://contacts-app.tobbymarshall815.vercel.app");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    //test
    @Test
    public void findElementsByTag() {
        WebElement element = wd.findElement(By.tagName("h1"));
        System.out.println(element.getText());

        List<WebElement> elements = wd.findElements(By.tagName("a"));
        System.out.println(elements.size());

    }

    @Test
    public void findElementByClassName() {
        WebElement container = wd.findElement(By.className("container"));
        System.out.println(container.getText());
    }

    @Test
    public void findElementById() {
        WebElement root = wd.findElement(By.id("root"));
        System.out.println(root.getText());
    }

    //after - tearDown()
    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
}
