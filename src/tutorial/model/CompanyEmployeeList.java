package tutorial.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by orogozina on 10/9/14.
 */
public class CompanyEmployeeList {
    List<Employee> companyEmployeeList;

    public CompanyEmployeeList(List<Employee> companyEmployeeList) {

        this.companyEmployeeList = companyEmployeeList;
    }

    // Sort by id
    public CompanyEmployeeList sortByID() {
        Collections.sort(companyEmployeeList, new Comparator<Employee>()

                {
                    @Override
                    public int compare(Employee e1, Employee e2) {
                        return Integer.compare(e1.getID(), e2.getID());
                    }
                }
        );
        return this;
    }

    // Sort by id
    public CompanyEmployeeList sortByName() {
        Collections.sort(companyEmployeeList, new Comparator<Employee>()

                {
                    @Override
                    public int compare(Employee e1, Employee e2) {
                        return Integer.compare(e1.getID(), e2.getID());
                    }
                }
        );
        return this;
    }
//    CompanyEmployeeList get


    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        for (int i=0; i<companyEmployeeList.size();i++){
            stringBuilder.append(" Employee "+i+": "+companyEmployeeList.get(i));
        }
        return stringBuilder.toString();
    }

}







