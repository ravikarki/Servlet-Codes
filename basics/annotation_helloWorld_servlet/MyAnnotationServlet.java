import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.*;

@WebServlet ( name="MyAnnotationServlet" , urlPatterns={"/hello"} )

public class MyAnnotationServlet extends HttpServlet
{
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		//super.service(req,res);
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<html><body>");
		out.println("Hello world by annotation");	
		out.println("</body></html>");
	}	

	
}