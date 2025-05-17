package game;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/quizfromadmin")
public class QuizFrom extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
       
    public QuizFrom() {
        super();
    }
    
	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "MYDB", "MYDB");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void destroy() {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
	    	Random ran = new Random();
	    	int qid = ran.nextInt(90000);
	        String qnsId = "Q" + qid; // Simple unique ID
	        String qnsAns = request.getParameter("qnsans");
	        String qnsName = request.getParameter("qnsname");
	        String qnsType = request.getParameter("qnstype");

	        String optionA = request.getParameter("optionA");
	        String optionB = request.getParameter("optionB");
	        String optionC = request.getParameter("optionC");
	        String optionD = request.getParameter("optionD");

	        String insertQuery = "INSERT INTO INTERNSHIP_PROJECT_QNSANS VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

	        PreparedStatement pstmt = con.prepareStatement(insertQuery);
	        pstmt.setString(1, qnsId);
	        pstmt.setString(2, qnsAns);
	        pstmt.setString(3, qnsName);
	        pstmt.setString(4, qnsType);
	        pstmt.setString(5, optionA);
	        pstmt.setString(6, optionB);
	        pstmt.setString(7, optionC);
	        pstmt.setString(8, optionD);

	        int rowsInserted = pstmt.executeUpdate();

	        if (rowsInserted > 0) {
	        	response.getWriter().println(
	        		    "<!DOCTYPE html>" +
	        		    "<html lang='en'>" +
	        		    "<head>" +
	        		    "<meta charset='UTF-8'>" +
	        		    "<meta name='viewport' content='width=device-width, initial-scale=1.0'>" +
	        		    "<title>Success</title>" +
	        		    "<style>" +
	        		    "body { font-family: 'Segoe UI', sans-serif; background: linear-gradient(to right, #00c7ae, #006d77); display: flex; justify-content: center; align-items: center; height: 100vh; }" +
	        		    ".card { background: #fff; padding: 2rem 3rem; border-radius: 16px; box-shadow: 0 8px 30px rgba(0,0,0,0.2); text-align: center; max-width: 500px; }" +
	        		    ".card h2 { color: #006d77; margin-bottom: 1rem; }" +
	        		    ".card p { color: #444; font-size: 1rem; margin-bottom: 2rem; }" +
	        		    ".btn { padding: 0.6rem 1.5rem; margin: 0.5rem; font-weight: bold; font-size: 1rem; border: none; border-radius: 8px; cursor: pointer; transition: 0.3s; }" +
	        		    ".btn-add { background-color: #00c7ae; color: white; }" +
	        		    ".btn-add:hover { background-color: #019c8e; }" +
	        		    ".btn-logout { background-color: #f44336; color: white; }" +
	        		    ".btn-logout:hover { background-color: #d32f2f; }" +
	        		    "</style>" +
	        		    "</head>" +
	        		    "<body>" +
	        		    "<div class='card'>" +
	        		    "<h2>✅ Question Saved Successfully!</h2>" +
	        		    "<p>You can now add another question or logout.</p>" +
	        		    "<a href='quizform.html'><button class='btn btn-add'>➕ Add New Question</button></a>" +
	        		    "<a href='quizmaster.html'><button class='btn btn-logout'>🚪 Logout</button></a>" +
	        		    "</div>" +
	        		    "</body>" +
	        		    "</html>"
	        		     );
	        } else {
	            response.getWriter().println("<h3>❌ Failed to save question.</h3>");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        response.getWriter().println("<h3>Error: " + e.getMessage() + "</h3>");
	    }
	}


//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	    try {
//	    	Random ran = new Random();
//	    	int qid = ran.nextInt(90000);
//	        String qnsId = "Q" + qid; // Simple unique ID
//	        String qnsAns = request.getParameter("qnsans");
//	        String qnsName = request.getParameter("qnsname");
//	        String qnsType = request.getParameter("qnstype");
//
//
//	        String insertQuery = "INSERT INTO INTERNSHIP_PROJECT_QNSANS VALUES (?, ?, ?, ?)";
//
//	        PreparedStatement pstmt = con.prepareStatement(insertQuery);
//	        pstmt.setString(1, qnsId);
//	        pstmt.setString(2, qnsAns);
//	        pstmt.setString(3, qnsName);
//	        pstmt.setString(4, qnsType);
//
//	        int rowsInserted = pstmt.executeUpdate();
//	        if (rowsInserted > 0) {
//	        	response.getWriter().println(
//	        		    "<!DOCTYPE html>" +
//	        		    "<html lang='en'>" +
//	        		    "<head>" +
//	        		    "<meta charset='UTF-8'>" +
//	        		    "<meta name='viewport' content='width=device-width, initial-scale=1.0'>" +
//	        		    "<title>Success</title>" +
//	        		    "<style>" +
//	        		    "body { font-family: 'Segoe UI', sans-serif; background: linear-gradient(to right, #00c7ae, #006d77); display: flex; justify-content: center; align-items: center; height: 100vh; }" +
//	        		    ".card { background: #fff; padding: 2rem 3rem; border-radius: 16px; box-shadow: 0 8px 30px rgba(0,0,0,0.2); text-align: center; max-width: 500px; }" +
//	        		    ".card h2 { color: #006d77; margin-bottom: 1rem; }" +
//	        		    ".card p { color: #444; font-size: 1rem; margin-bottom: 2rem; }" +
//	        		    ".btn { padding: 0.6rem 1.5rem; margin: 0.5rem; font-weight: bold; font-size: 1rem; border: none; border-radius: 8px; cursor: pointer; transition: 0.3s; }" +
//	        		    ".btn-add { background-color: #00c7ae; color: white; }" +
//	        		    ".btn-add:hover { background-color: #019c8e; }" +
//	        		    ".btn-logout { background-color: #f44336; color: white; }" +
//	        		    ".btn-logout:hover { background-color: #d32f2f; }" +
//	        		    "</style>" +
//	        		    "</head>" +
//	        		    "<body>" +
//	        		    "<div class='card'>" +
//	        		    "<h2>✅ Question Saved Successfully!</h2>" +
//	        		    "<p>You can now add another question or logout.</p>" +
//	        		    "<a href='quizform.html'><button class='btn btn-add'>➕ Add New Question</button></a>" +
//	        		    "<a href='quizmaster.html'><button class='btn btn-logout'>🚪 Logout</button></a>" +
//	        		    "</div>" +
//	        		    "</body>" +
//	        		    "</html>"
//	        		);
//
//	        } else {
//	            response.getWriter().println("<h3>Failed to save question.</h3>");
//	        }
//
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	        response.getWriter().println("<h3>Error: " + e.getMessage() + "</h3>");
//	    }
//	}


}
