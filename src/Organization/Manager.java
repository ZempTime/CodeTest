package Organization;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zempelc
 * Date: 9/14/13
 * Time: 11:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class Manager implements Employee {

    private int monthlyAllocation;

    public Manager(){
        this.monthlyAllocation = 300;
    }

    List<Employee> employees = new ArrayList<Employee>();

    public Employee getChild(int i){
        return employees.get(i);
    }

    public void add(Employee employee){
        employees.add(employee);
    }

    public void remove(Employee employee){
        employees.remove(employee);
    }

    public int getTotalAllocation(boolean originalCall) {
        int totalAllocation = 0;

        if (originalCall) totalAllocation = this.getAllocation(); // if this is the original call to getTotalAllocation,
                                                                  // adds the original manager's allocation as it won't
                                                                  // be included elsewhere


        if (!employees.isEmpty()){
            for (int e = 0; e < employees.size();) {
                totalAllocation += employees.get(e).getAllocation();

                if (employees.get(e).getClass() == Manager.class){
                    Manager subManager = (Manager) employees.get(e);
                    totalAllocation += subManager.getTotalAllocation(false);
                }

                e++;
            }
            return totalAllocation;
        } else {
        return totalAllocation;
        }
    }

    public int getAllocation(){
        return monthlyAllocation;
    }



}
