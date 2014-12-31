import javax.servlet.*; 
import java.io.*; 
import java.sql.*;

public class ReleaseServlet extends GenericServlet
{
	public void service(ServletRequest req , ServletResponse res)throws ServletException,IOException
	{
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		
		// Collecting Client data
		String regno = req.getParameter("vn");
			
		// JDBC Coding
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");

			Statement stmt = con.createStatement();
			String sql="DELETE FROM floor_slot_allocation WHERE regno="+regno;
			stmt.executeUpdate(sql);

			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.forward(req , res);
		}catch(Exception e){ e.printStackTrace(); }

	}
}