

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    String errorMsg = "Errore sconosciuto";
    if(session.getAttribute("errMsg") != null){
        errorMsg = (String)session.getAttribute("errMsg");
    }
%>
<html>
    <head>
        <title>Errore 500</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>

        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="error-template">
                        <h1>
                            Oops!</h1>
                        <h2>
                            Errore 500</h2>
                        <div class="error-details">
                            Si è verificato un errore interno del server: <%= errorMsg %>
                        </div>
                        <div class="error-actions">
                            <a href="/ProdottiJpa/" class="btn btn-primary btn-lg"><span class="glyphicon glyphicon-home"></span> Torna indietro </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>


    </body>
</html>
