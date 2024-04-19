package com.rpm.test.tasks.ui.rpm;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;

import com.rpm.test.page_objects.PatientsObject;
import com.rpm.test.utils.Key;

import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;

public class Patients extends UIInteractions implements Task {

	PatientsObject patobject;
	public Patients() {	}
	
	public static Patients fromUnderlineDetails() {	
		return new Patients();
	}
	
	@Override
	public <T extends Actor> void performAs(T actor) {
		
		List<String> getList = patobject.getPatientList();
		String searchinput = getList.get(3);
		if (searchinput.contains(" ")) {
			searchinput= searchinput.replaceAll(" .*", "");
		}
		waitABit(2200);
		actor.attemptsTo(Enter.keyValues(searchinput).into(PatientsObject.SEARCH_INPUT));
		
		waitABit(2200);	
		actor.remember(searchinput, Key.SEARCH_INPUT);
		
		waitABit(1000);
		String patientname = actor.asksFor(Text.of(PatientsObject.ALL_PATIENT_NAME));
		
		waitABit(2500);
		Ensure.that(patientname).isEqualTo(actor.recall(Key.SEARCH_INPUT));
	}

}
