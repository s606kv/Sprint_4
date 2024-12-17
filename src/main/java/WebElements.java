public class WebElements {

        /*

        Главная страница:
        - Вопрос_Текст "Сколько это стоит? И как оплатить?" → questionHowMatch = By.id("accordion__heading-0");
        - Ответ_Текст "Сутки — 400 рублей..." → answerPrice = By.id("accordion__panel-0");
        - Кнопка ЗАКАЗАТЬ_верх → orderButtonUp = By.className("Button_Button__ra12g");
        - Кнопка ЗАКАЗАТЬ_низ → orderButtonDown = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
        - Кнопка про куки - cookieButton = By.id("rcc-confirm-button");

        Форма заказа "Для кого самокат":
        - Поле "Имя" → clientName = By.xpath("//input[@placeholder='* Имя']");
        - Поле "Фамилия" → clientSurname = By.xpath(".//input[@placeholder='* Фамилия']");
        - Поле "Адрес" → clientAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
        - Поле "Станция метро" → metroStation = By.xpath(".//input[@placeholder='* Станция метро']");
        - Поле "Телефон" → clientTelephoneNumber = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
        - Кнопка ДАЛЕЕ → nextStepButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее']");

        Форма заказа "Про аренду":
        - Заголовок формы "Про аренду" → aboutRentHeader = By.className("Order_Header__BZXOb");
        - Поле "Когда привезти" → deliveryDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
        - Поле "Срок аренды" → rentPeriodDropdown = By.className("Dropdown-placeholder");
        - Выбранный срок 3 суток → rentFor3Days = By.xpath(".//div[text() = 'трое суток']");
        - Чек-бокс "Черный жемчуг" → checkboxColourBlack = By.id("black");
        - Поле "Комментарий" → comment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
        - Кнопка ЗАКАЗАТЬ → orderButtonConfirm = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");

        Попап "Хотите оформить заказ?":
        - Кнопка ДА → orderButtonConfirmFinal = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");

        Попап "Заказ оформлен":
        - Текст об успешном заказе → orderConfirmedHeader = By.xpath(".//div[text()='Заказ оформлен']");

        */

}
