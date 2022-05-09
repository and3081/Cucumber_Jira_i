package ru.vasyukov.StepsDefinition;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import ru.vasyukov.Test.Tests;

public class JiraSteps extends Tests {
    @Когда("^Авторизуемся")
    public void auth() { TestLogin(); }
}
