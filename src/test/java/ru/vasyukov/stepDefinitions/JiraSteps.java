package ru.vasyukov.stepDefinitions;

import io.cucumber.java.ru.*;
import ru.vasyukov.pageSteps.*;

import java.util.List;

import static ru.vasyukov.pageObjects.BaseElems.clickSideBarTaskListButton;

public class JiraSteps {
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

    @Затем("^Открываем список задач")
    public void openTaskList() { clickSideBarTaskListButton(); }

    @Тогда("^Проверяем количество открытых задач в проекте")
    public void getTaskCount() { TaskListSteps.assertTaskCount(); }

    @Когда("^Ищем и открываем задачу в проекте")
    public void searchTaskInProject(List<String> names) {
        SysDashboardSteps.clickProjectsButton();
        SysDashboardSteps.clickItemTest(names.get(0));
        clickSideBarTaskListButton();
        TaskListSteps.searchTask(names.get(1));
        TaskListSteps.assertAndClickGoalTask(names.get(1));
    }

    @Тогда("^Проверяем статус и версию задачи")
    public void getTaskDetail() { TaskListSteps.assertHeadTaskDetail(); }

    @И("^Появляется название раздела 'Открытые задачи'")
    public void checkChapterHead() { TasksSteps.assertHeadOpenTasks(); }

    @Затем("^Создаем новую задачу")
    public void createNewTask(List<String> fields) {
        TasksSteps.clickTaskCreateButton();
        TasksSteps.clickTaskCreateOpenDialogButton();
        TestCreateSteps.CreateTask(fields.get(0), fields.get(1), fields.get(2));
    }

    @Тогда("^Появляется созданная задача")
    public void checkCreatedTask(List<String> fields) { TasksSteps.assertTaskCreated(fields.get(0)); }

    @И("^Запрашиваем текущий статус задачи")
    public void checkTaskStatus(List<String> status) { TasksSteps.assertMyTaskStatus(status.get(0)); }

    @Затем("^Изменяем статус задаче В РАБОТЕ")
    public void changeStatusInWork() { TasksSteps.clickStatusInWorkButton(); }

    @Затем("^Изменяем статус задаче ГОТОВО")
    public void changeStatusDone() {
        TasksSteps.clickStatusProcessButton();
        TasksSteps.clickStatusDoneButton();
    }
}
