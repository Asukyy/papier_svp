package exobymyself;

import java.util.List;
import java.util.ArrayList;

public class Amende {
    private String motif;
    private String description;
    private int montant = 5;
    private Document document;

    // Liste des motifs possibles
    private static List<String> motifsPossibles = new ArrayList<>();

    static {
        motifsPossibles.add("Passeport périmé");
        motifsPossibles.add("Visa manquant");
        motifsPossibles.add("Contrôle de sécurité non passé");
        motifsPossibles.add("Passeport invalide");
        motifsPossibles.add("Visa invalide");
        motifsPossibles.add("Contrôle de sécurité invalide");
        motifsPossibles.add("Nom invalide");
        motifsPossibles.add("Prénom invalide");
        motifsPossibles.add("Date de naissance invalide");
        motifsPossibles.add("Date de délivrance invalide");
        motifsPossibles.add("Date d'expiration invalide");
        motifsPossibles.add("Ville d'origine invalide");
        motifsPossibles.add("Ville d'origine non autorisée");

    }

    public Amende(String motif, String description, int montant, Document document) {
        if (motifsPossibles.contains(motif)) {
            this.motif = motif;
        } else {
            throw new IllegalArgumentException("Motif d'amende invalide");
        }
        this.description = description;
        this.montant = montant;
        this.document = document;
    }

    public Integer getMontant() {
        return this.montant;
    }

    public String getMotif() {
        return this.motif;
    }

    public Document getDocument() {
        return this.document;
    }

    public void setMontant(Integer montant) {
        this.montant = montant;
    }

    public void setMotif(String motif) {
        if (motifsPossibles.contains(motif)) {
            this.motif = motif;
        } else {
            throw new IllegalArgumentException("Motif d'amende invalide");
        }
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public String toString() {
        return "Amende{" +
                "montant=" + montant +
                ", motif='" + motif + '\'' +
                ", document=" + document +
                '}';
    }

}
