package com.rpm.test.tasks.ui.rpm;

import java.util.Map;

import com.rpm.test.page_objects.PatientsObject;
import com.rpm.test.utils.ConvertCucumberDataTable;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class Patient_Staff_Status extends PageObject implements Task {

	PatientsObject patobject;
	
	private static String status;
	public Patient_Staff_Status(String status) {
		this.status=status;
	}
	
	public static Patient_Staff_Status fromUnderlineDetails(DataTable stausinfo) {
		Map<String, String> statusinfodata = ConvertCucumberDataTable.toMap(stausinfo);
		status = statusinfodata.get("Status");
		return new Patient_Staff_Status(status);
	}
	
	@Override
	public <T extends Actor> void performAs(T actor) {
		
		actor.attemptsTo(Click.on(PatientsObject.CHECKBOX));
				
		if (status.equalsIgnoreCase("Deactivate")) {
			actor.attemptsTo(Click.on(PatientsObject.DEACTIVATE_LINK));
			waitABit(2200);
			actor.attemptsTo(Enter.keyValues("This is deactivate description").into(PatientsObject.DESCRIPTION));
			waitABit(1000);
			actor.attemptsTo(Click.on(PatientsObject.STATUS_BUTTON));
			waitABit(3500);
		} else {
			actor.attemptsTo(Click.on(PatientsObject.DEACTIVATE_LINK));
			waitABit(2200);
			actor.attemptsTo(Enter.keyValues("This is activate description").into(PatientsObject.DESCRIPTION));
			waitABit(1000);
			actor.attemptsTo(Click.on(PatientsObject.STATUS_BUTTON));
			waitABit(3500);
		}
	}

}
