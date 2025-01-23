package maison;

import java.sql.*;
import java.util.*;

public class Arrondissement {
    private int idArrondissement;
    private String nomArrondissement;

    // Getters et Setters
    public int getIdArrondissement() {
        return idArrondissement;
    }

    public void setIdArrondissement(int idArrondissement) {
        this.idArrondissement = idArrondissement;
    }

    public String getNomArrondissement() {
        return nomArrondissement;
    }

    public void setNomArrondissement(String nomArrondissement) {
        this.nomArrondissement = nomArrondissement;
    }

    // Fonction pour obtenir la situation de paiement par arrondissement
    public void getSituationPaiementParArrondissement(int annee) throws SQLException {
        try (Connection c = new UtilDB().GetConn()) {
            if (c == null || c.isClosed()) {
                throw new SQLException("Impossible d'établir une connexion à la base de données.");
            }

            // 1. Obtenir les maisons dans l'arrondissement pour l'année donnée
            String query = "SELECT m.id_maison, m.id_arrondissement, p.montant " +
                           "FROM Maison m " +
                           "JOIN Paymant p ON m.id_maison = p.id_maison " +
                           "WHERE m.id_arrondissement = ? AND p.annee = ?";
            double totalPaiement = 0;
            int nombreMoisPayes = 0;
            double montantRestant = 0;

            try (PreparedStatement ps = c.prepareStatement(query)) {
                ps.setInt(1, idArrondissement);
                ps.setInt(2, annee);

                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        double montantMaison = rs.getDouble("montant");
                        totalPaiement += montantMaison;

                        // Récupérer l'impôt mensuel pour la maison (vous devez implémenter cette méthode)
                        Maison maison = new Maison();
                        double impotMensuel = maison.getImpot(rs.getInt("id_maison"), annee);

                        // Calculer le nombre de mois payés
                        nombreMoisPayes += (int)(montantMaison / impotMensuel);
                    }
                }
            }

            // 2. Obtenir l'impôt annuel total pour l'arrondissement (en supposant qu'il s'agit de l'impôt annuel de chaque maison)
            String queryImpotAnnuel = "SELECT SUM(m.getImpot(m.id_maison, ?)) AS impotAnnuel " +
                                      "FROM Maison m " +
                                      "WHERE m.id_arrondissement = ?";
            double impotAnnuelTotal = 0;

            try (PreparedStatement ps = c.prepareStatement(queryImpotAnnuel)) {
                ps.setInt(1, annee);
                ps.setInt(2, idArrondissement);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        impotAnnuelTotal = rs.getDouble("impotAnnuel");
                    }
                }
            }

            // 3. Calcul du montant restant et des mois restants
            montantRestant = impotAnnuelTotal - totalPaiement;
            int moisRestants = (int)((montantRestant / (impotAnnuelTotal / 12)));

            // Affichage des résultats
            System.out.println("Arrondissement : " + nomArrondissement);
            System.out.println("Total des paiements effectués : " + totalPaiement);
            System.out.println("Montant restant à payer : " + montantRestant);
            System.out.println("Nombre de mois restants à payer : " + moisRestants);
        } catch (SQLException e) {
            System.err.println("Erreur dans getSituationPaiementParArrondissement : " + e.getMessage());
            throw e;
        }
    }
}
