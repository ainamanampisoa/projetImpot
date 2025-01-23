package maison;

import java.sql.Date;

public class MetreCarree {
    private int id;
    private double prix;
    private Date datePrix;
    private int idCommun;

    // Constructeurs
    public MetreCarree() {
    }

    public MetreCarree(int id, double prix, Date datePrix, int idCommun) {
        this.id = id;
        this.prix = prix;
        this.datePrix = datePrix;
        this.idCommun = idCommun;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Date getDatePrix() {
        return datePrix;
    }

    public void setDatePrix(Date datePrix) {
        this.datePrix = datePrix;
    }

    public int getIdCommun() {
        return idCommun;
    }

    public void setIdCommun(int idCommun) {
        this.idCommun = idCommun;
    }

    @Override
    public String toString() {
        return "MetreCarree{" +
                "id=" + id +
                ", prix=" + prix +
                ", datePrix=" + datePrix +
                ", idCommun=" + idCommun +
                '}';
    }
}