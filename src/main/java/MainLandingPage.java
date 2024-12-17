import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainLandingPage {

    private WebDriver driver;

    // инициализировали переменные-локаторы
    private By scooterLogo = By.className("Header_LogoScooter__3lsAR");
    private By questionHowMatch = By.id("accordion__heading-0");
    private By answerPrice = By.id("accordion__panel-0");
    private By orderButtonUp = By.className("Button_Button__ra12g");
    private By orderButtonDown = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    private By cookieButton = By.id("rcc-confirm-button");

    // конструктор
    public MainLandingPage(WebDriver driver) {
        this.driver=driver;
    }

    // кликнуть на кнопку с куками
    public void cookieButtonClick () {
        driver.findElement(cookieButton).click();
    }

    // кликнуть по верхней кнопке "заказать"
    public void orderButtonUpClick () {
        driver.findElement(orderButtonUp).click();
    }

    // ожидание появления нижней кнопки
    public void waitForLowerOrderButtonIsVisible () {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(orderButtonDown));
    }

    // скролл до нижней кнопки "заказать"
    public void scrollToOrderButtonDown () {
        ((JavascriptExecutor)driver)
            .executeScript("arguments[0].scrollIntoView();", driver.findElement(orderButtonDown));
    }

    // кликнуть по нижней кнопке "заказать"
    public void orderButtonDownClick () {
        driver.findElement(orderButtonDown).click();
    }

    // скролл до блока с вопросами
    public void scrollToQuestionHowMatch () {
        ((JavascriptExecutor)driver)
            .executeScript("arguments[0].scrollIntoView();", driver.findElement(questionHowMatch));
    }

    // кликнуть по вопросу "сколько стоит"
    public void questionHowMatchClick () {
        driver.findElement(questionHowMatch).click();
    }

    // ожидание отображение ответа на вопрос "сколько стоит"
    public void waitForAnswerIsVisible () {
        new WebDriverWait(driver, Duration.ofSeconds(1))
            .until(ExpectedConditions.visibilityOf(driver.findElement(answerPrice)));
    }

    // получение текста ответа на вопрос "сколько стоит"
    public String getAnswerPriceText () {
        return driver.findElement(answerPrice).getText();
    }

}