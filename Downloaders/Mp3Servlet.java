//Auto refresh
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;

public class Mp3Servlet extends HttpServlet
{
	static int count=0;
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		String filename="Muskurane.mp3";
		ServletOutputStream stream= null;
		BufferedInputStream buf = null;
		
		stream = res.getOutputStream();
		String s1 = getServletContext()
		res.setContentType("text/html");
		PrintWriter out= res.getWriter();
		
		res.setHeader("Refresh","2");
		out.println(new Date().toString()+"time"+count++);
		
	}
}