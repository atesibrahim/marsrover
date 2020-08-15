package marsrover;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {


        System.out.println("Please enter size of matris1. Please leave space between size");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String matrisSize1 = in.readLine();
        System.out.println("Please enter current position of first rover");
        String currentPosition1 = in.readLine();
        System.out.println("Please enter moving direction for first rover");
        String movingDirection1 = in.readLine();
        System.out.println("Please enter current position of second rover");
        String currentPosition2 = in.readLine();
        System.out.println("Please enter moving direction for second rover");
        String movingDirection2 = in.readLine();


        in.close();

        MaxArea maxArea;
        Position currentPos;
        MarsRover marsRover = new MarsRover();
        Parser parser = new Parser();

        maxArea = parser.parseMaxArea(matrisSize1);

        currentPos = parser.parsePosition(currentPosition1);


        List<String> movingDirectionArray =  parser.parseMovingDirections(movingDirection1);


        System.out.println("Output for rovers are :");

        System.out.println(marsRover.getLastPosition(movingDirectionArray, currentPos, maxArea));

        currentPos = parser.parsePosition(currentPosition2);

        
        movingDirectionArray.clear();

        movingDirectionArray = parser.parseMovingDirections(movingDirection2);

        System.out.print(marsRover.getLastPosition(movingDirectionArray, currentPos, maxArea));


    }
}
