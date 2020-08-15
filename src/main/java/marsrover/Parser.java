package marsrover;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    MaxArea maxArea = new MaxArea();
    Position currentPos = new Position();
    Direction currentDirection = new Direction();

    public MaxArea parseMaxArea(String matrisSize1) {
        maxArea.setMaxXPosition(Integer.parseInt(matrisSize1.substring(0, 1)));
        maxArea.setMaxYPosition(Integer.parseInt(matrisSize1.substring(2, 3)));
        return maxArea;
    }

    public Position parsePosition(String currentPosition) {
        currentPos.setxPosition(Integer.parseInt(currentPosition.substring(0, 1)));
        currentPos.setyPosition(Integer.parseInt(currentPosition.substring(2, 3)));
        currentDirection.setMoveDirection(currentPosition.substring(4, 5));
        currentPos.setDirection(currentDirection);
        return currentPos;
    }

    public List<String> parseMovingDirections(String movingDirection){

        char[] ch = movingDirection.toCharArray();
        List<String> movingDirections = new ArrayList<>();

        for (char c : ch) {
            movingDirections.add(String.valueOf(c));
        }

        return movingDirections;
    }
}
