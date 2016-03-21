//How many hits
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;

public class ErrorCodeExample extends HttpServlet
{
	PrintWriter out;
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		
		res.setContentType("text/html");
		out= res.getWriter();
		
		res.sendError(500);
	}
}