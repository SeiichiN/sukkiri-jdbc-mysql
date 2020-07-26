import java.util.List;
import model.Employee;
import dao.EmployeeDAO;

public class SelectEmployeeSample {
    public static void main( String[] args ) {

        EmployeeDAO empDAO = new EmployeeDAO();
        List<Employee> empList = empDAO.findAll();
        
        // 一覧
        for (Employee emp : empList) {
            System.out.println("ID:" + emp.getId());
            System.out.println("名前:" + emp.getName());
            System.out.println("年齢:" + String.valueOf(emp.getAge()) + "\n");
        }

        String id = "EMP003";
        if (empDAO.remove(id)) {
            System.out.println(id + "を削除しました。");
        }
    }
}

// 修正時刻: Mon Jul 27 06:53:59 2020

