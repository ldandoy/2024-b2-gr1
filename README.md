
# 1 - Introduction au Java
### Histoire

Java a été créé en 1995 par James Gosling chez Sun Microsystems. Son objectif était de proposer un langage portable et performant, utilisable sur diverses plateformes sans modification du code source. Depuis, Java a évolué et est aujourd'hui détenu par Oracle.

### Caractéristiques principales

- **Portabilité** : Grâce à la machine virtuelle Java (JVM), le code Java peut être exécuté sur n'importe quel système supportant la JVM.
    
- **Programmation orientée objet (POO)** : Java repose sur les concepts de classes, objets, héritage et polymorphisme.
    
- **Sécurité** : Java inclut une gestion avancée des exceptions et un environnement d'exécution protégé.
    
- **Multithreading** : Il permet d'exécuter plusieurs processus en parallèle pour de meilleures performance

### Différences entre Java SE, EE et ME

- **Java SE (Standard Edition)** : Version de base pour les applications de bureau et les outils de développement.
    
- **Java EE (Enterprise Edition)** : Conçu pour les applications web et d'entreprise avec des fonctionnalités avancées (JSP, Servlets, EJB).
    
- **Java ME (Micro Edition)** : Version allégée pour les appareils embarqués et mobiles.

### Installation et configuration de l’environnement

#### Installation du JDK

Le **Java Development Kit (JDK)** est nécessaire pour développer et exécuter des programmes en Java.

1. Rendez-vous sur le site officiel d’[Oracle](https://www.oracle.com/java/technologies/javase-downloads.html) ou [OpenJDK](https://openjdk.org/).
2. Téléchargez la dernière version du JDK compatible avec votre système d’exploitation.
3. Installez le JDK en suivant les instructions.

#### Configuration des variables d’environnement

Pour utiliser Java en ligne de commande, vous devez configurer les variables d’environnement :

1. **Windows** :
    - Allez dans "Paramètres Système Avancés" > "Variables d’environnement".
    - Ajoutez `JAVA_HOME` avec le chemin du dossier d’installation du JDK.
    - Ajoutez `%JAVA_HOME%\bin` à la variable `Path`.
        
2. **Linux / macOS** :
    - Ajoutez ces lignes à votre fichier `~/.bashrc` ou `~/.zshrc` :
        
        ```
        export JAVA_HOME=/chemin/vers/le/jdk
        export PATH=$JAVA_HOME/bin:$PATH
        ```
        
    - Rechargez la configuration avec `source ~/.bashrc`.

#### Vérification

Après l’installation, ouvrez un terminal ou une invite de commandes et exécutez :

```bash
java --version
javac --version
```

Vous devriez voir s’afficher la version installée de Java et du compilateur.

### Premiers pas avec Java

Votre premier programme :

*HelloWorld.java*
```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

Pour compiler et exécuter :

```bash
javac HelloWorld.java
java HelloWorld
```

### Les IDES

Pour faciliter le développement, vous pouvez utiliser un IDE comme :
- **Eclipse** : Idéal pour les débutants.
- **IntelliJ IDEA** : Puissant et optimisé pour Java.    
- **VS Code** : Léger et personnalisable avec l’extension Java.

### Syntaxe de base

#### Types de données et variables
```java
int age = 25;
double prix = 19.99;
char lettre = 'A';
boolean estVrai = true;
String message = "Bonjour";
```

#### Les commentaires

* Sur une seule ligne*
```java
public class HelloWorld {
    public static void main(String[] args) {
		// Test ceci est un commentaire
		System.out.println("Hello, World!");
    }
}
```

Des que l'on modifie le programme il faudra le recompiler. A la différence des langages interprété comme le python ou le PHP, une fois le fichier exécutable créé, si on modifie le fichier source, il faut regénérer l'exécutable, c'est la compilation.

```bash
javac HelloWorld.java
java HelloWorld
```

*Sur plusieurs lignes*
```java
public class HelloWorld {
    public static void main(String[] args) {
		/* Test ceci est un commentaire 
		Mais il est sur plusieurs ligne.
		*/
		System.out.println("Hello, World!");
    }
}
```
#### Opérateurs arithmétiques et logiques
```java
int a = 10, b = 5;
int somme = a + b;
boolean resultat = (a > b) && (b < 20);
```

####  Afficher des choses dans la console

```java
System.out.println("Hello, World!")
```

#### Demander des informations à l'utilisateur

On peut demander plusieurs entrées en une seule exécution 

*Ask.java*
```java
import java.util.Scanner;

public class Ask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Création de l'objet Scanner

        System.out.print("Entrez votre nom : ");
        String nom = scanner.nextLine(); // Lecture de la ligne saisie

        System.out.println("Bonjour, " + nom + "!");

        scanner.close(); // Fermeture du scanner
    }
}
```

*AskMulti.java*
```java
import java.util.Scanner;

