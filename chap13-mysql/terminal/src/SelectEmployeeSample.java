import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectEmployeeSample {

    static final String USERNAME = "sa";
    static final String PASSWORD = "sa";
    static final String CONNECT =
        "jdbc:mysql://localhost:3306/docotsubu?serverTimezone=JST";

    public static void main( String[] args ) {
        
        // データベースに接続
        try (Connection conn =
             DriverManager.getConnection (CONNECT, USERNAME, PASSWORD)) {
            // select 文
            String sql = "SELECT * FROM mutter";
            PreparedStatement pStmt = conn.prepareStatement( sql );

            ResultSet rs = pStmt.executeQuery();

            while( rs.next() ) {
                // String id = rs.getString("id");
                String name = rs.getString("name");
                String text = rs.getString("text");
                // int age = rs.getInt("age");

                // System.out.println("ID:" + id);
                System.out.println("名前:" + name);
                System.out.println("発言:" + text);
                // System.out.println("年齢:" + age + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
}
    
// 修正時刻: Sun Jul 26 14:18:23 2020
