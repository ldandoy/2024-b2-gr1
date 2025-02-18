
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


### Correction

**Exo1**

*Person.java*
```java
public class Person {
    // Attributs
    private String nom;
    private int age;

    // Constructeur par défaut
    public Person() {
        this.nom = "";
        this.age = 0;
    }

    // Constructeur avec paramètres
    public Person(String nom, int age) {
        this.nom = nom;
        this.age = age;
    }

    // Méthode pour se présenter
    public void sePresenter() {
        System.out.println("Je m'appelle " + this.nom + " et j'ai " + this.age + " ans.");
    }
}
```

*Main.java*
```java
class Main {
// Méthode principale pour tester la classe
    public static void main(String[] args) {
        // Instanciation avec le constructeur par défaut
        Person personne1 = new Person();
        personne1.sePresenter(); // Affiche : Je m'appelle  et j'ai 0 ans.

        // Instanciation avec le constructeur paramétré
        Person personne2 = new Person("Alice", 25);
        personne2.sePresenter(); // Affiche : Je m'appelle Alice et j'ai 25 ans.
    }
}
```

Exo2

*CompteBancaire.java*
```java
public class CompteBancaire {
    // Attributs privés
    private double solde;
    private String titulaire;

    // Constructeur
    public CompteBancaire(String titulaire, double soldeInitial) {
        this.titulaire = titulaire;
        this.solde = soldeInitial;
    }

    // Méthode pour déposer de l'argent
    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant;
            System.out.println(montant + " € déposés. Nouveau solde : " + solde + " €");
        } else {
            System.out.println("Le montant à déposer doit être positif.");
        }
    }

    // Méthode pour retirer de l'argent
    public void retirer(double montant) {
        if (montant > 0 && montant <= solde) {
            solde -= montant;
            System.out.println(montant + " € retirés. Nouveau solde : " + solde + " €");
        } else if (montant > solde) {
            System.out.println("Fonds insuffisants. Solde actuel : " + solde + " €");
        } else {
            System.out.println("Le montant à retirer doit être positif.");
        }
    }
}
```

*Main.java*
```java
public class Main {
    public static void main(String[] args) {
        // Création d'une instance de CompteBancaire
        CompteBancaire compte = new CompteBancaire("Alice", 1000.0);
        
        // Dépôt d'argent
        compte.deposer(500.0); // 500.0 € déposés. Nouveau solde : 1500.0 €

        // Retrait d'argent
        compte.retirer(200.0); // 200.0 € retirés. Nouveau solde : 1300.0 €

        // Tentative de retrait d'un montant supérieur au solde
        compte.retirer(2000.0); // Fonds insuffisants. Solde actuel : 1300.0 €

        // Tentative de retrait d'un montant négatif
        compte.retirer(-100.0); // Le montant à retirer doit être positif.
    }
}
```

## Les principes fondamentaux de la POO

### Encapsulation

- L'encapsulation consiste à protéger les données d’une classe en les rendant inaccessibles directement depuis l'extérieur.
- Cela se fait en déclarant les attributs comme **privés** (`private`) et en fournissant des **getters** et **setters** publics.

```java
public class CompteBancaire {
    private double solde;

    // Getter
    public double getSolde() {
        return solde;
    }
	public void setSolde(double solde) {
		this.solde = solde;
	}

    // Setter
    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant;
        }
    }

    public void retirer(double montant) {
        if (montant > 0 && montant <= solde) {
            solde -= montant;
        } else {
            System.out.println("Fonds insuffisants !");
        }
    }
}
```

#### Exercice pratique

- Implémentez une classe `Produit` avec des attributs `nom`, `prix` et `quantite`.
- Créez des getters et setters pour gérer ces données.

### Héritage

- L’héritage permet à une classe (classe enfant) de **réutiliser** les attributs et méthodes d’une autre classe (classe parent).
- On utilise le mot-clé `extends` pour établir une relation d’héritage.

```java
public class Vehicule {
    protected String marque;

    public void demarrer() {
        System.out.println("Le véhicule démarre.");
    }
}

public class Voiture extends Vehicule {
    public void klaxonner() {
        System.out.println("La voiture klaxonne !");
    }
}

public class Main {
    public static void main(String[] args) {
        Voiture voiture = new Voiture();
        voiture.marque = "Toyota";
        voiture.demarrer();
        voiture.klaxonner();
    }
}
```

