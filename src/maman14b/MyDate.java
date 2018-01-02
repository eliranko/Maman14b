package maman14b;

import java.io.Serializable;

public class MyDate implements Serializable {
    private final int DEFAULT_DAY_VALUE = 4;
    private final int DEFAULT_MONTH_VALUE = 10;
    private final int DEFAULT_YEAR_VALUE = 1993;
    private final int[] daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
    
    private int day;
    private int month;
    private int year;

    /**
     * Constructor
     * @param day integer day
     * @param month integer month
     * @param year integer year
     */
    public MyDate(int day, int month, int year) {
        setDay(day);
        setMonth(month);
        setYear(year);
    }

    /**
     * Empty constructor
     */
    public MyDate() {
        setDay(DEFAULT_DAY_VALUE);
        setMonth(DEFAULT_MONTH_VALUE);
        setYear(DEFAULT_YEAR_VALUE);
    }

    /**
     * Get the day
     * @return integer day
     */
    public int getDay() {
        return day;
    }

    /**
     * Set the day
     * @param day Integer day
     */
    public final void setDay(int day) {
        if(day < 1 || day > daysInMonth[month]) {
            day = DEFAULT_DAY_VALUE;
        }
        this.day = day;
    }

    /**
     * Get the month
     * @return integer month
     */
    public int getMonth() {
        return month;
    }

    /**
     * Set the month
     * @param month integer month
     */
    public final void setMonth(int month) {
        if(month < 1 || month > 12) {
            month = DEFAULT_MONTH_VALUE;
        }
        this.month = month;
    }

    /**
     * Get the year
     * @return integer year
     */
    public int getYear() {
        return year;
    }

    /**
     * Set the year
     * @param year integer year
     */
    public final void setYear(int year) {
        if(year < 1) {
            year = DEFAULT_YEAR_VALUE;
        }
        this.daysInMonth[1] = isLeapYear(year) ? 29 : 28;
        this.year = year;
    }
    
    /**
     * Get the number of days in the chosen year and month
     * @return integer representing the number of days
     */
    public int getNumberOfDaysInChosenDate() {
        return this.daysInMonth[this.month - 1];
    }
    
    private boolean isLeapYear(int year) {
        return year % 4 == 0 && !(year % 100 == 0 && year % 400 != 0);
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.day;
        hash = 79 * hash + this.month;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        MyDate other = (MyDate) obj;
        return this.day == other.day && this.month == other.month &&
                this.year == other.year;
    }
}
