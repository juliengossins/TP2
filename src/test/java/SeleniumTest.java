import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SeleniumTest
{
    WebDriver webDriver;

    @Before
    public void Setup()
    {
        this.webDriver = new ChromeDriver();
        this.webDriver.get("https://www.google.com");
        this.webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
        String expectedResult = "République française - France — Wikipédia";

        WebElement element = this.webDriver.findElement(By.id("lst-ib"));
        element.sendKeys("France" + Keys.ENTER);

        WebElement searchFirstResult = this.webDriver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div/div/div/div/h3/a"));
        Assert.assertEquals(expectedResult,searchFirstResult.getText());
    }

    @Test
    public void TestSearchByClick()
    {
        String expectedResult = "République française - France — Wikipédia";

        WebElement searchField = this.webDriver.findElement(By.id("lst-ib"));
        searchField.sendKeys("France" + Keys.ESCAPE);

        WebElement searchButton = this.webDriver.findElement(By.name("btnK"));
        WebDriverWait wait = new WebDriverWait(this.webDriver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();

        WebElement searchFirstResult = this.webDriver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div/div/div/div/h3/a"));
        Assert.assertEquals(expectedResult,searchFirstResult.getText());
    }

    @Test
    public void TestSearchByClickInDropDown()
    {
        String expectedResult = "République française - France — Wikipédia";

        WebElement searchField = this.webDriver.findElement(By.id("lst-ib"));
        searchField.sendKeys("France");

        WebElement searchButton = this.webDriver.findElement(By.className("lsb"));

        WebDriverWait wait = new WebDriverWait(this.webDriver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();

        WebElement searchFirstResult = this.webDriver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div/div/div/div/h3/a"));
        Assert.assertEquals(expectedResult,searchFirstResult.getText());
    }
}
