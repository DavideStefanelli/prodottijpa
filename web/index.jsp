<%@page import="beans.UtenteBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
    UtenteBean utente = null;
    if(session.getAttribute("utente") != null){
        utente = (UtenteBean)session.getAttribute("utente");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <title>Home</title>
    </head>

    <body>
        <div class="container">
            <a href="editprodotto?action=view">Visualizza Prodotti</a>
            
            <% if(utente != null) { %>
                <br/>
                <a href="editCategoria.jsp">Modifica Categorie</a>
                <br/>
                <a href="editprodotto?action=edit">Modifica Prodotti</a>
                <br/>
                <a href="creaNegozio.jsp">Crea Negozio</a>
                <br/>
                <br/>
                <a href="utente?action=logout">Logout</a>
            <% } else { %>
                <br/>
                <a href="login.jsp">Accedi</a>
            <% } %>
            
        </div>

        <script src="js/bootstrap.min.js"></script>    
    </body>
</html>
