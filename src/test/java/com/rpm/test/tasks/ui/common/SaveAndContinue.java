package com.rpm.test.tasks.ui.common;

import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task; class SaveAndContinue extends UIInteractions {

    public static Performable onPersonalInfoScreen() {
        return Task.where("{0} save & continue",
                (actor) -> {
                    
                }
        );
    }
}
