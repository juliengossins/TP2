import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest
{
    WebDriver webDriver;

    @Before
    public void Setup()
    {
        this.webDriver = new ChromeDriver();
        this.webDriver.get("https://www.google.com");
    }

    @After
    public void TearDown() throws InterruptedException
    {
        Thread.sleep(2000);
        this.webDriver.quit();
    }

    @Test
    public void TestSearchByEnterKey()
    {
        WebElement element = this.webDriver.findElement(By.id("lst-ib"));
        element.sendKeys("Cannelés" + Keys.ENTER);
    }

    @Test
    public void TestSearchByClick()
    {
        WebElement element = this.webDriver.findElement(By.id("lst-ib"));
        element.sendKeys("Cannelés" + Keys.ESCAPE);
        WebElement element2 = this.webDriver.findElement(By.name("btnK"));
        element2.click();
    }
}