#### Exercice pratique
- Créez une classe parent `Animal` avec une méthode `faireDuBruit()`.
- Créez des classes enfants `Chien` et `Chat` qui redéfinissent cette méthode.

#### Correction

*Animal.java*
```java
// Classe parent Animal
public class Animal {
    // Méthode faireDuBruit() dans la classe parent
    public void faireDuBruit() {
        System.out.println("L'animal fait un bruit.");
    }
}
```

*Chien.java*
```java
// Classe enfant Chien
public class Chien extends Animal {
    // Redéfinition de la méthode faireDuBruit()
    @Override
    public void faireDuBruit() {
        System.out.println("Le chien aboie : Woof Woof !");
    }
}
```

*Chat.java*
```java
// Classe enfant Chat
public class Chat extends Animal {
    // Redéfinition de la méthode faireDuBruit()
    @Override
    public void faireDuBruit() {
        System.out.println("Le chat miaule : Meow Meow !");
    }
}
```

### Polymorphisme

- Le polymorphisme permet d’utiliser une méthode ou un objet de différentes manières, selon le contexte.
- Deux formes principales :
    - **Polymorphisme statique (surcharge)** : Plusieurs méthodes avec le même nom mais des signatures différentes.
    - **Polymorphisme dynamique (redéfinition)** : Une méthode d'une classe parent est redéfinie dans une classe enfant.

**Surcharge (statique)**
```java
public class Calculatrice {
    public int additionner(int a, int b) {
        return a + b;
    }

    public double additionner(double a, double b) {
        return a + b;
    }
}
```

**Surcharge (dynamique)**
```java
public class Animal {
    public void faireDuBruit() {
        System.out.println("L'animal fait du bruit.");
    }
}

public class Chien extends Animal {
    @Override
    public void faireDuBruit() {
        System.out.println("Le chien aboie.");
    }
}

public class Chat extends Animal {
    @Override
    public void faireDuBruit() {
        System.out.println("Le chat miaule.");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal = new Chien();
        animal.faireDuBruit(); // Affiche : "Le chien aboie."
        
        Animal animal2 = new Chat();
        animal2.faireDuBruit(); // Affiche : "Le chat miaule."
    }
}
```

#### Exercice pratique
Implémentez une méthode `calculerPrix` dans une classe parent `Produit` et redéfinissez là dans des classes enfants `Livre` et `DVD`.
Un Livre est à 5% de TVA et un DVD à 20%.

#### Correction

*Exercice.java*
```java
// Classe parent Produit
class Produit {
    protected String nom;
    protected double prixBase;

    public Produit(String nom, double prixBase) {
        this.nom = nom;
        this.prixBase = prixBase;
    }

    public double calculerPrix() {
        return prixBase; // Prix de base sans modification
    }

    public void afficherPrix() {
        System.out.println(nom + " coûte : " + calculerPrix() + " €");
    }
}

// Classe enfant Livre
class Livre extends Produit {
    private double taxeLivre = 0.05; // 5% de taxe

    public Livre(String nom, double prixBase) {
        super(nom, prixBase);
    }

    @Override
    public double calculerPrix() {
        return prixBase * (1 + taxeLivre);
    }
}

// Classe enfant DVD
class DVD extends Produit {
    private double taxeDVD = 0.20; // 20% de taxe

    public DVD(String nom, double prixBase) {
        super(nom, prixBase);
    }

    @Override
    public double calculerPrix() {
        return prixBase * (1 + taxeDVD);
    }
}
```


### Abstraction

- L’abstraction consiste à cacher les détails d’implémentation et à exposer uniquement les fonctionnalités essentielles.
- Implémentée avec :
    - **Classes abstraites** : Utilisent le mot-clé `abstract`.
    - **Interfaces** : Définissent un contrat sans fournir d'implémentation.

#### Classe abstraite
```java
public abstract class Forme {
    public abstract double calculerAire();
}

public class Cercle extends Forme {
    private double rayon;

    public Cercle(double rayon) {
        this.rayon = rayon;
    }

    @Override
    public double calculerAire() {
        return Math.PI * rayon * rayon;
    }
}

```

