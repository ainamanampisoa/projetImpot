package maison;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import utilitaire.UtilDB;

public class Proprietaire {
    private int idProprietaire;
    private String nomProprietaire;
    private String mdp;

    public Proprietaire(int idProprietaire, String nomProprietaire, String mdp) {
        this.idProprietaire = idProprietaire;
        this.nomProprietaire = nomProprietaire;
        this.mdp = mdp;
    }

    // Constructeurs
    public Proprietaire() {
    }

    // Getters et Setters
    public int getIdProprietaire() {
        return idProprietaire;
    }

    public void setIdProprietaire(int idProprietaire) {
        this.idProprietaire = idProprietaire;
    }

    public String getNomProprietaire() {
        return nomProprietaire;
    }

    public void setNomProprietaire(String nomProprietaire) {
        this.nomProprietaire = nomProprietaire;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    @Override
    public String toString() {
        return "Proprietaire{" +
                "idProprietaire=" + idProprietaire +
                ", nomProprietaire='" + nomProprietaire + '\'' +
                '}';
    }

    /**
     * Vérifie le login et le mot de passe du propriétaire.
     *
     * @param login Le nom du propriétaire
     * @param mdp   Le mot de passe du propriétaire
     * @return L'id du propriétaire si les informations sont correctes, -1 sinon
     * @throws Exception Si une erreur de base de données se produit
     */
    public int checkLogin(String login, String mdp) throws Exception {
        Connection c = null;
        boolean estOuvert = false;

        try {
            // Obtenir la connexion
            if (c == null) {
                c = new UtilDB().GetConn();
                estOuvert = true;
                System.out.println("Connexion à la base de données établie.");
            }

            // Préparer la requête SQL
            String query = "SELECT id_proprietaire FROM Proprietaire WHERE nom_proprietaire = ? AND mdp = ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, login);
            ps.setString(2, mdp);

            // Exécuter la requête
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("id_proprietaire");
            } else {
                return -1;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            // Fermer la connexion si elle a été ouverte ici
            if (estOuvert && c != null) {
                c.close();
                System.out.println("Connexion à la base de données fermée.");
            }
        }
    }
}
