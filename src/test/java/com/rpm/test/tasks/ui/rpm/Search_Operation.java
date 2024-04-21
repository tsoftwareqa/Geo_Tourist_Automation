package com.rpm.test.tasks.ui.rpm;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;

import com.rpm.test.page_objects.PatientsObject;
import com.rpm.test.page_objects.StaffObject;
import com.rpm.test.utils.ConvertCucumberDataTable;
import com.rpm.test.utils.Key;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;

public class Search_Operation extends UIInteractions implements Task {

	PatientsObject patobject;
	StaffObject stafobject;
	private static String searchType;

	public Search_Operation(String searchType) {
		this.searchType = searchType;
	}

	public static Search_Operation fromUnderlineDetails(DataTable searchtype) {
		Map<String, String> searchdata = ConvertCucumberDataTable.toMap(searchtype);
		searchType = searchdata.get("SearchType");
		return new Search_Operation(searchType);
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		String searchinput = "";
		if (searchType.equalsIgnoreCase("Patient")) {
			List<String> getList = patobject.getPatientList();
			searchinput = getList.get(3);
			if (searchinput.contains(" ")) {
				searchinput = searchinput.replaceAll(" .*", "");
			}
		} else {
			List<String> getList = stafobject.getStaffList();
			searchinput = getList.get(3);
			if (searchinput.contains(" ")) {
				searchinput = searchinput.replaceAll(" .*", "");
			}	
		}

		waitABit(2200);
		actor.attemptsTo(Enter.keyValues(searchinput).into(PatientsObject.SEARCH_INPUT));

		waitABit(2200);
		actor.remember(searchinput, Key.SEARCH_INPUT);

		waitABit(1000);
		String patient_staff_name;
		if (searchType.equalsIgnoreCase("Patient")) {
			patient_staff_name = actor.asksFor(Text.of(PatientsObject.ALL_PATIENT_NAME));
		} else {
			patient_staff_name = actor.asksFor(Text.of(StaffObject.ALL_STAFF_NAME));
		}
		
		waitABit(2500);
		Ensure.that(patient_staff_name).isEqualTo(actor.recall(Key.SEARCH_INPUT));
	}

}
