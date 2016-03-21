import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class Welcome extends HttpServlet
{
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		res.setContentType("text/html");
		PrintWriter out= res.getWriter();
		
		
		out.println("<html><body>");
		
					
		out.println("<br>Welcome "+ req.getAttribute("name"));
		out.println("</html></body>");
		
	}
}