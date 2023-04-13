/**
 * The Point class represent object with x,y coordinates
 * @author Itay getahun
 * id 315573667
 * @version 07/04/23
 * id 315573667
 */
public class Point {

    private int _x;
    private int _y;
    private static final int MINIMUM_VALID = 0;

    /**
     * gets the x coordinate
     * @return the x coordinate
     */
    public int getX() {
        return _x;
    }

    /**
     * gets the y coordinate
     *
     * @return the y coordinate
     */
    public int getY() {
        return _y;
    }

    /**
     * sets the x coordinate if valid
     */
    public void setX(int num) {
        if (isValidCoordinate(num)) {
            this._x = num;
        }
    }

    /**
     * sets the y coordinate if valid
     */
    public void setY(int num) {
        if (isValidCoordinate(num)) {
            this._y = num;
        }
    }

    /**
     * creates a new Point object
     * @param x the x coordinate initialize with default value if not valid
     * @param y the y coordinate initialize with default value if not valid
     */
    public Point(int x, int y) {
        this._x = 0;
        this._y = 0;
        setX(x);
        setY(y);
    }

    /**
     * copy constructor creates a new Point object from existing one's values
     * @param other the point which you want to copy from
     */
    public Point(Point other) {
        setY(other.getY());
        setX(other.getX());
    }

    /**
     * @return String that represents point object
     * in the following format: (x,y)
     */
    public String toString() {
        return "(" + getX() + "," + getY() + ")";
    }

    /**
     * validate the coordinate
     *
     * @param value the value to check
     * @return a boolean True if valid and False if not
     */

    private boolean isValidCoordinate(int value) {
        return value >= MINIMUM_VALID;
    }

    /**
     * check if two points are equal
     * @param other the point object to check
     * @return a boolean True if valid and False if not
     */
    public boolean equals(Point other) {
        return getX() == other.getX() && getY() == other.getY();
    }

    /**
     * check if a point is above other point
     *
     * @param other the point object to check
     * @return a boolean True if above and False if not
     */
    public boolean isAbove(Point other) {
        return getY() > other.getY();
    }

    /**
     * check if a point is under other point
     *
     * @param other the point object to check
     * @return a boolean True if under and False if not
     */
    public boolean isUnder(Point other) {
        return other.isAbove(this);
    }

    /**
     * check if a point is lefter than other point
     *
     * @param other the point object to check
     * @return a boolean True if left and False if not
     */
    public boolean isLeft(Point other) {
        return getX() < other.getX();
    }

    /**
     * check if a point is righter than other point
     *
     * @param other the point object to check
     * @return a boolean True if righter and False if not
     */
    public boolean isRight(Point other) {
        return other.isLeft(this);
    }

    /**
     * move point's coordinate if valid
     *
     * @param deltaX the x coordinate to move
     * @param deltaY the y coordinate to move
     */
    public void move(int deltaX, int deltaY) {
        if (isValidCoordinate(getX() + deltaX) && (isValidCoordinate(getY() + deltaY))) {
            setX(getX() + deltaX);
            setY(getY() + deltaY);
        }
    }

    /**
     * creates a new point object in the middle of two given points
     * @param p the second point
     * @return a new point in the middle of two
     */
    public Point middle(Point p) {
        int middleX = (getX() + p.getX()) / 2;
        int middleY = (getY() + p.getY()) / 2;
        return new Point(middleX, middleY);
    }
    /**
     * calculates the distance between two points
     * @param p the second point
     * @return the distance between two points
     */
    public double distance(Point p) {
        return Math.sqrt(Math.pow(getX() - p.getX(), 2) + Math.pow(getY() - p.getY(), 2));
    }
}
