package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    // Elements — contains()/css*= so hashed CSS modules and &nbsp; do not flake
    private SelenideElement buyButton = $("div[class*='homeHero__links'] button");
    private SelenideElement chooseTicketTitle = $x("//*[contains(text(), 'Выбрать билет')]");
    private SelenideElement getUpdatesButton = $("#subscription-home-banner-submit");
    private SelenideElement getUpdatesByEmailTitle = $x("//h3[contains(., 'email')]");
    private SelenideElement toBeAPartnerLink = $x("//button[contains(., 'Оставить запрос')]");
    private SelenideElement toBeAPartnerTitle = $x("//h2[contains(., 'Стать партнером')]");
    private SelenideElement languageSwitcher = $("a[href='/en/']");
    private SelenideElement englishMainPageTitle = $("p[class*='homeHero__description']");
    private SelenideElement searchButton = $("button[aria-label='Поиск']");
    private SelenideElement searchButtonAtModalWindow = $x("//button[contains(., 'Найти')]");
    private SelenideElement heroLogo = $("img[alt='Heisenbug 2026 Autumn']");


    // Actions
    @Step("Открываем Главную страницу Heisenbug")
    public MainPage openPage() {
        open("/");
        heroLogo.shouldBe(visible);

        return this;
    }

    @Step("Кликаем по кнопке 'Купить билет'")
    public MainPage clickBuyButton() {
        buyButton.click();

        return this;
    }

    @Step("Проверяем открытие модального окна выбора билета")
    public MainPage chooseTicketModalWindowCheck(String value) {
        chooseTicketTitle.shouldHave(text(value));

        return this;
    }

    @Step("Скроллим к блоку подписки и проверяем кнопку 'Подписаться'")
    public MainPage clickGetUpdatesButton() {
        executeJavaScript("arguments[0].scrollIntoView({block: 'center'});", getUpdatesButton);
        getUpdatesButton.shouldBe(visible);

        return this;
    }

    @Step("Проверяем заголовок подписки на email")
    public MainPage getUpdatesModalWindowCheck(String value) {
        getUpdatesByEmailTitle.shouldHave(text(value));

        return this;
    }

    @Step("Кликаем по кнопке 'Оставить запрос' в блоке партнерства")
    public MainPage clickToBeAPartnerLink() {
        executeJavaScript("arguments[0].click();", toBeAPartnerLink);

        return this;
    }

    public MainPage toBeAPartnerModalWindowCheck(String value) {
        toBeAPartnerTitle.shouldHave(text(value));

        return this;
    }

    @Step("Переключаем язык страницы на английский")
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
