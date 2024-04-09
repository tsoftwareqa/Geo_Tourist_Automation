package com.rpm.test.page_objects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class CommonObjects extends PageObject {
    public static Target USERS_MENU = Target.the("users menu").locatedBy("(//p[contains(text(),'Users')])[1]");
    public static Target ADD_USER = Target.the("add user").locatedBy("//p[contains(text(),'Add User')]");
    public static Target GLOBAL_SEARCH = Target.the("Global search").locatedBy("//input[@name='quickSearchValue']");
    public static Target ACCOUNTS_MENU = Target.the("Accounts menu").locatedBy("(//p[contains(text(),'Accounts')])[1]");
    public static Target ADD_ACCOUNT = Target.the("add account").locatedBy("//p[contains(text(),'Add Account')]");
    public static Target RESEARCH = Target.the("reserach").locatedBy("(//p[contains(text(),'Research')])[1]");
    public static Target INSTRUMENT = Target.the("instrument").locatedBy("//p[contains(text(),' Instruments')]");
    public static Target PORTFOLIOS = Target.the("portfolios").locatedBy("(//p[contains(text(),'Portfolios')])[1]");
    public static Target CORE_PORTFOLIO = Target.the("core portfolio").locatedBy("(//p[contains(text(),'Core Portfolios')])[1]");
    public static Target ACCOUNT_PORTFOLIO_MAP = Target.the("map portfolio").locatedBy("(//p[contains(text(),'Account Portfolio Mapping')])[1]");
    public static Target ALLOCATE_PORTFOLIO = Target.the("allocate portfolio").locatedBy("(//p[contains(text(),' Portfolio Allocations')])[1]");
    public static Target UPLOADS = Target.the("uploads").locatedBy("(//p[contains(text(),'Uploads')])[1]");
    public static Target UPLOAD_FILE = Target.the("upload file").locatedBy("(//p[contains(text(),'Upload File')])[1]");
    public static Target RESEARCH_ACTION = Target.the("research action").locatedBy("(//p[contains(text(),'Research Actions')])[1]");
    
}
