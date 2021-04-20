import java.util.HashMap;

public class Tennis {
    int scoreA=0;
    int scoreB=0;
    Winner winner = Winner.NONE;
    private HashMap<Integer, Integer> nextScore = new HashMap<>();


    public Tennis() {
        nextScore.put(0,15);
        nextScore.put(15,30);
        nextScore.put(30,40);

    }

    public int getScoreA() {
        return scoreA;
    }

    public int getScoreB() {
        return scoreB;
    }



    public void scoredA(){
        if(scoreA == 40 && scoreB != 40) {
            winner = Winner.A;
            return;
        }
        if(nextScore.containsKey(scoreA))
            scoreA = nextScore.get(scoreA);
    }

    public void scoredB(){
        if(scoreA != 40 && scoreB == 40) {
            winner = Winner.B;
            return;
        }
        if(nextScore.containsKey(scoreB))
            scoreB = nextScore.get(scoreB);
    }

    public boolean isAWinner() {
        return winner == Winner.A;
    }
    public boolean isBWinner() {
        return winner == Winner.B;
    }
    enum Winner {
        NONE,
        A,
        B
    }
}
