package tests;

import enumerators.SinTag;
import models.Sin;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.junit.Assert.fail;

public class SinCityTest {
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
        url = baseUrl +  "sincity.php";
    }

    @Test
    public void newSinTest() {
        driver.get(url);
        WebElement chbMurder = driver.findElement(By.xpath("//label[1]"));
        WebElement chbHijack = driver.findElement(By.xpath("//label[2]"));
        WebElement chbBlackmail = driver.findElement(By.xpath("//label[3]"));
        WebElement chbCarAccident = driver.findElement(By.xpath("//label[4]"));
        WebElement chbRobery = driver.findElement(By.xpath("//label[5]"));
        WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));

        Sin sin = new Sin("A","B","C");
        List<SinTag> sinTags = new ArrayList<>();

        sinTags.add(SinTag.MURDER);
        sinTags.add(SinTag.CAR_ACCIDENT);
        sin.setTags(sinTags);

        fillSinInformation(sin);
        markTag(sin.getTags());
    }

    public void fillSinInformation(String titleText, String authorText, String messageText){
        WebElement title = driver.findElement(By.name("title"));
        WebElement author = driver.findElement(By.name("author"));
        WebElement message = driver.findElement(By.name("message"));

        title.sendKeys(titleText);
        author.sendKeys(authorText);
        message.sendKeys(messageText);
    }

    public void fillSinInformation(Sin sin){
        WebElement title = driver.findElement(By.name("title"));
        WebElement author = driver.findElement(By.name("author"));
        WebElement message = driver.findElement(By.name("message"));

        title.sendKeys(sin.getTitle());
        author.sendKeys(sin.getAuthor());
        message.sendKeys(sin.getMessage());
    }

    private void markTag(List<SinTag> tags){
        for (SinTag tag : tags) {
            driver.findElement(By.xpath("//input[@value='"+ tag.getXpathValue() +"']")).click();
        }
    }

    @After
    public void tearDown() {
//        driver.quit();
        String verificationErrorsString = verificationErrors.toString();

        if (!"".equals(verificationErrorsString)){
            fail(verificationErrorsString);
        }
    }
}
