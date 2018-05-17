package servlet;

import beans.NegozioBean;
import beans.UtenteBean;
import ejbs.NegozioEjbLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class NegozioServlet extends HttpServlet {

    @EJB
    NegozioEjbLocal negozioEjb;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        boolean error = false;
        
        String action = request.getParameter("action");
        if (action == null) {
            session.setAttribute("errMsg", "Richiesta non valida");
            error = true;
        } else {
            UtenteBean utenteBean = (UtenteBean) session.getAttribute("utente");

            if (utenteBean != null) {
                if (action.equals("crea")) {
                    NegozioBean nBean = new NegozioBean(
                            request.getParameter("nome"),
                            request.getParameter("descrizione")
                    );
                    if(negozioEjb.creaNegozio(nBean, utenteBean.getId()) == false){
                        error = true;
                    }
                }
            } else {
                session.setAttribute("errorMsg", "Utente non autenticato");
                error = true;
            }
        }
        
        if(error){
            response.sendRedirect("error.jsp");
        }

    }
}
