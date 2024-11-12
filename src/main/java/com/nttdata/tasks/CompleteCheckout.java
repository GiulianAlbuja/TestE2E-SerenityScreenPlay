package com.nttdata.tasks;

import com.nttdata.userInterfaces.CartSection;
import com.nttdata.userInterfaces.CheckoutSection;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CompleteCheckout implements Task {

    private final String firstName, lastName, postalCode;

    public CompleteCheckout(String firstName, String lastName, String postalCode) {
        this.firstName = firstName;
        this. lastName = lastName;
        this.postalCode = postalCode;
    }

    public static Performable checkout(String firstName, String lastName, String postalCode) {
        return instrumented(CompleteCheckout.class, firstName, lastName, postalCode);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CartSection.CHECKOUT_BUTTON, isVisible()).forNoMoreThan(20).seconds(),
                Click.on(CartSection.CHECKOUT_BUTTON),

                WaitUntil.the(CheckoutSection.FIRST_NAME_INPUT, isVisible()).forNoMoreThan(20).seconds(),
                Enter.theValue(firstName).into(CheckoutSection.FIRST_NAME_INPUT),

                WaitUntil.the(CheckoutSection.LAST_NAME_INPUT, isVisible()).forNoMoreThan(20).seconds(),
                Enter.theValue(lastName).into(CheckoutSection.LAST_NAME_INPUT),

                WaitUntil.the(CheckoutSection.POSTAL_CODE_INPUT, isVisible()).forNoMoreThan(20).seconds(),
                Enter.theValue(postalCode).into(CheckoutSection.POSTAL_CODE_INPUT),

                WaitUntil.the(CheckoutSection.CONTINUE_BUTTON, isVisible()).forNoMoreThan(20).seconds(),
                Click.on(CheckoutSection.CONTINUE_BUTTON),

                WaitUntil.the(CheckoutSection.FINISH_BUTTON, isVisible()).forNoMoreThan(20).seconds(),
                Click.on(CheckoutSection.FINISH_BUTTON)
        );
    }
}
