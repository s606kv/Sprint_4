import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ClientDataPage {

    private WebDriver driver;

        // конструктор
    public ClientDataPage(WebDriver driver) {
        this.driver=driver;
    }

        //Поле "Имя"
    private By clientName = By.xpath("//input[@placeholder='* Имя']");
        // Поле "Фамилия"
    private By clientSurname = By.xpath(".//input[@placeholder='* Фамилия']");
        // Поле "Адрес"
    private By clientAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
        // Поле "Станция метро"
    private By metroStation = By.xpath(".//input[@placeholder='* Станция метро']");
        // Выпадающий список станций метро
    private By metroStationDropdown = By.xpath(".//div[@class='select-search__select']");
        // Поле "Телефон"
    private By clientTelephoneNumber = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
        // Кнопка "Далее"
    private By nextStepButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее']");

        // подождать видимость элементов формы
    public void waitClientDataFormIsVisible () {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(clientName)));
    }

        // заполнить данными поле "Имя"
    public void enterClientName (String name) {
        driver.findElement(clientName).sendKeys(name);
    }

        // заполнить данными поле "Фамилия"
    public void enterClientSurname (String surname) {
        driver.findElement(clientSurname).sendKeys(surname);
    }

        // заполнить данными поле "Адрес"
    public void enterClientAddress (String address) {
        driver.findElement(clientAddress).sendKeys(address);
    }

        // выбрать станцию
    public void chooseMetroStation (String station_name) {
        driver.findElement(metroStation).sendKeys(station_name);
        driver.findElement(metroStationDropdown).click();
    }

        // заполнить данными поле "Телефон"
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

        // кликнуть по кнопке "Далее"
    public void nextStepButtonClick () {
        driver.findElement(nextStepButton).click();
    }

}