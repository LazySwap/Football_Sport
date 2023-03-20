
public class Sportradar {

	public static void main(String[] args) {
		
		try
		{
		 LiveFootballScoreboard scoreboard = new LiveFootballScoreboard();

		    String[][] matchDetails = {
		            {"Mexico", "Canada", "5", "0"},
		            {"Spain", "Brazil", "10", "2"},
		            {"Germany", "France", "2", "2"},
		            {"Uruguay", "Italy", "6", "6"},
		            {"Argentina", "Australia", "3", "1"}
		        };

		        for (String[] details : matchDetails) {
		            String home = details[0];
		            String away = details[1];
		            int homeScore = Integer.parseInt(details[2]);
		            int awayScore = Integer.parseInt(details[3]);

		            scoreboard.startNewMatch(home, away);
		            scoreboard.updateScore(homeScore, awayScore);
		            scoreboard.finishMatch();
		        }
		        
		        scoreboard.getSummary();
		} catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Not enough arguments passed to create LiveFootballScoreboard object.");
        }
	   
	}
}
