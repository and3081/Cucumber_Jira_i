package ru.vasyukov.Test;

import ru.vasyukov.PageObject.TasksElems;
import ru.vasyukov.PageSteps.*;

import static ru.vasyukov.PageObject.BaseElems.clickSideBarTaskListButton;

public class Tests {
//
//    public void TestTaskInProject(String projectFullName, String taskName) {
//        AuthSteps.auth();
//        SysDashboardSteps.clickProjectsButton();
//        SysDashboardSteps.clickItemTest(projectFullName);
//        clickSideBarTaskListButton();
//        TaskListSteps.searchTask(taskName);
//        TaskListSteps.assertAndClickGoalTask(taskName);
//        TaskListSteps.assertHeadTaskDetail();
//        System.out.println("Статус задачи " +taskName +": " + TaskListSteps.getGoalTaskStatus());
//        System.out.println("Версия задачи " +taskName +": " + TaskListSteps.getGoalTaskVersion());
//    }
//
//    public void TestCreateTask(String projectFullName, String projectName,
//                               String themeTask, String typeTask, String version,
//                               String statDo, String statInWork, String statDone) {
//        AuthSteps.auth();
//        SysDashboardSteps.enteringProject(projectFullName, projectName);
//        TasksSteps.assertHeadOpenTasks();
//        TasksSteps.clickTaskCreateButton();
//        TasksSteps.clickTaskCreateOpenDialogButton();
//
//        TestCreateSteps.CreateTask(themeTask, typeTask, version);
//        TasksSteps.assertTaskCreated(themeTask);
//        TasksSteps.assertMyTaskStatus(statDo);
//        System.out.println("Статус моей задачи: " + TasksElems.getStatusMyTask());
//
//        TasksSteps.clickStatusInWorkButton();
//        TasksSteps.assertMyTaskStatus(statInWork);
//        System.out.println("Статус моей задачи: " + TasksElems.getStatusMyTask());
//
//        TasksSteps.clickStatusProcessButton();
//        TasksSteps.clickStatusDoneButton();
//        TasksSteps.assertMyTaskStatus(statDone);
//        System.out.println("Статус моей задачи: " + TasksElems.getStatusMyTask());
//    }
}
