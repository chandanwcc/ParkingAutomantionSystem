import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class DispServlet extends GenericServlet {
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException {
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");

			String sql;
			ResultSet rs;
			Statement stmt;
		//JDBC Coding
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");		
			stmt = con.createStatement();
			sql = "SELECT * FROM slot WHERE id NOT IN(SELECT slot_id FROM floor_slot_allocation WHERE floor_id=1)";
			rs = stmt.executeQuery(sql);
			out.println("slot free in first floor");
			while(rs.next()){
            //Retrieve by column name
            int id  = rs.getInt("id");
            String name = rs.getString("name");

            //Display values
            out.println("ID: " + id + "  ");
            out.println("status " + name + "<br>");
            
         }


		  sql = "SELECT * FROM slot WHERE id NOT IN(SELECT slot_id FROM floor_slot_allocation WHERE floor_id=2)";
		  rs = stmt.executeQuery(sql);
			out.println("slot free in second floor");
			while(rs.next()){
            //Retrieve by column name
            int id  = rs.getInt("id");
            String name = rs.getString("name");

            //Display values
            out.println("ID: " + id + "<br>");
            out.println("status: " + name + "<br>");
            
         }

		  sql = "SELECT * FROM slot WHERE id NOT IN(SELECT slot_id FROM floor_slot_allocation WHERE floor_id=3)";
		   rs = stmt.executeQuery(sql);
			out.println("slot free in third floor");
			while(rs.next()){
            //Retrieve by column name
            int id  = rs.getInt("id");
            String name = rs.getString("name");

            //Display values
            out.println("ID: " + id + "<br>");
            out.println("status: " + name + "<br>");
            
         }


		   sql = "SELECT * FROM slot WHERE id NOT IN(SELECT slot_id FROM floor_slot_allocation WHERE floor_id=4)";
		   rs = stmt.executeQuery(sql);
		   out.println("slot free in fourth floor");
			while(rs.next()){
            //Retrieve by column name
            int id  = rs.getInt("id");
            String name = rs.getString("name");

            //Display values
            out.println("ID: " + id + "<br>");
            out.println("status: " + name + "<br>");
            
         }

			rs.close();
			stmt.close();
			con.close();
		}
		catch(Exception e){ e.printStackTrace(); }
	}
}