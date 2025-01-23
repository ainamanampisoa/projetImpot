package maison;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Facture {
    private int idFacture;
    private Date dateFacture;
    private double montant;
    private int idProprietaire;
    private int idMaison;

    // Getters et Setters
    public int getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(int idFacture) {
        this.idFacture = idFacture;
    }

    public Date getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(Date dateFacture) {
        this.dateFacture = dateFacture;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public int getIdProprietaire() {
        return idProprietaire;
    }

    public void setIdProprietaire(int idProprietaire) {
        this.idProprietaire = idProprietaire;
    }

    public int getIdMaison() {
        return idMaison;
    }

    public void setIdMaison(int idMaison) {
        this.idMaison = idMaison;
    }

    // Fonction pour insérer une facture
    public void insererFacture() throws SQLException {
        String insertQuery = "INSERT INTO Facture (date_facture, montant, id_proprietaire, id_maison) " +
                             "VALUES (?, ?, ?, ?)";
        try (Connection conn = new UtilDB().GetConn()) {
            if (conn == null || conn.isClosed()) {
                throw new SQLException("Impossible d'établir une connexion à la base de données.");
            }

            try (PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {
                pstmt.setDate(1, dateFacture);  // Date de la facture
                pstmt.setDouble(2, montant);    // Montant de la facture
                pstmt.setInt(3, idProprietaire); // ID du propriétaire
                pstmt.setInt(4, idMaison);       // ID de la maison

                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Facture insérée avec succès.");
                } else {
                    System.out.println("Échec de l'insertion de la facture.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'insertion de la facture : " + e.getMessage());
            throw e;
        }
    }

    // Fonction pour récupérer toutes les factures
    public static List<Facture> getAllFacture() throws SQLException {
        String selectQuery = "SELECT * FROM Facture";
        List<Facture> factures = new ArrayList<>();

        try (Connection conn = new UtilDB().GetConn()) {
            if (conn == null || conn.isClosed()) {
                throw new SQLException("Impossible d'établir une connexion à la base de données.");
            }

            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(selectQuery)) {

                while (rs.next()) {
                    Facture facture = new Facture();
                    facture.setIdFacture(rs.getInt("id_facture"));
                    facture.setDateFacture(rs.getDate("date_facture"));
                    facture.setMontant(rs.getDouble("montant"));
                    facture.setIdProprietaire(rs.getInt("id_proprietaire"));
                    facture.setIdMaison(rs.getInt("id_maison"));
                    factures.add(facture);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des factures : " + e.getMessage());
            throw e;
        }

        return factures;
    }

    // Fonction pour récupérer les factures par id_maison
    public static List<Facture> getFactureByIdMaison(int idMaison) throws SQLException {
        String selectQuery = "SELECT * FROM Facture WHERE id_maison = ?";
        List<Facture> factures = new ArrayList<>();

        try (Connection conn = new UtilDB().GetConn()) {
            if (conn == null || conn.isClosed()) {
                throw new SQLException("Impossible d'établir une connexion à la base de données.");
            }

            try (PreparedStatement pstmt = conn.prepareStatement(selectQuery)) {
                pstmt.setInt(1, idMaison);
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        Facture facture = new Facture();
                        facture.setIdFacture(rs.getInt("id_facture"));
                        facture.setDateFacture(rs.getDate("date_facture"));
                        facture.setMontant(rs.getDouble("montant"));
                        facture.setIdProprietaire(rs.getInt("id_proprietaire"));
                        facture.setIdMaison(rs.getInt("id_maison"));
                        factures.add(facture);
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des factures par id_maison : " + e.getMessage());
            throw e;
        }

        return factures;
    }
}
