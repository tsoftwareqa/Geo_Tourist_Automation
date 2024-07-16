package com.geo.test.tasks.ui.common;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.core.di.SerenityInfrastructure;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.util.EnvironmentVariables;

import static com.geo.test.page_objects.HomePage.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

import com.geo.test.questions.ui.Landing;
import com.geo.test.utils.CommonUtil;

public class Login implements Task {

    private EnvironmentVariables environmentVariables;

    private String username;

    private String pwd;

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.wasAbleTo(NavigateTo.theLoginPage());

        actor.attemptsTo(
        		WaitUntil.the(LOGIN_LINK, isClickable()).forNoMoreThan(5).seconds(),
        		Click.on(LOGIN_LINK),
                WaitUntil.the(USERNAME, isClickable()).forNoMoreThan(5).seconds(),
                Enter.theValue(username).into(USERNAME),
                Enter.theValue(pwd).into(PASSWORD),
                WaitUntil.the(LOGIN_BTN, isClickable()),
                Click.on(LOGIN_BTN)
        );
               
        CommonUtil.staticWaitFor(1500L);         
    }

    public Login(String username, String pwd) {
        this.username = username;
        this.pwd = pwd;
    }

    public static Login withAgencyAdminCredentials() {
    	EnvironmentVariables environmentVariables = SerenityInfrastructure.getEnvironmentVariables();
        String username = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("default.admin.username");
        String pwd = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("default.admin.password");
        return new Login(username, pwd);
    }
    
    public static Login withAgencyInvalidAdminCredentials() {
    	EnvironmentVariables environmentVariables = SerenityInfrastructure.getEnvironmentVariables();
        String username = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("default.admin.username");
        String pwd = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("default.admin.invalidpassword");
        return new Login(username, pwd);
    }
}
