package tests;

import categories.SmokeTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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
import static org.junit.Assert.*;

public class HighlightElementTest {
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
        url = baseUrl +  "tabulka.php";
    }

    @Test
    @Category(SmokeTest.class)
    public void highlightElement() {
        driver.get(url);
        List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));

        for (WebElement row : rows) {
            JShighlight(row);
        }
    }

    private void JShighlight(WebElement row) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red'",row);
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
