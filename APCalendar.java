import java.util.Calendar;

public class APCalendar {

    private static Calendar cal = Calendar.getInstance();

    private static boolean isLeapYear(int year) {
        cal.set(Calendar.YEAR, year);
        return cal.getActualMaximum(Calendar.DAY_OF_YEAR) > 365;
        /*if (year % 4 != 0) {
            return false;
        } else if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else {
            return true;
        }*/
    }

    // part a
    // 21:37 - 21:37 ... woah
    public static int numberOfLeapYears(int year1, int year2) {
        int count = 0;
        for(int i = year1; i <= year2; i++) if(isLeapYear(i)) count++;
        return count;
    }

    private static int firstDayOfYear(int year) {
        cal.set(year,Calendar.JANUARY,1);
        return cal.get(Calendar.DAY_OF_WEEK) - Calendar.SUNDAY;
        
    }

    private static int dayOfYear(int m, int d, int y) {
        if(Calendar.JANUARY == 0)
            m--;
        cal.set(y,m,d);
        return cal.get(Calendar.DAY_OF_YEAR);
    }

    // part b
    // 21:38 - 21:44 (both versions)
    public static int dayOfWeek(int month, int day, int year) {
        // there's probably a tricky mod way to do this.
        /*
        int d = firstDayOfYear(year);
        int n = dayOfYear(month, day, year);
        
        for(int i = 1; i < n; i++) d = (d+1) % 7;
        return d;
        */
        
        // hey, why not, let's do the tricky mod way ... actually not tricky
        return (dayOfYear(month,day,year)-1+firstDayOfYear(year))%7;
    }

    public static void main(String[] args) {
        System.out.println("Testing library functions");
        cal.setFirstDayOfWeek(Calendar.SUNDAY);
        System.out.println(firstDayOfYear(2019) + " should be 2"); // Tuesday
        System.out.println(dayOfYear(1,7,2019) + " should be 7"); //7
        System.out.println(dayOfYear(2,7,2019) + " should be 38"); //38
        System.out.println(dayOfYear(3,1,2017) + " should be 60"); //60
        System.out.println(dayOfYear(3,1,2016) + " should be 61"); //61
        

        System.out.println(isLeapYear(1903) + " should be false"); // no (not 4)
        System.out.println(isLeapYear(1900) + " should be false"); // no (4, but 100 and not 400)
        System.out.println(isLeapYear(2000) + " should be true"); // yes (4, and 100 but 400)
        System.out.println(isLeapYear(2016) + " should be true"); // yes (4)

        System.out.println("\nTesting part a");
        System.out.println(numberOfLeapYears(1899,1901) + " should be 0");
        System.out.println(numberOfLeapYears(1899,1923) + " should be 5");
        System.out.println(numberOfLeapYears(1999,2022) + " should be 6");
        System.out.println(numberOfLeapYears(2015,2017) + " should be 1");
        
        System.out.println("\nTesting part b");
        System.out.println(dayOfWeek(1,1,2019) + " should be 2");
        System.out.println(dayOfWeek(1,5,2019) + " should be 6");
        System.out.println(dayOfWeek(1,10,2019) + " should be 4");
        System.out.println(dayOfWeek(5,19,2019) + " should be 0");
        System.out.println(dayOfWeek(3,1,2017) + " should be 3");
        System.out.println(dayOfWeek(3,1,2016) + " should be 2");
        
    }
}

/* plausible, but overly coddling (even if this is Q1), rubric:
part a (5 pts):
  initializes counter
  at least 1 valid call to isLeapYear
  considers all years in range (no OB1)
  conditionally increments counter if considered leap year
    (syntax error on isLeapYear call ok, so is faulty attempt at hand-computing LY)
  returns counter

part b (4 pts)
  calls firstDayOfYear correctly (syntax/follow directions point)
  calls dayOfYear correctly on month, day, year. (syntax/follow directions point)
  calculates day of the week or days elapsed, including offset (calculation + offset point)
  returns a valid day of the week (return + mod point)

*/
