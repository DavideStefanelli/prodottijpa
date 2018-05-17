<%-- 
    Document   : prodotto.jsp
    Created on : 17-mag-2018, 9.30.55
    Author     : web4e
--%>

<%@page import="java.util.List"%>
<%@page import="entities.Categoria"%>
<%@page import="entities.Categoria"%>
<%

    List<Categoria> categoriaList = (List<Categoria>) session.getAttribute("categorie");

%>

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
            <form class="form-signin" method="post" action="editprodotto">

                <label for="nomeProd">Nome</label>
                <input type="text" id="nomeProd" class="form-control" name="nomeProd" placeholder="Nome prodotto" required>

                <label for="descrizioneProd">Descrizione</label>
                <textarea rows="3" id="descrizioneProd" class="form-control" name="descrizioneProd" placeholder="Descrizione prodotto" required></textarea>

                <div class="form-group">
                    <label for="catSel">Seleziona cateogira</label>
                    <select name="catId" class="form-control" id="catSel">
                        <% for (Categoria c : categoriaList) {%> 
                            <option value="<%= c.getId()%>"><%= c.getNome()%></option>
                        <% }%>
                    </select>

                </div>
                    
                <input type="hidden" name="immagine" value="http://via.placeholder.com/128" />

                <input type="submit" class="btn btn-lg btn-primary btn-block" value="Aggiungi"/>


            </form>
            <br/>
            <a href="index.jsp">Indietro</a>
        </div>
        <script src="js/bootstrap.min.js"></script>    
    </body>
</html>
