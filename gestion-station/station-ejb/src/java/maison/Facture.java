package maison;

import java.util.Date;

public class Facture {
    private int idFacture;
    private Date dateFacture;
    private double montant;
    private int idProprietaire;
    private int idMaison;

    // Constructeurs
    public Facture() {
    }

    public Facture(int idFacture, Date dateFacture, double montant, int idProprietaire, int idMaison) {
        this.idFacture = idFacture;
        this.dateFacture = dateFacture;
        this.montant = montant;
        this.idProprietaire = idProprietaire;
        this.idMaison = idMaison;
    }

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

    @Override
    public String toString() {
        return "Facture{" +
                "idFacture=" + idFacture +
                ", dateFacture=" + dateFacture +
                ", montant=" + montant +
                ", idProprietaire=" + idProprietaire +
                ", idMaison=" + idMaison +
                '}';
    }
}