#### Interface
```java
public interface Volant {
    public void voler();
}

public class Avion implements Volant {
    @Override
    public void voler() {
        System.out.println("L'avion vole dans les airs.");
    }
}

```

#### Exercice pratique
- Créez une interface `Transport` avec une méthode `deplacer()`.
- Implémentez cette interface dans des classes `Voiture` et `Avion`.

#### Correction

*Transport.java*
```java
public interface Transport { void deplacer(); }
```

*Voiture.java*
```java
public class Voiture implements Transport {
    @Override
    public void deplacer() {
        System.out.println("La voiture roule sur la route.");
    }
}
```

*Avion.java*
```java
public class Avion implements Transport {
    @Override
    public void deplacer() {
        System.out.println("L'avion vole dans le ciel.");
    }
}
```

## Les collections, les exceptions et la gestion des fichiers

Les collections sont des structures de données dynamiques qui permettent de stocker, gérer et manipuler des groupes d’objets.

### Interfaces principales des collections
- **Collection** : Interface de base.
- **List** : Une liste ordonnée (par exemple, `ArrayList`, `LinkedList`).
- **Set** : Une collection sans doublons (par exemple, `HashSet`, `TreeSet`).
- **Map** : Une collection d'associations clé-valeur (par exemple, `HashMap`, `TreeMap`).

*Exemple d'utilisation d’une List*
```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Création d'une liste
        ArrayList<String> fruits = new ArrayList<>();
        
        // Ajout d'éléments
        fruits.add("Pomme");
        fruits.add("Banane");
        fruits.add("Orange");
        
        // Parcours de la liste
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // Accès à un élément
        System.out.println("Premier fruit : " + fruits.get(0));
    }
}
```

*Exemple d’utilisation d’une Map*
```java
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Création d'une map
        HashMap<String, Integer> stock = new HashMap<>();
        
        // Ajout d'éléments
        stock.put("Pommes", 50);
        stock.put("Bananes", 20);

        // Parcours de la map
        for (String key : stock.keySet()) {
            System.out.println(key + " : " + stock.get(key));
        }
    }
}
```

#### Résumé des différences principales

|Propriété|**List**|**Set**|**Map**|
|---|---|---|---|
|**Ordonnée**|Oui|Non (sauf `LinkedHashSet`)|Non (sauf `TreeMap`, `LinkedHashMap`)|
|**Doublons**|Autorisés|Interdits|Clés interdites, valeurs autorisées|
|**Accès par clé**|Non|Non|Oui (par la clé)|
|**Structure**|Séquence d'éléments|Collection d'éléments uniques|Association clé-valeur|
### Étude de cas complète

Créez une application pour gérer une liste d'étudiants :
- Ajouter un étudiant (nom, prenom et classe).
- Afficher la liste des étudiants.
- Supprimer un étudiant par son nom.

#### Correction

##### Structure

```css
/MonProjet
   ├── Etudiant.java
   ├── GestionEtudiants.java
   ├── Main.java




# Maven (dependency manager)
## Installation et Utilisation de Maven en Java

### Introduction à Maven

**Apache Maven** est un outil de gestion de projet principalement utilisé pour les projets Java. Il permet :  
- La gestion des dépendances (bibliothèques tierces) via un fichier `pom.xml`.  
- L’automatisation du cycle de vie du projet (compilation, test, packaging, déploiement).  
- Une structuration standardisée des projets Java.  
- Une gestion centralisée des builds et configurations.

## Installation de Maven

### Prérequis

Avant d’installer Maven, assurez-vous que :  
🔹 **Java (JDK)** est installé sur votre machine.  
🔹 **La variable d’environnement JAVA_HOME** est correctement configurée.

Vérifiez votre version de Java en exécutant :

```bash
java --version
```
### Installation de Maven sur Windows

Rendez-vous sur le site officiel : [https://maven.apache.org/download.cgi](https://maven.apache.org/download.cgi)
- Téléchargez la version **Binary zip** de Maven.
- Décompressez le fichier ZIP (ex: `C:\apache-maven-3.x.x`).
- Ajoutez le chemin `C:\apache-maven-3.x.x\bin` à la variable d’environnement `Path`.
- Vérifier l’installation

```bash
mvn --version
```

### Installation de Maven sur macOS

Pour macOS (avec Homebrew) :

```bash
brew install maven
```
## Création d’un Projet Maven

### Générer un projet Maven

Une fois Maven installé, vous pouvez créer un projet avec la commande :

```bash
mvn archetype:generate -DgroupId=com.monprojet -DartifactId=mon-app -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

