package exobymyself;
import java.io.*;
import java.util.*;
public class Carnet {

private List<String> villesAutorisees = new ArrayList<String>();

public Carnet(){
    this.villesAutorisees.add("Arstotzka");
    this.villesAutorisees.add("Antegria");
    this.villesAutorisees.add("Impor");
    this.villesAutorisees.add("Kolechia");
    this.villesAutorisees.add("Obristan");
    this.villesAutorisees.add("Republia");
    this.villesAutorisees.add("United Federation");
    this.villesAutorisees.add("Cobrastan");
    // this.villesAutorisees.add("Jorji Costava");
}

    public void mettreAJourVillesAutorisees(List<String> nouvellesVillesAutorisees){
        villesAutorisees.clear();
        villesAutorisees.addAll(nouvellesVillesAutorisees);
    }

 public List<String> getVillesAutorisees() {
        return villesAutorisees;
    }

     public String genererVilleAleatoire() {
        Random random = new Random();
        int index = random.nextInt(villesAutorisees.size());
        return villesAutorisees.get(index);
    }

}
