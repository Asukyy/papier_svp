package papier_svp;

import java.io.*;
import java.util.*;

import java.time.LocalDate;
import java.util.Random;

public class Mission {
    private String name;
    private String description;

    public Mission(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public static Mission generateMission() {
        List<Mission> missions = new ArrayList<>();
        missions.add(new Mission("Mission 1", "Laisser entrer uniquement les citoyens d'Arstotzka"));
        missions.add(new Mission("Mission 2", "Vérifier les permis de travail pour les étrangers"));
        missions.add(new Mission("Mission 3", "Recherche de contrebande de drogue"));
        missions.add(new Mission("Mission 4", "Contrôler la validité des visas"));
        missions.add(new Mission("Mission 5", "Rechercher les objets interdits dans les bagages"));
        missions.add(new Mission("Mission 6", "Assurer la sécurité aux points de contrôle"));

        LocalDate currentDate = LocalDate.now();

        Random random = new Random(currentDate.toEpochDay());
        int missionNumber = random.nextInt(missions.size());

        return missions.get(missionNumber);
    }
}
