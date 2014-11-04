package tutorial.dao;

import tutorial.model.Employee;
import tutorial.model.EmployeeSalary;
import tutorial.model.EmployeeSalaryFullTime;
import tutorial.model.EmployeeSalaryHours;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by orogozina on 9/9/14.
 */

// Fetching all data from DB and pushing it to collection
// type of employee can be 1- fulltime worker, 2-hours worker
// TODO adress

public class DB {

    public static Employee employee;
    public static List<Employee> employeeList = new ArrayList<Employee>();
    public static EmployeeSalary employeeSalaryFullTime;
    public static EmployeeSalary employeeSalaryHours;
    public Connection conn = null;
    public Statement stmt = null;
    public ResultSet rs = null;

    public static List<Employee> dbToCollection(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ResultSet rsSalary = null;
        String sqlQuery;


        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String URL = "jdbc:mysql://localhost/employee_salary?user=root&password=root";
        try {
            conn = DriverManager.getConnection(URL);
            sqlQuery = "Select * from employee";
//            String sqlQuery = "Select * from employee ";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sqlQuery);
            while (rs.next()) {
                employee = new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("last_name"));
                if (rs.getInt("type") == 1) {
                    employee.type = 1;
                    sqlQuery = "select * from salary_employee_full_time where employee_id=" + Integer.toString(rs.getInt("id"));
                    stmt = conn.createStatement();
                    rsSalary = stmt.executeQuery(sqlQuery);
                    while (rsSalary.next()) {
                        employeeSalaryFullTime = new EmployeeSalaryFullTime(rsSalary.getInt("month"), rsSalary.getDouble("salary"));
                        employee.addSalary(employeeSalaryFullTime);
                    }

                } else if (rs.getInt("type") == 2) {
                    employee.type = 2;
                    sqlQuery = "select * from salary_employee_hours where employee_id=" + Integer.toString(rs.getInt("id"));
                    stmt = conn.createStatement();
                    rsSalary = stmt.executeQuery(sqlQuery);
                    while (rsSalary.next()) {
                        employeeSalaryHours = new EmployeeSalaryHours(rsSalary.getInt("month"), rsSalary.getDouble("rate"), rsSalary.getInt("worked_hours"));
                        employee.addSalary(employeeSalaryHours);

                    }
                }
                employeeList.add(employee);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }
}

