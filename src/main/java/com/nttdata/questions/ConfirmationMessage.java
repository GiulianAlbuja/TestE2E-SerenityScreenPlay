package com.nttdata.questions;

import com.nttdata.userInterfaces.CheckoutSection;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ConfirmationMessage {
    public static Question<String> text() {
        return Text.of(CheckoutSection.PURCHASE_CONFIRMATION_MESSAGE).asString();
    }
}
