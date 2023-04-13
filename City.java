/**
 * The City class represent a city with couple of details : Name ,Date Established , City Center point, Central Station
 * location
 * Number Of Residents and Number Of Neighborhoods
 * @author Itay getahun
 * id 315573667
 * @version 13/04/23
 */
public class City {
    private String _cityName;
    private Date _dateEstablished;
    private Point _cityCenter, _centralStation;
    private long _numOfResidents;
    private int _numOfNeighborhoods;
    private static final int MINIMUM_RESIDENTS = 0, MINIMUM_NEIGHBORHOODS = 1;

    /**
     *
     * constructor creates a City object
     * @param cityName          city's name
     * @param dayEstablished    day in month the city established at
     * @param monthEstablished  month the city established at
     * @param yearEstablished   year the city established at
     * @param cityCenterX       city's center X coordinate
     * @param cityCenterY       city's center Y coordinate
     * @param centralStationX   city's central station X coordinate
     * @param centralStationY   city's central station Y coordinate
     * @param numOfResidents    city's resident count or default
     * @param numOfNeighborhoods city's neighborhoods count or default
     */
    public City(String cityName, int dayEstablished, int monthEstablished, int yearEstablished, int cityCenterX,
                int cityCenterY, int centralStationX, int centralStationY, long numOfResidents, int numOfNeighborhoods) {
        this._cityName = cityName;
        this._dateEstablished = new Date(dayEstablished, monthEstablished, yearEstablished);
        this._cityCenter = new Point(cityCenterX, cityCenterY);
        this._centralStation = new Point(centralStationX, centralStationY);
        this._numOfResidents = Math.max(numOfResidents,MINIMUM_RESIDENTS);
        this._numOfNeighborhoods = Math.max(numOfNeighborhoods, MINIMUM_NEIGHBORHOODS);
    }

    /**
     * copy constructor creates a new City object from existing one's values
     *
     * @param other the City which you want to copy from
     */
    public City(City other) {
        this._cityName = String.valueOf(other.getCityName());
        this._dateEstablished = new Date(other.getDateEstablished());
        this._cityCenter = new Point(other.getCityCenter());
        this._centralStation = new Point(other.getCentralStation());
        this._numOfResidents = other.getNumOfResidents();
        this._numOfNeighborhoods = other.getNumOfNeighborhoods();
    }


    /**
     * @return City's name
     */
    public String getCityName() {
        return _cityName;
    }

    /**
     * @return City's established Date object copy
     */
    public Date getDateEstablished() {
        return new Date(this._dateEstablished);
    }

    /**
     * @return City's center's Point object copy
     */
    public Point getCityCenter() {
        return new Point(this._cityCenter);
    }

    /**
     * @return City's central station's Point object copy
     */
    public Point getCentralStation() {
        return new Point(this._centralStation);
    }

    /**
     * @return City's residents count
     */
    public long getNumOfResidents() {
        return _numOfResidents;
    }

    /**
     * @return City's neighborhoods count
     */
    public int getNumOfNeighborhoods() {
        return _numOfNeighborhoods;
    }

    /**
     * set City's name
     */
    public void setCityName(String cityName) {
        this._cityName = cityName;
    }

    /**
     * set City's established Date object  or deafult
     */
    public void setDateEstablished(Date dateEstablished) {
        this._dateEstablished = new Date(dateEstablished);
    }

    /**
     * set City's center's Point  or deafult
     */
    public void setCityCenter(Point cityCenter) {
        this._cityCenter = new Point(cityCenter);
    }

    /**
     * set City's central station's Point object  or deafult
     */
    public void setCentralStation(Point centralStation) {
        this._centralStation = new Point(centralStation);
    }

    /**
     * set City's residents count or deafult
     */
    public void setNumOfResidents(long numOfResidents) {
        if (numOfResidents >= MINIMUM_RESIDENTS) {
            this._numOfResidents = numOfResidents;
        } else {
            this._numOfResidents = MINIMUM_RESIDENTS;
        }
    }

