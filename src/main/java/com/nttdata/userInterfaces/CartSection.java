package com.nttdata.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartSection {
    public static final Target CHECKOUT_BUTTON = Target.the("Checkout button").located(By.id("checkout"));
}
