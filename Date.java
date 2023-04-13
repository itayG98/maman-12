/**
 * The Date class represent date with day month year
 * @author Itay getahun
 * id 315573667
 * @version 07/04/23
 * id 315573667
 */

public class Date {

    private int _day;
    private int _month;
    private int _year;

    // Month values
    private static final int JAN = 1, FEB = 2, MAR = 3, APR = 4, MAY = 5, JUN = 6, JUL = 7, AUG = 8, SEP = 9, OCT = 10, NOV = 11, DEC = 12;
    private static final int DAY31 = 31, DAY30 = 30, DAY28 = 28;
    private static final int MIN_VALID_DAY = 1, MIN_VALID_MONTH = 1, MIN_VALID_YEAR = 1000, MAX_YEAR = 9999;
    //Deafult values
    private static final int DEFAULT_DAY = 1, DEFAULT_MONTH = 1, DEFAULT_YEAR = 2000;
    // printing helper constant
    private static final int TWO_DIGIT_NUM = 10;


    /**
     * gets the day
     *
     * @return the day represented by int
     */
    public int getDay() {
        return _day;
    }

    /**
     * gets the month
     *
     * @return the month represented by int
     */
    public int getMonth() {
        return _month;
    }

    /**
     * gets the year
     *
     * @return the year represented by int
     */
    public int getYear() {
        return _year;
    }

    /**
     * sets the day if valid
     */
    public void setDay(int datToSet) {
        if (validateDate(datToSet, getMonth(), getYear())) {
            this._day = datToSet;
        }
    }

    /**
     * sets the day  if valid
     */
    public void setMonth(int monthToSet) {
        if (validateDate(getDay(), monthToSet, getYear())) {
            this._month = monthToSet;
        }
    }

    /**
     * sets the year if valid
     */
    public void setYear(int yearToSet) {
        if (validateDate(getDay(), getMonth(), yearToSet)) {
            this._year = yearToSet;
        }
    }

    /**
     * creates a new Date object
     * If the date is not valid set its values to 01/01/2000
     *
     * @param day   the day represented by int
     * @param month the month represented by int
     * @param year  the year represented by int
     */
    public Date(int day, int month, int year) {
        if (validateDate(day, month, year)) {
            _day = day;
            _month = month;
            _year = year;
        } else {
            _day = DEFAULT_DAY;
            _month = DEFAULT_MONTH;
            _year = DEFAULT_YEAR;
        }
    }

    /**
     * copy constructor creates a new Date object from existing one's values
     *
     * @param other the date which you want to copy from
     */
    public Date(Date other) {
        _day = other.getDay();
        _month = other.getMonth();
        _year = other.getYear();
    }

    /**
     * @param day   the day number to validate
     * @param month the month number to validate
     * @param year  the year number to validate
     * @return true if the date values are valid and false if not
     */
    private boolean validateDate(int day, int month, int year) {
        if (year < MIN_VALID_YEAR || year > MAX_YEAR || month < MIN_VALID_MONTH || month > DEC || day < MIN_VALID_DAY || day > DAY31) {
            return false;
        } else if (month == JAN || month == MAR || month == MAY || month == JUL || month == AUG || month == OCT || month == DEC) {
            return true;
        } else if ((month == APR || month == JUN || month == SEP || month == NOV) && day <= DAY30) {
            return true;
        } else return month == FEB && day <= DAY28;
    }

    /**
     * @param other the other date to check
     * @return true if the dates representing the same date false if not
     */
    public boolean equals(Date other) {
        return getDay() == other.getDay() && getMonth() == other.getMonth() && getYear() == other.getYear();
    }

    //computes the day number since the beginning of the Christian counting of years
    private int calculateDate(int day, int month, int year) {
        if (month < 3) {
            year--;
            month = month + 12;
        }
        return 365 * year + year / 4 - year / 100 + year / 400 + ((month + 1) * 306) / 10 + (day - 62);
    }

    private int calculateDate() {
        return calculateDate(getDay(), getMonth(), getYear());
    }

    /**
     * @param other point to check if the first point is before the seconds
     * @return a boolean True if the first is before and False if not
     */
    public boolean before(Date other) {
        return calculateDate() < other.calculateDate();
    }

    /**
     * @param other point to check if the first point is after the seconds
     * @return a boolean True if the first is after and False if not
     */
    public boolean after(Date other) {
        return other.before(this);
    }

    /**
     * @param other second point to check the difference between it
     * @return the difference in days
     */
    public int difference(Date other) {
        return Math.abs(calculateDate() - other.calculateDate());
    }

    /**
     * Returns a date string
     * @return a string in format of "DD/MM/YYYY"
     */
    public String toString() {
        String day, month;
        if (getDay() < TWO_DIGIT_NUM) {
            day = '0' + Integer.toString(getDay());
        } else {
            day = Integer.toString(getDay());
        }
        if (getMonth() < TWO_DIGIT_NUM) {
            month = '0' + Integer.toString(getMonth());
        } else {
            month = Integer.toString(getMonth());
        }
        return day + '/' + month + '/' + _year;
    }

    /**
     * @return A new date object represent a day after current day
     */
    public Date tomorrow() {
        if (getDay() == DAY31 && getMonth() == DEC && getYear() == MAX_YEAR) //returns new deafult date object
            return new Date(DEFAULT_DAY, DEFAULT_MONTH, DEFAULT_YEAR);
        else if (validateDate(getDay() + 1, getMonth(), getYear()))
            return new Date(getDay() + 1, getMonth(), getYear());
        else {
            if (_month == 12)
                return new Date(01, 01, getYear() + 1); // if the date is the last one in the year return the first in the new year
            else
                return new Date(1, getMonth() + 1, getYear()); // else return the first in the next month
        }
    }
}
