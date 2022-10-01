package testJava;

import java.sql.*;
/*
* 1. import
* 2. load and resister the driver
* 3. establish the connection (Connection)
* 4. Statement
* 5. Exicute the query
* 6. Process the result
* 7. close
*/


public class JDBCConnection {
    public static void main(String[] args) {
        try {
            //String url = "jdbc:mysql://127.0.0.1:3306";
            String url = "jdbc:mysql://localhost:3306/employeedetails";
            String uname = "root";
            String pass = "praneeth1999";
            Class.forName("com.mysql.jdbc.Driver");
            String query ="select * from employee;";
            //establish the connection
            Connection conn = DriverManager.getConnection(url, uname, pass);
            //creating the object of Statement 
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            //avoid taking field name
            ResultSetMetaData rm = rs.getMetaData();
            int col = rm.getColumnCount();
            
            while(rs.next())
            {
                for(int i=1;i<=col;i++)
                {
                    System.out.print(rs.getString(i)+" ");
                }
                //type cast
                //int k = Integer.parseInt(rs.getString(1));
                
                System.out.println();
            }
            
            conn.close();
            

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

    }

}
