import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainLandingPage {

    private WebDriver driver;

        // Url главной страницы
    public static final String URL_OF_MAIN_PAGE = "https://qa-scooter.praktikum-services.ru/";
        // Кнопка ЗАКАЗАТЬ_верх:
    public static final By ORDER_BUTTON_UP = By.className("Button_Button__ra12g");
        // Кнопка ЗАКАЗАТЬ_низ:
    public static final By ORDER_BUTTON_DOWN = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
        // Кнопка про куки:
    public static final By COOKIE_BUTTON = By.id("rcc-confirm-button");

        // конструктор
    public MainLandingPage(WebDriver driver) {
        this.driver=driver;
    }

        // кликнуть на кнопку с куками
    public void cookieButtonClick () {
        driver.findElement(COOKIE_BUTTON).click();
    }

        // кликнуть по верхней кнопке "заказать"
    public void orderButtonUpClick () {
        driver.findElement(ORDER_BUTTON_UP).click();
    }

        // ожидание появления нижней кнопки
    public void waitForLowerOrderButtonIsVisible () {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(ORDER_BUTTON_DOWN));
    }

        // скролл до нижней кнопки "заказать"
    public void scrollToOrderButtonDown () {
        ((JavascriptExecutor)driver)
            .executeScript("arguments[0].scrollIntoView();", driver.findElement(ORDER_BUTTON_DOWN));
    }

        // кликнуть по нижней кнопке "заказать"
    public void orderButtonDownClick () {
        driver.findElement(ORDER_BUTTON_DOWN).click();
    }

        // скролл до вопроса
    public void scrollToQuestion (By questionLocator) {
        ((JavascriptExecutor)driver)
            .executeScript("arguments[0].scrollIntoView();", driver.findElement(questionLocator));
    }

        // кликнуть по вопросу
    public void questionClick (By questionLocator) {
        driver.findElement(questionLocator).click();
    }

        // получить текст вопроса
    public String getQuestionText (By questionLocator) {
        return driver.findElement(questionLocator).getText();
    }

        // ожидание ответа на вопрос
    public void waitForAnswerIsVisible (By answerLocator) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(answerLocator));
    }

    // получить текст ответа
    public String getAnswerText (By answerLocator) {
        return driver.findElement(answerLocator).getText();
    }

}