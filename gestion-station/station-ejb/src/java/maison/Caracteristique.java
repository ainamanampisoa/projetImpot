package maison;

import java.sql.Date;

public class Caracteristique {
    private int idMaison;
    private int idComposant;
    private int idType;
    private Date dateCaracteristique;

    // Constructeurs
    public Caracteristique() {
    }

    public Caracteristique(int idMaison, int idComposant, int idType, Date dateCaracteristique) {
        this.idMaison = idMaison;
        this.idComposant = idComposant;
        this.idType = idType;
        this.dateCaracteristique = dateCaracteristique;
    }

    // Getters et Setters
    public int getIdMaison() {
        return idMaison;
    }

    public void setIdMaison(int idMaison) {
        this.idMaison = idMaison;
    }

    public int getIdComposant() {
        return idComposant;
    }

    public void setIdComposant(int idComposant) {
        this.idComposant = idComposant;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public Date getDateCaracteristique() {
        return dateCaracteristique;
    }

    public void setDateCaracteristique(Date dateCaracteristique) {
        this.dateCaracteristique = dateCaracteristique;
    }

    @Override
    public String toString() {
        return "Caracteristique{" +
                "idMaison=" + idMaison +
                ", idComposant=" + idComposant +
                ", idType=" + idType +
                ", dateCaracteristique=" + dateCaracteristique +
                '}';
    }
}