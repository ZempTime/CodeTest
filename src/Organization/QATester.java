package Organization;

/**
 * Created with IntelliJ IDEA.
 * User: zempelc
 * Date: 9/14/13
 * Time: 11:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class QATester implements Employee {

    private int monthlyAllocation;

    public QATester() {

        this.monthlyAllocation = 500;

    }

    public void add(Employee employee) {}
    public void remove(Employee employee) {}
    public Employee getChild(int i) {
        return null;
    }
    public int getAllocation(){
        return monthlyAllocation;
    }

}
