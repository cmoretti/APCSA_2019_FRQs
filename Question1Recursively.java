public class Question1Recursively {

    //part a
    public static int numberOfLeapYears(int year1, int year2) {
        // Base case:
        // year1 has "passed" year2. We have finished the entire range.
        // There are no more leap years to count.
        if (year1 > year2) return 0;

        // Recursive case:
        // Recur on the range from year1+1 through year2, inclusive.
        // If year1 is a leap year, add 1 to the result of the call.
        if (isLeapYear(year1))
            return 1 + numberOfLeapYears(year1+1, year2);
        else
            return numberOfLeapYears(year1+1, year2);
    }
    
    //part b
    public static int dayOfWeek(int month, int day, int year) {
        // Base case:
        // January 1 -- use firstDayOfYear to find the day of the week.
        if (month == 1 && day == 1) 
            return firstDayOfYear(year);

        // Special recursive case for the first day of each month:
        // The first of m is one day beyond the last day of m-1.
        // So on the first of m, recur on the last day of m-1,
        //    and advance one day from that result.
        // The dayOfYear difference between the first of m and
        //    the first of m-1 computes the length of m-1.
        // This is the "day" (2nd argument) for the last day of m-1
        //    (e.g. 31 for January, or 29 for February in a leap year).

        if (day == 1) {
            int daysInPrevMonth =
                   dayOfYear(month,1,year) - dayOfYear(month-1,1,year);
            return (1 + dayOfWeek(month-1, daysInPrevMonth, year)) %7;
        }

        // General recursive case:
        // In any one month, day k is one day beyond day k-1.
        // So when not the first of the month (which was handled above)
        //    recur on day k-1, and advance one day from that result.
        return (1 + dayOfWeek(month, day-1, year)) % 7;
    }

}

    
        
