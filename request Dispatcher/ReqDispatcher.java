import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class ReqDispatcher extends HttpServlet
{
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		res.setContentType("text/html");
		PrintWriter out= res.getWriter();
		
		String name=req.getParameter("name");
		String pass=req.getParameter("pass");
		String driver = getInitParameter("driver");
		
		out.println("<html><body>");
		
		
		try {
			Class.forName(driver);
			Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","ravicool");
			Statement s = c.createStatement();
			
			String s1="Select * from emp101 where name='"+name+"' and pass='"+pass+"'";
			
			ResultSet rs=s.executeQuery(s1);
			
			out.println("before dispatcher <br>");
			
			req.setAttribute("name","ravinder");
		
			
			if(rs.next())
			{
				RequestDispatcher rd = req.getRequestDispatcher("/wel");
				rd.include(req, res);
				//rd.forward(reeq, res);
			}	
			else
			{
				RequestDispatcher rd = req.getRequestDispatcher("/err");
				//rd.include(req, res);
				rd.forward(req, res);
			}
		}
		catch(Exception e){}
		//res.sendRedirect("wel.html");
			//res.sendRedirect("wel");
		out.println("<br>after dispatcher");
		out.println("</html></body>");
		
	}
}