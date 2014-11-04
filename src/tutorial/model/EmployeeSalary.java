package tutorial.model;

/**
 * Created by orogozina on 9/23/14.
 */
public abstract class EmployeeSalary<T> {

    private int month;

    public EmployeeSalary(int month) {
        this.month = month;
    }

    public abstract double getSalary();

    public int getMonth() {
        return this.month;

    }


}


