import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebServlet (
	urlPatterns = {"/initparam"},
	initParams = { @WebInitParam(name="email", value="rskrocks@gmail.com"),
					@WebInitParam(name="phone", value="123456")
				}
	)

public class ServletInitParamDemo extends HttpServlet
{
	private String email="",phone="";
	public ServletInitParamDemo()
	{
		super();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException
	{
		//super.init(config);
		//The above statement is optional. Only required if you wish to call getInitParameter() directly
		email = config.getInitParameter("email");
		phone = config.getInitParameter("phone");
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		res.setContentType("text/html");
		PrintWriter out= res.getWriter();
		
		out.println("<html><body>"+"<br><h2>Accessed data using Annotation @WebInitParam </h2>");
		out.println("<br>Email : "+email+"<br />Phone :"+phone+"</body></html>");
	}
}