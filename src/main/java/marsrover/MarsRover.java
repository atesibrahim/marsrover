package marsrover;

import java.util.List;

public class MarsRover {


    public Position getLastPosition(List<String> movingDirections, Position position, MaxArea maxArea) {

        int end = 0;

        while (end < movingDirections.size()) {
            if (movingDirections.get(end).equals(position.getDirection().getRIGHTDIRECTION())) {

                position.setDirection(checkConditionForRightDirection(position.getDirection()));

            } else if (movingDirections.get(end).equals(position.getDirection().getLEFTDIRECTION())) {

                position.setDirection(checkConditionForLeftDirection(position.getDirection()));

            } else if (movingDirections.get(end).equals(position.getDirection().getMOVEFORWARD())) {

                checkConditionForMoveCommand(position, maxArea);
            }
            end++;
        }

        return position;
    }

    public void checkConditionForMoveCommand(Position position, MaxArea maxArea) {
        if (position.getDirection().getMoveDirection().equals(position.getDirection().getNORTH()) && position.getyPosition() < maxArea.getMaxYPosition()) {
            position.setyPosition(position.getyPosition() + 1);

        } else if (position.getDirection().getMoveDirection().equals(position.getDirection().getSOUTH()) && position.getyPosition() > 0) {
            position.setyPosition(position.getyPosition() - 1);

        } else if (position.getDirection().getMoveDirection().equals(position.getDirection().getEAST()) && position.getxPosition() < maxArea.getMaxXPosition()) {
            position.setxPosition(position.getxPosition() + 1);

        } else if (position.getDirection().getMoveDirection().equals(position.getDirection().getWEST()) && position.getxPosition() > 0) {
            position.setxPosition(position.getxPosition() - 1);

        }
    }

    public Direction checkConditionForLeftDirection(Direction currentDirection) {
        if (currentDirection.getMoveDirection().equals(currentDirection.getNORTH())) {

            currentDirection.setMoveDirection(currentDirection.getWEST());

        } else if (currentDirection.getMoveDirection().equals(currentDirection.getSOUTH())) {

            currentDirection.setMoveDirection(currentDirection.getEAST());

        } else if (currentDirection.getMoveDirection().equals(currentDirection.getEAST())) {

            currentDirection.setMoveDirection(currentDirection.getNORTH());

        } else if (currentDirection.getMoveDirection().equals(currentDirection.getWEST())) {

            currentDirection.setMoveDirection(currentDirection.getSOUTH());

        }
        return currentDirection;
    }

    public Direction checkConditionForRightDirection(Direction currentDirection) {
        if (currentDirection.getMoveDirection().equals(currentDirection.getNORTH())) {

            currentDirection.setMoveDirection(currentDirection.getEAST());

        } else if (currentDirection.getMoveDirection().equals(currentDirection.getSOUTH())) {

            currentDirection.setMoveDirection(currentDirection.getWEST());

        } else if (currentDirection.getMoveDirection().equals(currentDirection.getEAST())) {

            currentDirection.setMoveDirection(currentDirection.getSOUTH());
        } else if (currentDirection.getMoveDirection().equals(currentDirection.getWEST())) {

            currentDirection.setMoveDirection(currentDirection.getNORTH());

        }
        return currentDirection;
    }
}
