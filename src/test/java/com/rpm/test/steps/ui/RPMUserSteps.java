package com.rpm.test.steps.ui;

import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import java.util.logging.Logger;
import com.rpm.test.page_objects.HomePage;
import com.rpm.test.page_objects.PatientsObject;
import com.rpm.test.page_objects.StaffObject;
import com.rpm.test.questions.ui.ApplicationEnquiryResult;
import com.rpm.test.tasks.ui.common.Login;
import com.rpm.test.tasks.ui.rpm.Patient_Staff_Status;
import com.rpm.test.tasks.ui.rpm.Search_Operation;
import com.rpm.test.tasks.ui.rpm.Staff;
import com.rpm.test.utils.CommonUtil;
import com.rpm.test.utils.Key;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
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

public class RPMUserSteps extends UIInteractionSteps{

	private static Logger logger = Logger.getLogger(RPMUserSteps.class.getName());
	static EnvironmentVariables environmentVariables = SerenityInfrastructure.getEnvironmentVariables();

	private Actor rpmAdmin;
	private HomePage homepage;
	private PatientsObject patObject;
	
	@Before(order = 2)
	public void setup() {
		rpmAdmin = OnStage.theActor("rpmAdmin");
	}
	
	@Given("{word} is on Home page of application and login")
	public void user_is_on_home_page_of_application_and_login(String role) {
		rpmAdmin.assignName(role);
		givenThat(rpmAdmin).attemptsTo(Login.withAgencyAdminCredentials());
	}
	
	@When("{word} verify dashboard label")
	public void verify_validation_message(String role) {
		givenThat(rpmAdmin).attemptsTo(Ensure.that("Dashboard Label", ApplicationEnquiryResult.hasDashBoardLabel())
				.isEqualTo("Patient accounts"));
	}
	
	@Given("{word} is on Home page of application and login with invalid credentials")
	public void is_on_Home_page_of_application_and_login_with_invalid_credentials(String role) {
		rpmAdmin.assignName(role);
		givenThat(rpmAdmin).attemptsTo(Login.withAgencyInvalidAdminCredentials());
	}

	@When("{word} verify error validation message")
	public void verify_error_validation_message(String role) {
		givenThat(rpmAdmin).attemptsTo(Ensure.that(homepage.INVALID_LOGIN_ERROR_MESSAGE.resolveFor(rpmAdmin).getTextValue())
				.isEqualTo("Wrong email or password"));
	}
	
	@When("{word} clicks on logout option")
	public void clicks_on_logout_option(String role) {
		givenThat(rpmAdmin).attemptsTo(Click.on(homepage.DOWN_ARROW));
		givenThat(rpmAdmin).attemptsTo(Click.on(homepage.LOGOUT));
	}
	
	//verify logo
	@Given("{word} should logout from application and navigate to login screen")
	public void should_logout_from_application_and_navigate_to_login_screen(String role) {
		givenThat(rpmAdmin).attemptsTo(Ensure.that(homepage.APP_LOGO).isDisplayed());
	}
	
	@When("Search the staff by name")
	@When("Search the patient by name")
	public void Search_the_patient_by_name(DataTable search_type) {
		givenThat(rpmAdmin).attemptsTo(Search_Operation.fromUnderlineDetails(search_type));
	}
	
	@When("Verify searched record")
	public void Verify_searched_record() {
		givenThat(rpmAdmin).attemptsTo();
	}
	
	@Given("update status of staff")
	@Given("update status of patient")
	public void update_status_of_patient(DataTable statinfo) {
		givenThat(rpmAdmin).attemptsTo(Patient_Staff_Status.fromUnderlineDetails(statinfo));
	}
	
	@Given("Navigate to Staff menu")
	public void Navigate_to_Staff_menu() {
		givenThat(rpmAdmin).attemptsTo(Click.on(StaffObject.STAFF_MENU));
	}
	
	@Given("Create staff account")
	public void Create_staff_account(DataTable staffinfo) {
		givenThat(rpmAdmin).attemptsTo(Staff.fromUnderlineDetails(staffinfo));
	}
	
	@Given("Verify created staff record")
	public void Verify_created_staff_record() {
		givenThat(rpmAdmin).attemptsTo();
	}
	
	@Given("Select Inactive status from dropdown")
	public void Select_Inactive_status_from_dropdown() {
		givenThat(rpmAdmin).attemptsTo(Click.on(PatientsObject.STATUS));
		waitABit(1000);
		givenThat(rpmAdmin).attemptsTo(Click.on(PatientsObject.INACTIVE));
		waitABit(5000);
	}
	
	@Given("verify searched records")
	public void verify_searched_records() {
		givenThat(rpmAdmin).attemptsTo(Ensure.that(PatientsObject.INACTIVE_ICON).isDisplayed());
	}
	
	@Given("Update patient record")
	public void Update_patient_record() {
		waitABit(1000);
		givenThat(rpmAdmin).attemptsTo(Click.on(PatientsObject.EDIT_ICON));
		waitABit(3000);
		String num = CommonUtil.generateRandomNumber()+"";
		givenThat(rpmAdmin).remember( Key.LAST_NAME, num);
		givenThat(rpmAdmin).attemptsTo(Enter.keyValues(num).into(PatientsObject.LAST_NAME));
		waitABit(2000);
		givenThat(rpmAdmin).attemptsTo(Scroll.to(PatientsObject.SAVE_INFO).andAlignToBottom());
		waitABit(2000);
		givenThat(rpmAdmin).attemptsTo(Click.on(PatientsObject.SAVE_INFO));
		waitABit(4000);
		
	} 	 	
	
	@Given("Verify updated patient record")
	public void Verify_updated_patient_record() {
		String updated_name = givenThat(rpmAdmin).asksFor(Text.of(PatientsObject.UPDATED_LNAME));
		waitABit(1000);
		Ensure.that(updated_name).endsWith(givenThat(rpmAdmin).recall(Key.LAST_NAME));
		System.out.println(Key.LAST_NAME);
		waitABit(1000);
	}
}
