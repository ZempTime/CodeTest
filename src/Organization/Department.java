package Organization;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zempelc
 * Date: 9/14/13
 * Time: 11:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class Department implements Employee {

    List<Employee> employees = new ArrayList<Employee>();

    public void add(Employee employee) {
        employees.add(employee);
    };
    public void remove(Employee employee) {
        employees.remove(employee);
    };

    public int getAllocation(){
    //iterates through Department's employee list adding up totalAllocation per manager, and individual allocation per employee
            int totalAllocation = 0;

            for (int e = 0; e < employees.size();) {
                if (employees.get(e).getClass() == Manager.class){
                    Manager manager = (Manager) employees.get(e);
                    totalAllocation += manager.getTotalAllocation(true);
            } else {
                    totalAllocation += employees.get(e).getAllocation();
                }
                e++;
            }
        return totalAllocation;
    }
}
