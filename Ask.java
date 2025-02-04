import java.util.Scanner;

public class Ask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Création de l'objet Scanner

        System.out.print("Entrez votre nom : ");
        String nom = scanner.nextLine(); // Lecture de la ligne saisie

        System.out.print("Entrez votre age : ");
        int age = scanner.nextInt();

        System.out.println("Bonjour " + nom + " ! Et vous avez " + age);

        scanner.close(); // Fermeture du scanner
    }
}
