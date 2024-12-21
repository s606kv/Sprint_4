import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AboutRentPage {

    private WebDriver driver;

        // конструктор
    public AboutRentPage(WebDriver driver) {
        this.driver = driver;
    }

        // Заголовок формы "Про аренду"
    private By aboutRentHeader = By.className("Order_Header__BZXOb");
        // Поле "Когда привезти"
    private By deliveryDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
        // Поле "Срок аренды"
    private By rentPeriodDropdown = By.className("Dropdown-placeholder");
        // Выбранный срок 3 суток
    private By rentFor3Days = By.xpath(".//div[text() = 'трое суток']");
        // Чек-бокс "Черный жемчуг"
    private By checkboxColourBlack = By.id("black");
        // Поле "Комментарий"
    private By comment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
        // Кнопка "Заказать"
    private By orderButtonConfirm = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
        //Кнопка "Да"
    private By orderButtonConfirmFinal = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
        // Попап "Заказ оформлен"
    private By orderConfirmedHeader = By.xpath(".//div[text()='Заказ оформлен']");

        // подождать видимость элементов формы
    public void waitAboutRentFormIsVisible () {
        new WebDriverWait(driver, Duration.ofSeconds(3)).
                until(ExpectedConditions.visibilityOf(driver.findElement(deliveryDate)));
    }

        // указать дату доставки
    public void chooseDeliveryDate (String date) {
        driver.findElement(deliveryDate).click();
        driver.findElement(deliveryDate).sendKeys(date);
        driver.findElement(aboutRentHeader).click();
    }

        // выбрать срок аренды
    public void chooseRentPeriod () {
        driver.findElement(rentPeriodDropdown).click();
        driver.findElement(rentFor3Days).click();
    }

        // поставить чек-бокс на черном цвете
    public void checkboxColourBlackClick () {
        driver.findElement(checkboxColourBlack).click();
    }

        // добавить комментарий
    public void addComment (String commentText) {
        driver.findElement(comment).sendKeys(commentText);
    }

        // метод-шаг заполнения всей формы деталей аренды
    public void addRentInfo (String date, String commentText) {
        chooseDeliveryDate (date);
        chooseRentPeriod ();
        checkboxColourBlackClick();
        addComment(commentText);
    }

        // кликнуть кнопку "заказать"
    public void orderButtonConfirmClick () {
        driver.findElement(orderButtonConfirm).click();
    }

        // дождаться появления окна с вопросом о подтверждении
    public void waitForConfirmationQuestion () {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(orderButtonConfirmFinal)));
    }

        // клик по кнопке подтверждения
    public void orderButtonConfirmFinalClick () {
        driver.findElement(orderButtonConfirmFinal).click();
    }

        // ждем окно с подтверждением заказа
    public void waitForConfirmationWindow () {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(orderConfirmedHeader)));
    }

}