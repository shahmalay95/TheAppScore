package Tests;

import Pages.PlayerPage;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PlayerTest extends BaseClass{



//    @Parameters({"player"})
    @Test(priority = 0)
    public void search_Player() throws InterruptedException {
        PlayerPage playerPage = new PlayerPage(getDriver());

        // get started with initial steps and navigate to home screen
        playerPage.getStarted();

        // search a player
        playerPage.search_a_player("Tiger Wood");

        // verify that searched player is displayed
        Assert.assertTrue(playerPage.verify_player_displayed("Tiger Wood"));

        // see player stats
        playerPage.open_player_stats();

        // verify that player stats are displayed
        Assert.assertTrue(playerPage.player_stats_table.isDisplayed());

        // navigate back
        playerPage.navigate_back();
    }
}
