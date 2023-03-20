# LiveFootballScoreboard

The LiveFootballScoreboard is a Java program that allows you to manage and display live football scores for matches in progress, as well as finished matches. You can start new matches, update the score for the current match in progress, and finish matches. The scoreboard displays the matches in progress and finished matches sorted by score in descending order.

## How to Run the Program

To run the LiveFootballScoreboard program, you can follow these steps:

1. Open the program in your favorite Java IDE, such as Eclipse or IntelliJ IDEA.
2. Compile the program by clicking on the "Run" or "Build" button.
3. Run the program by clicking on the "Run" button.

Alternatively, you can compile and run the program from the command line using the following commands:

javac LiveFootballScoreboard.java

java LiveFootballScoreboard



## How to Use the Program

The LiveFootballScoreboard program has three main methods that you can use:

- `startNewMatch(String home, String away)`: Starts a new match with the given home and away teams. If a match is already in progress, an error message is printed.
- `updateScore(int homeScore, int awayScore)`: Updates the score for the current match in progress. If no match is in progress, an error message is printed.
- `finishMatch()`: Finishes the current match in progress and moves it to the finished matches list. If no match is in progress, an error message is printed.

To see a summary of the matches in progress and finished matches, you can call the `getSummary()` method, which will print out the matches sorted by score in descending order.

## Testing the Program

The LiveFootballScoreboard program includes a test suite that you can run to make sure the program is working correctly. To run the test suite, you can follow these steps:

1. Open the program in your favorite Java IDE, such as Eclipse or IntelliJ IDEA.
2. Navigate to the test file, `LiveFootballScoreboardTest.java`.
3. Run the test suite by clicking on the "Run" button next to the test class.


