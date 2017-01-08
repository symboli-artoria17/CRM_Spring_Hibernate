package Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class TestDBConn
 */
@WebServlet("/TestDBConn")
public class TestDBConn extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TestDBConn() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// setup connections variables
		String userAndPw = "root";
		String jdbcURL = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";
		
		// get connection to db
		try{
			PrintWriter out = response.getWriter();
			out.println("Connecting to database:" + jdbcURL);
			
			/*
			 * Loading class 'com.mysql.jdbc.Driver'. 
			 * This is deprecated.!!
			 * The new driver class is `com.mysql.cj.jdbc.Driver'. 
			 * The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.
			 */
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection myConn = DriverManager.getConnection(jdbcURL,userAndPw,userAndPw);
			
			out.println("SUCCESS!!!");
			
			myConn.close();
		}catch(Exception e){
			e.printStackTrace();
			throw new ServletException(e);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
