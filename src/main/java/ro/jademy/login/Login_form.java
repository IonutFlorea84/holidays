package ro.jademy.login;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Owner
 */
@WebServlet(urlPatterns = {"/login_form"})
public class Login_form extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        SqlConnection sqlConn = new SqlConnection();
        sqlConn.makeConnection();
        boolean answer = false;
        boolean login = false;
        StringBuilder userTable = new StringBuilder("<table>");
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/result.jsp");
        List<String> tableHeadName = new ArrayList<>();
        if (request.getParameter("login") != null) {
            if (sqlConn.loginUser(username, password)) {
                ResultSet users = sqlConn.listDB("grades");
                try {
                    ResultSetMetaData rsmd = users.getMetaData();
                    int columnCount = rsmd.getColumnCount();
                    userTable.append("<tr>");
                    for (int i = 1; i <= columnCount; i++) {
                        String name = rsmd.getColumnName(i);
                        tableHeadName.add(name);
                        
                        if (!name.equals("id")) {
                            userTable.append("<th>").append(name).append("</th>");
                        }
                    }
                    userTable.append("</tr>");

                    while (users.next()) {
                        userTable.append("<tr>");
                        for (String th : tableHeadName) {
                            if (!th.equals("id")){
                                userTable.append("<td>").append(users.getString(th)).append("</td>");
                            }
                        }
                        userTable.append("</tr>");
                    }
                    userTable.append("</table>");
                } catch (SQLException ex) {
                    Logger.getLogger(Login_form.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.setAttribute("result", "Autentificare reusita");
                request.setAttribute("userlist", userTable.toString());
                dispatcher = context.getRequestDispatcher("/listUsers.jsp");
            } else {
                request.setAttribute("result", "Username or password wrong");
            }
        } 
//        else if (request.getParameter("register") != null) {
//            if (sqlConn.checkIfUserExists(username)) {
//                request.setAttribute("result", "Username already in use.");
//            } else {
//                sqlConn.addUserToDB(username, password);
//                request.setAttribute("result", "Userul a fost inregistrat");
//            }
//        }

        dispatcher.forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
