import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class RequestServlet extends HttpServlet
{
	/*
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<html><body>");
		String name=req.getParameter("name");
		String pass=req.getParameter("pass");
		if(name.equals("ravi") && pass.equals("ravicool"))
		{
			out.println("User is valid through <b>service</b> method");
		}
		else
		{
			out.println("User is invalid through <b>service</b> method");	
		}
		out.println("</body></html>");
	}
	*/
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<html><body>");
		String s=req.getMethod();
		out.println("<b>"+s+"</b>request from service");
		if(s.equals("POST"))
		{
			doPost(req,res);
		}
		if(s.equals("GET"))
		{
			doGet(req,res);
		}
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		res.setContentType("text/html");
		
		PrintWriter out = res.getWriter();
		out.println("<html><body>");
		String name=req.getParameter("name");
		String pass=req.getParameter("pass");
		
		String query="Insert into emp101 values( '"+name+"' , '"+pass+"')";
		out.println(query);
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection c= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","ravicool");
			
			Statement s = c.createStatement();
			
			int x = s.executeUpdate(query);
			
			ResultSet rs = s.executeQuery("Select * from emp101");

			ResultSetMetaData rsmd=rs.getMetaData();
			
			out.println("<table bgcolor='yellow' border=1 width=200>");
			
			out.println("<tr>");
			for(int i=0; i>rsmd.getColumnCount(); i++)
			{
				out.println("<th>"+rsmd.getColumnName(i)+"</th>");
			}
			out.println("</tr>");
			
			while(rs.next())
			{
				out.println("<tr>");
				
				out.println("<td>"+rs.getString(1)+"</td>");
				out.println("<td>"+rs.getString(2)+"</td>");
				
				out.println("</tr>");
				
			}
			
			out.println("</table>");
			
		}catch(Exception e){
			System.out.println(e);}		
		
		if(name.equals("ravi") && pass.equals("ravicool"))
		{
			out.println("User is valid through <b>post</b> method");
		}
		else
		{
			out.println("User is invalid through <b>post</b> method");	
		}
		out.println("</body></html>");
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<html><body>");
		String name=req.getParameter("name");
		String pass=req.getParameter("pass");
		if(name.equals("ravi") && pass.equals("ravicool"))
		{
			out.println("User is valid through <b>get</b> method");
		}
		else
		{
			out.println("User is invalid through <b>get</b> method");	
		}
		out.println("</body></html>");
	}
	
}