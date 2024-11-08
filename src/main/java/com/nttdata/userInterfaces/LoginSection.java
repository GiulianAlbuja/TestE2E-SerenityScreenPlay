package com.nttdata.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginSection {
    public static final Target INP_USERNAME = Target.the("Username input").located(By.id("user-name"));
    public static final Target INP_PASSWORD = Target.the("Password input").located(By.id("password"));
    public static final Target LOGIN_BUTTON = Target.the("Login button").located(By.id("login-button"));
}
