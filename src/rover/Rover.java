package rover;

import java.util.HashMap;
import java.util.Map;

public class Rover implements Direction {
    private Plateau plateau;
    private Position position;
    private String compass;
    int posX = 0;
    int posY = 0;
    Map<String, String> dictionaryLeft = new HashMap<String, String>();
    Map<String, String> dictionaryRight = new HashMap<String, String>();

    public Rover(Plateau plateau, Position position, String compass) {
        this.plateau = plateau;
        this.position = position;
        this.compass = compass;

        //turn left
        dictionaryLeft.put("N"  , "W");
        dictionaryLeft.put("W","S");
        dictionaryLeft.put("S","E");
        dictionaryLeft.put("E","N");

        //turn right
        dictionaryRight.put("N","E");
        dictionaryRight.put("E","S");
        dictionaryRight.put("S","W");
        dictionaryRight.put("W","N");

    }

    public Plateau getPlateau() {
        return plateau;
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getCompass() {
        return compass;
    }

    public void setCompass(String compass) {
        this.compass = compass;
    }

    public void runCommands(String commands){
        for (char i : commands.toCharArray()){
            inputCommands(i);
        }
    }
    public void inputCommands(char command) {
        if (command == 'L'){
            turnLeft();
        }else if(command == 'R'){
            turnRight();
        }else if(command == 'M') {
            move();
        }else{
            System.out.println("Command is not valid !");
        }
    }

    @Override
    public void turnLeft() {
        compass = dictionaryLeft.get(compass);
    }

    @Override
    public void turnRight() {
        compass = dictionaryRight.get(compass);
    }

    @Override
    public void move() {
        if (compass.equals("N")) {
            increaseY();
        }else if (compass.equals("E")){
            increaseX();
        }else if (compass.equals("S")){
            decreaseY();
        }else if (compass.equals("W")){
            decreaseX();
        }
    }
    public void decreaseX(){
        if (position.getX() - 1 < plateau.getMinWidth()){
            throw new ArrayIndexOutOfBoundsException("You are trying to go out of the plateau");
        }else {
            posX = position.getX();
            posX -= 1;
            position.setX(posX);
        }
    }
    public void decreaseY(){
        if (position.getY() - 1 < plateau.getMinHeight()){
            throw new ArrayIndexOutOfBoundsException("You are trying to go out of the plateau");
        }else {
            posY = position.getY();
            posY -= 1;
            position.setY(posY);
        }
    }
    public void increaseX(){
        if(position.getX() + 1 > plateau.getWidth()){
            throw new ArrayIndexOutOfBoundsException("You are trying to go out of the plateau");
        }else{
            posX = position.getX();
            posX += 1;
            position.setX(posX);
        }
    }
    public void increaseY(){
        if(position.getY() + 1 > plateau.getHeight()){
            throw new ArrayIndexOutOfBoundsException("You are trying to go out of the plateau");
        }else{
            posY = position.getY();
            posY +=  1;
            position.setY(posY);
        }
    }
}
