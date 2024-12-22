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
                {FAQ.QUESTION_ABOUT_PRICE, FAQ.ANSWER_ABOUT_PRICE, FAQ.QUESTION_ABOUT_PRICE_TEXT, FAQ.ANSWER_ABOUT_PRICE_TEXT},
                {FAQ.QUESTION_ABOUT_QUANTITY, FAQ.ANSWER_ABOUT_QUANTITY, FAQ.QUESTION_ABOUT_QUANTITY_TEXT, FAQ.ANSWER_ABOUT_QUANTITY_TEXT},
                {FAQ.QUESTION_ABOUT_RENT_TIME, FAQ.ANSWER_ABOUT_RENT_TIME, FAQ.QUESTION_ABOUT_RENT_TIME_TEXT, FAQ.ANSWER_ABOUT_RENT_TIME_TEXT},
                {FAQ.QUESTION_ABOUT_TODAY_RENT, FAQ.ANSWER_ABOUT_TODAY_RENT, FAQ.QUESTION_ABOUT_TODAY_RENT_TEXT, FAQ.ANSWER_ABOUT_TODAY_RENT_TEXT},
                {FAQ.QUESTION_ABOUT_RETURNING, FAQ.ANSWER_ABOUT_RETURNING, FAQ.QUESTION_ABOUT_RETURNING_TEXT, FAQ.ANSWER_ABOUT_RETURNING_TEXT},
                {FAQ.QUESTION_ABOUT_CHARGER, FAQ.ANSWER_ABOUT_CHARGER, FAQ.QUESTION_ABOUT_CHARGER_TEXT, FAQ.ANSWER_ABOUT_CHARGER_TEXT},
                {FAQ.QUESTION_ABOUT_CANCEL_ORDER, FAQ.ANSWER_ABOUT_CANCEL_ORDER, FAQ.QUESTION_ABOUT_CANCEL_ORDER_TEXT, FAQ.ANSWER_ABOUT_CANCEL_ORDER_TEXT},
                {FAQ.QUESTION_ABOUT_MKAD, FAQ.ANSWER_ABOUT_MKAD, FAQ.QUESTION_ABOUT_MKAD_TEXT, FAQ.ANSWER_ABOUT_MKAD_TEXT},
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
        String actualQuestionText = objMainLandingPage.getQuestionText(questionLocator); // переменная, в которую
        // будет записан текст вопроса из реализации
        assertEquals("Текст вопроса не совпадает с требованиями", expectedQuestionText, actualQuestionText); // сравнение
        // текста вопроса из требований и текстом из реализации
        objMainLandingPage.questionClick(questionLocator); // клик по локатору с вопросом
        objMainLandingPage.waitForAnswerIsVisible(answerLocator); // ожидание открытия карточки вопроса
        String actualAnswerText = objMainLandingPage.getAnswerText(answerLocator); // переменная, в которую
        // будет записан текст ответа из реализации
        assertEquals("Текст ответа не совпадает с требованиями", expectedAnswerText, actualAnswerText); // сравнение
        // текста ответа из требований и текстом из реализации

    }

        // закрыли браузер
    @After
    public void teardown() {
        driver.quit();
    }
}