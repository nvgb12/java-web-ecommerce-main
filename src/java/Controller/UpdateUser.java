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
public class UpdateUser extends HttpServlet {
   
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
            out.println("<title>Servlet updateUser</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet updateUser at " + request.getContextPath () + "</h1>");
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
        UserDao userDb = new UserDao();
        String resMessage = request.getParameter("response");
        try{
            int id = Integer.parseInt(request.getParameter("id"));
            User user = userDb.getUserById(id);
            request.setAttribute("user", user);
            if(resMessage != null){
                request.setAttribute("response", resMessage);
            }
            request.getRequestDispatcher("updateUser.jsp").forward(request, response);
        }catch(Exception e){
            System.out.println(e.getMessage());
            response.sendRedirect("GetAllUser");
        }
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
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        int gender = 0 ;
        int id = 0;
        //kiem tra xem gender va id co phai la int khong
        try{
            gender = Integer.parseInt(request.getParameter("gender"));
            id  = Integer.parseInt(request.getParameter("id"));
        }catch(Exception e){
            System.out.println(e.getMessage());
            response.sendRedirect("GetAllUser");
        }
        
        //update information
        UserDao userDb = new UserDao();
        User user = new User(id, email, lastName, firstName, lastName, gender, address);
        try{
            int result = userDb.updateUser(user);
            if(result <= 0){
                response.sendRedirect("updateUser?id="+id+"&response=email_is_existed");
            }else{
                response.sendRedirect("GetAllUser");
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            response.sendRedirect("updateUser?id="+id+"&response=update_failed");
        }
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
