import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class XpathTest {

    @Test
    public void findElements(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        //by Id
        By buttonId = By.xpath(("//button[@id='clickOnMe']"));
        WebElement clickOnMeButton = driver.findElement(buttonId);
        //clickOnMeButton.click();

        //by name
        By firstName = By.xpath("//input[@name='fname']");
        WebElement firstNameInput = driver.findElement(firstName);
        WebElement firstNameInput2 = driver.findElement(By.name("fname"));
        //firstNameInput.sendKeys("abc");

        //by className
        WebElement hiddenParagraph = driver.findElement(By.xpath("//p[@class='topSecret']"));

        //by tagName
        WebElement inputList = driver.findElement(By.xpath("//input"));

        //by tagName (list of elements)
        List<WebElement> inputs = driver.findElements(By.tagName("//input"));
        System.out.println("Inputs found: " + inputs.size());

        //by linkText
        WebElement linkToW3School = driver.findElement(By.xpath("//a[text()='Visit W3Schools.com!']"));
        linkToW3School = driver.findElement(By.xpath("//a[contains(text(), 'Visit')]"));

        WebElement fullPath = driver.findElement(By.xpath("/html/body/div/ul"));
        WebElement shortPath = driver.findElement(By.xpath("//ul"));

        WebElement allXpath = driver.findElement(By.xpath("//*"));
        WebElement secondElement = driver.findElement(By.xpath("(//input)[2]"));
        WebElement lastElement = driver.findElement(By.xpath("(//input)[last()]"));
        WebElement elementWithAttribute = driver.findElement(By.xpath("//*[@name]"));
        WebElement firstElementWithAttribute = driver.findElement(By.xpath("(//input)[last()]"));
        WebElement allXpathWithAttribute = driver.findElement(By.xpath("//*[@name='fname']"));

        WebElement attrEquals = driver.findElement(By.xpath("//button[@id='clickOnMe']"));
        WebElement attrNotEquals = driver.findElement(By.xpath("//button[@id!='clickOnMe']"));
        WebElement attrContains = driver.findElement(By.xpath("//*[contains(@name, 'ame')]"));
        WebElement startsWith = driver.findElement(By.xpath("//*[starts-with(@name, 'user')]"));
        WebElement endsWith = driver.findElement(By.xpath("//*[substring(@name,string-length(@name)-string-length('name')+1)='name']"));

        WebElement child = driver.findElement(By.xpath("//div/child::ul"));
        WebElement desc = driver.findElement(By.xpath("//div//descendant::ul"));
        WebElement parent = driver.findElement(By.xpath("//div/../.."));
        WebElement asc = driver.findElement(By.xpath("//div/ancestor::*"));
        WebElement following = driver.findElement(By.xpath("//img/following::*"));
        WebElement followingSub = driver.findElement(By.xpath("//img/following-sibling::*"));
        WebElement preced = driver.findElement(By.xpath("//img/preceding::*")); //wszystkie przed obrazkiem
        WebElement precedSub = driver.findElement(By.xpath("//img/preceding-sibling::*")); //wszystkie przed obrazkiem na tym samym poziomie

        WebElement sum = driver.findElement(By.xpath("//a | //div"));
        WebElement andOp = driver.findElement(By.xpath("//input[@name ='fname' and @id ='fname']"));
        WebElement orOp = driver.findElement(By.xpath("//input[@name = 'fname' or @id = 'name']"));

    }
}
