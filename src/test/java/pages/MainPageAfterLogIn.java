package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class MainPageAfterLogIn {
    public MainPageAfterLogIn(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@title='Hesabım']")
    public WebElement myAccountButton;
    @FindBy(id = "searchData")
    public WebElement searchInput;
    @FindBy(linkText = "Favorilerim / Listelerim")
    public WebElement myFavouritesAndListsLink;
    @FindBy(className = "logoutBtn")
    public WebElement logOutButton;
}
