package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


    @Epic("Heisenbug UI")
    @Feature("Ручное тестирование")
    @Story("Проверки, выполняемые вручную")
    @Tag("manual")
    public class ManualUiTests {

        @Test
        @Owner("tsvetlitskaya")
        @Severity(SeverityLevel.CRITICAL)
        @DisplayName("Регитрация пользователя, новый пользователь")
        @Description("""
            Предусловия: открыт сайт https://heisenbug.ru/
            Шаги:
            1. Перейти в раздел "Логин" https://my.jugru.org/oauth/login
            2. Перейти во вкладку "Создать Личный кабинет"
            3. Ввести e-mail, которого нет в системе
            4. Нажать кнопку "Создать"
            5. Перейти в e-mail почту, в полученном письме нажать кнопку "Подтвердить"  
            Ожидаемый результат: В новой вкладке открыта страница https://my.jugru.org/tickets, пользователь авторизован,
            вверху экрана отображается e-mail, под которым проходила регистрация  
            """)
        void newUserRegistrationManually() {
        }

        @Test
        @Owner("tsvetlitskaya")
        @Severity(SeverityLevel.NORMAL)
        @DisplayName("Регистрация. Ввод e-mail существующего пользователя")
        @Description("""
            Предусловия: открыт сайт https://heisenbug.ru/
            Шаги:
            1. Перейти в раздел "Логин" https://my.jugru.org/oauth/login
            2. Перейти во вкладку "Создать Личный кабинет"
            3. Ввести e-mail, который уже зарегистрирован в системе
            4. Нажать кнопку "Создать"
            5. Перейти в e-mail почту, в полученном письме нажать кнопку "Войти"  
            Ожидаемый результат: В новой вкладке открыта страница https://my.jugru.org/tickets, пользователь авторизован,
            вверху экрана отображается e-mail, под которым проходила регистрация
            """)
        void existUserRegistrationManually() {
        }

        @Test
        @Owner("tsvetlitskaya")
        @Severity(SeverityLevel.NORMAL)
        @DisplayName("Регистрация, ввод невалидного значения")
        @Description("""
            Предусловия: открыт сайт https://heisenbug.ru/
            Шаги:
            1. Перейти в раздел "Логин" https://my.jugru.org/oauth/login
            2. Перейти во вкладку "Создать Личный кабинет"
            3. Ввести значение, состоящее из букв кириллицы
            Ожидаемый результат: Поле ввода подсвечено красным, сообщение "Пока что недостаточно данных для логина",
            кнопка "Получить код на телефон" неактивна
            """)
        void wrongUserRegistrationDataManually() {
        }
    }



