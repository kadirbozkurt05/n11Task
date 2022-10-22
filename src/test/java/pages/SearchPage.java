package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class SearchPage {
    public SearchPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//ul[@class='list-ul']/li)[25]")
    public WebElement lastProductOfFirstPage;
    @FindBy(xpath = "(//ul[@class='list-ul']/li)[28]//span")
    public WebElement FavButtonOfthirdProductOfSecondPage;
    @FindBy(xpath = "(//ul[@class='list-ul']/li)[28]")
    public WebElement thirdProductOfSecondPage;
    @FindBy(xpath = "(//ul[@class='list-ul']/li)[28]//h3")
    public WebElement textOfThirdProductOfSecondPage;



}
