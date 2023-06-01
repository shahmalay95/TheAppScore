package Pages;

import Tests.BaseClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LeaguePage extends BaseClass {

    public LeaguePage(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }


    @FindBy(id = "com.fivemobile.thescore:id/navigation_leagues")
    public WebElement league_Tab;

    @FindBy(id = "com.fivemobile.thescore:id/header_right_text_container")
    public WebElement edit_Btn;

    @FindBy(id = "com.fivemobile.thescore:id/header_right_text")
    public WebElement done_edit_Btn;

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id='com.fivemobile.thescore:id/btn_primary']")
    public WebElement Get_Started_Btn;

    @FindBy(id = "com.fivemobile.thescore:id/btn_primary")
    public WebElement Continue_Btn;

    @FindBy(id = "com.fivemobile.thescore:id/btn_primary")
    public WebElement Done_Btn;

    @FindBy(id = "com.fivemobile.thescore:id/btn_disallow")
    public WebElement mayBe_Later_Btn;

    @FindBy(xpath = "(//android.widget.ImageView[@resource-id='com.fivemobile.thescore:id/follow_icon'])[1]")
    public WebElement Follow_Icon;

    @FindBy(xpath = "//android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]")
    public WebElement NFL_league;

    @FindBy(xpath = "//android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView")
    public WebElement NFL_league_Header;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    public WebElement back_Arrow_Btn;

    @FindBy(xpath = "(//android.widget.TextView[@text,'Quick Tip'])[3]")
    public WebElement tour_tip;

    @FindBy(id = "com.fivemobile.thescore:id/dismiss_modal")
    public  WebElement dissmis_Model;


    public void getStarted(){
        waitForElementToBeVisible(Get_Started_Btn);
        Assert.assertTrue(Get_Started_Btn.isDisplayed());
        Get_Started_Btn.isEnabled();
        Get_Started_Btn.click();
        Assert.assertTrue(Continue_Btn.isDisplayed());
        Continue_Btn.click();
        waitForElementToBeVisible(Follow_Icon);
        Assert.assertTrue(Follow_Icon.isDisplayed());
        Follow_Icon.isEnabled();
        Follow_Icon.click();
        Assert.assertTrue(Continue_Btn.isDisplayed());
        Continue_Btn.click();
        Assert.assertTrue(Done_Btn.isDisplayed());
        Done_Btn.click();
        waitForElementToBeVisible(dissmis_Model);
        dissmis_Model.click();
    }

    public void clickOnLeaguesTab() throws InterruptedException {
        waitForElementToBeVisible(league_Tab);
        league_Tab.click();
        waitForElementToBeVisible(edit_Btn);
        edit_Btn.click();
        waitForElementToBeVisible(NFL_league);
    }

    public void select_NFL_league(){
        Assert.assertTrue(NFL_league.isEnabled());
        NFL_league.click();
    }

    public boolean NFL_league_screen_displayed(){
        NFL_league_Header.isDisplayed();
        return NFL_league_Header.getText().contains("NFL");
    }

    public void navigate_back(){
        waitForElementToBeVisible(back_Arrow_Btn);
        back_Arrow_Btn.click();
        waitForElementToBeVisible(NFL_league);
        Assert.assertTrue(NFL_league.isDisplayed());
    }
    public void waitForElementToBeVisible(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue(element.isDisplayed());
    }
}