```

### Structure du projet Maven généré

```plantext
mon-app/
│── src/
│   ├── main/java/com/monprojet/App.java  # Code source principal
│   ├── test/java/com/monprojet/AppTest.java  # Tests unitaires
│── pom.xml  # Fichier de configuration du projet

```
## Comprendre le fichier `pom.xml`

Le fichier **`pom.xml` (Project Object Model)** est le cœur du projet Maven.

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.monprojet</groupId>
    <artifactId>mon-app</artifactId>
    <packaging>jar</packaging>
    <version>1.0-SNAPSHOT</version>
    <name>mon-app</name>
    <url>http://maven.apache.org</url>
	<properties>
      <maven.compiler.source>23</maven.compiler.source>
      <maven.compiler.target>23</maven.compiler.target>
	</properties>
	<build>
		<plugins>
			<plugin>
			    <artifactId>maven-jar-plugin</artifactId>
			    <version>3.2.2</version>
			    <configuration>
				    <archive>
				        <manifest>
					        <mainClass>com.projet1.App</mainClass>
				        </manifest>
			        </archive>
			    </configuration>
		    </plugin>
		</plugins>
	</build>
    <dependencies>
        <!-- Dépendance pour JUnit (tests unitaires) -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.2</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>

```

### Explication :

- `<groupId>` : Identifiant unique du projet (ex: nom du package).
- `<artifactId>` : Nom du projet (génère `mon-app-1.0-SNAPSHOT.jar`).
- `<version>` : Version du projet.
- `<dependencies>` : Liste des bibliothèques utilisées.
## Utilisation de Maven : Commandes essentielles

### Compiler le projet

```bash
mvn compile
```

### Générer un fichier JAR

```bash
mvn package
```

Le fichier `.jar` est généré dans `target/mon-app-1.0-SNAPSHOT.jar`.

### Exécuter un programme Java compilé avec Maven 

Si le projet contient une classe `main()`, vous pouvez l’exécuter avec :

```bash
java -jar target/mon-app-1.0-SNAPSHOT.jar
```

### Ajouter une dépendance Maven

Vous pouvez ajouter une bibliothèque comme **MySQL Connector** en modifiant `pom.xml` :

```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.33</version>
</dependency>
```

Puis téléchargez la dépendance avec :

```bash
mvn clean install
```

### Nettoyer le projet**  
Supprime les fichiers générés (`target/` etc.) :

```bash
mvn clean
```

# JDBC (Java Data Base Connectivity)

### Qu'est-ce que JDBC ?

**JDBC (Java Database Connectivity)** est une API fournie par Java permettant aux applications de se connecter à une base de données et d’exécuter des requêtes SQL.

🔹 **Pourquoi JDBC ?**
- JDBC est une interface standardisée pour l'accès aux bases de données relationnelles.
- Il permet aux applications Java d’être indépendantes du type de base de données utilisée.
- JDBC facilite l’interaction avec les bases de données via une série de classes et d’interfaces Java.

🔹 **Exemple de workflow JDBC :**
- Charger un **driver JDBC** (logiciel permettant la communication avec la base).
- Établir une **connexion** avec la base de données.
- Exécuter des requêtes SQL (lecture, insertion, mise à jour, suppression).
- Lire les résultats et les afficher ou les manipuler.
- Fermer la connexion pour libérer les ressources.

### Architecture et fonctionnement de JDBC

L’architecture JDBC repose sur **quatre composants principaux** :

**JDBC API** :
    - Fournit des classes et interfaces pour interagir avec la base de données.
    - Située dans le package `java.sql`.
    - Permet d’exécuter des requêtes SQL et de gérer les transactions.
**JDBC Driver** :
    - Un **driver** est un pont entre Java et la base de données.
    - Chaque base de données (MySQL, PostgreSQL, Oracle, etc.) a son propre driver.
    - Exemples de drivers JDBC :
        - MySQL : `com.mysql.cj.jdbc.Driver`
        - PostgreSQL : `org.postgresql.Driver`
        - SQLite : `org.sqlite.JDBC`
