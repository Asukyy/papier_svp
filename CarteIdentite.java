package exobymyself;
import java.io.*;

public class CarteIdentite extends Document {
public CarteIdentite(String numero, String dateDelivrance, String dateExpiration, String nom, String prenom, Integer age, String villeOrigine, Integer id) {
    super("Carte d'Identité", numero, dateDelivrance, dateExpiration, "Emetteur de la carte", "Autres informations", age, nom, prenom, villeOrigine, id);
}
}
