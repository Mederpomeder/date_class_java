import java.util.*;

class Date implements Comparable<Date> {
    private int day;
    private int month;
    private int year;

    
    private static final String[] MONTH_NAMES = {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    
    
    private static final int[] DAYS_IN_MONTH = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public Date(int day, int month, int year) {
        if (isValidDate(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            throw new IllegalArgumentException("Invalid date");
        }
    }

    public boolean isValidDate(int day, int month, int year) {
        if (year < 1 || month < 1 || month > 12 || day < 1) {
            return false;
        }
        
        int maxDays = DAYS_IN_MONTH[month];
        if (month == 2 && isLeapYear(year)) {
            maxDays = 29;
        }
        
        return day <= maxDays;
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public void updateDate(int day, int month, int year) {
        if (isValidDate(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            throw new IllegalArgumentException("Invalid date");
        }
    }

    public String getDayOfWeek() {
        Calendar calendar = new GregorianCalendar(year, month - 1, day);
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        return days[calendar.get(Calendar.DAY_OF_WEEK) - 1];
    }

    public int calculateDifference(Date otherDate) {
        Calendar c1 = new GregorianCalendar(year, month - 1, day);
        Calendar c2 = new GregorianCalendar(otherDate.year, otherDate.month - 1, otherDate.day);
        long diff = Math.abs(c1.getTimeInMillis() - c2.getTimeInMillis());
        return (int) (diff / (1000 * 60 * 60 * 24));
    }

    public void printDate() {
        System.out.println(MONTH_NAMES[month] + " " + day + ", " + year);
    }

    @Override
    public int compareTo(Date other) {
        if (this.year != other.year) {
            return Integer.compare(this.year, other.year);
        }
        if (this.month != other.month) {
            return Integer.compare(this.month, other.month);
        }
        return Integer.compare(this.day, other.day);
    }
}

public class Main {
    public static void main(String[] args) {
        List<Date> dates = new ArrayList<>();
        
        try {
            dates.add(new Date(15, 3, 2024));
            dates.add(new Date(1, 1, 2023));
            dates.add(new Date(29, 2, 2020)); 
            dates.add(new Date(5, 7, 2025));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("Original Dates:");
        for (Date d : dates) {
            d.printDate();
        }
        
        Collections.sort(dates);
        System.out.println("\nSorted Dates:");
        for (Date d : dates) {
            d.printDate();
        }
        
        
        Date d1 = new Date(10, 4, 2023);
        Date d2 = new Date(25, 4, 2023);
        System.out.println("\nDifference between dates: " + d1.calculateDifference(d2) + " days");
        
        
        System.out.println("Day of the week for 10 April 2023: " + d1.getDayOfWeek());
    }
}
