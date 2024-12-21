import org.junit.Before;
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
                {"Соник", "Ёжик", "Москва", "Беговая", "89222222222", "25.12.2024"},
                {"Марио", "Бразер", "Тында", "Спартак", "89111111111", "25.01.2026"},
        };
    }

    @Before
    public void creation () {
//        driver = new FirefoxDriver(); // драйвер для браузера Firefox
        driver = new ChromeDriver(); // драйвер для браузера Chrome
        driver.manage().window().maximize();
        // открываем страницу
        driver.get(MainLandingPage.URL_OF_MAIN_PAGE);
    }

    @Test // проверка сценария по входу через ВЕРХНЮЮ кнопку "заказать"
    public void testItIsPossibleToMakeAnOrderFromUpperOrderButton() {
        // экземпляры классов
        MainLandingPage objMainLandingPage = new MainLandingPage(driver);
        ClientDataPage client = new ClientDataPage(driver);
        AboutRentPage objAboutRentPage = new AboutRentPage(driver);

        // реализуем действия
        objMainLandingPage.cookieButtonClick();
        objMainLandingPage.orderButtonUpClick(); // кликнули по ВЕРХНЕЙ кнопке
        client.waitClientDataFormIsVisible();
        client.addClientInfo (name, surname, address, station_name, telephoneNumber);
        client.nextStepButtonClick();
        objAboutRentPage.waitAboutRentFormIsVisible();
        objAboutRentPage.addRentInfo(date, "привет, курьер");
        objAboutRentPage.orderButtonConfirmClick();
        objAboutRentPage.waitForConfirmationQuestion();
        objAboutRentPage.orderButtonConfirmFinalClick();
        objAboutRentPage.waitForConfirmationWindow(); // баг - невозможно оформить заказ в Chrome
    }

    @Test // проверка сценария по входу через НИЖНЮЮ кнопку "заказать"
    public void testItIsPossibleToMakeAnOrderFromLowerOrderButton() {
        // экземпляры классов
        MainLandingPage objMainLandingPage = new MainLandingPage(driver);
        ClientDataPage client = new ClientDataPage(driver);
        AboutRentPage objAboutRentPage = new AboutRentPage(driver);

        // реализуем действия
        objMainLandingPage.cookieButtonClick();
        objMainLandingPage.waitForLowerOrderButtonIsVisible();
        objMainLandingPage.scrollToOrderButtonDown(); // скролл до НИЖНЕЙ кнопки
        objMainLandingPage.orderButtonDownClick(); // клик по НИЖНЕЙ кнопке
        client.waitClientDataFormIsVisible();
        client.addClientInfo (name, surname, address, station_name, telephoneNumber);
        client.nextStepButtonClick();
        objAboutRentPage.waitAboutRentFormIsVisible();
        objAboutRentPage.addRentInfo(date, "привет, курьер");
        objAboutRentPage.orderButtonConfirmClick();
        objAboutRentPage.waitForConfirmationQuestion();
        objAboutRentPage.orderButtonConfirmFinalClick();
        objAboutRentPage.waitForConfirmationWindow(); // баг - невозможно оформить заказ в Chrome
    }

    // закрыли браузер
    @After
    public void teardown() {
        driver.quit();
    }

}