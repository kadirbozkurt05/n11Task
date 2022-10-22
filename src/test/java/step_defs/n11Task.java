package step_defs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import utils.ConfigReader;
import utils.Driver;

public class n11Task {

    MainPage mainPage = new MainPage();
    SignInPage signInPage = new SignInPage();
    MainPageAfterLogIn mainPageAfterLogIn = new MainPageAfterLogIn();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
    SearchPage searchPage = new SearchPage();
    FavouritesAndListsPage favouritesAndListsPage = new FavouritesAndListsPage();
    Actions actions = new Actions(Driver.getDriver());

    @When("user goes to n11 page")
    public void user_goes_to_n11_page() {
        Driver.getDriver().get(ConfigReader.getProperty("env"));
        mainPage.allowCookies.click();
    }
    @Then("verify n11 page is opened")
    public void verify_n11_page_is_opened() {
        String expectedTitle = "n11 - Hayat Sana Gelir";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }
    @When("user click login button")
    public void user_click_login_button() {
        mainPage.signInButton.click();
    }
    @Then("verify that user is logged in")
    public void verify_that_user_is_logged_in() {
        Assert.assertTrue(mainPageAfterLogIn.myAccountButton.isDisplayed());
    }

    @When("user types {string} into search box and press enter")
    public void user_types_into_search_box(String searchData) {
        mainPageAfterLogIn.searchInput.sendKeys(searchData+Keys.ENTER);
    }
    @Then("verify that {string} is searched")
    public void verify_that_is_searched(String searchData) {
        String expectedTitle = searchData+" - n11.com";
        wait.until(ExpectedConditions.titleContains(searchData));
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);

    }
    @When("user open the second page of search results")
    public void user_open_the_second_page_of_search_results() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        js.executeScript("arguments[0].scrollIntoView(true);", searchPage.lastProductOfFirstPage);
        js.executeScript("window.scrollBy(0,-400)");
    }
    @Then("verify that second page of search results is shown")
    public void verify_that_second_page_of_search_results_is_shown() {
        wait.until(ExpectedConditions.urlContains("pg=2"));
        String url = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(url.contains("pg=2"));
    }
    @When("user add to favorites the third product of the page")
    public void user_add_to_favorites_the_third_product_of_the_page() {
        wait.until(ExpectedConditions.visibilityOf(searchPage.FavButtonOfthirdProductOfSecondPage));
        searchPage.FavButtonOfthirdProductOfSecondPage.click();
    }
    @When("user goes the My Favourites and My Lists")
    public void user_goes_the_my_favourites_and_my_lists() {
        actions.moveToElement(mainPageAfterLogIn.myAccountButton).perform();
        mainPageAfterLogIn.myFavouritesAndListsLink.click();

    }
    @Then("verify that My Favourites page is opened")
    public void verify_that_my_favourites_page_is_opened() {
        String expectedTitle = "İstek Listem - n11.com";
        String actualResult = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitle,actualResult);
    }
    @When("user delete the product from the favourites list")
    public void user_delete_the_product_from_the_favourites_list() {
       favouritesAndListsPage.myFavouritesList.click();
       favouritesAndListsPage.deleteButton.click();
    }
    @Then("verify that the product is deleted from favourites list")
    public void verify_that_the_product_is_deleted_from_favourites_list() {
        Assert.assertTrue(favouritesAndListsPage.approveButton.isDisplayed());
        favouritesAndListsPage.approveButton.click();
    }
    @When("user clicks the logout")
    public void user_clicks_the_logout() {
        actions.moveToElement(mainPageAfterLogIn.myAccountButton).perform();
        wait.until(ExpectedConditions.elementToBeClickable(mainPageAfterLogIn.logOutButton));
        mainPageAfterLogIn.logOutButton.click();
    }
    @Then("verify that user is logged out")
    public void verify_that_user_is_logged_out() {
        String expectedTitle = "Giriş Yap - n11.com";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);
    }
    @When("user types {string} into user input")
    public void userTypesIntoUserInput(String email) {
        signInPage.emailInput.sendKeys(email);
    }
    @And("user types {string} into password input")
    public void userTypesIntoPasswordInput(String password) {
            signInPage.passwordInput.sendKeys(password);
    }
    @And("user click login button on Sign In Page")
    public void userClickLoginButtonOnSignInPage() {
            signInPage.loginButton.click();
    }
}
