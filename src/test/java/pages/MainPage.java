package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

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
    public MainPage openPage() {
        open("/");
        $(".HomeHero-module-scss-module__WkJq2G__homeHero__logo").shouldHave(Condition.attribute("alt", "Heisenbug 2026 Autumn"));

        return this;
    }

    public MainPage clickBuyButton() {
        buyButton.click();

        return this;
    }

    public MainPage chooseTicketModalWindowCheck(String value) {
        chooseTicketTitle.shouldHave(text(value));

        return this;
    }

    public MainPage clickGetUpdatesButton() {
        getUpdatesButton.click();

        return this;
    }

    public MainPage getUpdatesModalWindowCheck(String value) {
        String actual = executeJavaScript("return arguments[0].innerText;", getUpdatesByEmailTitle);
        assert actual.contains(value);

        return this;
    }

    public MainPage clickToBeAPartnerLink() {
        executeJavaScript("arguments[0].click();", toBeAPartnerLink);

        return this;
    }

    public MainPage toBeAPartnerModalWindowCheck(String value) {
        toBeAPartnerTitle.shouldHave(text(value));

        return this;
    }

    public MainPage clickLanguageSwitcher() {
        executeJavaScript("arguments[0].click();", languageSwitcher);

        return this;
    }

    public MainPage mainPageSwitchedToEnglishCheck(String value) {
        englishMainPageTitle.shouldHave(text(value));

        return this;
    }

    public MainPage clickSearchButton() {
        executeJavaScript("arguments[0].click();", searchButton);

        return this;
    }

    public MainPage searchButtonAtModalWindowCheck(String value) {
        searchButtonAtModalWindow.shouldHave(Condition.text(value));

        return this;
    }

}
