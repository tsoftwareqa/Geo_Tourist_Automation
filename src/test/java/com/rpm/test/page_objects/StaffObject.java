package com.rpm.test.page_objects;

import java.util.List;
import java.util.stream.Collectors;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.targets.Target;

public class StaffObject extends PageObject {

	public static Target STAFF_MENU = Target.the("staff menu")
			.locatedBy("//a[@href='/dashboards/staff']");
	public static Target ALL_STAFF_NAME = Target.the("all patient name").locatedBy(
			"//div[@class='MuiTypography-root MuiTypography-body1 MuiTypography-gutterBottom MuiTypography-noWrap css-6wkntp']");
	public static Target CREATE_NEW_ACCOUNT = Target.the("create new account").locatedBy(
			"//button[@class='MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButtonBase-root  css-17wv3t3']");
	public static Target FIRST_NAME = Target.the("First name")
			.locatedBy("//input[@name='fname']");
	public static Target LAST_NAME = Target.the("last name")
			.locatedBy("//input[@name='lname']");
	public static Target EMAIL = Target.the("email")
			.locatedBy("//input[@name='email']");
	public static Target PHONE = Target.the("phone")
			.locatedBy("//input[@name='phone']");
	public static Target ADDRESS = Target.the("address")
			.locatedBy("//textarea[@name='address']");
	public static Target ZIP = Target.the("zip")
			.locatedBy("//input[@id='zip']");
	public static Target STATE = Target.the("state")
			.locatedBy("//input[@name='state']");
	public static Target CITY = Target.the("city")
			.locatedBy("//input[@name='city']");
	public static Target STAFF_TYPE = Target.the("staff type")
			.locatedBy("//input[@id='staffType']");
	public static Target NPI_NUMBER = Target.the("npinumber")
			.locatedBy("//input[@name='npiNumber']");
	public static Target CREDENTIALS = Target.the("credentials")
			.locatedBy("//input[@id='credentials']");
	public static Target STATE_OF_LICENSES = Target.the("state of licenses")
			.locatedBy("//input[@id='stateOfLicenses']");
	public static Target SAVE_INFO = Target.the("Save info")
			.locatedBy("//button[@class='MuiLoadingButton-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButtonBase-root css-mz0g63']");
	public static Target SELECT_ZIP = Target.the("select zip")
			.locatedBy("//div[@class='MuiAutocomplete-popper css-11e80r3']");
	public static Target SELECT_STAFFTYPE = Target.the("select staff type")
			.locatedBy("//input[@value='FTC']");
	public static Target SELECT_CREDENTIALS = Target.the("select cred")
			.locatedBy("//input[@aria-activedescendant='credentials-option-0']");
	public static Target SELECT_STATE_LICENSE = Target.the("select state license")
			.locatedBy("//input[@value='Alabama']");
	
	public List<String> getStaffList() {
		return findAll(ALL_STAFF_NAME).stream().map(WebElementFacade::getText).collect(Collectors.toList());
	}
}
