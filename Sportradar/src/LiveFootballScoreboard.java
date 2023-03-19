import java.util.*;

class LiveFootballScoreboard {
private TreeMap<Integer, FootballMatch> inProgress; // matches in progress, sorted by score
private HashMap<Integer, FootballMatch> finished; // finished matches, keyed by finish time

public LiveFootballScoreboard() {
    inProgress = new TreeMap<>(Collections.reverseOrder());
    finished = new HashMap<>();
}

public void startNewMatch(String home, String away) {
    if (!inProgress.isEmpty()) {
        System.out.println("Cannot start a new match while another match is in progress.");
        return;
    }
    FootballMatch match = new FootballMatch(home, away);
    inProgress.put(0, match);
}

public void updateScore(int homeScore, int awayScore) {
    if (inProgress.isEmpty()) {
        System.out.println("No match is currently in progress to update the score.");
        return;
    }

    // get the current match
    FootballMatch currentMatch = inProgress.firstEntry().getValue();

    // update the score
    currentMatch.homeScore = homeScore;
    currentMatch.awayScore = awayScore;
}

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

//public static boolean compareMatches(FootballMatch a, FootballMatch b) {
//    int aTotalScore = a.homeScore + a.awayScore;
//    int bTotalScore = b.homeScore + b.awayScore;
//    if (aTotalScore != bTotalScore) {
//        return aTotalScore > bTotalScore;
//    } else {
//        return a.hashCode() > b.hashCode();
//    }
//}

public static int compareMatches(FootballMatch a, FootballMatch b) {
    int aTotalScore = a.homeScore + a.awayScore;
    int bTotalScore = b.homeScore + b.awayScore;
    if (aTotalScore != bTotalScore) {
        return bTotalScore - aTotalScore;
    } else {
        return b.hashCode() - a.hashCode();
    }
}


public void getSummary() {
    System.out.println("Matches in progress:");
    if (inProgress.isEmpty()) {
        System.out.println("None");
    } else {
        for (FootballMatch match : inProgress.values()) {
            System.out.println(match.homeTeam + " " + match.homeScore + " - " + match.awayScore + " " + match.awayTeam);
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
            System.out.println(match.homeTeam + " " + match.homeScore + " - " + match.awayScore + " " + match.awayTeam);
        }
    }
}
}
