<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="maison.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Liste des Maisons</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h1>Liste des Maisons</h1>

    <%
        Maison maison = new Maison();
        Maison[] toutesLesMaisons = null;

        try {
            toutesLesMaisons = maison.getAllMaisons();
        } catch (Exception e) {
            out.println("<p style='color:red;'>Erreur : " + e.getMessage() + "</p>");
        }

        if (toutesLesMaisons != null && toutesLesMaisons.length > 0) {
    %>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Adresse</th>
                    <th>Longueur</th>
                    <th>Largeur</th>
                    <th>Longitude</th>
                    <th>Latitude</th>
                    <th>ID Arrondissement</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (Maison m : toutesLesMaisons) {
                %>
                    <tr>
                        <td><%= m.getIdMaison() %></td>
                        <td><%= m.getAdress() %></td>
                        <td><%= m.getLongueur() %></td>
                        <td><%= m.getLargueur() %></td>
                        <td><%= m.getLongitude() %></td>
                        <td><%= m.getLatitude() %></td>
                        <td><%= m.getIdArrondissement() %></td>
                    </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    <%
        } else {
            out.println("<p>Aucune maison trouvée.</p>");
        }
    %>
</body>
</html>
