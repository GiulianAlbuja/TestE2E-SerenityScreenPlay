package com.nttdata.stepdefinitions;

import com.nttdata.questions.ConfirmationMessage;
import com.nttdata.tasks.*;
import com.nttdata.userInterfaces.CheckoutSection;
import com.nttdata.userInterfaces.ProductsSection;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;



public class ShopStepDef {

    private static final String ACTOR_NAME = "User";

    @Before
    public void setTheStag(){
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled(ACTOR_NAME);
    }

    @Given("I am on the store page")
    public void iAmOnTheStorePage() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                OpenPage.openPage("https://www.saucedemo.com/")
        );
    }

    @And("^I log in with my user (.*) and password (.*)$")
    public void iLogInWithMyUserUserAndPasswordPassword(String username, String password) {
        theActorInTheSpotlight().attemptsTo(
                Login.withData(username, password)
        );
    }

    @When("^I add a unit of the product (.*) to the cart$")
    public void iAddAUnitOfTheProductProductToTheCart(String productName) {
        theActorInTheSpotlight().attemptsTo(
                AddToCart.addProduct(productName)
        );
        System.out.println(ProductsSection.ADD_TO_CART_BUTTON.of(productName));
    }

    @And("I enter the cart")
    public void iEnterTheCart() {
        theActorInTheSpotlight().attemptsTo(
                EnterToCart.enterToCart()
        );
    }

    @When("^I checkout with (.*) (.*) (.*)$")
    public void iCheckoutWithFirstNameLastNamePostalCode(String firstName, String lastName, String postalCode) {
        theActorInTheSpotlight().attemptsTo(
                CompleteCheckout.checkout(firstName, lastName, postalCode)
        );
    }

    @Then("I see the message {string}")
    public void iSeeTheMessage(String confirmatonMessage) {
        try {
            theActorInTheSpotlight().attemptsTo(
                    WaitUntil.the(CheckoutSection.PURCHASE_CONFIRMATION_MESSAGE, isVisible()).forNoMoreThan(20).seconds()
            );
        } catch (AssertionError e) {
            System.out.println("The confirmation message does not appear in the expected time.");
        }
        theActorInTheSpotlight().should(
                seeThat("the confirmation message", ConfirmationMessage.text(), equalTo(confirmatonMessage))
        );
    }
}
