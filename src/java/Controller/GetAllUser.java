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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HOME PC
 */
public class GetAllUser extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GetAllUser</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GetAllUser at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        User user = (User) request.getSession().getAttribute("userData");
        int page = 1;
        if (user != null && user.getRole() == 1) {
            UserDao ud = new UserDao();
            List<User> listUser = null;
            try {
                listUser = ud.getAllUser();
                String s = request.getParameter("page");
                if(s!= null){
                    page = Integer.parseInt(s);
                }else{
                    page = 1;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
            //phan trang
            
            int amountPerPage = 15;
            int totalPage = (int)Math.ceil((float)listUser.size()/amountPerPage);
            int start = (page-1)*amountPerPage > listUser.size() ? listUser.size() : (page-1)*amountPerPage;;
            int end = (page-1)*amountPerPage+amountPerPage > listUser.size() ? listUser.size() : (page-1)*amountPerPage+amountPerPage;
            listUser = listUser.subList(start, end);
            request.setAttribute("totalPage", totalPage);
            request.setAttribute("page", page);
            request.setAttribute("data", listUser);
            request.getRequestDispatcher("userManagement.jsp").forward(request, response);
        } else {
            response.sendRedirect("Home");
            return;
        }
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
