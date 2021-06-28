package suits;

import categories.SmokeTest;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.DummyTest;
import tests.HighlightElementTest;

// !!! kukni videjko

@RunWith(Categories.class)
@IncludeCategory(SmokeTest.class)
@Suite.SuiteClasses({
        DummyTest.class,
        HighlightElementTest.class
})
public class SmokeTestSuit {
}
