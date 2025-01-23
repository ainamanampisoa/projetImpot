package maison;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

    public int getIdCommuneByIdMaison(int idMaison) throws Exception {
    int idCommun = -1; // Valeur par défaut en cas d'absence de résultat

    try (Connection c = new UtilDB().GetConn()) {
        if (c == null || c.isClosed()) {
            throw new Exception("Impossible d'établir une connexion à la base de données.");
        }

        String query = "SELECT id_commun FROM Maison WHERE id_maison = ?";
        System.out.println("Exécution de la requête : " + query);

        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, idMaison);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    idCommun = rs.getInt("id_commun");
                }
            }
        }
    } catch (Exception e) {
        System.err.println("Erreur dans getIdCommuneByIdMaison : " + e.getMessage());
        throw e;
    }

    return idCommun;
    }

}
