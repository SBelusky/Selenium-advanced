package tests;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.ExcelReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class PrimeNumberTest {
    private static final String TEST_DATA_PATH = "src/test/resources/data.xlsx";
    private static final String SHEET = "prime";


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
        url = baseUrl +  "primenumber.php";
    }

    @Test
    public void testPrimeNumber() throws IOException, InterruptedException {
        driver.get(url);
        WebElement input = driver.findElement(By.xpath("//input"));
        WebElement submit = driver.findElement(By.xpath("//button[contains(@class,'btn-default')]"));
        WebElement answerText = driver.findElement(By.xpath("//div[contains(@class,'result')]"));
        String number, answer;
        ExcelReader excelReader = new ExcelReader(TEST_DATA_PATH);
        Sheet sheet = excelReader.getSheetByName(SHEET);

        for (Row row : sheet) {
            if (row.getRowNum() == 0){
                continue;
            }
            number = String.valueOf(row.getCell(0).getNumericCellValue());
            answer = rewriteAnswear(row.getCell(1).getBooleanCellValue());

            input.sendKeys(number);
            submit.click();

            new WebDriverWait(driver,10)
                    .until(ExpectedConditions.visibilityOf(answerText));

            assertEquals(answer,answerText.getText());

            input.clear();
        }
    }

    public String rewriteAnswear(Boolean answer){
        if (answer) {
            return "Optimus approves";
        } else if (!answer) {
            return "Optimus is sad";
        }
        return "Optimus is sad";
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