public class AskMulti {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez votre prénom : ");
        String prenom = scanner.nextLine();

        System.out.print("Entrez votre âge : ");
        int age = scanner.nextInt();

        System.out.print("Entrez votre taille : ");
        double taille = scanner.nextDouble();

        System.out.println("Bonjour " + prenom + ", vous avez " + age + " ans et vous mesurez " + taille + " m.");

        scanner.close();
    }
}

```

Il se peux que vous ayez des erreurs, à cause des "types". Par exemple age est un entier, il faut donc mettre des chiffres. Mais vous ne pouvez pas empêcher l'utilisateur de taper une lettre. Vous devez donc vérifier une fois la saisie effectué, quelle est correcte.

**Ne faite jamais confiance à l'utilisateur !!**

*VerifierEntree.java*
```java
import java.util.Scanner;

public class VerifierEntree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Entrez un nombre entier : ");
        if (scanner.hasNextInt()) {
            int nombre = scanner.nextInt();
            System.out.println("Vous avez entré : " + nombre);
        } else {
            System.out.println("Erreur : Vous devez entrer un nombre entier !");
        }

        scanner.close();
    }
}
```
#### Structures de contrôle

*Condition if/else/else if*
```java
public class ConditionsExample {
    public static void main(String[] args) {
        int age = 18;

        if (age < 18) {
            System.out.println("Vous êtes mineur.");
        } else if (age == 18) {
            System.out.println("Vous venez d'être majeur !");
        } else {
            System.out.println("Vous êtes majeur.");
        }
    }
}
```

*Condition switch*
```java
public class SwitchExample {
    public static void main(String[] args) {
        String jour = "Lundi";

        switch (jour) {
            case "Lundi":
                System.out.println("C'est le début de la semaine.");
                break;
            case "Vendredi":
                System.out.println("C'est bientôt le week-end !");
                break;
            default:
                System.out.println("Jour ordinaire.");
        }
    }
}
```

*Boucle for*
```java
for (int i = 0; i < 5; i++) {
    System.out.println("i = " + i);
}
```

*Boucle while*
```java
public class WhileLoopExample {
    public static void main(String[] args) {
        int compteur = 1;

        while (compteur <= 5) {
            System.out.println("Compteur : " + compteur);
            compteur++;
        }
    }
}
```

*Boucle do-while*
```java
public class DoWhileLoopExample {
    public static void main(String[] args) {
        int compteur = 1;

        do {
            System.out.println("Compteur : " + compteur);
            compteur++;
        } while (compteur <= 5);
```

Boucle for-each
```java
public class ForEachExample {
    public static void main(String[] args) {
        String[] langages = {"Java", "Python", "C++", "JavaScript"};

        for (String langage : langages) {
            System.out.println("Langage : " + langage);
        }
    }
}
```

*Break et Continue*
```java
public class BreakExample {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                break; // Sort de la boucle quand i == 5
            }
            System.out.println("Itération : " + i);
        }
    }
}

public class ContinueExample {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                continue; // Saute l'itération quand i == 3
            }
            System.out.println("Itération : " + i);
        }
    }
}
```

#### Fonctions et portée des variables

*Exemple.java*
```java
public class Exemple {
    public static int addition(int x, int y) {
        return x + y;
    }

    public static void main(String[] args) {
        int resultat = addition(3, 4);
        System.out.println("Le résultat est : " + resultat);
    }
}
```

### Exercices pratiques

#### Compter les nombres pairs
Écrivez un programme Java qui affiche tous les nombres pairs entre 1 et 20.
- Expliquez pourquoi vous avez choisi cette boucle.

#### Compte à rebours

Créez un programme `CompteARebours.java` qui compte à rebours de **10 à 1** après avoir affiché **"Lancement !"**.

#### Pour aller plus loin

Faire un programme qui:

- Crée un tableau de nombres entiers.
- Calcule la moyenne, la médiane et l'écart-type des valeurs du tableau.
- Trie le tableau et trouve les valeurs minimales et maximales.


#### Correction

```java
import java.util.Arrays;

