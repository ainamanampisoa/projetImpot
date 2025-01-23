<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.io.*, java.util.*" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Confirmation du Paiement</title>
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Récapitulatif du Paiement</h1>
        <div class="card shadow mt-4">
            <div class="card-body">
<%
    String idMaison = request.getParameter("idMaison");
    String mois = request.getParameter("mois");
    String annee = request.getParameter("annee");

    if (idMaison != null && mois != null && annee != null) {
%>
                <p><strong>ID Maison :</strong> <%= idMaison %></p>
                <p><strong>Mois :</strong> <%= mois %> (<%= new DateFormatSymbols(Locale.FRENCH).getMonths()[Integer.parseInt(mois) - 1] %>)</p>
                <p><strong>Année :</strong> <%= annee %></p>
<%
    } else {
%>
                <p class="text-danger">Erreur : Les informations transmises sont incomplètes. Veuillez réessayer.</p>
<%
    }
%>
            </div>
        </div>
    </div>
    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
