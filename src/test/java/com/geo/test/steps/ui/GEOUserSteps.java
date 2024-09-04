package com.geo.test.steps.ui;

import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import java.util.logging.Logger;

import org.openqa.selenium.Keys;

import com.geo.test.page_objects.HomePage;
import com.geo.test.questions.ui.ApplicationEnquiryResult;
import com.geo.test.tasks.ui.common.Login;
import com.geo.test.tasks.ui.geo.UserRegister;
import com.geo.test.utils.CommonUtil;
import com.geo.test.utils.Key;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.di.SerenityInfrastructure;
import net.serenitybdd.core.pages.ClearContents;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.RememberThat;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.ClearBy;
import net.serenitybdd.screenplay.actions.ClearElement;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.model.util.EnvironmentVariables;

public class GEOUserSteps extends UIInteractionSteps{

	private static Logger logger = Logger.getLogger(GEOUserSteps.class.getName());
	static EnvironmentVariables environmentVariables = SerenityInfrastructure.getEnvironmentVariables();

	private Actor user;
	private HomePage homepage;
		
	@Before(order = 2)
	public void setup() {
		user = OnStage.theActor("user");
	}
	
	@Given("{word} is on Home page of application and login")
	public void user_is_on_home_page_of_application_and_login(String role) {
		user.assignName(role);
		givenThat(user).attemptsTo(Login.withAgencyAdminCredentials());
	}
	
	@When("{word} verify dashboard label")
	public void verify_validation_message(String role) {
		givenThat(user).attemptsTo(Ensure.that("Dashboard Label", ApplicationEnquiryResult.hasDashBoardLabel())
				.isEqualTo("Experience your environment in a new and inspiring way"));
	}
	
	@Given("{word} is on Home page of application and login with invalid credentials")
	public void is_on_Home_page_of_application_and_login_with_invalid_credentials(String role) {
		user.assignName(role);
		givenThat(user).attemptsTo(Login.withAgencyInvalidAdminCredentials());
	}

	@When("{word} verify error validation message")
	public void verify_error_validation_message(String role) {
		givenThat(user).attemptsTo(Ensure.that(homepage.INVALID_LOGIN_ERROR_MESSAGE.resolveFor(user).getText())
				.isEqualTo("Login Credentials Failed"));
	}
	
	@When("{word} clicks on logout option")
	public void clicks_on_logout_option(String role) {
		givenThat(user).attemptsTo(Click.on(homepage.DOWN_ARROW));
		givenThat(user).attemptsTo(Click.on(homepage.LOGOUT));
		givenThat(user).attemptsTo(Click.on(homepage.APP_LOGOUT));
	}
	
	//verify logo
	@Given("{word} should logout from application and navigate to login screen")
	public void should_logout_from_application_and_navigate_to_login_screen(String role) {
		givenThat(user).attemptsTo(Ensure.that(homepage.APP_LOGO).isDisplayed());
	}
	
	@Given("{word} is on Home page of application and signup")
	public void user_is_on_home_page_of_application_and_signup(String role) {
		user.assignName(role);
		givenThat(user).attemptsTo(UserRegister.fromUnderlineDetails());
	}
	
	@When("verify user logged in successfully")
	public void verify_user_logged_in_successfully() {
		//givenThat(user).attemptsTo(Ensure.that(homepage.APP_LOGO).isDisplayed());
	}
	
	@When("navigate to profile screen")
	public void navigate_to_profile_screen() {
		givenThat(user).attemptsTo(Click.on(homepage.DOWN_ARROW));
		waitABit(1000);
		givenThat(user).attemptsTo(Click.on(homepage.MY_PROFILE));
		waitABit(1000);
	}
	
	@Then("update profile details and validate")
	public void update_profile_details_and_validate() {
		givenThat(user).attemptsTo(Scroll.to(HomePage.EDIT_PROFILE).andAlignToBottom());
		waitABit(3000);
		givenThat(user).attemptsTo(Click.on(homepage.EDIT_PROFILE));
		waitABit(3000);
		givenThat(user).attemptsTo(Click.on(homepage.EDIT_NAME));
		givenThat(user).attemptsTo(Clear.field(homepage.INPUT_UPDATED_NAME));
		givenThat(user).attemptsTo(Click.on(homepage.EDIT_NAME));
		waitABit(3000);
		givenThat(user).attemptsTo(Enter.keyValues("TestUser"+CommonUtil.generateRandomNumber()).into(HomePage.INPUT_UPDATED_NAME).thenHit(Keys.TAB));
		waitABit(1000);
		givenThat(user).attemptsTo(Scroll.to(HomePage.SAVE_BTN).andAlignToBottom());
		waitABit(3000);
		givenThat(user).attemptsTo(Click.on(homepage.SAVE_BTN));
		waitABit(3000);
	}
}
