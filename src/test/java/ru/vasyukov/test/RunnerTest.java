package ru.vasyukov.test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/ru.vasyukov/features",
        glue = {"ru.vasyukov.stepDefinitions", "ru.vasyukov.hooks"},
        plugin={"pretty"},
        tags = "@AllTests"
)
public class RunnerTest {}
