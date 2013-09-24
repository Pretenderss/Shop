
package connectionpool;
import java.sql.*;

import java.sql.Connection;
import java.sql.Statement;

public class TestPool {
    public static void main(String[] args) throws SQLException {
        ConnectionPool cp = ConnectionPool.getConnPool();
        Connection con = cp.getOneConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM clients;");
        while (rs.next()){
            System.out.println("Результат: " + rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6) + " " + rs.getString(7) + " " + rs.getString(8));
        }
        cp.releaseConnection(con);
//        cp.closeAll();
    }
}
