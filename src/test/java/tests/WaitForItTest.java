package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import static org.junit.Assert.*;

public class WaitForItTest {
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
    public void waitForIt() {
        driver.get(url);

        driver.findElement(By.id("startWaitForText")).click();
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.attributeToBe(By.id("waitForTextInput"),"value","dary !!!"));
    }

    @Test
    public void getTheProperty() {
        driver.get(url);

        driver.findElement(By.id("startWaitForProperty")).click();
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.attributeContains(By.id("waitForProperty"),"class","error"));
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.attributeContains(By.id("startWaitForProperty"),"disabled",""));
        assertFalse(driver.findElement(By.id("startWaitForProperty")).isEnabled());
    }

    @Test
    @Ignore                                                                                                             //test nebude spúštaný
    public void failtTest() {
        driver.get(url);
        driver.findElement(By.id("startWaitForTexts")).click();
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
