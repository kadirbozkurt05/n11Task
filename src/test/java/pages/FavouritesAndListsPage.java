package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class FavouritesAndListsPage {

    public FavouritesAndListsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@href='https://www.n11.com/hesabim/favorilerim']")
    public WebElement myFavouritesList;
    @FindBy(className = "deleteProFromFavorites")
    public WebElement deleteButton;
    @FindBy(css = ".btn.btnBlack.confirm")
    public WebElement approveButton;

}
