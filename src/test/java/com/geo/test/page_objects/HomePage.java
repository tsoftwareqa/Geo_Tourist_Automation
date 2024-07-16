package com.geo.test.page_objects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.annotations.DefaultUrl;

@DefaultUrl("page:home.page")
public class HomePage extends PageObject {
	public static Target LOGIN_LINK = Target.the("login link").locatedBy("//a[contains(text(),'Log in')]");
	public static Target USERNAME = Target.the("username").locatedBy("//input[@type='email']");
    public static Target PASSWORD = Target.the("password").locatedBy("//input[@type='password']");
    public static Target LOGIN_BTN = Target.the("submit").locatedBy("//button[contains(text(),'Log in')]");
    public static Target DASHBOARD_LABEL = Target.the("Dashboard Label").locatedBy("//h1[@class='banner-text__heading']");
    public static Target DOWN_ARROW = Target.the("Down Arrow Link").locatedBy("//div[@class='MuiTypography-root MuiTypography-body1 css-1t0druo']");
    public static Target LOGOUT = Target.the("Logout Link").locatedBy("//button[contains(text(),'Sign out')]");
    public static Target VERIFY_LOGIN_LABEL = Target.the("Verify Login Label").locatedBy("//div[contains(text(),'Login')]");
    public static Target INVALID_LOGIN_ERROR_MESSAGE = Target.the("Error message").locatedBy("//span[@id='error-element-password']");
    public static Target APP_LOGO = Target.the("App logo").locatedBy("//img[@id='prompt-logo-center']");
           
    public boolean isLandingComplete(Actor actor) {

        double startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() < startTime + getWaitForTimeout().getSeconds() * 1000) {
            String previousState = BrowseTheWeb.as(actor).getDriver().getPageSource();
            waitABit(1500);
            if (previousState.equals(BrowseTheWeb.as(actor).getDriver().getPageSource())) {
                break;
            }
        }

        BrowseTheWeb.as(actor).waitFor(DASHBOARD_LABEL.getCssOrXPathSelector());
        return DASHBOARD_LABEL.isVisibleFor(actor);
    }
    
	/*
	 * 
	 * public List<String> getAscaMenu() { return findAll(ASCA_MENU).stream()
	 * .map(WebElementFacade::getText) .collect(Collectors.toList()); }
	 */
}
