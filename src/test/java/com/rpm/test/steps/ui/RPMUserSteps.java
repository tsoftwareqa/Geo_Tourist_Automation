package com.rpm.test.steps.ui;

import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import java.util.logging.Logger;
import com.rpm.test.page_objects.HomePage;
import com.rpm.test.questions.ui.ApplicationEnquiryResult;
import com.rpm.test.tasks.ui.common.Login;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.core.di.SerenityInfrastructure;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.model.util.EnvironmentVariables;

public class RPMUserSteps extends UIInteractionSteps{

	private static Logger logger = Logger.getLogger(RPMUserSteps.class.getName());
	static EnvironmentVariables environmentVariables = SerenityInfrastructure.getEnvironmentVariables();

	private Actor appAdmin;
	private HomePage homepage;
	
	@Before(order = 2)
	public void setup() {
		appAdmin = OnStage.theActor("AA");
	}
	
	@Given("{word} is on Home page of application and login")
	public void user_is_on_home_page_of_application_and_login(String role) {
		appAdmin.assignName(role);
		givenThat(appAdmin).attemptsTo(Login.withAgencyAdminCredentials());
	}
	
	@When("{word} verify dashboard label")
	public void verify_validation_message(String role) {
		givenThat(appAdmin).attemptsTo(Ensure.that("Dashboard Label", ApplicationEnquiryResult.hasDashBoardLabel())
				.isEqualTo("Patient accounts"));
	}
	
	@Given("{word} is on Home page of application and login with invalid credentials")
	public void is_on_Home_page_of_application_and_login_with_invalid_credentials(String role) {
		appAdmin.assignName(role);
		givenThat(appAdmin).attemptsTo(Login.withAgencyInvalidAdminCredentials());
	}

	@When("{word} verify error validation message")
	public void verify_error_validation_message(String role) {
		givenThat(appAdmin).attemptsTo(Ensure.that(homepage.INVALID_LOGIN_ERROR_MESSAGE.resolveFor(appAdmin).getTextValue())
				.isEqualTo("Wrong email or password"));
	}
	
	@When("{word} clicks on logout option")
	public void clicks_on_logout_option(String role) {
		givenThat(appAdmin).attemptsTo(Click.on(homepage.DOWN_ARROW));
		givenThat(appAdmin).attemptsTo(Click.on(homepage.LOGOUT));
	}
	
	@Given("{word} should logout from application and navigate to login screen")
	public void should_logout_from_application_and_navigate_to_login_screen(String role) {
		givenThat(appAdmin).attemptsTo(Ensure.that(homepage.APP_LOGO).isDisplayed());
	}
}
