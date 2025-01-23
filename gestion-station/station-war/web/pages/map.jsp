<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Carte de Madagascar</title>
    <link rel="stylesheet" href="https://unpkg.com/leaflet@1.9.4/dist/leaflet.css" />
    <script src="https://unpkg.com/leaflet@1.9.4/dist/leaflet.js"></script>
    <style>
        #map {
            width: 100%;
            height: 600px;
        }
    </style>
</head>
<body>
    <h1>Carte de Madagascar</h1>
    <div id="map"></div>
    <script>
        // Initialiser la carte
        var map = L.map('map').setView([-18.8792, 47.5079], 7);

        // Ajouter une couche OpenStreetMap
        L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
            attribution: '© <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors'
        }).addTo(map);

        // Ajouter un marqueur
        L.marker([-18.8792, 47.5079]).addTo(map)
            .bindPopup('<b>Antananarivo</b><br>Capitale de Madagascar.')
            .openPopup();
    </script>
</body>
</html>
