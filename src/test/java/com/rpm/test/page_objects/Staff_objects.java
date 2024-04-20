package com.rpm.test.page_objects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class Staff_objects extends PageObject {

	public static Target STAFF_MENU = Target.the("staff menu")
			.locatedBy("//a[@href='/dashboards/staff']");
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
			.locatedBy("//input[@name='address']");
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
}
