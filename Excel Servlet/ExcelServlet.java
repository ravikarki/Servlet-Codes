//How many hits
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;

public class ExcelServlet extends HttpServlet
{
	PrintWriter out;
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		
		res.setContentType("application/vnd.ms-excel");
		out= res.getWriter();
		
		out.println("name/thin/teng/tmaths/ttotal");
		out.println("lalu/t30/t40/t20/t=sum(b2:d2)");
		
	}
}