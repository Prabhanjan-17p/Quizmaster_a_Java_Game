package game;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/startQuiz")
public class QuizExamServlet extends HttpServlet {
    Connection con;

    public void init() throws ServletException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "MYDB", "MYDB");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String ExaType = request.getParameter("examType");

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM INTERNSHIP_PROJECT_QNSANS WHERE QNSTYPE='"+ExaType+"'");

            out.println("<html><head><title>");
            out.print(ExaType);
            out.println(" Quiz</title>");
            out.println("<style>");
            out.println("body { font-family: Arial; padding: 20px; background: #f0f0f0; }");
            out.println("form { background: #fff; padding: 20px; border-radius: 8px; box-shadow: 0 2px 6px rgba(0,0,0,0.1); }");
            out.println("h2 { color: #333; }");
            out.println(".question { margin-bottom: 20px; }");
            out.println("input[type=submit] { padding: 10px 20px; border: none; background: #28a745; color: white; border-radius: 5px; cursor: pointer; }");
            out.println("</style></head><body>");
            out.println("<h2>");
            out.print(ExaType);
            out.print(" Quiz</h2>");
            out.println("<form method='post'>");

            int i = 1;
            while (rs.next()) {
                String qnsID = rs.getString("QNSID");
                out.println("<div class='question'>");
                out.println("<p><b>" + i + ". " + rs.getString("QNSNMAE") + "</b></p>");
                out.println("<input type='radio' name='" + qnsID + "' value='A'> " + rs.getString("OPTIONA") + "<br>");
                out.println("<input type='radio' name='" + qnsID + "' value='B'> " + rs.getString("OPTIONB") + "<br>");
                out.println("<input type='radio' name='" + qnsID + "' value='C'> " + rs.getString("OPTIONC") + "<br>");
                out.println("<input type='radio' name='" + qnsID + "' value='D'> " + rs.getString("OPTIOND") + "<br>");
                out.println("</div>");
                i++;
            }

            out.println("<input type='submit' value='Submit Quiz'>");
            out.println("</form></body></html>");

        } catch (Exception e) {
            out.println("<h3>Error loading quiz</h3>");
            e.printStackTrace(out);
        }
    }

    // Answers
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT QNSID, QNSANS FROM INTERNSHIP_PROJECT_QNSANS WHERE QNSTYPE='Java'");

           
            int total = 0;
            int score = 0;

            while (rs.next()) {
                total++;
                String qid = rs.getString("QNSID");
                String correctAns = rs.getString("QNSANS");
                String userAns = request.getParameter(qid);

                if (correctAns != null && correctAns.equalsIgnoreCase(userAns)) {
                    score++;
                }
            }

            out.println("<html><head><title>Quiz Result</title>");
            out.println("<style>");
            out.println("body { font-family: Arial; padding: 20px; background: #e9f7ef; }");
            out.println("div.result { background: white; padding: 20px; border-radius: 8px; box-shadow: 0 2px 6px rgba(0,0,0,0.1); }");
            out.println("h2 { color: #2e7d32; }");
            out.println("a { margin-top: 20px; display: inline-block; padding: 10px 20px; background: #007bff; color: white; border-radius: 5px; text-decoration: none; }");
            out.println("</style></head><body>");
            out.println("<div class='result'>");
            out.println("<h2>Your Quiz is Completed!</h2>");
            out.println("<p><b>Total Questions:</b> " + total + "</p>");
            out.println("<p><b>Your Score:</b> " + score + " / " + total + "</p>");
            out.println("<a href='dashboard.html'>Back to Dashboard</a>");
            out.println("</div></body></html>");

        } catch (Exception e) {
            out.println("<h3>Error processing answers</h3>");
            e.printStackTrace(out);
        }
    }

    public void destroy() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
