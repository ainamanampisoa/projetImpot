package maison;

public class Commun {
    private int idCommun;
    private String nomCommun;

    // Constructeurs
    public Commun() {
    }

    public Commun(int idCommun, String nomCommun) {
        this.idCommun = idCommun;
        this.nomCommun = nomCommun;
    }

    // Getters et Setters
    public int getIdCommun() {
        return idCommun;
    }

    public void setIdCommun(int idCommun) {
        this.idCommun = idCommun;
    }

    public String getNomCommun() {
        return nomCommun;
    }

    public void setNomCommun(String nomCommun) {
        this.nomCommun = nomCommun;
    }

    @Override
    public String toString() {
        return "Commun{" +
                "idCommun=" + idCommun +
                ", nomCommun='" + nomCommun + '\'' +
                '}';
    }
}
