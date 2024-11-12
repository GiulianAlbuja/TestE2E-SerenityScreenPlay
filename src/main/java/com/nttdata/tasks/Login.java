package com.nttdata.tasks;

import com.nttdata.userInterfaces.LoginSection;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Login implements Task {

    public final String username, password;


    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static Performable withData(String username, String password){
        return instrumented(Login.class, username, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LoginSection.INP_USERNAME, isVisible()).forNoMoreThan(20).seconds(),
                Enter.theValue(username).into(LoginSection.INP_USERNAME),

                WaitUntil.the(LoginSection.INP_PASSWORD, isVisible()).forNoMoreThan(20).seconds(),
                Enter.theValue(password).into(LoginSection.INP_PASSWORD),

                WaitUntil.the(LoginSection.LOGIN_BUTTON, isVisible()).forNoMoreThan(20).seconds(),
                Click.on(LoginSection.LOGIN_BUTTON)

        );
    }

}
