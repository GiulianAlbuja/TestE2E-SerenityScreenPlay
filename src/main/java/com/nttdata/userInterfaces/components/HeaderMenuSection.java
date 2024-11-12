package com.nttdata.userInterfaces.components;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HeaderMenuSection {
    public static final Target ENTER_TO_CART_BUTTON = Target.the("Enter to cart button").located(By.className("shopping_cart_link"));
}
