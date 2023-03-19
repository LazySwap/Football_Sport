
public class Sportradar {

	public static void main(String[] args) {
	    LiveFootballScoreboard scoreboard = new LiveFootballScoreboard();

	    scoreboard.startNewMatch("Mexico", "Canada");
	    scoreboard.updateScore(0, 5);
	    scoreboard.finishMatch();

	    scoreboard.startNewMatch("Spain", "Brazil");
	    scoreboard.updateScore(10, 2);
	    scoreboard.finishMatch();

	    scoreboard.startNewMatch("Germany", "France");
	    scoreboard.updateScore(2, 2);
	    scoreboard.finishMatch();

	    scoreboard.startNewMatch("Uruguay", "Italy");
	    scoreboard.updateScore(6, 6);
	    scoreboard.finishMatch();

	    scoreboard.startNewMatch("Argentina", "Australia");
	    scoreboard.updateScore(3, 1);
	    scoreboard.finishMatch();
	    
	    scoreboard.startNewMatch("India", "Australia");
	    scoreboard.updateScore(33, 1);
	    scoreboard.finishMatch();

	    scoreboard.getSummary();
	}
}
