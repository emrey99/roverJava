package rover;

public class Plateau {
    private int width;
    private int height;
    private int minHeight ;
    private int minWidth ;

    public Plateau(int width, int height) {
        this.width = width;
        this.height = height;
        this.minHeight = 0;
        this.minWidth = 0;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(int minHeight) {
        this.minHeight = minHeight;
    }

    public int getMinWidth() {
        return minWidth;
    }

    public void setMinWidth(int minWidth) {
        this.minWidth = minWidth;
    }
}
