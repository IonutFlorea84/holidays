/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.jademy.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gabi
 */
public class Register_form extends HttpServlet {

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

        SqlConnection conn = new SqlConnection();
        conn.makeConnection();

        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/result.jsp");

        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("hir_date"));

            if (!conn.checkIfUserExists(username)) {

                User registerUser = new User();

                registerUser.setUsername(username);
                registerUser.setPassword(request.getParameter("password"));
                registerUser.setName(request.getParameter("name"));
                registerUser.setSurname(request.getParameter("surname"));
                registerUser.setEmail(request.getParameter("email"));
                registerUser.setDepartment(request.getParameter("department"));
                registerUser.setHir_date(date);
                registerUser.setAddress(request.getParameter("address"));
                registerUser.setPhone(request.getParameter("phone"));
                registerUser.setGender(request.getParameter("gender"));

                conn.addUserToDB(registerUser);

                context.setAttribute("result", "added to db");
                dispatcher = context.getRequestDispatcher("/listUsers.jsp");

            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

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
