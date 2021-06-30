package tests;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.ExcelReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(Parameterized.class)
public class ParameterTest {
    private static final String TEST_DATA_PATH = "src/test/resources/data.xlsx";
    private static final String SHEET = "prime";
    int number;
    private WebDriver driver;
    private StringBuffer verificationErrors;
    private String baseUrl;
    static final Properties prop = new Properties();
    private FileInputStream ip;
    private static String url;

    public ParameterTest(int number) {
        this.number = number;
    }

    @Before
    public void setUp() throws IOException {
        ip = new FileInputStream("src/test/resources/config.properties");
        prop.load(ip);

        System.setProperty("webdriver.gecko.driver", prop.getProperty("WEBDRIVER_PATH"));
        verificationErrors = new StringBuffer();
        driver = new FirefoxDriver();
        baseUrl = prop.getProperty("BASE_URL");
        url = baseUrl + "primenumber.php";
    }

    @Parameters
    public static Collection<Object[]> getData() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        Collection<Object[]> result = new ArrayList<>();

        for (Integer integer : list) {
            result.add(new Object[]{integer});
        }

        return result;
    }

    @Test
    public void parameterTest() throws IOException {
        driver.get(url);
        System.out.println(number);
        WebElement input = driver.findElement(By.xpath("//input"));
        WebElement submit = driver.findElement(By.xpath("//button[contains(@class,'btn-default')]"));
        WebElement answerText = driver.findElement(By.xpath("//div[contains(@class,'result')]"));
        ExcelReader excelReader = new ExcelReader(TEST_DATA_PATH);
        Sheet sheet = excelReader.getSheetByName(SHEET);

    }

    @After
    public void tearDown() {
        driver.quit();
        String verificationErrorsString = verificationErrors.toString();

        if (!"".equals(verificationErrorsString)) {
            fail(verificationErrorsString);
        }
    }
}