public class DataManipulation {
    public static void main(String[] args) {
        int[] data = {3, 5, 7, 2, 8, 10, 11, 1, 6, 4};
        
        // Calcul de la moyenne
        double sum = 0;
        for (int value : data) {
            sum += value;
        }
        double mean = sum / data.length;
        System.out.println("Moyenne: " + mean);
        
        // Tri et médiane
        Arrays.sort(data);
        double median;
        if (data.length % 2 == 0) {
            median = (data[data.length / 2] + data[data.length / 2 - 1]) / 2.0;
        } else {
            median = data[data.length / 2];
        }
        System.out.println("Médiane: " + median);
        
        // Écart-type
        double variance = 0;
        for (int value : data) {
            variance += Math.pow(value - mean, 2);
        }
        double stdDev = Math.sqrt(variance / data.length);
        System.out.println("Écart-type: " + stdDev);
        
        // Min et Max
        System.out.println("Min: " + data[0]);
        System.out.println("Max: " + data[data.length - 1]);
    }
}
```

##  2 - Introduction à la Programmation Orientée Objet (POO)

### Définition de la Programmation Orientée Objet (POO)

La **Programmation Orientée Objet (POO)** est un paradigme de programmation qui repose sur la création et la manipulation d’**objets** pour modéliser des éléments du monde réel ou conceptuel. Ces objets interagissent entre eux pour accomplir des tâches dans un programme.

La POO organise le code autour de **classes** et **objets** plutôt que de simples instructions ou fonctions isolées, ce qui la rend particulièrement adaptée aux systèmes complexes et évolutifs.

### Les concepts clés de la POO :

- **Classe** :
    
    - Une classe est un plan ou un modèle à partir duquel des objets sont créés.
    - Elle définit les **attributs** (données ou propriétés) et les **méthodes** (comportements ou actions) que possèdent ses objets.
    - Exemple : Une classe `Voiture` peut contenir :
        - Attributs : `marque`, `modèle`, `couleur`.
        - Méthodes : `demarrer()`, `freiner()`.
- **Objet** :
    
    - Un objet est une **instance** d’une classe, c’est-à-dire une version concrète et spécifique de cette classe.
    - Chaque objet a ses propres valeurs pour les attributs définis dans la classe.
    - Exemple : Une instance de la classe `Voiture` peut représenter une Toyota Corolla rouge.


### Principes fondamentaux de la POO :

La POO repose sur quatre piliers principaux qui permettent de structurer le code de manière efficace et réutilisable :

1. **Encapsulation** :
    - Limiter l'accès direct aux données (attributs) d’un objet.
    - Protéger l’intégrité des données en fournissant des méthodes pour les consulter ou les modifier (**getters** et **setters**).
    - Exemple : Une classe `CompteBancaire` peut cacher le solde pour éviter des modifications non contrôlées.
    
1. **Héritage** :
    - Permet de créer une nouvelle classe (classe enfant) basée sur une classe existante (classe parent).
    - La classe enfant hérite des attributs et méthodes de la classe parent, et peut ajouter ou redéfinir des fonctionnalités.
    - Exemple : Une classe `Véhicule` peut être héritée par `Voiture` et `Moto`.
    
1. **Polymorphisme** :
    - Permet à une même méthode ou interface d’être utilisée différemment selon le contexte.
    - Exemple : Une méthode `dessiner()` peut être implémentée différemment pour des objets `Cercle` ou `Rectangle`.
    
1. **Abstraction** :
    - Consiste à masquer les détails d’implémentation d’un objet pour se concentrer sur ses fonctionnalités principales.
    - Exemple : Une classe abstraite `Animal` définit un comportement générique (`faireDuBruit()`), mais chaque sous-classe (`Chien`, `Chat`) implémente ce comportement différemment.

### Avantages de la POO :

- **Modularité** : Le code est organisé en classes et objets, ce qui facilite la gestion et la compréhension.
- **Réutilisabilité** : Les classes peuvent être réutilisées ou étendues pour créer de nouvelles fonctionnalités.
- **Extensibilité** : Il est facile d’ajouter de nouvelles fonctionnalités en étendant les classes existantes.
- **Maintenance simplifiée** : Les bugs sont plus faciles à localiser, car le code est structuré en modules indépendants.

### Exercice pour comprendre

#### Prenons l’exemple de la modélisation d’une voiture :

- **Classe** : Une classe `Voiture` définit le modèle général d’une voiture.
- **Objet** : Une voiture spécifique comme une Toyota Corolla rouge.
- **Attributs** : `marque`, `modèle`, `couleur`.
- **Méthodes** : `démarrer`, `freiner`, `accélérer`.

```
+--------------------+
|      Voiture       |
+--------------------+
| + marque  : String |
| + modele  : String |
| + couleur : String |
+--------------------+
| + demarrer()       |
| + accelerer()      |
| + freiner()        |
+--------------------+

