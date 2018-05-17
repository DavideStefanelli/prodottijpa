<%-- 
    Document   : categoria.jsp
    Created on : 17-mag-2018, 9.30.44
    Author     : web4e
--%>
 

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
            <form class="form-signin" method="post" action="editcategoria">
            
                <label for="nomeCat">Nome prodotto</label>
                <input type="text" id="nomeCat" class="form-control" name="nomeCat" placeholder="Nome categoria" required>
                
                <label for="descrizioneCat">Descrizione prodotto</label>
                <textarea rows="3" id="descrizioneCat" class="form-control" name="descrizioneCat" placeholder="Descrizione categoria" required></textarea>
                
                <input type="hidden" name="immagine" value="http://via.placeholder.com/128" />
                
                <input type="submit" class="btn btn-lg btn-primary btn-block" value="Aggiungi"/>
                
                
            </form>
            <br/>
            <a href="index.html">Indietro</a>
        </div>
        
    <script src="js/bootstrap.min.js"></script>    
    </body>
</html>
