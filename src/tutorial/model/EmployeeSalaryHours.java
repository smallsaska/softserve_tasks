package tutorial.model;

/**
 * Created by orogozina on 9/24/14.
 */
public class EmployeeSalaryHours extends EmployeeSalary {
    private double rate;
    private int workedHours;

    public EmployeeSalaryHours(int month, double rate, int workedHours) {

//        this.month = month;
        super(month);
        this.rate = rate;
        this.workedHours = workedHours;
    }


    @Override
    public double getSalary() {

        return rate * workedHours;
    }
    @Override
    public String toString() {
        return  Double.toString(getSalary()) ;
    }
}
