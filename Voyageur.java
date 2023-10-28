package exobymyself;

import java.io.*;

public class Voyageur {
    private String nom;
    private String prenom;
    private Integer age;
    private String villeOrigine;
    private Integer id;
    private Document document;
    private Boolean estEnRegle;
    private Carnet carnet;

    public Voyageur(Document document, Carnet carnet) {
        this.nom = DonneesAleatoiresUtil.genererNomAleatoire();
        this.prenom = DonneesAleatoiresUtil.genererPrenomAleatoire();
        this.age = DonneesAleatoiresUtil.genererAgeAleatoire(18, 65);
        this.villeOrigine = carnet.genererVilleAleatoire();
        this.id = DonneesAleatoiresUtil.genererIdAleatoire(1, 1000);
        this.document = document;
        this.estEnRegle = false;
        this.carnet = carnet;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public Integer getAge() {
        return this.age;
    }

    public String getVilleOrigine() {
        return this.villeOrigine;
    }

    public Integer getId() {
        return this.id;
    }

    public Document getDocument() {
        return this.document;
    }

    public Boolean getEstEnRegle() {
        return this.estEnRegle;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

     public String getPasseport() {
        if (document.getType().equals("Passeport")) {
            return document.getNumero();
        }
        return "N/A";
    }

    public String getCarteIdentite() {
        if (document.getType().equals("Carte d'identité")) {
            return document.getNumero();
        }
        return "N/A";
    }

    // public static void main(String[] args) {
    //     Carnet carnet = new Carnet();
    //     Document document = new Document("Passeport", "123456789", "01/01/2020", "01/01/2025", "Dupont", "John", 30, "Paris", 1);
    //     Voyageur voyageur = new Voyageur(document, carnet);
    //     System.out.println(voyageur.getNom());
    //     System.out.println(voyageur.getPrenom());
    //     System.out.println(voyageur.getAge());
    //     System.out.println(voyageur.getVilleOrigine());
    //     System.out.println(voyageur.getId());
    //     System.out.println(voyageur.getDocument());
    //     System.out.println(voyageur.getEstEnRegle());
    // }

}
