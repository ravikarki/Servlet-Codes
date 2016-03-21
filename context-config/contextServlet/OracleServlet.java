import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class ConfigServlet extends HttpServlet
{
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		
		res.setContentType("text/html");
		PrintWriter out= res.getWriter();
		
		ServletContext ctx = getServletContext();
		
		out.println("<html><body>");
		
		String driver = ctx.getInitParameter("driver");
		String url = ctx.getInitParameter("url");
		String user = ctx.getInitParameter("user");
		String pass = ctx.getInitParameter("pass");
		
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, pass);
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("Select * from emp101");
			
			while(rs.next())
			{
				out.println(rs.getString(1));
				out.println(rs.getString(2));	
			}
		}catch(Exception e) {}
		
		out.println("</body></html>");
	}
}