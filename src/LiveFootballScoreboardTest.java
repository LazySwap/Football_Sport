
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LiveFootballScoreboardTest {

    private LiveFootballScoreboard scoreboard;

    @BeforeEach
    public void setup() {
        scoreboard = new LiveFootballScoreboard();
    }

    @Test
    public void testStartNewMatch() {
        scoreboard.startNewMatch("Team A", "Team B");
        assertEquals(1, scoreboard.getInProgress().size());
    }

    @Test
    public void testStartNewMatchWhileAnotherInProgress() {
        scoreboard.startNewMatch("Team A", "Team B");
        scoreboard.startNewMatch("Team C", "Team D");
        assertEquals(1, scoreboard.getInProgress().size());
        assertEquals(0, scoreboard.getFinished().size());
    }

    @Test
    public void testUpdateScore() {
        scoreboard.startNewMatch("Team A", "Team B");
        scoreboard.updateScore(1, 0);
        assertEquals(1, scoreboard.getInProgress().firstEntry().getValue().getHomeScore());
        assertEquals(0, scoreboard.getInProgress().firstEntry().getValue().getAwayScore());
    }

    @Test
    public void testUpdateScoreWhileNoInProgress() {
        scoreboard.updateScore(1, 0);
        assertEquals(0, scoreboard.getInProgress().size());
        assertEquals(0, scoreboard.getFinished().size());
    }

    @Test
    public void testFinishMatch() {
        scoreboard.startNewMatch("Team A", "Team B");
        scoreboard.finishMatch();
        assertEquals(0, scoreboard.getInProgress().size());
        assertEquals(1, scoreboard.getFinished().size());
    }

    @Test
    public void testFinishMatchWhileNoInProgress() {
        scoreboard.finishMatch();
        assertEquals(0, scoreboard.getInProgress().size());
        assertEquals(0, scoreboard.getFinished().size());
    }

    @Test
    public void testCompareMatches() {
        FootballMatch match1 = new FootballMatch("Team A", "Team B", 2, 1);
        FootballMatch match2 = new FootballMatch("Team C", "Team D", 1, 1);
        assertTrue(LiveFootballScoreboard.compareMatches(match1, match2) < 0);
    }


}

