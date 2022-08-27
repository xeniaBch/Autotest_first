import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindElementFromTable {
    WebDriver driver;
    //before -setUp()
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/css/css_table.asp");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void tableTestWithCss(){
        WebElement canada = driver.findElement(By.cssSelector("tr:nth-child(8) td:last-child"));
        String text = canada.getText();
        //assert finding element
        Assert.assertEquals(text, "Canada");
        Assert.assertTrue(text.contains("Canada"));
    }

    @Test
    public void tableListTestWithCss(){
        //assert numbers of rows
        List<WebElement> rows = driver.findElements(By.cssSelector("tr"));
        Assert.assertEquals(rows.size(), 21);
        //assert numbers of columns
        List<WebElement> columns = driver.findElements(By.cssSelector("tr th"));
        Assert.assertEquals(columns.size(), 11);


    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
