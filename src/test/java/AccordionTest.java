import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.Test;
import org.junit.After;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccordionTest {

        // переменные
    private WebDriver driver;
    private final By questionLocator;
    private final By answerLocator;
    private final String expectedQuestionText;
    private final String expectedAnswerText;

        // конструктор
    public AccordionTest
    (By questionLocator, By answerLocator, String expectedQuestionText, String expectedAnswerText) {
        this.questionLocator=questionLocator;
        this.answerLocator=answerLocator;
        this.expectedQuestionText=expectedQuestionText;
        this.expectedAnswerText=expectedAnswerText;
    }

    @Parameterized.Parameters
    public static Object[][] expectedFAQData() {
        return new Object[][] {
                {FAQ.QUESTION_1_LOCATOR, FAQ.ANSWER_1_LOCATOR, FAQ.QUESTION_1_TEXT, FAQ.ANSWER_1_TEXT},
                {FAQ.QUESTION_2_LOCATOR, FAQ.ANSWER_2_LOCATOR, FAQ.QUESTION_2_TEXT, FAQ.ANSWER_2_TEXT},
                {FAQ.QUESTION_3_LOCATOR, FAQ.ANSWER_3_LOCATOR, FAQ.QUESTION_3_TEXT, FAQ.ANSWER_3_TEXT},
                {FAQ.QUESTION_4_LOCATOR, FAQ.ANSWER_4_LOCATOR, FAQ.QUESTION_4_TEXT, FAQ.ANSWER_4_TEXT},
                {FAQ.QUESTION_5_LOCATOR, FAQ.ANSWER_5_LOCATOR, FAQ.QUESTION_5_TEXT, FAQ.ANSWER_5_TEXT},
                {FAQ.QUESTION_6_LOCATOR, FAQ.ANSWER_6_LOCATOR, FAQ.QUESTION_6_TEXT, FAQ.ANSWER_6_TEXT},
                {FAQ.QUESTION_7_LOCATOR, FAQ.ANSWER_7_LOCATOR, FAQ.QUESTION_7_TEXT, FAQ.ANSWER_7_TEXT},
                {FAQ.QUESTION_8_LOCATOR, FAQ.ANSWER_8_LOCATOR, FAQ.QUESTION_8_TEXT, FAQ.ANSWER_8_TEXT},
        };
    }

    @Before
    public void creation () {
        driver = new ChromeDriver(); // драйвер для браузера Chrome
        driver.manage().window().maximize(); // развернули окно
        driver.get(MainLandingPage.URL_OF_MAIN_PAGE); // открываем страницу
    }

    @Test
    public void testAccordionFAQTexts() {
        MainLandingPage objMainLandingPage = new MainLandingPage(driver);

            // реализация
        objMainLandingPage.cookieButtonClick(); // клик по окну с куками
        objMainLandingPage.scrollToQuestion(questionLocator); // скролл до вопроса
        String actualQuestionText = objMainLandingPage.getQuestionText(questionLocator);
        assertEquals("Текст вопроса не совпадает с требованиями", expectedQuestionText, actualQuestionText);
        objMainLandingPage.questionClick(questionLocator);
        objMainLandingPage.waitForAnswerIsVisible(answerLocator);
        String actualAnswerText = objMainLandingPage.getAnswerText(answerLocator);
        assertEquals("Текст ответа не совпадает с требованиями", expectedAnswerText, actualAnswerText);

    }

        // закрыли браузер
    @After
    public void teardown() {
        driver.quit();
    }
}
