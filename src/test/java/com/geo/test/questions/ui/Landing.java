package com.geo.test.questions.ui;

import com.geo.test.page_objects.HomePage;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class Landing extends UIInteractionSteps implements Question<Boolean> {

    private HomePage homePage;

    public static Landing isComplete() {
        return new Landing();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return homePage.isLandingComplete(actor);
    }

}
