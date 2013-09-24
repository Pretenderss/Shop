/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeeshop.entities;
import connectionpool.ConnectionPool;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



public class POS_List {
    List<PointOfService> pos_list;
    
    
    
    
 public List<PointOfService> getPOS(){
        pos_list = new ArrayList<PointOfService>();
        ConnectionPool cp = ConnectionPool.getConnPool();
        Connection con = cp.getOneConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM store;");
            while(rs.next()){
                PointOfService pos;
                pos = new PointOfService(rs.getDouble("latitude"), rs.getDouble("longitude"), rs.getString("store"), rs.getString("contact"));
                pos_list.add(pos);
//                System.out.println(rs.getInt(1) + rs.getString(2) + rs.getString(3) + rs.getString(4) + rs.getString(1) + rs.getString(1) + );
            }
        } catch (SQLException ex)  {
            Logger.getLogger(POS_List.class.getName()).log(Level.SEVERE, null, ex);
        }
// Для тестирования!!!
//        pos_list.add(new PointOfService(25, 35, "Юра", "12341234"));
//        pos_list.add(new PointOfService(35, 55, "Вася", "12341234"));
//        pos_list.add(new PointOfService(22, 77, "Петя", "12341234"));
//        pos_list.add(new PointOfService(67, 23, "Коля", "12341234"));
//        
        return pos_list;
    }

    @Override
    public String toString() {
        return "POS_List.toString";
    }
    
}
