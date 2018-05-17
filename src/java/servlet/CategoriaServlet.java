package servlet;

import beans.CategoriaBean;
import ejbs.ProdottiEJBLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 

public class CategoriaServlet extends HttpServlet {
    
    @EJB
    ProdottiEJBLocal prodottiEjb;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CategoriaBean c = new CategoriaBean(
                request.getParameter("nomeCat"), 
                request.getParameter("descrizioneCat"),
                request.getParameter("immagine")
        );
        boolean success = prodottiEjb.aggiungiCategoria(c);
        
        if(success) {
            response.sendRedirect("index.html");
        } else {
            response.sendRedirect("errore500.html");
        }
        
    }

}
