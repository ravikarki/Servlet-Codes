import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class SendRedirect extends HttpServlet
{
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		res.setContentType("text/html");
		PrintWriter out= res.getWriter();
		
		String name=req.getParameter("name");
		String pass=req.getParameter("pass");
		String image = getInitParameter("image");
		String driver = getInitParameter("driver");
		
		out.println("<html><body>");
		out.println("before");
		
		
		try {
			Class.forName(driver);
			Connection c = DriverManager.getConnection("jdbc:odbc:thin:@localhost:1521:xe","system","ravicool");
			Statement s = c.createStatement();
			
			String s1="Select * from emp101 where name='"+name+"' and pass='"+pass+"'";
			
			ResultSet rs=s.executeQuery(s1);
			
				//res.sendRedirect("wel.html");
				res.sendRedirect("wel");
				//res.sendRedirect("http://google.com");
				//res.sendRedirect("http://localhost:9090/tom1/well");;
				
		}
		catch(Exception e){}
		//res.sendRedirect("wel.html");
			//res.sendRedirect("wel");
				res.sendRedirect("http://google.com");
				//res.sendRedirect("http://localhost:9090/tom1/well");
		out.println("<br>after");
		out.println("</html></body>");
		
	}
}