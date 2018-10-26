package MazeProject;

/**
 *
 * @author Elliott Ruebush
 */
public class BetterPoint {
    private int xVal;
    private int yVal;

    /**
     * Constructor for BetterPoints that directly takes two ints.
     * @param x
     * @param y
     */
    public BetterPoint(int x, int y){
        this.xVal = x;
        this.yVal = y;
    }

    /**
     * Constructor for BetterPoints that takes another points. (This was created so that I could create new unique
     * pointers for each BetterPoint object in my stack)
     * @param p
     */
    public BetterPoint(BetterPoint p){
        xVal = p.getX();
        yVal = p.getY();
    }

    /**
     * Constructor that takes no parameters and simply initializes a BetterPoint(might be a redundant constructor).
     */
    public BetterPoint(){

    }

    /**
     * Sets the x and y values for the location of a BetterPoint
     * @param x
     * @param y
     */
    public void setLocation(int x, int y){
        xVal = x;
        yVal = y;
    }

    /**
     * Sets the location of x and y values of one BetterPoint to be the x and y values of another point. Again, I don't know
     * if this is needed but it makes it so you only need one method call instead of the two(You would need to setX to
     * (otherPoint.getX()) and setY to(otherPoint.getY())).
     * @param p
     */
    public void setLocation(BetterPoint p){
        xVal = p.getX();
        yVal = p.getY();
    }

    /**
     * Sets x value of a BetterPoint
     * @param x
     */
    public void setX(int x){
        xVal = x;
    }

    /**
     * Sets y value of a BetterPoint
     * @param y
     */
    public void setY(int y){
        yVal = y;
    }

    /**
     * Gets x value of a BetterPoint
     * @return
     */
    public int getX(){
        return xVal;
    }

    /**
     * Gets y value of a BetterPoint
     * @return
     */
    public int getY(){
        return yVal;
    }

    /**
     * Returns a string with a classic (x, y) format of x and y values of a BetterPoint.
     * @return "(5, 3)"
     */
    public String print(){
        return "(" + xVal + ", " + yVal + ")";
    }

    /**
     * Compares x and y values of two BetterPoints to determine if they are equal.
     * @param p
     * @return true
     */
    public boolean equals(BetterPoint p){
        if(this.getX() == p.getX() && this.getY() == p.getY()){
            return true;
        }else{
            return false;
        }
    }
}