package com.rpm.test.page_objects;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.targets.Target;

public class PatientsObject extends PageObject {

	public static Target SEARCH_INPUT = Target.the("search input")
			.locatedBy("//input[@id='outlined-adornment-weight']");
	public static Target ALL_PATIENT_NAME = Target.the("all patient name").locatedBy(
			"//div[@class='MuiTypography-root MuiTypography-body1 MuiTypography-gutterBottom MuiTypography-noWrap css-uje2ya']");

	public static Target CHECKBOX = Target.the("check").locatedBy(
			"(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[2]");
	public static Target DEACTIVATE_LINK = Target.the("deactivate").locatedBy(
			"//button[@class='MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeSmall MuiButton-textSizeSmall MuiButtonBase-root  css-qywzso']");
	public static Target DESCRIPTION = Target.the("description").locatedBy(
			"//textarea[@name='description']");
	public static Target STATUS_BUTTON = Target.the("description").locatedBy(
			"//button[@class='MuiLoadingButton-root MuiButton-root MuiButton-contained MuiButton-containedError MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButtonBase-root css-1b4w0jq']");

	public static Target STATUS = Target.the("status").locatedBy(
			"(//div[@class='MuiSelect-select MuiSelect-outlined MuiOutlinedInput-input MuiInputBase-input MuiInputBase-inputSizeSmall css-80wq58'])[2]");
	public static Target INACTIVE = Target.the("inactive status").locatedBy(
			"//li[contains(text(),'In-Active')]");
	public static Target INACTIVE_ICON = Target.the("inactive icon").locatedBy(
			"(//div[@style='background-color: lightgray;'])[1]");
	public static Target EDIT_ICON = Target.the("edit icon").locatedBy(
			"(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeSmall css-1r7zgn4'])[1]");
	public static Target LAST_NAME = Target.the("lname").locatedBy(
			"//input[@name='lname']");
	public static Target SAVE_INFO = Target.the("save").locatedBy(
			"//button[contains(text(),'Save Info')]");
	public static Target UPDATED_LNAME = Target.the("updated lname").locatedBy(
			"(//div[@class='MuiTypography-root MuiTypography-body1 MuiTypography-gutterBottom MuiTypography-noWrap css-uje2ya'])[1]");
	
	public List<String> getPatientList() {
		return findAll(ALL_PATIENT_NAME).stream().map(WebElementFacade::getText).collect(Collectors.toList());
	}
	
	public void clearField() {
		getDriver().findElement(By.xpath("//input[@name='phone']")).clear();
	}

}