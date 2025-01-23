package maison;

import java.util.Date;

public class HistoMaison {
    private int idHisto;
    private double longueur;
    private double largueur;
    private int nbrEtage;
    private Date dateHisto;
    private int idMaison;

    // Constructeurs
    public HistoMaison() {
    }

    public HistoMaison(int idHisto, double longueur, double largueur, int nbrEtage, Date dateHisto, int idMaison) {
        this.idHisto = idHisto;
        this.longueur = longueur;
        this.largueur = largueur;
        this.nbrEtage = nbrEtage;
        this.dateHisto = dateHisto;
        this.idMaison = idMaison;
    }

    // Getters et Setters
    public int getIdHisto() {
        return idHisto;
    }

    public void setIdHisto(int idHisto) {
        this.idHisto = idHisto;
    }

    public double getLongueur() {
        return longueur;
    }

    public void setLongueur(double longueur) {
        this.longueur = longueur;
    }

    public double getLargueur() {
        return largueur;
    }

    public void setLargueur(double largueur) {
        this.largueur = largueur;
    }

    public int getNbrEtage() {
        return nbrEtage;
    }

    public void setNbrEtage(int nbrEtage) {
        this.nbrEtage = nbrEtage;
    }

    public Date getDateHisto() {
        return dateHisto;
    }

    public void setDateHisto(Date dateHisto) {
        this.dateHisto = dateHisto;
    }

    public int getIdMaison() {
        return idMaison;
    }

    public void setIdMaison(int idMaison) {
        this.idMaison = idMaison;
    }

    @Override
    public String toString() {
        return "HistoMaison{" +
                "idHisto=" + idHisto +
                ", longueur=" + longueur +
                ", largueur=" + largueur +
                ", nbrEtage=" + nbrEtage +
                ", dateHisto=" + dateHisto +
                ", idMaison=" + idMaison +
                '}';
    }
}
