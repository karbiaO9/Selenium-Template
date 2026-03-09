package stepdefinitions;

import base.TestBase;
import com.aventstack.extentreports.Status;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.HomePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Placeholder step definitions for the template.
 * Replace these steps (and add new step definition classes) with the steps that match
 * your project's Gherkin features (e.g. login, navigation, form submission).
 */
public class HomeSteps extends TestBase {

    /** Placeholder page — replace with the page(s) used by your scenarios. Created per step so driver is set (after Hooks @Before). */
    private HomePage getHomePage() {
        return new HomePage(TestBase.getDriver());
    }

    /**
     * Opens the application under test.
     * For the template this goes to about:blank; replace with your app's entry point.
     */
    @Given("I open the application")
    public void iOpenTheApplication() {
        try {
            getHomePage().openApplication();
            Hooks._scenario.log(Status.PASS, "Application opened");
        } catch (Exception e) {
            Hooks._scenario.log(Status.FAIL, "Failed to open application: " + e.getMessage());
            throw e;
        }
    }

    /**
     * Asserts that the application page is displayed.
     * Replace with your real assertion (e.g. expected title, visible element, URL).
     */
    @Then("the application page is displayed")
    public void theApplicationPageIsDisplayed() {
        try {
            assertTrue(getHomePage().isApplicationPageDisplayed(), "Application page was not displayed");
            Hooks._scenario.log(Status.PASS, "Application page is displayed");
        } catch (Exception e) {
            Hooks._scenario.log(Status.FAIL, "Application page check failed: " + e.getMessage());
            throw e;
        }
    }
}
