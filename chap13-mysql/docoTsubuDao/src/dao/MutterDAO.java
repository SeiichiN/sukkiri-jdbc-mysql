package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Mutter;

public class MutterDAO {
    // info about database
    private final String JDBC_URL =
        "jdbc:mysql://localhost:3306/docoTsubu?serverTimezone=JST";
    private final String DB_USER = "sa";
    private final String DB_PASS = "sa";

    public List<Mutter> findAll () {
        List<Mutter> mutterList = new ArrayList <> ();

        // connect
        try (Connection conn =
                DriverManager.getConnection( JDBC_URL, DB_USER, DB_PASS )) {
            
            String sql =
                "select id, name, text from mutter order by id desc";
            PreparedStatement pStmt = conn.prepareStatement( sql );

            ResultSet rs = pStmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String userName = rs.getString("name");
                String text = rs.getString("text");
                System.out.println("CHECK: " + userName);
                Mutter mutter = new Mutter( id, userName, text );
                mutterList.add(mutter);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("エラーでっせ！");
            return null;
        }
        return mutterList;
    }

    public boolean create( Mutter mutter ) {
        try (Connection conn = 
                DriverManager.getConnection(
                    JDBC_URL, DB_USER, DB_PASS)) {
            String sql = "insert into mutter( name, text ) values (?, ?)";
            PreparedStatement pStmt = conn.prepareStatement( sql );
            pStmt.setString(1, mutter.getUserName());
            pStmt.setString(2, mutter.getText());

            // resultには追加された行数が入る
            int result = pStmt.executeUpdate();
            if (result != 1) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }
}


// 修正時刻: Tue Jul 28 05:18:50 2020

