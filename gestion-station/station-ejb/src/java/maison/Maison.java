package maison;

import bean.CGenUtil;
import bean.AdminGen;
import bean.ClassMere;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import utilitaire.UtilDB;

public class Maison {
    private int idMaison;
    private String adress;
    private double longitude;
    private double latitude;
    private int idCommun;
    private int idProprietaire;
    private int idArrondissement;

    // Constructeurs
    public Maison() {
    }

    public Maison(int idMaison, String adress, double longitude, double latitude, int idCommun, int idProprietaire, int idArrondissement) {
        this.idMaison = idMaison;
        this.adress = adress;
        this.longitude = longitude;
        this.latitude = latitude;
        this.idCommun = idCommun;
        this.idProprietaire = idProprietaire;
        this.idArrondissement = idArrondissement;
    }

    // Getters et Setters
    public int getIdMaison() {
        return idMaison;
    }

    public void setIdMaison(int idMaison) {
        this.idMaison = idMaison;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getIdCommun() {
        return idCommun;
    }

    public void setIdCommun(int idCommun) {
        this.idCommun = idCommun;
    }

    public int getIdProprietaire() {
        return idProprietaire;
    }

    public void setIdProprietaire(int idProprietaire) {
        this.idProprietaire = idProprietaire;
    }

    public int getIdArrondissement() {
        return idArrondissement;
    }

    public void setIdArrondissement(int idArrondissement) {
        this.idArrondissement = idArrondissement;
    }

    @Override
    public String toString() {
        return "Maison{" +
                "idMaison=" + idMaison +
                ", adress='" + adress + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", idCommun=" + idCommun +
                ", idProprietaire=" + idProprietaire +
                ", idArrondissement=" + idArrondissement +
                '}';
    }

    public Maison[] getAllMaisons() throws Exception {
        List<Maison> maisons = new ArrayList<>();
    
        try (Connection c = new UtilDB().GetConn()) {
            if (c == null || c.isClosed()) {
                throw new Exception("Impossible d'établir une connexion à la base de données.");
            }
    
            String query = "SELECT id_maison, adress, longitude, latitude, id_commune, id_proprietaire, id_arrondissement FROM Maison";
            System.out.println("Exécution de la requête : " + query);
    
            try (PreparedStatement ps = c.prepareStatement(query);
                 ResultSet rs = ps.executeQuery()) {
    
                while (rs.next()) {
                    Maison maison = new Maison();
                    maison.setIdMaison(rs.getInt("id_maison"));
                    maison.setAdress(rs.getString("adress"));
                    maison.setLongitude(rs.getDouble("longitude"));
                    maison.setLatitude(rs.getDouble("latitude"));
                    maison.setIdCommun(rs.getInt("id_commune"));
                    maison.setIdProprietaire(rs.getInt("id_proprietaire"));
                    maison.setIdArrondissement(rs.getInt("id_arrondissement"));
    
                    maisons.add(maison);
                }
            }
        } catch (Exception e) {
            System.err.println("Erreur dans getAllMaisons : " + e.getMessage());
            throw e;
        }
        return maisons.toArray(new Maison[0]);
    }  
    
    public Maison[] getMaisonsByProprio(int userId) throws Exception {
        List<Maison> maisons = new ArrayList<>();
    
        try (Connection c = new UtilDB().GetConn()) {
            if (c == null || c.isClosed()) {
                throw new Exception("Impossible d'établir une connexion à la base de données.");
            }
    
            String query = "SELECT id_maison, adress, longitude, latitude, id_commun, id_proprietaire, id_arrondissement " +
                           "FROM Maison WHERE id_proprietaire = ?";
            System.out.println("Exécution de la requête : " + query);
    
            try (PreparedStatement ps = c.prepareStatement(query)) {
                ps.setInt(1, userId);
    
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        Maison maison = new Maison();
                        maison.setIdMaison(rs.getInt("id_maison"));
                        maison.setAdress(rs.getString("adress"));
                        maison.setLongitude(rs.getDouble("longitude"));
                        maison.setLatitude(rs.getDouble("latitude"));
                        maison.setIdCommun(rs.getInt("id_commun"));
                        maison.setIdProprietaire(rs.getInt("id_proprietaire"));
                        maison.setIdArrondissement(rs.getInt("id_arrondissement"));
    
                        maisons.add(maison);
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Erreur dans getMaisonsByProprio : " + e.getMessage());
            throw e;
        }
        return maisons.toArray(new Maison[0]);
    }  
}