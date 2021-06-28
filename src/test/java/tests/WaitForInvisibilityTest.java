package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import static org.junit.Assert.*;

public class WaitForInvisibilityTest {
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
        url = baseUrl +  "prestige.php";
    }

    @Test
    public void isItemInvisible() {
        driver.get(url);
        WebElement hat = driver.findElement(By.xpath("//div[@class='hat']/img"));

        hat.click();
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='hat']/img")));
        assertFalse(hat.isDisplayed());

        new WebDriverWait(driver,10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='hat']/img")));
        assertTrue(hat.isDisplayed());

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
