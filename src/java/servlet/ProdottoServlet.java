package servlet;

import beans.ProdottoBean;
import ejbs.ProdottiEJBLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProdottoServlet extends HttpServlet {

    @EJB
    ProdottiEJBLocal prodottiEjb;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String action = request.getParameter("action");
        if (action != null) {
            if (action.equals("edit")) {
                session.setAttribute("categorie", prodottiEjb.getCategorie());
                response.sendRedirect("editProdotto.jsp");
            } else if (action.equals("view")) {
                session.setAttribute("prodotti", prodottiEjb.getProdotti());
                response.sendRedirect("prodotti.jsp");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProdottoBean p = new ProdottoBean(
                request.getParameter("nomeProd"),
                request.getParameter("descrizioneProd"),
                request.getParameter("immagine")
        );
        int idCat = Integer.parseInt(request.getParameter("catId"));
        boolean success = prodottiEjb.aggiungiProdotto(p, idCat);
        if (success) {
            response.sendRedirect("index.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }

    }

}