```

Créez la classe qui correspond à cette définition. En suite dans un fichier Main.java vous crérez une voiture et la ferrez démarrer.

### Correction de l'exercice

*Voiture.java*
```java
// Voiture.java
public class Voiture {
    // Attributs
    String marque;
    String modele;
    String couleur;

    // Méthodes
    void demarrer() {
        System.out.println("La voiture démarre");
    }
	
	void accelerer() {
        System.out.println("La voiture accelère");
    }

    void freiner() {
        System.out.println("La voiture freine");
    }
}
```

*main.java*
```java
public class Main {
    public static void main(String[] args) {
        Voiture voiture = new Voiture();
        voiture.marque = "Toyota";
        voiture.modele = "Corolla";
        voiture.couleur = "Rouge";

        voiture.demarrer();
    }
}
```

# 2 - Les bases de Java et de la POO

### Définition 

Une classe est un plan ou modèle pour créer des objets. Elle contient des **attributs** (propriétés) et des **méthodes** (comportements).

```java
public class NomDeLaClasse {
    // Attributs
    Type nomAttribut;

    // Méthodes
    Accessibilité TypeRetour nomMethode (Paramètres) {
        // Corps de la méthode
    }
}
```

Instanciation d’un objet : action de créer un objet à partir d’une classe.

```java
Voiture voiture = new Voiture();
```

Un objet est une référence en mémoire.

```java
Voiture voiture1 = new Voiture();
Voiture voiture2 = voiture1; // Les deux variables pointent vers le même objet
```

### Modificateurs d’accès et encapsulation

**Public, Private, Protected** :
- `public` : Accessible depuis n’importe où.
- `private` : Accessible uniquement depuis la classe elle-même.
- `protected` : Accessible depuis la classe, ses sous-classes et le même package.

```java
public class Voiture {
    private String marque;

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }
}
```

### Constructeurs

#### Définition
- Un constructeur est une méthode spéciale utilisée pour initialiser un objet.
- Il porte le même nom que la classe et n’a pas de type de retour.

```java
public class Voiture {
    String marque;
    String modele;
    String couleur;

    public Voiture(String marque, String modele, String couleur) {
        this.marque = marque;
        this.modele = modele;
        this.couleur = couleur;
    }
	
	void demarrer() {
        System.out.println("La voiture démarre");
    }

    void accelerer() {
        System.out.println("La voiture accelère");
    }

    void freiner() {
        System.out.println("La voiture freine");
    }
}

public class Main {
    public static void main(String[] args) {
        Voiture voiture = new Voiture("Toyota", "Corolla", "Rouge");
        System.out.println(voiture.marque + " " + voiture.modele + " " + voiture.couleur);
    }
}
```

#### Exercice 

En partant de l'exemple rendre les attributs marque et modèle privé.
### Surcharge des constructeurs

Possibilité de définir plusieurs constructeurs avec des signatures différentes.

```java
public class Voiture {
    String marque;
    String modele;

    public Voiture() {
        marque = "Inconnu";
        modele = "Inconnu";
    }

    public Voiture(String marque) {
        this.marque = marque;
        this.modele = "Inconnu";
    }

    public Voiture(String marque, String modele) {
        this.marque = marque;
        this.modele = modele;
    }
}
```

### Méthodes

##### Définition :
- Les méthodes définissent les comportements d’une classe.
- Une méthode peut prendre des paramètres et retourner une valeur

```java
public class Calculatrice {
    public int additionner(int a, int b) {
        return a + b;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculatrice calc = new Calculatrice();
        System.out.println(calc.additionner(5, 3));
    }
}

```

### Méthodes statiques et attributs statiques

#### Définition
Les membres `static` appartiennent à la classe et non à une instance.

```java
public class MathUtils {
    public static double pi = 3.14;

    public static double multiplier(double a, double b) {
        return a * b;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(MathUtils.pi);
        System.out.println(MathUtils.multiplier(2, 3));
    }
}
```

### Exercice

**1/ Créer une classe Person** :
- Attributs : `nom`, `age`.
- Constructeurs : un par défaut, un avec paramètres.
- Méthodes : `sePresenter()` qui affiche le nom et l’âge.
- Instanciez cette classe dans une méthode principale.

**2/ Classe CompteBancaire** :
- Attributs privés : `solde`, `titulaire`.
- Méthodes : `deposer()`, `retirer()` (vérifier que le solde reste positif).
- Créez une instance et effectuez plusieurs opérations dans une méthode principale.