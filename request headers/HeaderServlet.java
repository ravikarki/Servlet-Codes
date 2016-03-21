//How many hits
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;

public class HeaderServlet extends HttpServlet
{
	PrintWriter out;
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		
		res.setContentType("text/html");
		out= res.getWriter();
		
		out.println("<html><body>");
		
		Enumeration e=req.getHeaderNames();
		
		while(e.hasMoreElements())
		{
			String name=(String)e.nextElement();
			String value=req.getHeader(name);
			out.println("<br/>"+name+" : "+value);
		}
		
		out.println("<br>Protocol : "+req.getProtocol());
		out.println("<br>Method : "+req.getMethod());
		out.println("<br>Content Length : "+req.getContentLength());
		
		out.println("</body></html>");
	}
}