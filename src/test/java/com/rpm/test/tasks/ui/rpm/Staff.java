package com.rpm.test.tasks.ui.rpm;

import java.util.Map;

import com.rpm.test.page_objects.Staff_objects;
import com.rpm.test.utils.CommonUtil;
import com.rpm.test.utils.ConvertCucumberDataTable;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class Staff extends UIInteractions implements Task  {
	
	private static String stafftype;
	private static String zipcode;
	private static String credentials;
	private static String stateoflicense;
	
	public Staff(String stafftype, String zipcode, String credentials, String stateoflicense) {
		this.stafftype=stafftype;
		this.zipcode=zipcode;
		this.credentials=credentials;
		this.stateoflicense=stateoflicense;
	}
	
	public static Staff fromUnderlineDetails(DataTable staffinfo) {
		Map<String, String> staffdata = ConvertCucumberDataTable.toMap(staffinfo);
		stafftype = staffdata.get("StaffType");
		zipcode = staffdata.get("ZipCode");
		credentials = staffdata.get("Credentials");
		stateoflicense = staffdata.get("StateOfLicense");
		return new Staff(stafftype,zipcode,credentials,stateoflicense);
	}
	@Override
	public <T extends Actor> void performAs(T actor) {
		
		actor.attemptsTo(Click.on(Staff_objects.CREATE_NEW_ACCOUNT));
		waitABit(1000);
		
		actor.attemptsTo(Enter.keyValues("Aman").into(Staff_objects.FIRST_NAME));
		
		actor.attemptsTo(Enter.keyValues("Singh").into(Staff_objects.LAST_NAME));
		
		String mailString = "testmail"+CommonUtil.generateRandomNumber()+"@gmail.com";
		actor.attemptsTo(Enter.keyValues(mailString).into(Staff_objects.EMAIL));
		
		actor.attemptsTo(Enter.keyValues(CommonUtil.generateNineDigitNumber()+"0").into(Staff_objects.PHONE));
		
		actor.attemptsTo(Enter.keyValues("St peters 125th").into(Staff_objects.ADDRESS));
		
		actor.attemptsTo(Enter.keyValues(zipcode).into(Staff_objects.ZIP));
		
		actor.attemptsTo(Enter.keyValues("Alabama").into(Staff_objects.STATE));
		
		actor.attemptsTo(Enter.keyValues("Birmingham").into(Staff_objects.CITY));
		
		actor.attemptsTo(Enter.keyValues(stafftype).into(Staff_objects.STAFF_TYPE));
		
		actor.attemptsTo(Enter.keyValues(CommonUtil.generateNineDigitNumber()).into(Staff_objects.NPI_NUMBER));
		
		actor.attemptsTo(Enter.keyValues(credentials).into(Staff_objects.CREDENTIALS));
		
		actor.attemptsTo(Enter.keyValues(stateoflicense).into(Staff_objects.STATE_OF_LICENSES));
		
		actor.attemptsTo(Click.on(Staff_objects.SAVE_INFO));
	}

}
