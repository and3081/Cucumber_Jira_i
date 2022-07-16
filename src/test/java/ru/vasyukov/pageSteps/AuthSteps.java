package ru.vasyukov.pageSteps;

import ru.vasyukov.pageObjects.AuthElems;
import ru.vasyukov.custom.properties.TestData;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;

public class AuthSteps extends AuthElems {
    public static void auth() {
        assertAuthPage();
        inputAuthLogin();
        inputAuthPsw();
        clickAuthButton();
    }

    @Step("Проверка head блока логина страницы авторизации")
    public static void assertAuthPage() {
        headLogin.shouldBe(exist, visible);
    }

    @Step("Ввод login на странице авторизации")
    public static void inputAuthLogin() {
        fieldLogin.shouldBe(exist, visible, enabled).setValue(TestData.application.loginJira());  //System.getenv()
    }

    @Step("Ввод пароля на странице авторизации")
    public static void inputAuthPsw() {
        fieldPsw.shouldBe(exist, visible, enabled).setValue(TestData.application.passwordJira());
    }

    @Step("Нажатие кнопки Вход")
    public static void clickAuthButton() {
        buttonLogin.shouldBe(exist, visible, enabled).click();
    }

    @Step("Проверка наличия кнопки Проекты")
    public static void assertButtonProjects() {
        buttonProjects.shouldBe(exist, visible);
    }
}
