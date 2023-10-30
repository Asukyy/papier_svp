package exobymyself;

import java.awt.Toolkit;
import java.awt.*;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.*;

public class BorderGuard {

    private static BorderGuard instance;

    private BorderGuard() {
    }

    public static BorderGuard getInstance() {
        if (instance == null) {
            instance = new BorderGuard();
        }
        return instance;
    }

    public void afficherTexteProgressivement(String texte, int delai) {
        for (char c : texte.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(delai);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

    public void afficherTexteProgressivementavecSon(String texte, int delai) {
        for (char c : texte.toCharArray()) {
            System.out.print(c);
            jouerSon();
            try {
                Thread.sleep(delai);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

    private void jouerSon() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                    getClass().getResourceAsStream("wav/dialog.wav"));

            Clip clip = AudioSystem.getClip();

            clip.open(audioInputStream);

            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int compteurPersonnes = 0;
    private Timer sessionTimer;

    private Carnet carnet;
    private Document document;
    private Voyageur voyageur;
    private Cite cite;
    private Mission mission;
    private Amende amende;
    private Integer missionActuelle;
    private int amendeCourante = 0;
    private int argentGagné = 0;
    private int argentTotal = argentGagné - amendeCourante;
    private long debutPartie;
    private int jour = 1;

    public void display() {
        Carnet carnet = new Carnet();
        Document document = new Document("Passeport", "Numéro de passeport", "Date de délivrance", "Date d'expiration",
                "Emetteur du passeport", "Autres informations", 15, "John", "Dupont", "Paris", 1);
        Voyageur voyageur = new Voyageur(document, carnet);
        Cite cite = new Cite();
        Mission mission = new Mission("Mission 1", "Laisser entrer uniquement les citoyens d'Arstotzka");
        Amende amende = new Amende("Passeport périmé", "Le passeport est périmé", 5, document);
        Mission missionActuelle = null;
        Mission missionJour1 = new Mission("Mission 1", "Laisser entrer uniquement les citoyens d'Arstotzka");

        Scanner scanner = new Scanner(System.in);
        boolean verifPersonnepass = false;

        boolean choixValide = false;
        int menu = 0;

        while (!choixValide) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            afficherTexteProgressivementavecSon("Voulez-vous commencer à jouer ?", 35);
            afficherTexteProgressivementavecSon("1. Oui", 35);
            afficherTexteProgressivementavecSon("2. Non", 35);

            if (scanner.hasNextInt()) {
                menu = scanner.nextInt();
                scanner.nextLine();

                if (menu == 1) {
                    System.out.println("Vous avez choisi de commencer à jouer");
                    choixValide = true;
                    afficherTexteProgressivementavecSon("Personne suivante", 30);
                } else if (menu == 2) {
                    afficherTexteProgressivementavecSon("A la prochaine !", 30);
                    System.exit(0);
                } else {
                    afficherTexteProgressivementavecSon("Choix invalide. Veuillez choisir 1 (Oui) ou 2 (Non).", 30);
                }
            } else {
                scanner.nextLine();
                afficherTexteProgressivementavecSon("Saisie invalide. Veuillez choisir 1 (Oui) ou 2 (Non).", 30);
            }
        }

        boolean premierDialogue = true;
        boolean continuer = true;
        Voyageur voyageurPrecedent = null;
        while (continuer) {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            if (voyageurPrecedent == null || !voyageurPrecedent.equals(voyageur)) {
                afficherTexteProgressivementavecSon("Vous: Bonjour votre nom s'il vous plaît ?", 30);
                afficherTexteProgressivementavecSon(voyageur.getNom() + " " + voyageur.getPrenom(), 30);
                voyageurPrecedent = voyageur;
            }

            System.out.println("-----------------------------");
            System.out.println(voyageur.getNom() + " " + voyageur.getPrenom());
            afficherTexteProgressivement("Que voulez-vous faire ?", 5);
            afficherTexteProgressivement("1. Afficher les villes", 5);
            System.out.println("-----------------------------");
            afficherTexteProgressivement("2. Voir les missions", 5);
            System.out.println("-----------------------------");
            afficherTexteProgressivement("3. Vérifier passeport", 5);
            System.out.println("-----------------------------");
            afficherTexteProgressivement("4. Vérifier carte d'identité", 5);
            System.out.println("-----------------------------");
            afficherTexteProgressivement("5. Faire un choix", 5);
            System.out.println("-----------------------------");
            afficherTexteProgressivement("6. Quitter", 5);
            System.out.println("-----------------------------");
            afficherTexteProgressivement("Personnes passées : " + compteurPersonnes, 5);
            afficherTexteProgressivement("Votre choix:", 5);
            debutPartie = System.currentTimeMillis();
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    finDeSession();
                }
                // 3min = 180000ms
            }, 180000);
            System.out.println(timer);

            int choix = scanner.nextInt();
            scanner.nextLine();

            System.out.print("\033[H\033[2J");
            System.out.flush();

            switch (choix) {
                case 1:
                    System.out.println("Villes autorisées :");
                    for (String ville : carnet.getVillesAutorisees()) {
                        System.out.println(ville + " — " + cite.getDomainesPourCite(ville));
                    }
                    break;
                case 2:
                    missionActuelle = missionJour1;

                    System.out.println("Mission en cours :");
                    System.out.println("Mission name: " + missionActuelle.getName());
                    System.out.println("Mission description: " + missionActuelle.getDescription());
                    break;

                case 3:
                    System.out.println("Vérification du passeport : " + voyageur.getDocument().getNumero());
                    System.out.println("Vérification du nom : " + voyageur.getNom());
                    System.out.println("Vérification du prénom : " + voyageur.getPrenom());
                    System.out.println("Vérification de l'âge : " + voyageur.getAge());
                    System.out.println("Vérification de la ville d'origine : " + voyageur.getVilleOrigine());
                    System.out.println("Vérification de l'ID : " + voyageur.getId());
                    break;
                case 4:
                    System.out.println("Vérification de la carte d'identité : ");
                    System.out.println("Nom : " + voyageur.getNomIdentite());
                    System.out.println("Prénom : " + voyageur.getPrenomIdentite());
                    System.out.println("Date de naissance : " + voyageur.getDateNaissance());
                    System.out.println("Numéro de la carte : " + voyageur.getNumeroCarte());
                    break;
                case 5:
                    if (missionActuelle != null && missionActuelle.getName().equals(missionJour1.getName())) {
                        System.out.println("Faire un choix");
                        System.out.println("1. Laisser entrer");
                        System.out.println("2. Refuser entrée");
                        int choix2 = scanner.nextInt();
                        scanner.nextLine();

                        switch (choix2) {
                            case 1:
                                gererMission1(voyageur);
                                voyageur = new Voyageur(document, carnet);
                                break;

                            case 2:
                                gererMission1_2(voyageur);
                                voyageur = new Voyageur(document, carnet);
                                break;
                        }
                    } else {
                        System.out.println("Verifie les missions avant de faire un choix");
                    }
                    break;

                case 6:
                    continuer = false;
                    break;

                default:
                    System.out.println("Choix invalide");
                    break;
            }

            if (choix != 6) {
                System.out.println("Appuyez sur Entrée pour continuer...");
                scanner.nextLine();
            }
        }
    }

