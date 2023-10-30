package papier_svp;

import java.io.*;
import java.util.*;

public class Cite {
    private Map<String, String> citeMap = new HashMap<>();

    public Cite() {
        citeMap.put("Arstotzka", "Orwich-Vanor, Vost. Grechtin, Paradis");
        citeMap.put("Antegria", "Lesrenadi, Mergerous, Grouse");
        citeMap.put("Impor", "Enkyo, Tsunkeido, Shingleton");
        citeMap.put("Kolechia", "Lesko, Yurko City, Grestin");
        citeMap.put("Obristan", "Skal, Lorndaz, Vedor");
        citeMap.put("Republia", "Republia, Republia City, West Grestin");
        citeMap.put("United Federation", "Vedestan, East Grestin, Shingleton");
        citeMap.put("Cobrastan", "Cobrastan, Cobrastan City, West Grestin");

    }

    public List<String> getCiteinEachCity() {
        return new ArrayList<>(citeMap.keySet());
    }

    public String genererCiteAleatoire() {
        Random random = new Random();
        int index = random.nextInt(citeMap.size());
        return (String) citeMap.keySet().toArray()[index];
    }

    public String CiteArtozka() {
        return "Arstotzka";
    }

    public String getDomainesPourCite(String cite) {
        return citeMap.get(cite);
    }

    // public static void main(String[] args) {
    // Cite cite = new Cite();
    // System.out.println(cite.genererCiteAleatoire());
    // }

}
