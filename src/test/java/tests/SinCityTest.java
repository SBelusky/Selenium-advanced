package tests;

import base.TestBase;
import enumerators.SinTag;
import models.Sin;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.SinCityPage;
import pages.SpartaPage;
import utility.RandomWordGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SinCityTest extends TestBase {
    private static final int NUMBER_OF_WORDS = 3;

    @Test
    public void newSinTest() throws IOException {
        SinCityPage sinCityPage = new SinCityPage();
        Sin sin = new Sin("A", "B", "C");
        List<SinTag> sinTags = new ArrayList<>();

        sinTags.add(SinTag.MURDER);
        sinTags.add(SinTag.CAR_ACCIDENT);
        sin.setTags(sinTags);

        sinCityPage.openPage();
        sinCityPage.fillSinInformation(sin);
        sinCityPage.markTag(sin.getTags());
        sinCityPage.confessSin();
        sinCityPage.openSinDetail(sin);
    }

    @Test
    @Ignore
    public void uloha() throws IOException {
        SinCityPage sinCityPage = new SinCityPage();
        SpartaPage spartaPage = new SpartaPage();
        List<SinTag> sinTags = new ArrayList<>();
        Map <String,String> sinDetail;
        String[] listOfWords = RandomWordGenerator.generateRandomWords(NUMBER_OF_WORDS);
        int i = 1;

        Sin sin = new Sin(listOfWords[0],listOfWords[1],listOfWords[2]);

        sinTags.add(SinTag.MURDER);
        sinTags.add(SinTag.CAR_ACCIDENT);
        sin.setTags(sinTags);

        sinCityPage.openPage();
        sinCityPage.fillSinInformation(sin);
        sinCityPage.markTag(sin.getTags());
        sinCityPage.confessSin();

        assertEquals("pending", getDriver().findElement(By.xpath("(//ul[contains(@class, 'list-of-sins')]//p[contains(text(),'pending')])[last()]")).getText());

        sinCityPage.openSinDetail(sin);
        sinDetail = sinCityPage.getDetailSinData();
        assertEquals(sin.getAuthor() + " : " + sin.getTitle(), sinDetail.get("titleSinnerTime").substring(0,sinDetail.get("titleSinnerTime").lastIndexOf("\n")));
        assertEquals(sin.getMessage(),sinDetail.get("whatHaveYouDone"));

        for (SinTag sinTag : sinTags) {
            assertEquals(sinTag.getXpathValue(), sinDetail.get("tag" + i));
            i++;
        }

        spartaPage.openPage();
        spartaPage.forgiveSin(sin);

        sinCityPage.openPage();
        assertEquals("forgiven",sinCityPage.getSinStatus(sin));
    }
}