    // GESTION DES ERREURS ET DES INCOHERENCES

    public void gererMission1(Voyageur voyageur) {
        System.out.println("Mission 1 : Laisser entrer uniquement les citoyens d'Arstotzka");
        Document document = new Document("numéro de passeport", "nom", "prénom", "sexe", "date de naissance",
                "date de délivrance", 123456, "ville de délivrance", "date d'expiration", "nationalité", 7890);
        Carnet carnet = new Carnet(); // Initialisez le carnet ici
        if (voyageur.getVilleOrigine().equals("Arstotzka")) {
            afficherTexteProgressivementavecSon("Bienvenue à Arstotzka", 30);
            afficherTexteProgressivementavecSon("Veuillez passer", 30);
            compteurPersonnes++;
            argentGagné += 3;
            argentTotal = argentGagné - amendeCourante;
            voyageur = new Voyageur(document, carnet);
            afficherTexteProgressivementavecSon("Personne suivante !", 30);
        } else {
            Amende amende = new Amende("Ville d'origine non autorisée", "Le voyageur n'est pas citoyen d'Arstotzka", 5,
                    voyageur.getDocument());

            amendeCourante += amende.getMontant();
            argentTotal = argentGagné - amendeCourante;
            afficherTexteProgressivementavecSon("Amende pour non respect des règles : 5$", 40);
            compteurPersonnes++;
            voyageur = new Voyageur(document, carnet);
        }
    }

    public void gererMission1_2(Voyageur voyageur) {
        Document document = new Document("numéro de passeport", "nom", "prénom", "sexe", "date de naissance",
                "date de délivrance", 123456, "ville de délivrance", "date d'expiration", "nationalité", 7890);
        Carnet carnet = new Carnet();

        if (voyageur.getVilleOrigine().equals("Arstotzka")) {
            Amende amende = new Amende("Ville d'origine autorisée", "Le voyageur était un citoyen d'Arstotzka", 5,
                    voyageur.getDocument());
            amendeCourante += amende.getMontant();
            argentTotal = argentGagné - amendeCourante;
            afficherTexteProgressivementavecSon("Amende pour non respect des règles : 5$", 40);
            compteurPersonnes++;
            voyageur = new Voyageur(document, carnet);
        } else {
            argentGagné += 3;
            argentTotal = argentGagné - amendeCourante; // Met à jour l'argent total
            afficherTexteProgressivementavecSon("Vous ne pouvez pas entrer", 30);
            afficherTexteProgressivementavecSon("Veuillez partir", 30);
            compteurPersonnes++;
            voyageur = new Voyageur(document, carnet);
        }
    }

    // FONCTIONS GLOBAL

    public void afficherTotalAmendes() {
        afficherTexteProgressivementavecSon("Argent gagné : " + argentGagné + "$", 30);
        afficherTexteProgressivementavecSon("Argent perdu : " + amendeCourante + "$", 30);
        afficherTexteProgressivementavecSon("Argent total : " + argentTotal + "$", 30);
    }

    public void jourSuivant() {
        System.out.println("Jour " + jour);
        jour++;
    }

    public void reinitialiserSessionPrecedente() {
        amendeCourante = 0;
        compteurPersonnes = 0;

        argentGagné = 0;

        jourSuivant();
    }

    public void continuerJeu() {
        reinitialiserSessionPrecedente();
        display();
    }

    public void finDeSession() {
        afficherTotalAmendes();
        reinitialiserSessionPrecedente();

        System.out.println("Fin de la session. Voulez-vous continuer ?");
        System.out.println("1. Continuer");
        System.out.println("2. Quitter");

        Scanner scanner = new Scanner(System.in);
        int choix = scanner.nextInt();

        if (choix == 1) {
            argentTotal = 0;
            jourSuivant();
            continuerJeu();
        } else {
            System.out.println("Merci d'avoir joué !");
            System.exit(0);
        }
    }

}
