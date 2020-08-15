package marsrover;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MarsRoverTest {

    private MarsRover marsRover = new MarsRover();
    private Parser parser = new Parser();
    private MaxArea maxArea = new MaxArea();
    private Position position = new Position();
    private List<String> movingDirections;

    private String movingDirection = "LMLMLMLMM";
    private String currentPosString = "1 2 N";
    private String maxAreaString = "5 5";

    @Before
    public void setUp() {
        maxArea = parser.parseMaxArea(maxAreaString);
        position = parser.parsePosition(currentPosString);
        movingDirections = parser.parseMovingDirections(movingDirection);
    }

    @Test
    public void shouldBeEqual() {

        Position expectedPos = new Position();
        Direction expectedDirection = new Direction();
        expectedPos.setyPosition(3);
        expectedPos.setxPosition(1);
        expectedDirection.setMoveDirection("N");
        expectedPos.setDirection(expectedDirection);

        assertEquals(marsRover.getLastPosition(movingDirections, position, maxArea).toString().trim(), expectedPos.toString().trim());
    }

    @Test
    public void shouldNotBeEqual() {

        Position expectedPos = new Position();
        Direction expectedDirection = new Direction();
        expectedPos.setyPosition(3);
        expectedPos.setxPosition(1);
        expectedDirection.setMoveDirection("S");
        expectedPos.setDirection(expectedDirection);

        assertNotEquals(marsRover.getLastPosition(movingDirections, position, maxArea).toString().trim(), expectedPos.toString().trim());
    }

}
