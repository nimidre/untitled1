import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumTests {

    @Test
    public void openGooglePage() {

        WebDriver driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        //przechodzimy do okienka z plikami cookies
        //driver.switchTo().frame(1);
        //znalezienie przycisku
        WebElement agreeButton = driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div"));
        //kliknięcie przycisku Zgadzam się
        agreeButton.click();
        //powrót do pierwotnego okna
        driver.switchTo().defaultContent();
        //znajdz pole wyszukiwania google
        WebElement searchField = driver.findElement(By.name("q"));
        //wprowadź wartość Selenium do pola
        searchField.sendKeys("Selenium");
        //zasymuluj kliknięcie przycisku Enter
        searchField.sendKeys(Keys.ENTER);
        //znaleźć rezultat
        WebElement result = driver.findElement(By.xpath("//a[contains(@href, 'sii.pl')]//span"));

        Assert.assertTrue(result.isDisplayed());
    }

    public WebDriver getDriver(String browser) {

        switch (browser){
            case "chrome":
                return new ChromeDriver();
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "C:\\WebDrivery\\geckodriver-v0.29.1-win64\\geckodriver.exe");
                return new FirefoxDriver();
            case "ie":
                System.setProperty("webdriver.ie.driver", "C:\\WebDrivery\\IEDriverServer_x64_3.150.1\\IEDriverServer.exe");
                return new InternetExplorerDriver();
            default:
                throw new InvalidArgumentException("Invalid browser name");
        }

    }
}
