import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.Test;
import org.junit.After;

import static org.junit.Assert.assertEquals;

public class AccordionTest {

    private WebDriver driver;

    @Test
    public void checkAccordionShowsAnswers() {
        // драйвер для браузера Chrome
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // открываем страницу
        String landingPage = "https://qa-scooter.praktikum-services.ru/";
        driver.get(landingPage);

        // экземпляр класса
        MainLandingPage objMainLandingPage = new MainLandingPage(driver);

        // реализуем действия
        objMainLandingPage.cookieButtonClick();
        objMainLandingPage.scrollToQuestionHowMatch();
        objMainLandingPage.questionHowMatchClick();
        objMainLandingPage.waitForAnswerIsVisible();

        // задали переменную с ожидаемым ответом для сравнения и сравнили с фактическими данными
        String expectedAnswer = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        assertEquals("Текст ответа некорректен.", expectedAnswer, objMainLandingPage.getAnswerPriceText());
    }

    // закрыли браузер
    @After
    public void teardown() {
        driver.quit();
    }
}
