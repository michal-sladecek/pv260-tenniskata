import java.util.Formatter;
import java.util.HashMap;

public class Tennis {
    int scoreA=0;
    int scoreB=0;
    Winner winner = Winner.NONE;
    private Advantage advantage = Advantage.NONE;
    private HashMap<Integer, Integer> nextScore = new HashMap<>();

    public Tennis() {
        nextScore.put(0,15);
        nextScore.put(15,30);
        nextScore.put(30,40);

    }

    public String showScore(){
        Formatter f = new Formatter();

        if (advantage == Advantage.A) {
            return f.format("A - %d", scoreB).toString();
        }
        if (advantage == Advantage.B) {
            return f.format("%d - A", scoreA).toString();
        }
        if(scoreA == 40 && scoreA == scoreB){
            return f.format("deuce").toString();
        }
        if(scoreA == scoreB){
            return f.format("%d all",scoreA).toString();
        }
        return f.format("%d - %d", scoreA, scoreB).toString();
    }

    public int getScoreA() {
        return scoreA;
    }

    public int getScoreB() {
        return scoreB;
    }



    public void scoredA(){
        if(this.hasBAdvantage()){
            advantage = Advantage.NONE;
        }
        else if(advantage==Advantage.A){
            winner = Winner.A;
        }
        else if(scoreA == 40 && scoreB == 40){
            advantage = Advantage.A;
        }
        else if(scoreA == 40) {
            winner = Winner.A;
        }
        else if(nextScore.containsKey(scoreA))
            scoreA = nextScore.get(scoreA);
    }

    public void scoredB(){
        if(this.hasAAdvantage()){
            advantage = Advantage.NONE;
        }
        else if(advantage==Advantage.B){
            winner = Winner.B;
        }
        else if(scoreA == 40 && scoreB == 40){
            advantage = Advantage.B;
        }
        else if(scoreB == 40) {
            winner = Winner.B;
        }
        else if(nextScore.containsKey(scoreB))
            scoreB = nextScore.get(scoreB);
    }

    public boolean isAWinner() {
        return winner == Winner.A;
    }
    public boolean isBWinner() {
        return winner == Winner.B;
    }

    public boolean hasAAdvantage(){
        return advantage == Advantage.A;
    }
    public boolean hasBAdvantage(){
        return advantage == Advantage.B;
    }

    enum Winner {
        NONE,
        A,
        B
    }

    enum Advantage {
        NONE,
        A,
        B
    }
}
