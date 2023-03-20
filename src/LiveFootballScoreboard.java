import java.util.*;

class LiveFootballScoreboard {
private TreeMap<Integer, FootballMatch> inProgress; // matches in progress, sorted by score
private HashMap<Integer, FootballMatch> finished; // finished matches, keyed by finish time

public LiveFootballScoreboard() {
    inProgress = new TreeMap<>(Collections.reverseOrder());
    finished = new HashMap<>();
}


/**
 * Starts a new match with the given home and away teams. If a match is already in progress, an error message is printed.
 *
 * @param home the name of the home team
 * @param away the name of the away team
 */
public void startNewMatch(String home, String away) {
    if (!inProgress.isEmpty()) {
        System.out.println("Cannot start a new match while another match is in progress.");
        return;
    }
    
    FootballMatch match = new FootballMatch(home, away,0,0);
    inProgress.put(0, match);
}

/**
 * Updates the score for the current match in progress.
 * If no match is in progress, an error message is printed.
 *
 * @param homeScore The updated score for the home team
 * @param awayScore The updated score for the away team
 */
public void updateScore(int homeScore, int awayScore) {
    if (inProgress.isEmpty()) {
        System.out.println("No match is currently in progress to update the score.");
        return;
    }

    // get the current match
    FootballMatch currentMatch = inProgress.firstEntry().getValue();
    

    // update the score
    currentMatch.setHomeScore(homeScore);;
    currentMatch.setAwayScore(awayScore);
}

public TreeMap<Integer, FootballMatch> getInProgress() {
    return inProgress;
}

public HashMap<Integer, FootballMatch> getFinished() {
    return finished;
}



/**
 * This method finishes the current football match in progress and moves it to the finished matches map.
 * If no match is in progress, an error message is printed.
 */
public void finishMatch() {
    if (inProgress.isEmpty()) {
        System.out.println("No match is currently in progress to finish.");
        return;
    }

    // get the current match
    FootballMatch currentMatch = inProgress.firstEntry().getValue();

    // move the match to the finished matches map
    finished.put(finished.size(), currentMatch);
    inProgress.remove(inProgress.firstKey());
}


/**
 * Compares two football matches based on their total score, with ties broken using their hash codes.
 * If the total scores of the matches are different, the match with the higher total score comes first.
 * If the total scores are the same, the match with the higher hash code comes first.
 * @param a the first match to compare
 * @param b the second match to compare
 * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second
 */
public static int compareMatches(FootballMatch a, FootballMatch b) {
    int aTotalScore = a.getHomeScore() + a.getAwayScore();
    int bTotalScore = b.getHomeScore() + b.getAwayScore();
    if (aTotalScore != bTotalScore) {
        return Integer.compare(bTotalScore, aTotalScore);
    } else {
        return Integer.compare(b.hashCode(), a.hashCode());
    }
}


/**
 * Prints a list of matches in progress and finished matches sorted by score in descending order.
 * If there are no matches in progress or finished matches, "None" is printed for that section.
 */
public void getSummary() {
    System.out.println("Matches in progress:");
    if (inProgress.isEmpty()) {
        System.out.println("None");
    } else {
        for (FootballMatch match : inProgress.values()) {
            System.out.println(match.getHomeTeam() + " " + match.getHomeScore() + " - " + match.getAwayScore() + " " + match.getAwayTeam());
        }
    }

    System.out.println("Finished matches:");
    if (finished.isEmpty()) {
        System.out.println("None");
    } else {
        // Create a list of finished matches to sort them by score
        List<FootballMatch> sortedMatches = new ArrayList<>(finished.values());
        // Sort the finished matches in descending order of their total score, with the most recent match first
        Collections.sort(sortedMatches, LiveFootballScoreboard::compareMatches);
        for (FootballMatch match : sortedMatches) {
        	System.out.println(match.getHomeTeam() + " " + match.getHomeScore() + " - " + match.getAwayScore() + " " + match.getAwayTeam());
        }
    }
}
}
