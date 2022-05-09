package ru.vasyukov.StepsDefinition;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

public class JiraSteps {
    private Calculator calc;

    @Step("Входные данные {a} и {b}")
    @Дано("^Два числа ([^ ]+) и ([^ ]+)$")
    public void givenTwoNumber(double a, double b) {
        //System.out.println(a+" "+b);
        calc = new Calculator(a, b);
    }

    @Step("суммируем")
    @Когда("^Считаем сумму двух чисел")
    public void sumTwoNumber() { calc.sum(); }

    @Step("вычитаем")
    @Когда("^Считаем разность двух чисел")
    public void diffTwoNumber() { calc.diff(); }

    @Step("умножаем")
    @Когда("^Считаем произведение двух чисел")
    public void mulTwoNumber() { calc.mul(); }

    @Step("делим")
    @Когда("^Считаем деление двух чисел")
    public void divTwoNumber() { calc.div(); }

    @Step("Результат {result}")
    @Тогда("^Результат должен быть ([^ ]+)$")
    public void checkResult(double result) {
        Assertions.assertEquals(result, calc.getResult(), 0.00001,
                "Результат вычисления неправильный");
    }
}
