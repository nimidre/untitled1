import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CssSelectorsTest {

    @Test
    public void findElements(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        WebElement elementWithId = driver.findElement(By.cssSelector("#clickOnMe"));
        WebElement elementWithClass = driver.findElement(By.cssSelector(".topSecret"));
        WebElement elementWithCssTag = driver.findElement(By.cssSelector("input"));
        WebElement elementWithCssName = driver.findElement(By.cssSelector("[name='fname']"));
        WebElement elementWithClass2= driver.findElement(By.cssSelector("[class='topSecret']"));
        WebElement all = driver.findElement(By.cssSelector("*"));
        WebElement ulInsideDiv = driver.findElement(By.cssSelector("div ul"));
        WebElement firstChildUlinDiv = driver.findElement(By.cssSelector("div > ul"));
        WebElement firstChildTrInTbody = driver.findElement(By.cssSelector("tbody > tr"));
        WebElement firstElementAfterLabel = driver.findElement(By.cssSelector("label + form"));
        WebElement allElementsAfterLabel = driver.findElement(By.cssSelector("label ~ form"));
        WebElement attrTag = driver.findElement(By.cssSelector("input[name='fname']"));
        WebElement attrContains = driver.findElement(By.cssSelector("[name*='name']"));
        WebElement attrStarts = driver.findElement(By.cssSelector("[name^='f']"));
        WebElement attrEnds = driver.findElement(By.cssSelector("[name$='name']"));
        WebElement firstChild = driver.findElement(By.cssSelector("li:first-child"));
        WebElement lastChild = driver.findElement(By.cssSelector("li:last-child"));
        WebElement nChild = driver.findElement(By.cssSelector("li:nth-child(2)"));
        WebElement button1 = driver.findElement(By.cssSelector("#newPage"));
        WebElement button2 = driver.findElement(By.cssSelector("button#newPage"));
    }
}
