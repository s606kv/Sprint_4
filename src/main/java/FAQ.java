import org.openqa.selenium.By;

public class FAQ {
        // Локаторы вопросов 1-8
    public static final By QUESTION_ABOUT_PRICE = By.id("accordion__heading-0");
    public static final By QUESTION_ABOUT_QUANTITY = By.id("accordion__heading-1");
    public static final By QUESTION_ABOUT_RENT_TIME = By.id("accordion__heading-2");
    public static final By QUESTION_ABOUT_TODAY_RENT = By.id("accordion__heading-3");
    public static final By QUESTION_ABOUT_RETURNING = By.id("accordion__heading-4");
    public static final By QUESTION_ABOUT_CHARGER = By.id("accordion__heading-5");
    public static final By QUESTION_ABOUT_CANCEL_ORDER = By.id("accordion__heading-6");
    public static final By QUESTION_ABOUT_MKAD = By.id("accordion__heading-7");
        // Локаторы ответов 1-8
    public static final By ANSWER_ABOUT_PRICE = By.xpath(".//div[@id='accordion__panel-0']/p");
    public static final By ANSWER_ABOUT_QUANTITY = By.xpath(".//div[@id='accordion__panel-1']/p");
    public static final By ANSWER_ABOUT_RENT_TIME = By.xpath(".//div[@id='accordion__panel-2']/p");
    public static final By ANSWER_ABOUT_TODAY_RENT = By.xpath(".//div[@id='accordion__panel-3']/p");
    public static final By ANSWER_ABOUT_RETURNING = By.xpath(".//div[@id='accordion__panel-4']/p");
    public static final By ANSWER_ABOUT_CHARGER = By.xpath(".//div[@id='accordion__panel-5']/p");
    public static final By ANSWER_ABOUT_CANCEL_ORDER = By.xpath(".//div[@id='accordion__panel-6']/p");
    public static final By ANSWER_ABOUT_MKAD = By.xpath(".//div[@id='accordion__panel-7']/p");
        // Текст вопросов 1-8
    public static final String QUESTION_ABOUT_PRICE_TEXT = "Сколько это стоит? И как оплатить?";
    public static final String QUESTION_ABOUT_QUANTITY_TEXT = "Хочу сразу несколько самокатов! Так можно?";
    public static final String QUESTION_ABOUT_RENT_TIME_TEXT = "Как рассчитывается время аренды?";
    public static final String QUESTION_ABOUT_TODAY_RENT_TEXT = "Можно ли заказать самокат прямо на сегодня?";
    public static final String QUESTION_ABOUT_RETURNING_TEXT = "Можно ли продлить заказ или вернуть самокат раньше?";
    public static final String QUESTION_ABOUT_CHARGER_TEXT = "Вы привозите зарядку вместе с самокатом?";
    public static final String QUESTION_ABOUT_CANCEL_ORDER_TEXT = "Можно ли отменить заказ?";
    public static final String QUESTION_ABOUT_MKAD_TEXT = "Я жизу за МКАДом, привезёте?";
        // Текст ответов 1-8
    public static final String ANSWER_ABOUT_PRICE_TEXT = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public static final String ANSWER_ABOUT_QUANTITY_TEXT = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public static final String ANSWER_ABOUT_RENT_TIME_TEXT = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public static final String ANSWER_ABOUT_TODAY_RENT_TEXT = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public static final String ANSWER_ABOUT_RETURNING_TEXT = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public static final String ANSWER_ABOUT_CHARGER_TEXT = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public static final String ANSWER_ABOUT_CANCEL_ORDER_TEXT = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    public static final String ANSWER_ABOUT_MKAD_TEXT = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
}
