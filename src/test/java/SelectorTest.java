import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class SelectorTest {

    @Test
    public void findElements(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        //by Id
        By buttonId = By.id("clickOnMe");
        WebElement clickOnMeButton = driver.findElement(buttonId);
        //clickOnMeButton.click();

        //by name
        By firstName = By.name("fname");
        WebElement firstNameInput = driver.findElement(firstName);
        WebElement firstNameInput2 = driver.findElement(By.name("fname"));
        //firstNameInput.sendKeys("abc");

        //by className
        WebElement hiddenParagraph = driver.findElement(By.className("topSecret"));

        //by tagName
        WebElement inputList = driver.findElement(By.tagName("input"));

        //by tagName (list of elements)
        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        System.out.println("Inputs found: " + inputs.size());

        //by linkText
        WebElement linkToW3School = driver.findElement(By.linkText("Visit W3Schools.com!"));
        linkToW3School = driver.findElement(By.partialLinkText("Visit"));

    }
}
