package com.nttdata.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductsSection {
    public static final Target ADD_TO_CART_BUTTON = Target.the("Add to cart button for {0}")
            .locatedBy("#add-to-cart-{0}");
}
