package com.geo.test.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features/user_register.feature"},
        plugin = {"pretty"},
        glue = {"com.geo.test"},
        tags = "@SmokeTest1",
        dryRun = false)

public class GEORunner {

}