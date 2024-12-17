import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ClientData {

    private WebDriver driver;

    // конструктор
    public ClientData(WebDriver driver) {
        this.driver=driver;
    }

    // инициализировали переменные-локаторы
    private By clientName = By.xpath("//input[@placeholder='* Имя']");
    private By clientSurname = By.xpath(".//input[@placeholder='* Фамилия']");
    private By clientAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private By metroStation = By.xpath(".//input[@placeholder='* Станция метро']");
    private By clientTelephoneNumber = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By nextStepButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее']");

    // подождать видимость элементов формы
    public void waitClientDataFormIsVisible () {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(clientName)));
    }

    // заполнить данными поле "имя"
    public void enterClientName (String name) {
        driver.findElement(clientName).sendKeys(name);
    }

    // заполнить данными поле "фамилия"
    public void enterClientSurname (String surname) {
        driver.findElement(clientSurname).sendKeys(surname);
    }

    // заполнить данными поле "адрес"
    public void enterClientAddress (String address) {
        driver.findElement(clientAddress).sendKeys(address);
    }

    // выбрать станцию
    public void chooseMetroStation (String station_name) {
        driver.findElement(metroStation).sendKeys(station_name);
        driver.findElement(By.xpath(".//div[@class='select-search__select']")).click();
    }

    // заполнить данными поле "телефон"
    public void enterClientTelephoneNumber (String telephoneNumber) {
        driver.findElement(clientTelephoneNumber).sendKeys(telephoneNumber);
    }

    // метод-шаг заполнения всей формы о клиенте
    public void addClientInfo (String name, String surname, String address, String station_name, String telephoneNumber) {
        enterClientName (name);
        enterClientSurname (surname);
        enterClientAddress (address);
        chooseMetroStation (station_name);
        enterClientTelephoneNumber (telephoneNumber);
    }

    // кликнуть по кнопке "далее"
    public void nextStepButtonClick () {
        driver.findElement(nextStepButton).click();
    }

}
