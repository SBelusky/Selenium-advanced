package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class BlurTest {
    private WebDriver driver;
    private StringBuffer verificationErrors;
    private String baseUrl;
    static final Properties prop = new Properties();
    private FileInputStream ip;
    private static String url;

    @Before
    public void setUp() throws IOException {
        ip = new FileInputStream("src/test/resources/config.properties");
        prop.load(ip);

        System.setProperty("webdriver.gecko.driver",prop.getProperty("WEBDRIVER_PATH"));
        verificationErrors = new StringBuffer();
        driver = new FirefoxDriver();
        baseUrl = prop.getProperty("BASE_URL");
        url = baseUrl +  "waitforit.php";
    }

    @Test
    public void blur() {
        driver.get(url);
        WebElement input = driver.findElement(By.id("waitForBlur"));

        input.sendKeys("AHOJ");

        jsBlur(input);                                                                                                  // na kliknutie hocikam na stránke môžem použiť JavaScript alebo obyčajnú metódu
        clickSomewhere(driver.findElement(By.xpath("/html/body")));

        new WebDriverWait(driver,10)
                .until(ExpectedConditions.attributeToBe(input,"value","blured!"));

        assertEquals("blured!",input.getAttribute("value"));
    }

    private void clickSomewhere(WebElement element){
        element.click();
    }

    private void jsBlur (WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].blur()",element);
    }

    @After
    public void tearDown() {
        driver.quit();
        String verificationErrorsString = verificationErrors.toString();

        if (!"".equals(verificationErrorsString)){
            fail(verificationErrorsString);
        }
    }
}
