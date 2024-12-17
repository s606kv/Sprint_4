import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Test;
import org.junit.After;

@RunWith(Parameterized.class)
public class FullOrderScenarioTest {

    // переменные
    private WebDriver driver;
    private final String name;
    private final String surname;
    private final String address;
    private final String station_name;
    private final String telephoneNumber;
    private final String date;

    // конструктор
    public FullOrderScenarioTest
    (String name, String surname, String address, String station_name, String telephoneNumber, String date) {
        this.name=name;
        this.surname=surname;
        this.address=address;
        this.station_name=station_name;
        this.telephoneNumber=telephoneNumber;
        this.date=date;
    }

    // параметры
    @Parameterized.Parameters
    public static Object[][] clientInfo() {
        return new Object[][] {
                {"Соник", "Ёжик", "Москва", "Беговая", "89222222222", "20.12.2024"},
                {"Марио", "Бразер", "Тында", "Спартак", "89111111111", "20.01.2026"},
        };
    }

    @Test // проверка сценария по входу через ВЕРХНЮЮ кнопку "заказать"
    public void checkItIsPossibleToMakeAnOrderFromUpperOrderButton() {
        // driver = new FirefoxDriver(); // драйвер для браузера Firefox
        driver = new ChromeDriver(); // драйвер для браузера Chrome
        driver.manage().window().maximize();

        // открываем страницу
        String landingPage = "https://qa-scooter.praktikum-services.ru/";
        driver.get(landingPage);

        // экземпляры классов
        MainLandingPage objMainLandingPage = new MainLandingPage(driver);
        ClientData client = new ClientData(driver);
        AboutRent aboutRent = new AboutRent(driver);

        // реализуем действия
        objMainLandingPage.cookieButtonClick();
        objMainLandingPage.orderButtonUpClick(); // кликнули по ВЕРХНЕЙ кнопке
        client.waitClientDataFormIsVisible();
        client.addClientInfo (name, surname, address, station_name, telephoneNumber);
        client.nextStepButtonClick();
        aboutRent.waitAboutRentFormIsVisible();
        aboutRent.chooseDeliveryDate (date);
        aboutRent.chooseRentPeriod();
        aboutRent.checkboxColourBlackClick();
        aboutRent.addComment("привет. это тест.");
        aboutRent.orderButtonConfirmClick();
        aboutRent.waitForConfirmationQuestion();
        aboutRent.orderButtonConfirmFinalClick();
        aboutRent.waitForConfirmationWindow(); // баг - невозможно оформить заказ в Chrome
    }

    @Test // проверка сценария по входу через НИЖНЮЮ кнопку "заказать"
    public void checkItIsPossibleToMakeAnOrderFromLowerOrderButton() {
        // driver = new FirefoxDriver(); // драйвер для браузера Firefox
        driver = new ChromeDriver(); // драйвер для браузера Chrome
        driver.manage().window().maximize();

        // открываем страницу
        String landingPage = "https://qa-scooter.praktikum-services.ru/";
        driver.get(landingPage);

        // экземпляры классов
        MainLandingPage objMainLandingPage = new MainLandingPage(driver);
        ClientData client = new ClientData(driver);
        AboutRent aboutRent = new AboutRent(driver);

        // реализуем действия
        objMainLandingPage.cookieButtonClick();
        objMainLandingPage.waitForLowerOrderButtonIsVisible();
        objMainLandingPage.scrollToOrderButtonDown(); // скролл до НИЖНЕЙ кнопки
        objMainLandingPage.orderButtonDownClick(); // клик по НИЖНЕЙ кнопке
        client.waitClientDataFormIsVisible();
        client.addClientInfo (name, surname, address, station_name, telephoneNumber);
        client.nextStepButtonClick();
        aboutRent.waitAboutRentFormIsVisible();
        aboutRent.chooseDeliveryDate (date);
        aboutRent.chooseRentPeriod();
        aboutRent.checkboxColourBlackClick();
        aboutRent.addComment("привет. это тест.");
        aboutRent.orderButtonConfirmClick();
        aboutRent.waitForConfirmationQuestion();
        aboutRent.orderButtonConfirmFinalClick();
        aboutRent.waitForConfirmationWindow(); // баг - невозможно оформить заказ в Chrome
    }

    // закрыли браузер
    @After
    public void teardown() {
        driver.quit();
    }

}