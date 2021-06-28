package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import static org.junit.Assert.*;

public class HowManyElementsTest {
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
        url = baseUrl +  "minions.php";
    }

    @Test
    public void waitForElements() {
        driver.get(url);

        driver.findElement(By.xpath("//input[@type='number']")).sendKeys("6");
        driver.findElement(By.xpath("//button[contains(@class,'btn')]")).click();

        new WebDriverWait(driver,10)
                .until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[@class='minions']/li"),5));

        assertEquals(5,driver.findElements(By.xpath("//div[@class='minions']/li")).size());
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
