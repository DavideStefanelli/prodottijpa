<%-- 
    Document   : prodotti
    Created on : 17-mag-2018, 9.31.26
    Author     : web4e
--%>

<%@page import="java.util.List"%>
<%@page import="entities.Categoria"%>
<%@page import="entities.Prodotto"%>
<% 
    List<Prodotto> prodottiList = (List<Prodotto>) session.getAttribute("prodotti");
%>

<%@page import="entities.Prodotto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <title>JSP Page</title>
    </head>

    <body>


        <div class="container"> 
            <div class="table-responsive-xl">
                <table class="table">
                    <thead>
                        <tr>
                            <th>Immagine</th>
                            <th>Nome prodotto</th>
                            <th>Descrizione</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for(Prodotto p : prodottiList) { %>
                        
                            <tr>
                                <td><img src="<%= p.getImmagine()%>" alt="<%= p.getNome() %>" class="img-thumbnail"></td>
                                <td><%= p.getNome() %></td>
                                <td><%= p.getDescrizione() %></td> 
                            </tr>
                        
                        <% } %>
                    </tbody>
                </table>
            </div>

            <a href="index.html">Indietro</a>

        </div>

        <script src="js/bootstrap.min.js"></script>    
    </body>
</html>
