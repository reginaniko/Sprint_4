package ApplicationTests;

import Base.BaseTest;
import PageObjects.HomePageSamokat;
import org.junit.Test;

public class HomePageQuestionsDropdownTest extends BaseTest {

    @Test
    public void verifyQuestionDropdowns() {
        HomePageSamokat objHomePage = new HomePageSamokat(driver);
        objHomePage.verifyAllQuestions();
    }
}