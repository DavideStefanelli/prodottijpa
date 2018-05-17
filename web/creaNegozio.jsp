<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <title>Crea negozio</title>
    </head>
    <body>

        <div class="container"> 
            
            <form class="form-signin" method="POST" action="negozio">
                <h2>Crea un negozio</h2>
                <input type="hidden" name="action" value="crea">
                <label for="nome" class="sr-only">Nome</label>
                <input type="text" id="nome" class="form-control" name="nome" placeholder="Nome negozio..." required autofocus>
                
                <label for="descrizioneNegozio">Descrizione negozio</label>
                <textarea rows="3" id="descrizioneNegozio" class="form-control" name="descrizione" placeholder="Descrizione negozio" required></textarea>
                
                <button class="btn btn-lg btn-primary btn-block" type="submit">Crea</button>
                
            </form>
            
            <a href="index.jsp">Indietro</a>

        </div>

        <script src="js/bootstrap.min.js"></script>    

    </body>
</html>
