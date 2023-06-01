package Pages;

import Tests.BaseClass;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class TeamPage extends BaseClass {

    public TeamPage(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

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

    @FindBy(id = "com.fivemobile.thescore:id/search_bar_text_view")
    public WebElement search_bar;

    @FindBy(id = "com.fivemobile.thescore:id/search_src_text")
    public WebElement search_bar_input_field;

    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Teams\"]")
    public WebElement teams_tab;

    @FindBy(id = "com.fivemobile.thescore:id/txt_name")
    public WebElement team_in_List;

    @FindBy(id = "com.fivemobile.thescore:id/team_name")
    public WebElement team_name_header;

    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Team Stats\"]")
    public WebElement team_stats_tab;

    @FindBy(id = "com.fivemobile.thescore:id/recyclerView")
    public WebElement team_stats_table;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    public WebElement back_Arrow_Btn;

    @FindBy(id = "com.fivemobile.thescore:id/dismiss_modal")
    public  WebElement dissmis_Model;

    public void getStarted() throws InterruptedException {
        waitForElementToBeVisible(Get_Started_Btn);
        Assert.assertTrue(Get_Started_Btn.isDisplayed());
        Get_Started_Btn.isEnabled();
        Get_Started_Btn.click();
        waitForElementToBeVisible(Continue_Btn);
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
        Thread.sleep(20);
    }

    public void search_a_team(String team){
        waitForElementToBeVisible(search_bar);
        search_bar.click();
        waitForElementToBeVisible(search_bar_input_field);
        search_bar_input_field.sendKeys(team);
        waitForElementToBeVisible(team_in_List);
        teams_tab.click();
        waitForElementToBeVisible(team_in_List);
        team_in_List.click();
        waitForElementToBeVisible(team_stats_tab);
    }

    public boolean verify_team_displayed(String team_name){
        waitForElementToBeVisible(team_name_header);
        return team_name_header.getText().contains(team_name);
    }

    public void open_teams_stats(){
        team_stats_tab.click();
        waitForElementToBeVisible(team_stats_table);
    }

    public void navigate_back(){
        waitForElementToBeVisible(back_Arrow_Btn);
        back_Arrow_Btn.click();
        waitForElementToBeVisible(team_in_List);
        Assert.assertTrue(team_in_List.isDisplayed());
    }

    public void waitForElementToBeVisible(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue(element.isDisplayed());
    }
}
