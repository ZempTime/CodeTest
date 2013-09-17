package OrganizationTest;

import Organization.*;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Chris Zempel Date: 9/14/13 Time: 11:14 PM
 *
 */
public class ApplicationTest {

    @Test
    public void developerGetAllocationTest(){
        Developer dev = new Developer();
        assertEquals(1000, dev.getAllocation());
    }

    @Test
    public void qatesterGetAllocationTest(){
        QATester qatester = new QATester();
        assertEquals(500, qatester.getAllocation());
    }

    @Test
    public void managerGetAllocationTest() {
        Manager manager = new Manager();
        assertEquals(300, manager.getAllocation());
    }

    @Test
    public void getOneManagerAllocation() {
        Manager manager = new Manager();
        assertEquals(300, manager.getTotalAllocation(true));
    }

    @Test
    public void  getAllocationForOneManagerWithOneEmployee(){
        Manager manager = new Manager();
        Developer developer = new Developer();
        manager.add(developer);
        assertEquals(1300, manager.getTotalAllocation(true));
    }

    @Test
    public void getAllocationForOneManagerWithTwoEmployees(){
        Manager manager = new Manager();
        Developer developer = new Developer();
        QATester qatester = new QATester();
        manager.add(developer);
        manager.add(qatester);
        assertEquals(1800, manager.getTotalAllocation(true));
    }

    @Test
    public void getAllocationForManagerUnderManagerWithEmployee(){
        Manager upperManager = new Manager();
        Manager manager = new Manager();
        Developer developer = new Developer();

        manager.add(developer);
        upperManager.add(manager);
        assertEquals(1600, upperManager.getTotalAllocation(true));

    }


    @Test
    public void givenExampleCodeTest(){
        Manager managerA = new Manager();
        Manager managerB = new Manager();
        Developer developer = new Developer();
        QATester qatester = new QATester();

        managerA.add(managerB);
        managerB.add(developer);
        managerB.add(qatester);

        assertEquals(2100, managerA.getTotalAllocation(true));
    }

    @Test
    public void departmentCreationTest(){
        Department dunderMifflin = new Department();
        assertEquals(Department.class, dunderMifflin.getClass());
    }

    @Test
    public void departmentWithOneManagerOneEmployee(){
        Department dunderMifflin = new Department();
        Manager michaelScott = new Manager();
        Developer jim = new Developer();

        dunderMifflin.add(michaelScott);
        dunderMifflin.add(jim);

        assertEquals(1300, dunderMifflin.getAllocation());

    }

    @Test
    public void departmentWithHugeStaff(){

        Department department = new Department();
        Manager mA = new Manager(); //300
        Manager mB = new Manager(); //300
        Manager mC = new Manager(); //300
        Developer dA = new Developer(); //1000
        Developer da = new Developer(); //1000
        Developer db = new Developer(); //1000
        Developer dc = new Developer(); //1000
        QATester qA = new QATester(); // 500
        QATester qa = new QATester(); // 500
        QATester qb = new QATester(); // 500
        QATester qc = new QATester(); // 500
        Manager ma = new Manager(); //300
        Manager mb = new Manager(); //300
        Manager mc = new Manager(); //300
        Developer daa = new Developer(); //1000
        Developer dbb = new Developer(); //1000
        Developer dcc = new Developer(); //1000
        QATester qaa = new QATester(); // 500
        QATester qbb = new QATester(); // 500
        QATester qcc = new QATester(); // 500

        department.add(mA);
        department.add(mB);
        department.add(mC);
        department.add(dA);
        department.add(qA);
        mA.add(ma);
        mA.add(da);
        mA.add(qa);
        ma.add(daa);
        ma.add(qaa);
        mB.add(mb);
        mB.add(db);
        mb.add(qb);
        mb.add(dbb);
        mb.add(qbb);
        mC.add(mc);
        mC.add(qc);
        mC.add(dc);
        mc.add(dcc);
        mc.add(qcc);

        // 6 managers = 1800
        // 7 developers = 7000
        // 7 qatesters = 3500
        // Total: 12300

        assertEquals(12300, department.getAllocation());
    }

}
