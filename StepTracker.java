// start 22:08. End 22:14

public class StepTracker {

    private int threshold;
    private int activeDays;
    private int totalDays;
    private int totalSteps;
    
    public StepTracker(int minMinsForActive) {
        threshold = minMinsForActive;
    }

    public void addDailySteps(int steps) {
        totalSteps += steps;
        totalDays++;
        if(steps > threshold) activeDays++;
    }

    public int activeDays() {
        return activeDays;
    }

    public double averageSteps() {
        if(totalDays == 0)
            return 0.;
        return (double) totalSteps / totalDays;
    }

    public static void main(String[] args) {
        StepTracker tr = new StepTracker(10000);
        System.out.println(tr.activeDays() + " should be 0");
        System.out.println(tr.averageSteps() + " should be 0.0");
        tr.addDailySteps(9000);
        tr.addDailySteps(5000);
        System.out.println(tr.activeDays() + " should be 0");
        System.out.println(tr.averageSteps() + " should be 7000.0");
        tr.addDailySteps(13000);
        System.out.println(tr.activeDays() + " should be 1");
        System.out.println(tr.averageSteps() + " should be 9000.0");
        tr.addDailySteps(23000); //reading dine out night
        tr.addDailySteps(1111);
        System.out.println(tr.activeDays() + " should be 2");
        System.out.println(tr.averageSteps() + " should be 10222.2");
    }
}

/* plausible rubric

 * class header
 * appropriate private instance vars (i.e. must be able to solve problem with them)
 * constructor header
 * constructor initializes all required instance variables (ok to assume defaults where applicable)
 * addDailySteps header
 * addDailySteps correctly updates IV(s)
 * activeDays header and correct implementation
 * averageSteps header
 * averageSteps correctness (no int div, no division by 0)

 */
