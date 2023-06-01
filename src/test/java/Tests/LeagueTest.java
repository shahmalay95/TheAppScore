package Tests;

import Pages.LeaguePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LeagueTest extends BaseClass{



    @Test(priority = 0)
    public void Search_League() throws InterruptedException {
        LeaguePage leaguePage = new LeaguePage(getDriver());

        // follow strting steps and go home screen
        leaguePage.getStarted();

        // go my league tab
        leaguePage.clickOnLeaguesTab();

        // select NFL league
        leaguePage.select_NFL_league();

        // Verify that NFL league screen is displayed
        Assert.assertTrue(leaguePage.NFL_league_screen_displayed());

        leaguePage.navigate_back();
    }
}