    /**
     * set City's neighborhoods count or deafult
     */
    public void setNumOfNeighborhoods(int numOfNeighborhoods) {
        this._numOfNeighborhoods = Math.max(numOfNeighborhoods, MINIMUM_NEIGHBORHOODS);
    }

    /**
     * @return a string representation contains the city's details
     */
    public String toString() {
        return "City Name: " + getCityName() + "\n" +
                "Date established: " + getDateEstablished().toString() + "\n" +
                "City center: " + getCityCenter().toString() + "\n" +
                "Central station: " + getCentralStation().toString() + "\n" +
                "Number of residents:" + getNumOfResidents() + "\n" +
                "Number of neighborhoods: " + getNumOfNeighborhoods();
    }

    /**
     * @param other  other city to compare to
     * @return boolean true if all fields are equal by value false if not
     */
    public boolean equals(City other) {
        return getCityName().equals(other.getCityName()) &&
                getDateEstablished().equals(other._dateEstablished) &&
                getCityCenter().equals(other.getCityCenter()) &&
                getCentralStation().equals(other.getCentralStation()) &&
                getNumOfResidents() == other.getNumOfResidents() &&
                getNumOfNeighborhoods() == other.getNumOfNeighborhoods();
    }

    /**
     * Add or subtract residents count if valid
     * @param residentToUpdate the amount of residents to change
     * @return if the operation is valid and did happen
     */
    public boolean addResidents(long residentToUpdate) {
        if (getNumOfResidents() + residentToUpdate >= MINIMUM_RESIDENTS) {
            setNumOfResidents(getNumOfResidents() + residentToUpdate);
            return true;
        }
        setNumOfResidents(MINIMUM_RESIDENTS);
        return false;
    }

    /**
     * move central station point's coordinate if valid
     *
     * @param deltaX the x coordinate to move
     * @param deltaY the y coordinate to move
     */
    public void moveCentralStation(int deltaX, int deltaY) {
        this._centralStation.move(deltaX, deltaY);
    }

    /**
     * calculates the distance between the city's center and city's central station
     * @return the distance between the city's center and city's central station
     */
    public double distanceBetweenCenterAndStation() {
        return getCentralStation().distance(getCityCenter());
    }

    /**
     * Creates a new city
     * @param newCityName - a new name for the new city
     * @param dX delta x of new city's coordinates
     * @param dY delta y of new city's coordinates
     * @return the new city with appropriate fields
     */
    public City newCity(String newCityName, int dX, int dY) {
        Date newDate = this.getDateEstablished().tomorrow();
        Point newCenter = new Point(getCityCenter());
        newCenter.move(dX, dY);
        Point newStation = new Point(getCentralStation());
        newStation.move(dX, dY);
        return new City(newCityName, newDate.getDay(), newDate.getMonth(), newDate.getYear(),
                newCenter.getX(), newCenter.getY(), newStation.getX(), newStation.getY(),
                MINIMUM_RESIDENTS, MINIMUM_NEIGHBORHOODS);
    }

    /**
     * Check whether the city established between the two dates
     * @param date1 first to date to check
     * @param date2 second to date to check
     * @return true if the city established between the two dates false if not
     */
    public boolean cityEstablishedBetweenDates(Date date1, Date date2) {
        if (date1.equals(getDateEstablished()) || date2.equals(getDateEstablished())) {
            return true;
        } else if (date1.before(getDateEstablished()) && getDateEstablished().before(date2)) {
            return true;
        } else return date2.before(getDateEstablished()) && getDateEstablished().before(date1);
    }

    /**
     * Calculates the date diffrence between the two cities' established dates
     * @param other thr other city to compare
     * @return the diffrence of established dates as int
     */
    public int establishmentDateDiff(City other){
        return getDateEstablished().difference(other.getDateEstablished());
    }
}
