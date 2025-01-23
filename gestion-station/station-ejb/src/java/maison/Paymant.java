package maison;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Paymant {
    private int idPaymant;
    private int mois;
    private int annee;
    private double montant;
    private int idMaison;

    // Getters et Setters
    public int getIdPaymant() {
        return idPaymant;
    }

    public void setIdPaymant(int idPaymant) {
        this.idPaymant = idPaymant;
    }

    public int getMois() {
        return mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public int getIdMaison() {
        return idMaison;
    }

    public void setIdMaison(int idMaison) {
        this.idMaison = idMaison;
    }

    //Tsy aiko hoe tokony apiana idproprietaire ve ty? rah tokony de mba apio azafady

    public void EtatPaiement(double prix, int idMaison, int[] mois, int annee) throws Exception {
        try (Connection c = new UtilDB().GetConn()) {
            if (c == null || c.isClosed()) {
                throw new Exception("Impossible d'établir une connexion à la base de données.");
            }
            
            Maison maison=new Maison();
            // Vérifier l'impôt mensuel
            double impotMensuel = maison.getImpot(idMaison, mois[0], annee);
            if (prix < impotMensuel) {
                throw new Exception("Montant insuffisant pour payer l'impôt.");
            }
            
            // Vérifier les paiements précédents
            String checkQuery = "SELECT COUNT(*) AS nbPaiements FROM Paymant WHERE id_maison = ? AND annee = ?";
            int nbPaiementsExistant = 0;
            
            try (PreparedStatement ps = c.prepareStatement(checkQuery)) {
                ps.setInt(1, idMaison);
                ps.setInt(2, annee);
                
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        nbPaiementsExistant = rs.getInt("nbPaiements");
                    }
                }
            }
            
            int nombreMoisAPayer = (int) (prix / impotMensuel);
            if (nombreMoisAPayer > mois.length) {
                nombreMoisAPayer = mois.length;
            }
            
            // Insérer les paiements
            String insertQuery = "INSERT INTO Paymant(id_paymant, mois, annee, montant, id_maison) VALUES (SEQ_PAYMANT.NEXTVAL, ?, ?, ?, ?)";
            
            try (PreparedStatement ps = c.prepareStatement(insertQuery)) {
                for (int i = 0; i < nombreMoisAPayer; i++) {
                    ps.setInt(1, mois[i]);
                    ps.setInt(2, annee);
                    ps.setDouble(3, impotMensuel);
                    ps.setInt(4, idMaison);
                    ps.executeUpdate();
                }
            }
            
            int moisRestants = mois.length - nombreMoisAPayer;
            double montantRestant = prix - (nombreMoisAPayer * impotMensuel);
            
            System.out.println("Nombre de mois payés : " + nombreMoisAPayer);
            System.out.println("Nombre de mois restants : " + moisRestants);
            System.out.println("Montant total payé : " + (nombreMoisAPayer * impotMensuel));
            System.out.println("Montant restant : " + montantRestant);
        } catch (Exception e) {
            System.err.println("Erreur dans payerImpot : " + e.getMessage());
            throw e;
        }
    }
    
}
