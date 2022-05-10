package ru.vasyukov.PageSteps;

import ru.vasyukov.PageObjects.SysDashboardElems;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;

public class SysDashboardSteps extends SysDashboardElems {
    public static void enteringProject(String projectFullName) {
        clickProjectsButton();
        clickItemTest(projectFullName);
        clickSideBarTasksButton();
    }

    @Step("Нажатие dropdown Проекты")
    public static void clickProjectsButton() {
        buttonProjects.shouldBe(exist, visible, enabled).click();
    }

    @Step("Нажатие item {projectFullName}")
    public static void clickItemTest(String projectFullName) {
        getItemProject(projectFullName).shouldBe(exist, visible, enabled).click();
    }

    @Step("Проверка наличия линка {projectName}")
    public static void assertLinkProjects(String projectName) {
        getLinkProject(projectName).shouldBe(exist, visible);
    }
}
