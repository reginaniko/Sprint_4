package ApplicationTests;

import Base.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class HomePageQuestionsDropdownTest extends BaseTest {

    private final String question;
    private final String answer;

    public HomePageQuestionsDropdownTest(String question, String answerText){
        this.question = question;
        this.answer = answerText;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData(){
        return new Object[][]{
                {"0", "Сутки — 400 рублей. Оплата курьеру — наличными или"},
                {"1", "Пока что у нас так: один заказ — один самокат. Есл"},
                {"2", "Допустим, вы оформляете заказ на 8 мая. Мы привозим"},
                {"3", "Только начиная с завтрашнего дня. Но скоро станем "},
                {"4", "Пока что нет! Но если что-то срочное — всегда можн"},
                {"5", "Самокат приезжает к вам с полной зарядкой. Этого х"},
                {"6", "Да, пока самокат не привезли. Штрафа не будет, объ"},
                {"7", "Да, обязательно. Всем самокатов! И Москве, и Моско"},
        };
    }

    @Test
    public void verifyQuestionDropdowns() {
        //перейти к разделу «Вопросы о важном»
        objHomePage.scrollToViewQuestions();
        //найти вопрос и кликнуть по нему
        objHomePage.clickQuestion(question);
        //подтвердить что после клика на вопрос отображается ответ на него
        Assert.assertNotNull(objHomePage.answerLocator(answer));
    }
}