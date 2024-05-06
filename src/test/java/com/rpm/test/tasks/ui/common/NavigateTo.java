package com.rpm.test.tasks.ui.common;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import com.rpm.test.page_objects.HomePage;

public class NavigateTo {
	
    public static Performable theLoginPage() {
        return Task.where("{0} opens the login page",
                Open.browserOn().the(HomePage.class));
    }
        
}
