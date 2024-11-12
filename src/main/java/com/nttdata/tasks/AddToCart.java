package com.nttdata.tasks;

import com.nttdata.userInterfaces.ProductsSection;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddToCart implements Task {

    private final String productName;

    public AddToCart(String productName) {
        this.productName = productName;
    }

    public static Performable addProduct(String productName) {
        return instrumented(AddToCart.class, productName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ProductsSection.ADD_TO_CART_BUTTON.of(productName), isVisible()).forNoMoreThan(20).seconds(),
                Click.on(ProductsSection.ADD_TO_CART_BUTTON.of(productName))
        );
    }


}
