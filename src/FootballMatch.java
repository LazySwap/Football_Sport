
public class FootballMatch {
    private String homeTeam;
    private String awayTeam;
    private int homeScore;
    private int awayScore;

    public FootballMatch(String home, String away, int homeScore, int awayScore) {
    	
    	if (home == null || home.trim().isEmpty()) {
            throw new IllegalArgumentException("Home team cannot be empty");
        }
        if (away == null || away.trim().isEmpty()) {
            throw new IllegalArgumentException("Away team cannot be empty");
        }
        
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


	