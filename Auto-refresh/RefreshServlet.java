//Auto refresh
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;

public class RefreshServlet extends HttpServlet
{
	static int count=0;
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		
		res.setContentType("text/html");
		PrintWriter out= res.getWriter();
		
		res.setHeader("Refresh","2");
		out.println(new Date().toString()+"time"+count++);
		
	}
}