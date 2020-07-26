package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;

public class EmployeeDAO {
    private final String JDBC_URL =
        "jdbc:mysql://localhost:3306/example?serverTimezone=JST";
    private final String DB_USER = "sa";
    private final String DB_PASS = "sa";

    public List<Employee> findAll () {
        List<Employee> empList = new ArrayList <> ();

        try (Connection conn =
             DriverManager.getConnection( JDBC_URL, DB_USER, DB_PASS )) {

            String sql = "select id, name, age from employee";
            PreparedStatement pStmt = conn.prepareStatement( sql );

            ResultSet rs = pStmt.executeQuery();

            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                Employee employee = new Employee( id, name, age );
                empList.add( employee );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return empList;
    }

    public boolean remove ( String id ) {
        try (Connection conn =
             DriverManager.getConnection( JDBC_URL, DB_USER, DB_PASS )) {

            String sql = "delete from employee where id = ?";
            PreparedStatement pStmt = conn.prepareStatement( sql );
            pStmt.setString(1, id);
            int result = pStmt.executeUpdate();
            if (result < 1) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}

// 修正時刻： Wed Jul  8 10:36:47 2020
