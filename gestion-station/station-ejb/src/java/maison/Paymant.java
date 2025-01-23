package maison;

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
}
