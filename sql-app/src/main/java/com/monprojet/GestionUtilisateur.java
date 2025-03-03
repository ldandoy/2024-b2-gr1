package com.monprojet;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.PreparedStatement;

public class GestionUtilisateur
{
    ArrayList listUser = new ArrayList<>();

    public void add (Connexion connect, Scanner sc)
    {
        sc.nextLine();
        System.out.println("Nom de l'utilisateur");
        String lastName = sc.nextLine();

        System.out.println("Prénom de l'utilisateur");
        String fistName = sc.nextLine();
        
        System.out.println("Email de l'utilisateur");
        String email = sc.nextLine();
        
        try {
            String sqlInsert = "INSERT INTO utilisateurs (prenom, nom, email) VALUES (?, ?, ?)";
            PreparedStatement pstmtInsert = connect.connexion.prepareStatement(sqlInsert);
            pstmtInsert.setString(1, fistName);
            pstmtInsert.setString(2, lastName);
            pstmtInsert.setString(3, email);

            int rowsAffected = pstmtInsert.executeUpdate();
            System.out.println("Insertion réussie, lignes affectées : " + rowsAffected);
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
    }
}
