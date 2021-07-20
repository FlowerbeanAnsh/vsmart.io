import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class Contact extends HttpServlet {  
@Override
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String first_name=request.getParameter("first_name");  
String last_name=request.getParameter("last_name");  
String country=request.getParameter("country");  
String subject=request.getParameter("subject");  
          
try{  
Class.forName("com.mysql.cj.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/employee", "root", "");  
  
PreparedStatement ps=con.prepareStatement(  
"insert into contact values(?,?,?,?)");  
  
ps.setString(1,first_name);  
ps.setString(2,last_name);  
ps.setString(3,country);  
ps.setString(4,subject);  
          
int i=ps.executeUpdate();  
if(i>0)  
out.print("<h1>Your response has been recorded..we will contact you soon</h1>  "+ "<a href='home.html'>Home</a>");   
      
          
}catch (Exception e2) {System.out.println(e2);}  
          
out.close();  
}  
  }