**Driver Manager (`java.sql.DriverManager`)** :
    - Gère les différents drivers installés.
    - Sert d’intermédiaire entre l’application et la base de données.
**Base de données** :
    - La source des données avec lesquelles Java interagit.

**Schéma de fonctionnement :**

```mathematica
Application Java  →  JDBC API  →  Driver Manager  →  Driver JDBC  →  Base de données
```


### Différences entre JDBC et ORM (ex : Hibernate)

JDBC est une approche **bas niveau** permettant de manipuler directement les bases de données en SQL, tandis que les ORM (Object-Relational Mapping) comme **Hibernate** automatisent ce processus.

|Critère|JDBC|Hibernate (ORM)|
|---|---|---|
|Niveau d’abstraction|Bas (requêtes SQL directes)|Élevé (manipulation d’objets Java)|
|Facilité d’utilisation|Complexe (code répétitif)|Plus simple (annotations, mapping automatique)|
|Performances|Rapide (accès direct)|Peut être plus lent (couche d’abstraction)|
|Transactions|Gestion manuelle|Géré automatiquement|
|Sécurité|Risque d'injection SQL|Protégé par défaut|

- **JDBC est idéal pour des projets simples ou lorsqu’on a besoin d’un contrôle total.**  
- **Hibernate est recommandé pour des projets complexes nécessitant un mapping entre objets Java et bases de données.**

### Les différents types de drivers JDBC

JDBC utilise des **drivers** pour communiquer avec les bases de données. Il existe **quatre types de drivers JDBC** :

**Type 1 : JDBC-ODBC Bridge Driver** _(obsolète, non recommandé)_
    - Utilise ODBC comme intermédiaire.
    - Peu performant et dépendant du système d’exploitation.
**Type 2 : Native-API Driver**
    - Utilise des bibliothèques natives de la base de données.
    - Performant mais dépendant de la plateforme.
**Type 3 : Middleware Driver**
    - Utilise un serveur intermédiaire pour convertir les requêtes JDBC.
    - Adapté aux architectures distribuées.
**Type 4 : Thin Driver (100% Java)** _(Recommandé)_
    - Communique directement avec la base de données.
    - Indépendant du système et performant.
    - Exemples : `mysql-connector-java`, `postgresql-42.2.5.jar`, `sqlite-jdbc.jar`.

### Mise en pratique

Avant toute chose installer une base de donnée SQL
- MySQL
- Sqlite
- PostgreSQL

#### Installation et utilisation de maven

Voir le cours sur maven
#### Le code

*pom.xml*
```xml
<build>
    <plugins>
        <!-- Maven Shade Plugin -->
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-shade-plugin</artifactId>
            <version>3.5.1</version> <!-- Vérifiez la dernière version sur Maven Central -->
            <executions>
                <execution>
                    <phase>package</phase>
                    <goals>
                        <goal>shade</goal>
                    </goals>
                    <configuration>
                        <!-- Optionnel : spécifier la classe principale -->
                        <transformers>
                            <transformer implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
                                <mainClass>com.monprojet.App</mainClass> <!-- Remplacez par votre classe principale -->
                            </transformer>
                        </transformers>
                    </configuration>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>

<dependencies>
    <dependency>
      <groupId>com.mysql</groupId>
      <artifactId>mysql-connector-j</artifactId>
      <version>8.0.33</version>
    </dependency>
</dependencies>
```

*ConnexionJDBC.java*
```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionJDBC {
    public static void main(String[] args) {
        // Informations de connexion
        String url = "jdbc:mysql://localhost:3306/maBase"; // Remplacer "maBase" par le nom de votre base
        String utilisateur = "root";
        String motDePasse = "password";
        Connection connexion = null;

        try {
            // Établir la connexion
            connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
            System.out.println("Connexion réussie !");
            
        } catch (SQLException e) {
            System.out.println("Erreur de connexion : " + e.getMessage());
        } finally { // Toujours fermer la connexion pour éviter les fuites de ressources 
	        if (connexion != null) { 
		        try { 
			        connexion.close(); 
			        System.out.println("Connexion fermée avec succès."); 
			    } catch (SQLException e) { 
				    System.err.println("Erreur lors de la fermeture de la connexion : " + e.getMessage()); 
				} 
			} 
		}
    }
}
```
