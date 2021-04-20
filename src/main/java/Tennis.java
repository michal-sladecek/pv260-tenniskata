import java.util.HashMap;

public class Tennis {
    int scoreA=0;
    int scoreB=0;
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
        if(nextScore.containsKey(scoreA))
            scoreA = nextScore.get(scoreA);
    }

    public void scoredB(){
        if(nextScore.containsKey(scoreB))
            scoreB = nextScore.get(scoreB);
    }
}
