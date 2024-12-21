import org.openqa.selenium.By;

public class FAQ {
        // Локаторы вопросов 1-8
    public static final By QUESTION_1_LOCATOR = By.id("accordion__heading-0");
    public static final By QUESTION_2_LOCATOR = By.id("accordion__heading-1");
    public static final By QUESTION_3_LOCATOR = By.id("accordion__heading-2");
    public static final By QUESTION_4_LOCATOR = By.id("accordion__heading-3");
    public static final By QUESTION_5_LOCATOR = By.id("accordion__heading-4");
    public static final By QUESTION_6_LOCATOR = By.id("accordion__heading-5");
    public static final By QUESTION_7_LOCATOR = By.id("accordion__heading-6");
    public static final By QUESTION_8_LOCATOR = By.id("accordion__heading-7");
        // Локаторы ответов 1-8
    public static final By ANSWER_1_LOCATOR = By.xpath(".//div[@id='accordion__panel-0']/p");
    public static final By ANSWER_2_LOCATOR = By.xpath(".//div[@id='accordion__panel-1']/p");
    public static final By ANSWER_3_LOCATOR = By.xpath(".//div[@id='accordion__panel-2']/p");
    public static final By ANSWER_4_LOCATOR = By.xpath(".//div[@id='accordion__panel-3']/p");
    public static final By ANSWER_5_LOCATOR = By.xpath(".//div[@id='accordion__panel-4']/p");
    public static final By ANSWER_6_LOCATOR = By.xpath(".//div[@id='accordion__panel-5']/p");
    public static final By ANSWER_7_LOCATOR = By.xpath(".//div[@id='accordion__panel-6']/p");
    public static final By ANSWER_8_LOCATOR = By.xpath(".//div[@id='accordion__panel-7']/p");
        // Текст вопросов 1-8
    public static final String QUESTION_1_TEXT = "Сколько это стоит? И как оплатить?";
    public static final String QUESTION_2_TEXT = "Хочу сразу несколько самокатов! Так можно?";
    public static final String QUESTION_3_TEXT = "Как рассчитывается время аренды?";
    public static final String QUESTION_4_TEXT = "Можно ли заказать самокат прямо на сегодня?";
    public static final String QUESTION_5_TEXT = "Можно ли продлить заказ или вернуть самокат раньше?";
    public static final String QUESTION_6_TEXT = "Вы привозите зарядку вместе с самокатом?";
    public static final String QUESTION_7_TEXT = "Можно ли отменить заказ?";
    public static final String QUESTION_8_TEXT = "Я жизу за МКАДом, привезёте?";
        // Текст ответов 1-8
    public static final String ANSWER_1_TEXT = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public static final String ANSWER_2_TEXT = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public static final String ANSWER_3_TEXT = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public static final String ANSWER_4_TEXT = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public static final String ANSWER_5_TEXT = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public static final String ANSWER_6_TEXT = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public static final String ANSWER_7_TEXT = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    public static final String ANSWER_8_TEXT = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
}
