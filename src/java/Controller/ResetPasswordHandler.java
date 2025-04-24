/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import Dal.UserDao;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author HOME PC
 */
public class ResetPasswordHandler extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ResetPasswordHandler</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ResetPasswordHandler at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.getRequestDispatcher("resetPassword.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        UserDao db = new UserDao();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        if(email.isBlank()){
            request.setAttribute("response", "email khong duoc rong");
            request.getRequestDispatcher("resetPassword.jsp").forward(request, response);
            return;
        }else if(password.isBlank()){
            request.setAttribute("response", "password khong duoc rong");
            request.getRequestDispatcher("resetPassword.jsp").forward(request, response);
            return;
        } else if(confirmPassword.isBlank()){
            request.setAttribute("response", "confirm password khong duoc rong");
            request.getRequestDispatcher("resetPassword.jsp").forward(request, response);
            return;
        }
        User user = db.getUserByEmail(email);
        if(user == null){
            request.setAttribute("response", "user khong ton tai");
            request.getRequestDispatcher("resetPassword.jsp").forward(request, response);
            return;
        }
        if(!password.equals(confirmPassword)){
            request.setAttribute("response", "password khong giong nhau");
            request.getRequestDispatcher("resetPassword.jsp").forward(request, response);
            return;
        }
        
        int rowAffected = db.updatePassword(email, password);
        if(rowAffected > 0){
            request.setAttribute("isSuccess", true);
            request.setAttribute("response", "reset successfully");           
        }else{
            request.setAttribute("response", "reset failed");
        }
        
        request.getRequestDispatcher("resetPassword.jsp").forward(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
