package tests;

import categories.ReleaseTest;
import categories.SmokeTest;
import com.google.code.tempusfugit.concurrency.ConcurrentTestRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

@RunWith(ConcurrentTestRunner.class)                                                                                    //Testy sa spúšťajú paralelne (naraz) !!
public class DummyTest {

    @Category(SmokeTest.class)
    @Test
    public void testA() {
        System.out.println("A");
    }

    @Category({SmokeTest.class, ReleaseTest.class})
    @Test
    public void testB() {
        Assert.assertEquals(1,1);
    }
}
