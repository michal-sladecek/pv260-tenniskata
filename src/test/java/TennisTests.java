import org.junit.Test;

import static com.googlecode.catchexception.CatchException.catchException;
import static java.util.Arrays.asList;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

public class TennisTests {
    @Test
    public void testPlayersStartWithZeroPoints() {
        Tennis tennis = new Tennis();
        assertEquals(0,tennis.getScoreA());
        assertEquals(0,tennis.getScoreB());
    }
    @Test
    public void testPlayerScoreNonEqual() {
        Tennis tennis = new Tennis();
        tennis.scoredA();
        assertEquals(15,tennis.getScoreA());
        assertEquals(0,tennis.getScoreB());
        tennis.scoredA();
        assertEquals(30,tennis.getScoreA());
        assertEquals(0,tennis.getScoreB());
        tennis.scoredA();
        assertEquals(40,tennis.getScoreA());
        assertEquals(0,tennis.getScoreB());
        tennis.scoredB();
        assertEquals(40,tennis.getScoreA());
        assertEquals(15,tennis.getScoreB());
        tennis.scoredB();
        assertEquals(40,tennis.getScoreA());
        assertEquals(30,tennis.getScoreB());
    }

    public void testPlayerWinsIfHeScoresWhenHeHas40Points(){
        Tennis tennis = new Tennis();
        tennis.scoredA();
        tennis.scoredA();
        tennis.scoredA();
        tennis.scoredA();
        assertEquals(true,tennis.isAWinner());
        assertEquals(false,tennis.isBWinner());

        tennis = new Tennis();
        tennis.scoredA();
        tennis.scoredA();
        tennis.scoredB();
        tennis.scoredA();
        tennis.scoredB();
        tennis.scoredA();
        assertEquals(true,tennis.isAWinner());
        assertEquals(false,tennis.isBWinner());


        tennis = new Tennis();
        tennis.scoredB();
        tennis.scoredB();
        tennis.scoredA();
        tennis.scoredB();
        tennis.scoredA();
        tennis.scoredB();
        assertEquals(true,tennis.isBWinner());
        assertEquals(false,tennis.isAWinner());

        tennis = new Tennis();
        tennis.scoredA();
        tennis.scoredB();
        tennis.scoredA();
        tennis.scoredB();
        tennis.scoredA();
        tennis.scoredB();
        tennis.scoredA();
        assertEquals(false,tennis.isBWinner());
        assertEquals(false,tennis.isAWinner());
    }

}
