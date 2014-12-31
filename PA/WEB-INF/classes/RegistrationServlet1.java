import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class RegistrationServlet1 extends GenericServlet
{
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException
	{
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");

		// Collecting Client data
		String regno = req.getParameter("t1");
		String name = req.getParameter("t2");
		String floorid= req.getParameter("t3");
		String slotid = req.getParameter("t4");
		int x=Integer.parseInt(floorid);
		int y=Integer.parseInt(slotid);

		//JDBC Coding
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");		
			PreparedStatement ps = con.prepareStatement("INSERT INTO floor_slot_allocation VALUES(?,?)");
			
			ps.setInt(1,x);
			ps.setInt(2,y);
			ps.setString(1,regno);
			ps.setString(2,name);
			
			int count = ps. executeUpdate(); 
			
			if(count == 1) 
			{
				RequestDispatcher rd = req.getRequestDispatcher("login.html");
				rd.forward(req,res);
			}
			con.close();
		}
		catch(Exception e){ e.printStackTrace();}
	}
}