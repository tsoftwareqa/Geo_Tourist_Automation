package com.rpm.test.tasks.ui.rpm;

import java.util.Map;

import org.openqa.selenium.Keys;

import com.rpm.test.page_objects.StaffObject;
import com.rpm.test.utils.CommonUtil;
import com.rpm.test.utils.ConvertCucumberDataTable;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

public class Staff extends UIInteractions implements Task  {
	
	private static String stafftype;
	private static String zipcode;
	private static String credentials;
	private static String stateoflicense;
	private StaffObject staffObject;
	
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
		waitABit(2200);
		
		actor.attemptsTo(Click.on(StaffObject.CREATE_NEW_ACCOUNT));
		waitABit(1000);
		
		actor.attemptsTo(Enter.keyValues("Aman").into(StaffObject.FIRST_NAME));
		
		actor.attemptsTo(Enter.keyValues("Singh").into(StaffObject.LAST_NAME));
		
		String mailString = "testmail"+CommonUtil.generateRandomNumber()+"@gmail.com";
		actor.attemptsTo(Enter.keyValues(mailString).into(StaffObject.EMAIL));
		
		actor.attemptsTo(Enter.keyValues(CommonUtil.generateNineDigitNumber()+"0").into(StaffObject.PHONE));
		
		actor.attemptsTo(Enter.keyValues("St peters 125th").into(StaffObject.ADDRESS));
		waitABit(1000);
		
		actor.attemptsTo(Enter.keyValues(zipcode).into(StaffObject.ZIP));	
		waitABit(3000);
		
		actor.attemptsTo(Enter.keyValues("").into(StaffObject.ZIP)
				.thenHit(Keys.ARROW_DOWN).thenHit(Keys.RETURN));
		waitABit(3000);
		
		actor.attemptsTo(Click.on(StaffObject.SELECT_STAFFTYPE));
		waitABit(3000);
		
		actor.attemptsTo(Enter.keyValues("").into(StaffObject.SELECT_STAFFTYPE)
				.thenHit(Keys.ARROW_UP).thenHit(Keys.RETURN));
		waitABit(3000);
		
		actor.attemptsTo(Scroll.to(StaffObject.SAVE_INFO).andAlignToTop());
		waitABit(1000);
		
		actor.attemptsTo(Click.on(StaffObject.SAVE_INFO));
		waitABit(3500);
	}

}
