package tutorial.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by orogozina on 9/8/14.
 */

//TODO adress
//

public class Employee {
    public int id = 0;
    public String lastName;
    public String name;
    public String address;
    public int type = 1;
    public ArrayList<EmployeeSalary> salaryList = new ArrayList<EmployeeSalary>();


    public Employee(int id, String lastName, String name /*String address*/) {
        this.id = id;
        this.lastName = lastName;
        this.name = name;
        this.address = address;

    }

    //Add salary to the list of employee's salary
    public void addSalary(EmployeeSalary salary) {
        salaryList.add((salary));

    }

    //Get employee's list of salary values
    public List<Double> getSalaryValueList() {
        List<Double> salaryValueList = new ArrayList<Double>();
        for (int i = 0; i < salaryList.size(); i++) {
            salaryValueList.set(i, salaryList.get(i).getSalary());
        }
        return salaryValueList;
    }

    //Get the list of sums by mont of all salaries for employee
    public List<EmployeeSalaryFullTime> getSalaryList() {
        List<EmployeeSalaryFullTime> salaryList = new ArrayList<EmployeeSalaryFullTime>();
        for (int i = 0; i < salaryList.size(); i++) {
            //           salaryList.set(i, new EmployeeSalaryFullTime(salaryList.get(i).));
        }
        return salaryList;
    }

    public Double getSalaryByMonth(int month) {
        Double salaryPerMonth = 0.0;
        for (int i = 0; i < salaryList.size(); i++) {
            while (salaryList.get(i).getMonth() == month) {
                salaryPerMonth = +salaryList.get(i).getSalary();
                i++;
            }

        }
        return salaryPerMonth;
    }

    public Double calculateAverageSalary(List<? extends EmployeeSalary> salaryList) {

        Double averageSalary = null;
        averageSalary = calculateSumSalary(salaryList) / salaryList.size();

        return averageSalary;
    }


    public Double calculateSumSalary(List<? extends EmployeeSalary> salaryList) {


        Double salarySum = null;
        for (int i = 0; i < salaryList.size(); i++) {
            salarySum = +salaryList.get(i).getSalary();
        }

        return salarySum;
    }

    public int getID() {
        int id = this.id;
        return id;

    }

    @Override
    public String toString() {
        return "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", type=" + type +
                ", salaryList=" + salaryList;
    }
}

