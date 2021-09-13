import rover.Plateau;
import rover.Position;
import rover.Rover;

public class Main {
    public static void main(String[] args) {
    Plateau plateau = new Plateau(5,5);
    Position position = new Position(1,2);
    String compass = "N";
    Rover rover = new Rover(plateau,position,compass);
    rover.runCommands("LMLMLMLMM");
        System.out.print(rover.getPosition().getX() + " ");
        System.out.print(rover.getPosition().getY() + " ");
        System.out.print(rover.getCompass());
    }
}
