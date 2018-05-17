package servlet;

import ejbs.UserEjbLocal;
import entities.Utente;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserServlet extends HttpServlet {

    @EJB
    UserEjbLocal userEjb;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("logout")) {
            request.getSession().invalidate();
            response.sendRedirect("login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("login")) {
            Utente utente = userEjb.eseguiLogin(request.getParameter("email"), request.getParameter("password"));
            if (utente != null) {
                HttpSession sessione = request.getSession();
                sessione.setAttribute("utente", utente);
                response.sendRedirect("editprodotto?action=view");
            } else {
                response.sendRedirect("login.jsp");
            }
        } 
    }

}
