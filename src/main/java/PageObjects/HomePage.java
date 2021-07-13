package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//header//img[@alt='Bhinneka.com']//parent::a")
    private WebElement headerLogoButton;

    @FindBy(xpath ="//div[contains(@placeholder,'Cari produk asli')]//div//input")
    private WebElement searchInput;

    @FindBy(xpath = "//a[contains(@href,'/cart')]")
    private WebElement cartButton;

    @FindBy(xpath = "//img[contains(@src,'bhinneka-logo')]//parent::a//following-sibling::div")
    private WebElement bhinnekaCopyrightFooter;

    //@FindBy(xpath = "//span[contains(text(),'Login')]//parent::button")
    //this element for check if the test failed
    @FindBy(xpath = "//span[contains(text(),'Login')]//parent::div")
    private WebElement loginButton;

    public boolean defaultHomePageIsDisplayed() {

        headerLogoButton.isDisplayed();
        searchInput.isDisplayed();
        cartButton.isDisplayed();
        bhinnekaCopyrightFooter.isDisplayed();
        return true;
    }

    public void clickLoginButton() {

        loginButton.isDisplayed();
        loginButton.isEnabled();
        loginButton.click();
    }

    public void clickCartButton() {

        cartButton.isEnabled();
        cartButton.click();
    }

    public void setSearchInput(String product) {

        searchInput.isEnabled();
        searchInput.click();
        searchInput.sendKeys(product);
    }

    @FindBy(xpath = "//div[contains(@placeholder,'Cari produk asli')]//div//a")
    private WebElement searchProductLink;

    public String getSearchProductLink() {

        searchProductLink.isDisplayed();
        return searchProductLink.getText();
    }
}
