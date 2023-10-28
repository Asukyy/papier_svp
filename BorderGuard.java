package exobymyself;

import java.awt.Toolkit;
import java.awt.*;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class BorderGuard {

    private static BorderGuard instance;
    private BorderGuard() {}

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
            // Chargez le fichier audio (remplacez "your-audio-file.wav" par le chemin de votre fichier audio)
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                getClass().getResourceAsStream("wav/dialog.wav")
            );

            // Obtenez un clip audio
            Clip clip = AudioSystem.getClip();

            // Ouvrez l'audioInputStream dans le clip
            clip.open(audioInputStream);

            // Jouez le son
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static final int TEMPS_PAR_PERSONNE = 150000;
    private int compteurPersonnes = 0;
    private Timer timer;

    private Carnet carnet;
    private Document document;
    private Voyageur voyageur;


    public void display() {
        Carnet carnet = new Carnet();
        Document document = new Document("Passeport", "Numéro de passeport", "Date de délivrance", "Date d'expiration", "Emetteur du passeport", "Autres informations", 15, "John", "Dupont", "Paris", 1);
        Voyageur voyageur = new Voyageur(document, carnet);


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

        boolean continuer = true;
         while (continuer) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            afficherTexteProgressivement("Que voulez-vous faire ?", 15);
            afficherTexteProgressivement("1. Afficher les villes", 15);
            System.out.println("-----------------------------");
            afficherTexteProgressivement("2. Voir les missions", 15);
            System.out.println("-----------------------------");
            afficherTexteProgressivement("3. Vérifier passeport", 15);
            System.out.println("-----------------------------");
            afficherTexteProgressivement("4. Vérifier carte d'identité", 15);
            System.out.println("-----------------------------");
            afficherTexteProgressivement("5. Faire un choix", 15);
            System.out.println("-----------------------------");
            afficherTexteProgressivement("6. Quitter", 15);
            System.out.println("-----------------------------");
            afficherTexteProgressivement("Personnes passées : " + compteurPersonnes, 15);
            afficherTexteProgressivement("Votre choix:", 15);

            int choix = scanner.nextInt();
            scanner.nextLine();

            System.out.print("\033[H\033[2J");
            System.out.flush();

            switch (choix) {
                case 1:
                    System.out.println("Villes autorisées :");
                    for (String ville : carnet.getVillesAutorisees()) {
                        System.out.println(ville);
                    }
                    break;
                case 2:
                    System.out.println("Mission en cours :");
                    Mission mission = Mission.generateMission();
                    System.out.println("Mission name: " + mission.getName());
                    System.out.println("Mission description: " + mission.getDescription());
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
                    System.out.println("Vérification de la carte d'identité : " + voyageur.getCarteIdentite());
                    break;
                case 5:
                    System.out.println("Faire un choix");
                    System.out.println("1. Laisser entrer");
                    System.out.println("2. Refuser entrée");
                    int choix2 = scanner.nextInt();
                    scanner.nextLine();

                    switch (choix2) {
                        case 1:
                            afficherTexteProgressivementavecSon("Bienvenue à Arstotzka", 30);
                            afficherTexteProgressivementavecSon("Veuillez passer", 30);
                            compteurPersonnes++;
                            voyageur = new Voyageur(document, carnet);
                            afficherTexteProgressivementavecSon("Personne suivante !", 30);

                            if (timer != null) {
                                timer.cancel();
                            }
                            timer = new Timer();
                            timer.schedule(new TimerTask() {
                                @Override
                                public void run() {
                                    System.out.println("Temps écoulé");
                                    compteurPersonnes++;
                                    timer.cancel();
                                    timer = new Timer();
                                    timer.schedule(this, TEMPS_PAR_PERSONNE);
                                }
                            }, TEMPS_PAR_PERSONNE);
                            break;

                            case 2:
                                afficherTexteProgressivementavecSon("Vous ne pouvez pas entrer", 30);
                                afficherTexteProgressivementavecSon("Veuillez partir", 30);
                                compteurPersonnes++;
                                voyageur = new Voyageur(document, carnet);
                                break;
        default:
            System.out.println("Choix invalide");
            break;
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
}
