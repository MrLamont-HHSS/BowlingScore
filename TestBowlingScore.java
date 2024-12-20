import org.junit.*;
import static org.junit.Assert.*;

public class TestBowlingScore {
    
    private BowlingScore game;

    @Before
    public void setUp(){
        game = new BowlingScore();
    }

    @After
    public void tearDown(){

    }

    @Test
    public void gutterGameTest(){
        // roll 20 zeros
        rollMany(0, 20);
        // get the score for the game
        int score = game.score();
        // check that the score is 0
        assertEquals(0, score);
    }

    @Test
    public void onesGameTest(){
        // roll 20 zeros
        rollMany(1, 20);
        // get the score for the game
        int score = game.score();
        // check that the score is 0
        assertEquals(20, score);
    }

    @Test
    public void normalGameTest(){
        game.roll(5);
        game.roll(2);
        game.roll(8);
        game.roll(1);
        rollMany(0, 16);
        int score = game.score();
        assertEquals(16, score);
    }

    @Test
    public void singleSpareTest(){
        // roll a spare
        game.roll(7);
        game.roll(3);
        // single roll for the bonus
        game.roll(5);
        // rest are 0
        rollMany(0,17);
        int score = game.score();
        assertEquals(20, score);
    }

    @Test
    public void twoSparesTest(){
        game.roll(7);
        game.roll(3);
        game.roll(5);
        game.roll(5);
        game.roll(2);
        rollMany(0, 15);
        int score = game.score();
        assertEquals(29,score);
    }


    @Test
    public void singleStrikeTest(){
        game.roll(10);
        game.roll(7);
        game.roll(2);
        rollMany(0, 016);
        int score = game.score();
        assertEquals(28, score);
    }

    @Test
    public void twoStrikeTest(){
        game.roll(10);
        game.roll(10);
        game.roll(5);
        game.roll(2);
        rollMany(0, 14);
        int score = game.score();
        assertEquals(49, score);
    }

    @Test
    public void threeStrikeTest(){
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(5);
        game.roll(2);
        rollMany(0, 12);
        int score = game.score();
        assertEquals(79, score);
    }

    @Test
    public void perfectGameTest(){
        rollMany(10, 12);
        int score = game.score();
        assertEquals(300, score);
    }

    // refactor rollMany method
    private void rollMany(int value, int numRolls){
        for(int i = 0; i < numRolls; i++){
            game.roll(value);
        }
    }

}
