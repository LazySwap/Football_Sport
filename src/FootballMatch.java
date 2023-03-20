
public class FootballMatch {
    private String homeTeam;
    private String awayTeam;
    private int homeScore;
    private int awayScore;

    
    /**

    Constructor to create a new FootballMatch object with the given parameters.
    @param home the name of the home team
    @param away the name of the away team
    @param homeScore the score of the home team
    @param awayScore the score of the away team
    @throws IllegalArgumentException if the home or away team name is empty or null, or if the score is negative.
    
    */

    public FootballMatch(String home, String away, int homeScore, int awayScore) {
    	
    	// Check if the home team name is not empty or null
    	if (home == null || home.trim().isEmpty()) {
            throw new IllegalArgumentException("Home team cannot be empty");
        }
    	
    	// Check if the away team name is not empty or null
        if (away == null || away.trim().isEmpty()) {
            throw new IllegalArgumentException("Away team cannot be empty");
        }
        
        
        // Check if the score is not negative
        if (homeScore < 0 || awayScore < 0) {
            throw new IllegalArgumentException("Score cannot be negative.");
        }
        
        this.homeTeam = home;
        this.awayTeam = away;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }
    
    public FootballMatch(String home, String away) {
        if (home == null || home.trim().isEmpty()) {
            throw new IllegalArgumentException("Home team cannot be empty");
        }
        if (away == null || away.trim().isEmpty()) {
            throw new IllegalArgumentException("Away team cannot be empty");
        }
        this.homeTeam = home;
        this.awayTeam = away;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }
    
    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public void setHomeScore(int homeScore) throws IllegalArgumentException {
        if (homeScore < 0) {
            throw new IllegalArgumentException("Score cannot be negative.");
        }
        this.homeScore = homeScore;
    }

    public void setAwayScore(int awayScore) throws IllegalArgumentException {
        if (awayScore < 0) {
            throw new IllegalArgumentException("Score cannot be negative.");
        }
        this.awayScore = awayScore;
    }


}


	