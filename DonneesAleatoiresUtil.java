package papier_svp;

import java.util.Random;

public class DonneesAleatoiresUtil {
    private static final String[] noms = {
            "Kuznetsov", "Ivanov", "Petrov", "Sidorov", "Volkov",
            "Popov", "Smirnov", "Egorov", "Sokolov", "Lebedev",
            "Abdulov", "Ahmadov", "Khalilov", "Safarov", "Ismailov",
            "Rizov", "Malikov", "Osmanov", "Mustafaev", "Kazakov",
            "Karimov", "Rasulov", "Tahirov", "Guseinov", "Mirzoyan",
            "Akhmadov", "Osipov", "Yusupov", "Makarov", "Makhmudov",
            "Orlov", "Sadikhov", "Magomedov", "Suleymanov", "Umarov",
            "Khadzhiev", "Saidov", "Umarov", "Magomedov", "Abdulayev",
            "Isakov", "Yusufov", "Rasulov", "Usmanov", "Alikhanov",
            "Rustamov", "Kazimov", "Temirbekov", "Narimanov", "Kasimov"
    };

    private static final String[] prenoms = {
            "Yuri", "Sergei", "Dmitri", "Andrei", "Mikhail",
            "Abdul", "Ahmed", "Ali", "Rashid", "Omar",
            "Karim", "Ramazan", "Yusuf", "Magomed", "Islam",
            "Farid", "Rustam", "Arsen", "Timur", "Aslan",
            "Said", "Zubair", "Imran", "Tamerlan", "Ilyas",
            "Malik", "Shamil", "Kamil", "Tariq", "Rahim",
            "Mansur", "Anwar", "Latif", "Bahram", "Asad",
            "Azamat", "Zafar", "Vagif", "Umar", "Irfan",
            "Suleyman", "Kamal", "Eldar", "Orkhan", "Emil",
            "Murad", "Ayub", "Asker", "Timur", "Ilgar"
    };
    
    private static final String[] nomsJorgi = {
            "Jorgi Costava"
    };

    //sans fonction random rappelle jorji costava
    public static String JorgiCostava() {
        return nomsJorgi[0];
    }

    public static String genererNomAleatoire() {
        int index = (int) (Math.random() * noms.length);
        return noms[index];
    }

    public static String genererPrenomAleatoire() {
        int index = (int) (Math.random() * prenoms.length);
        return prenoms[index];
    }

    public static int genererAgeAleatoire(int minAge, int maxAge) {
        return (int) (Math.random() * (maxAge - minAge + 1)) + minAge;
    }

    public static int genererIdAleatoire(int minId, int maxId) {
        return (int) (Math.random() * (maxId - minId + 1)) + minId;
    }
}
