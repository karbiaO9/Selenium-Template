package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Placeholder page object for the template.
 * Replace this class (or add new page classes in this package) with the real pages
 * of your project (e.g. LoginPage, DashboardPage, etc.) and their selectors/actions.
 */
public class HomePage {

    /** Driver and wait — reuse this pattern in your real page classes. */
    protected WebDriver driver;
    protected WebDriverWait wait;

    /**
     * Base URL for the application under test.
     * Replace with your local or environment URL (e.g. "http://localhost:8080").
     */
    private static final String BASE_URL = "about:blank";

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Opens the application (placeholder: about:blank so the scenario runs without a server).
     * Replace with your app URL and consider using a config property for different environments.
     */
    public void openApplication() {
        driver.get(BASE_URL);
    }

    /**
     * Placeholder check that the page is displayed (e.g. URL or title).
     * Replace with real checks for your app (e.g. visibility of a main element or expected title).
     */
    public boolean isApplicationPageDisplayed() {
        String url = driver.getCurrentUrl();
        return url != null && !url.isEmpty();
    }
}
