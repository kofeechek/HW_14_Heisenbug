package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    // Elements
    private SelenideElement buyButton = $x("//button[text()='Купить билет']");
    private SelenideElement chooseTicketTitle = $x("//*[text()='Выбрать билет']");
    private SelenideElement getUpdatesButton = $x("//button[text()='Получать апдейты']");
    private SelenideElement getUpdatesByEmailTitle = $x("//h3[text()='Heisenbug в\u00A0email']");
    private SelenideElement toBeAPartnerLink = $x("//button[text()='Стать партнером']");
    private SelenideElement toBeAPartnerTitle = $x("//h2[text()='Стать партнером']");
    private SelenideElement languageSwitcher = $x("//a[@href='/en/']");
    private SelenideElement englishMainPageTitle = $(".HomeHero-module-scss-module__WkJq2G__homeHero__description");
    private SelenideElement searchButton = $("button[aria-label='Поиск']");
    private SelenideElement searchButtonAtModalWindow = $(".SearchForm-module-scss-module__KtHGZG__searchForm__submit");


    // Actions
    @Step("Открываем Главную страницу Heisenbug")
    public MainPage openPage() {
        open("/");
        $(".HomeHero-module-scss-module__WkJq2G__homeHero__logo").shouldHave(Condition.attribute("alt", "Heisenbug 2026 Autumn"));

        return this;
    }

    @Step("Кликаем по кнопке 'Купить билет'")
    public MainPage clickBuyButton() {
        buyButton.click();

        return this;
    }

    @Step("Проверяем открытие модального окна подписки на апдейты")
    public MainPage chooseTicketModalWindowCheck(String value) {
        chooseTicketTitle.shouldHave(text(value));

        return this;
    }

    @Step("Кликаем по кнопке 'Получать апдейты'")
    public MainPage clickGetUpdatesButton() {
        getUpdatesButton.click();

        return this;
    }

    @Step("Проверяем открытие модального окна подписки на апдейты")
    public MainPage getUpdatesModalWindowCheck(String value) {
        String actual = executeJavaScript("return arguments[0].innerText;", getUpdatesByEmailTitle);
        assert actual.contains(value);

        return this;
    }

    @Step("Кликаем по ссылке 'Стать партнером'")
    public MainPage clickToBeAPartnerLink() {
        executeJavaScript("arguments[0].click();", toBeAPartnerLink);

        return this;
    }

    public MainPage toBeAPartnerModalWindowCheck(String value) {
        toBeAPartnerTitle.shouldHave(text(value));

        return this;
    }

    @Step("Проверяем открытие модального окна заявки на партнерство")
    public MainPage clickLanguageSwitcher() {
        executeJavaScript("arguments[0].click();", languageSwitcher);

        return this;
    }

    @Step("Проверяем, что главная страница отображается на английском")
    public MainPage mainPageSwitchedToEnglishCheck(String value) {
        englishMainPageTitle.shouldHave(text(value));

        return this;
    }

    @Step("Кликаем по кнопке поиска")
    public MainPage clickSearchButton() {
        executeJavaScript("arguments[0].click();", searchButton);

        return this;
    }

    @Step("Проверяем открытие модального окна поиска")
    public MainPage searchButtonAtModalWindowCheck(String value) {
        searchButtonAtModalWindow.shouldHave(Condition.text(value));

        return this;
    }

}
