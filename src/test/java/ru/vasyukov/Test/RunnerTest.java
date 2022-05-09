package ru.vasyukov.Test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/ru.vasyukov/features",
        glue = {"ru.vasyukov.StepsDefinition", "ru.vasyukov.Hooks"}
)
public class RunnerTest {}
