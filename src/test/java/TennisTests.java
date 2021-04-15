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
}
