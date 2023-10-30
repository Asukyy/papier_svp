package exobymyself;

import java.io.*;
import java.util.*;

public class Document {
    private String type;
    private String numero;
    // private String dateDelivrance;
    private String dateExpiration;
    private String nom;
    private String prenom;
    private Integer age;
    private String villeOrigine;
    private Integer id;
    private String emetteur;
    private String autreInformation;

    public Document(String type, String numero, String dateDelivrance, String dateExpiration, String emetteur,
            String autresInformations, Integer age, String nom, String prenom, String villeOrigine, Integer id) {
        this.type = type;
        this.numero = numero;
        // this.dateDelivrance = dateDelivrance;
        this.dateExpiration = dateExpiration;
        this.emetteur = emetteur;
        this.autreInformation = autresInformations;
        this.age = age;
        this.nom = nom;
        this.prenom = prenom;
        this.villeOrigine = villeOrigine;
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Integer getAge() {
        return age;
    }

    public String getVilleOrigine() {
        return villeOrigine;
    }

    public Integer getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public String getDateExpiration() {
        return dateExpiration;
    }

    public String getEmetteur() {
        return emetteur;
    }

    public String getAutreInformation() {
        return autreInformation;
    }

}
