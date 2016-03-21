//How many hits
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class ContextAttribute extends HttpServlet
{
	PrintWriter out;
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		
		res.setContentType("text/html");
		out= res.getWriter();
		
		ServletContext ctx = getServletContext();
		
		Integer count = (Integer)ctx.getAttribute("count");
		out.println("<html><body>");
		
		if(count == null)
		{
			count = 0;
		}
		
		count = count+1;
		
		ctx.setAttribute("count",count);
		
		out.println("You are "+count+" visitor");
		out.println("</body></html>");
	}
}