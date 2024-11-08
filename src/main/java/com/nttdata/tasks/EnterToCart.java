package com.nttdata.tasks;

import com.nttdata.userInterfaces.components.HeaderMenuSection;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EnterToCart implements Task {

    public static Performable enterToCart() {
        return instrumented(EnterToCart.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(HeaderMenuSection.ENTER_TO_CART_BUTTON, isVisible()).forNoMoreThan(20).seconds(),
                Click.on(HeaderMenuSection.ENTER_TO_CART_BUTTON)
        );
    }
}
