import tutorial.dao.*;
import tutorial.model.*;
import tutorial.service.EmployeeService;

/**
 * Created by orogozina on 9/9/14.
 */

public class Main {


    public static void main(String[] args) {
        CompanyEmployeeList traineeCompanyList = new CompanyEmployeeList(DB.dbToCollection());
        traineeCompanyList.sortByName();
        EmployeeService.printCompanyList(traineeCompanyList);



    }


}
