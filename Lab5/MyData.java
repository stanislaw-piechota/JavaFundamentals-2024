package Lab5;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyData {
    // constants
    final static String[] SEPARATORS = {"/", ".", ",", " ", "-"};
    final static int DEFAULT_DAY = 1, DEFAULT_MONTH = 1, DEFAULT_YEAR = 2000;
    final static String DEFAULT_WEEKDAY = "Saturday";
    final static String[] DAYS_OF_WEEK = {
        "Monday", "Tuesday", "Wednesday", "Thursday",
        "Friday", "Saturday", "Sunday"
    }, MONTHS_OF_YEAR = {
        "January", "February", "March", "April",
        "May", "June", "July", "August",
        "September", "October", "November", "December"
    };

    private int day, month, year;
    private String dayOfWeek;

    private static boolean valueInArray(String value, String[] array) {
        for (String el : array) {
            if (el.equals(value))
                return true;
        }
        return false;
    }

    private static String findRegex(String searchString, String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(searchString);
        String subs =  matcher.find() ? searchString
            .substring(matcher.start(), matcher.end())
            .trim() : "";

        if (!subs.isEmpty() && valueInArray(String.valueOf(subs.charAt(0)), SEPARATORS))
            subs = subs.substring(1);
        if (!subs.isEmpty() && valueInArray(String.valueOf(subs.charAt(subs.length()-1)), SEPARATORS))
            subs = subs.substring(0, subs.length()-1);
        return subs;
    }

    public static int findDay(String date) {
        String searchResult;
        if (!(searchResult = findRegex(date, "[/\\-\\. ]\\d{2} ")).isEmpty())
            return Integer.parseInt(searchResult);
        if (!(searchResult = findRegex(date, "[/\\-\\. ]\\d{2}$")).isEmpty())
            return Integer.parseInt(searchResult);
        if (!(searchResult = findRegex(date, "^\\d{2}[/\\-\\.]")).isEmpty())
            return Integer.parseInt(searchResult);
        if (!(searchResult = findRegex(date, "^\\d{2}[/\\-\\.,]")).isEmpty())
            return Integer.parseInt(searchResult);
        if (!(searchResult = findRegex(date, " \\d{2}[/\\-\\.,]")).isEmpty())
            return Integer.parseInt(searchResult);
        return DEFAULT_DAY;
    }

    private static int findMonthByName(String date){
        for (int i = 0; i < MONTHS_OF_YEAR.length; i++) {
            if (date.contains(MONTHS_OF_YEAR[i]))
                return i + 1;
        }
        return 0;
    }

    private static int findMonthWithDelimeter(String date){
        String searchResult = findRegex(date, "[/\\-\\.]\\d{1,2}[/\\-\\.]");
        return !searchResult.isEmpty() ? Integer.parseInt(searchResult.strip()) : 0;
    }

    private static int findMonth(String date){
        int month;
        if ((month = findMonthByName(date)) >= 1)
            return month;
        if ((month = findMonthWithDelimeter(date)) >= 1)
            return month;
        return DEFAULT_MONTH;
    }

    private static int findYear(String date){
        String searchResult = findRegex(date, "\\d{3,}");
        return !searchResult.isEmpty() ? Integer.parseInt(searchResult) : DEFAULT_YEAR;
    }

    public static String findWeekday(String date){
        for (String weekday: DAYS_OF_WEEK){
            if (date.contains(weekday))
                return weekday;
        }
        return DEFAULT_WEEKDAY;
    }

    public MyData(){
        this.day = DEFAULT_DAY;
        this.month = DEFAULT_MONTH;
        this.year = DEFAULT_YEAR;
        this.dayOfWeek = DEFAULT_WEEKDAY;
    }

    public MyData(int day, int month, int year, String weekday){
        this.day = day;
        this.month = month;
        this.year = year;
        this.dayOfWeek = weekday;
    }

    public String toString(){
        return String.format(
            "day=%d, month=%d, year=%d, weekday=%s",
            this.day, this.month, this.year, this.dayOfWeek
        );
    }

    public static MyData fromString(String dateString){
        return new MyData(
            findDay(dateString),
            findMonth(dateString),
            findYear(dateString),
            findWeekday(dateString)
        );
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass()) 
            return false;
        MyData myData = (MyData) obj;
        return (this.day == myData.day &&
            this.month == myData.month &&
            this.year == myData.year);
    }
}
