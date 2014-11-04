package tutorial.model;

/**
 * Created by orogozina on 9/24/14.
 */

public class EmployeeSalaryFullTime extends EmployeeSalary {

    //    private int month;
    private double salary;


    public EmployeeSalaryFullTime(int month, double salary/*, int workedDay*/) {
        super(month);
        this.salary = salary;
//        this.workedDay = workedDay;
    }


    @Override
    public double getSalary() {


        return salary;
    }

    @Override
    public String toString() {
        return  Double.toString(salary) ;
    }
}
