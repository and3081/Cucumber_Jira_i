package ru.vasyukov.StepsDefinition;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import ru.vasyukov.PageSteps.AuthSteps;
import ru.vasyukov.PageSteps.SysDashboardSteps;
import ru.vasyukov.PageSteps.TaskListSteps;
import ru.vasyukov.Test.Tests;

import java.util.List;

import static ru.vasyukov.PageObject.BaseElems.clickSideBarTaskListButton;

public class JiraSteps extends Tests {
    @Когда("^Авторизуемся")
    public void auth() { AuthSteps.auth(); }

    @Тогда("^Появляется кнопка 'Проекты'")
    public void checkAuthPass() { AuthSteps.assertButtonProjects(); }

    @Когда("^Открываем проект")
    public void openProject(List<String> projectFullName) {
        SysDashboardSteps.enteringProject(projectFullName.get(0));
    }

    @Тогда("^Появляется название-линк открытого проекта")
    public void checkTitleProject(List<String> projectName) {
        SysDashboardSteps.assertLinkProjects(projectName.get(0));
    }

    @И("^Открываем список задач")
    public void openTaskList() { clickSideBarTaskListButton(); }

    @Тогда("^Проверяем количество открытых задач в проекте")
    public void getTaskCount() { TaskListSteps.assertTaskCount(); }
}
