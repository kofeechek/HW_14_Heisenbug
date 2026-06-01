package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.logevents.SelenideLogger.step;

@Feature("Heisenbug Issue")
@Story("Главная страница Heisenbug")
@Tag("Test")
@Owner("SvetlitskayaTS")
public class MainPageTests extends TestBase {


    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка кнопки 'Купить билет'")
    void buyTicketButtonTest() {
        step("Открываем главную странницу Heisenbug", () -> {
            mainPage.openPage();
        });
        step("Кликаем по кнопке 'Купить билет'", () -> {
            mainPage.clickBuyButton();
        });

        step("Проверяем открытие модального окна выбора билетов", () -> {
            mainPage.chooseTicketModalWindowCheck(testData.chooseTicketTitle);
        });
    }


    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка кнопки 'Получать апдейты'")
    void updatesReceiveButtonTest() {
        step("Открываем главную странницу Heisenbug", () -> {
            mainPage.openPage();
        });
        step("Кликаем по кнопке 'Получать апдейты'", () -> {
            mainPage.clickGetUpdatesButton();
        });

        step("Проверяем открытие модального окна подписки на апдейты", () -> {
            mainPage.getUpdatesModalWindowCheck(testData.getUpdatesByEmailTitle);
        });
    }


    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка ссылки 'Стать партнером'")
    void toBeAPartnerLinkTest() {
        step("Открываем главную странницу Heisenbug", () -> {
            mainPage.openPage();
        });
        step("Кликаем по ссылке 'Стать партнером'", () -> {
            mainPage.clickToBeAPartnerLink();
        });
        step("Проверяем открытие модального окна заявки на партнерство", () -> {
            mainPage.toBeAPartnerModalWindowCheck(testData.toBeAPartnerTitle);
        });
    }


    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка переключателя языка страницы")
    void changeLanguageButtonTest() {
        step("Открываем главную странницу Heisenbug", () -> {
            mainPage.openPage();
        });
        step("Кликаем по переключателю языка на английский", () -> {
            mainPage.clickLanguageSwitcher();
        });
        step("Проверяем, что главная страница отображается на английском", () -> {
            mainPage.mainPageSwitchedToEnglishCheck(testData.englishMainPageTitle);
        });

    }


    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка кнопки поиска")
    void searchButtonTest() {
        step("Открываем главную странницу Heisenbug", () -> {
            mainPage.openPage();
        });
        step("Кликаем по кнопке поиска", () -> {
            mainPage.clickSearchButton();
        });
        step("Проверяем открытие модального окна поиска", () -> {
            mainPage.searchButtonAtModalWindowCheck(testData.searchButtonAtModalWindowText);
        });

    }

}
