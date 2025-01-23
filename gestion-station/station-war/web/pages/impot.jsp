<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="maison.*" %>
<%@ page import="java.util.List" %>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    Proprietaire proprietaire = new Proprietaire();
    int userId = proprietaire.checkLogin(username, password); 

    if (userId > 0) {
        // Connexion réussie
        session.setAttribute("userId", userId);

        Maison maisonManager = new Maison();
        Maison[] maisons = null;
        try {
            maisons = maisonManager.getMaisonsByProprio(userId);
        } catch (Exception e) {
            out.println("<p style='color: red;'>Erreur lors de la récupération des maisons : " + e.getMessage() + "</p>");
        }

        if (maisons != null && maisons.length > 0) {
%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des Maisons</title>
    <!-- Inclusion de Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <div class="row justify-content-center mt-5">
            <div class="col-md-6 offset-md-1">
                <div class="card shadow">
                    <div class="card-body text-center">
                        <form action="InsertImpot.jsp" method="get">
                            <h5 class="card-title mb-4">Sélectionnez une maison :</h5>
                            <div class="mb-3">
                                <select class="form-select" name="idMaison" id="maison">
                                    <%
                                        for (Maison maison : maisons) {
                                            out.println("<option value='" + maison.getIdMaison() + "'>" + maison.getAdress() + "</option>");
                                        }
                                    %>
                                </select>
                                <select name="mois" id="mois" class="form-select" required>
                                    <option value="1">Janvier</option>
                                    <option value="2">Février</option>
                                    <option value="3">Mars</option>
                                    <option value="4">Avril</option>
                                    <option value="5">Mai</option>
                                    <option value="6">Juin</option>
                                    <option value="7">Juillet</option>
                                    <option value="8">Août</option>
                                    <option value="9">Septembre</option>
                                    <option value="10">Octobre</option>
                                    <option value="11">Novembre</option>
                                    <option value="12">Décembre</option>
                                </select>
                                <select name="annee" id="annee" class="form-select" required>
                                    <option value="2020">2020</option>
                                    <option value="2021">2021</option>
                                    <option value="2022">2022</option>
                                    <option value="2023">2023</option>
                                    <option value="2024">2024</option>
                                    <option value="2025">2025</option>
                                </select>
                            </div>
                            <button type="submit" class="btn btn-primary">Payer</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Inclusion de Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
<%
        } else {
            out.println("<p class='text-danger text-center'>Aucune maison n'a été trouvée pour ce propriétaire.</p>");
        }
    } else {
        // Connexion échouée
        response.sendRedirect("login.jsp?error=Identifiants incorrects");
    }
%>
