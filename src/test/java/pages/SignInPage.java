package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class SignInPage {
    public SignInPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "email")
    public WebElement emailInput;
    @FindBy(id = "password")
    public WebElement passwordInput;
    @FindBy(id = "loginButton")
    public WebElement loginButton;

}
