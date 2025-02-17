package MonProjet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Lancement du programme - v1");

        int choix = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Que voulez vous faire ?");
            System.out.println("1 - Ajouter un edutiant");
            System.out.println("4 - Quitter");
            choix = sc.nextInt();


            switch (choix) {
                case 1:
                    
                    break;
                case 4:
                    System.out.println("Au revoir !");
                    break;
            
                default:
                    System.out.println("Choix non gérer !");
                    break;
            }
        } while (choix != 4);
        sc.close();
    }
}
