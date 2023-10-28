package exobymyself;

import java.io.*;
import java.util.*;

public class Cite {
    private List<String> CiteinEachCity = new ArrayList<String>();

    public Cite(){
        this.CiteinEachCity.add("Orwich-Vanor");
        this.CiteinEachCity.add("Vost. Grechtin");
        this.CiteinEachCity.add("Paradis");
        this.CiteinEachCity.add("Altan");
        this.CiteinEachCity.add("Veskillo");
        this.CiteinEachCity.add("Bernton");
        this.CiteinEachCity.add("Octovalis");
        this.CiteinEachCity.add("Gennistor");
        this.CiteinEachCity.add("Lendiform");
        this.CiteinEachCity.add("Wozenfield");
        this.CiteinEachCity.add("Fardesto");
        this.CiteinEachCity.add("Yourko");
        this.CiteinEachCity.add("Védor");
        this.CiteinEachCity.add("Zap. Grechtin");
        this.CiteinEachCity.add("San Marmero");
        this.CiteinEachCity.add("Glorian");
        this.CiteinEachCity.add("Tétras extérieur");
        this.CiteinEachCity.add("Skal");
        this.CiteinEachCity.add("Lorndaz");
        this.CiteinEachCity.add("Fusionus");
        this.CiteinEachCity.add("Saint-Glorian");
        this.CiteinEachCity.add("Lesrénadi");
        this.CiteinEachCity.add("Bostan");
        this.CiteinEachCity.add("Grand Rapide");
        this.CiteinEachCity.add("Bardeauton");
        this.CiteinEachCity.add("Korista");
        this.CiteinEachCity.add("Enkyo");
        this.CiteinEachCity.add("Haïhan");
        this.CiteinEachCity.add("Tsunkéido");
    }

    public void mettreAJourCite(List<String> nouvellesCite){
        CiteinEachCity.clear();
        CiteinEachCity.addAll(nouvellesCite);
    }

 public List<String> getCiteinEachCity() {
        return CiteinEachCity;
    }

        public String genererCiteAleatoire() {
            Random random = new Random();
            int index = random.nextInt(CiteinEachCity.size());
            return CiteinEachCity.get(index);
        }

        // public static void main(String[] args) {
        //     Cite cite = new Cite();
        //     System.out.println(cite.genererCiteAleatoire());
        // }



}
