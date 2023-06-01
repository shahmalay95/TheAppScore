package Tests;

import Pages.TeamPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TeamTest extends BaseClass{


//    @Parameters({"team"})
    @Test(priority = 0)
    public void search_team() throws InterruptedException {
        TeamPage teamPage = new TeamPage(getDriver());

        // complete initial steps
        teamPage.getStarted();

        // search a team
        teamPage.search_a_team("Barcelona");

        // verify that searched team is displayed
        Assert.assertTrue(teamPage.verify_team_displayed("Barcelona"));

        // see teams stats
        teamPage.open_teams_stats();

        // verify that teams stats are displayed
        Assert.assertTrue(teamPage.team_stats_table.isDisplayed());

        // navigate back
        teamPage.navigate_back();
    }
}
