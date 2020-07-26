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

        String id = "EMP001";
        if (empDAO.remove(id)) {
            System.out.println(id + "を削除しました。");
        }
    }
}

// 修正時刻： Wed Jul  8 10:36:08 2020
