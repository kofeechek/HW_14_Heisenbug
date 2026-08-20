package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Feature("Heisenbug Issue")
@Story("Главная страница Heisenbug")
@Tag("Test")
@Owner("SvetlitskayaTS")
public class MainPageTests extends TestBase {


    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка кнопки 'Купить билет'")
    void buyTicketButtonTest() {
        mainPage.openPage()
                .clickBuyButton()

                .chooseTicketModalWindowCheck(testData.chooseTicketTitle);
    }

    @Disabled
    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка кнопки 'Получать апдейты'")
    void updatesReceiveButtonTest() {
        mainPage.openPage()
                .clickGetUpdatesButton()

                .getUpdatesModalWindowCheck(testData.getUpdatesByEmailTitle);
    }

    @Disabled
    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка ссылки 'Стать партнером'")
    void toBeAPartnerLinkTest() {
        mainPage.openPage()
                .clickToBeAPartnerLink()

                .toBeAPartnerModalWindowCheck(testData.toBeAPartnerTitle);
    }


    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка переключателя языка страницы")
    void changeLanguageButtonTest() {
        mainPage.openPage()
                .clickLanguageSwitcher()

                .mainPageSwitchedToEnglishCheck(testData.englishMainPageTitle);
    }


    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка кнопки поиска")
    void searchButtonTest() {
        mainPage.openPage()
                .clickSearchButton()
                .searchButtonAtModalWindowCheck(testData.searchButtonAtModalWindowText);
    }

}
