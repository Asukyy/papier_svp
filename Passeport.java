package papier_svp;

import java.io.*;

public class Passeport extends Document {
    public Passeport(String numero, String dateDelivrance, String dateExpiration, String nom, String prenom,
            Integer age, String villeOrigine, Integer id) {
        super("Passeport", numero, dateDelivrance, dateExpiration, "Emetteur du passeport", "Autres informations", age,
                nom, prenom, villeOrigine, id);
    }
}
