# CoopainFX - Gestion des Tournées d'Insémination

## Description du Projet
CoopainFX est une application Java orientée bureau, conçue pour modéliser et fiabiliser la saisie des actes d'insémination vétérinaire (Missions 4 et 5 de l'étude de cas Coopain).
Le logiciel permet à un inséminateur de facturer ses tournées quotidiennes tout en assurant une traçabilité rigoureuse en base de données. Il intègre une fiabilisation mathématique du chiffre d'affaires (TDD) et un historique visuel des actes.

## Fonctionnalités Principales
- **Facturation dynamique** : Calcul automatique et cumulatif du chiffre d'affaires (CA) de la tournée en cours.
- **Saisie des actes** : Formulaire permettant de choisir le type de prestation (Insémination, Echographie) et la quantité réalisée selon le tarif en vigueur.
- **Historique de saisie** : Traçabilité visuelle immédiate des actes ajoutés à la tournée.
- **Persistance des données** : Connexion directe avec une base de données MySQL via le modèle ORM pour extraire les tarifs et types de prestations.
- **Sécurisation métier** : Tests unitaires garantissant qu'une saisie invalide (comme 0 acte) n'altère pas les calculs financiers logiciels.

## Architecture Technique (Stack)
Le projet repose sur les standards de l'industrie Java :
- **Langage** : Java 17+
- **Interface Graphique** : JavaFX (Conception Modèle-Vue-Contrôleur)
- **Persistance (ORM)** : Hibernate 6 / Jakarta Persistence
- **Base de Données** : MySQL
- **Gestionnaire de dépendances** : Maven
- **Tests Qualité** : JUnit 5

## Structure du Projet (MVC)
```text
src/
├── main/
│   ├── java/coopain/
│   │   ├── controleur/         # Logique d'interaction UI (TourneeController)
│   │   ├── modele/             # Objets métiers purs (Visite, Tournee, TypePrestation)
│   │   ├── util/               # Singleton Hibernate (HibernateUtil)
│   │   ├── Launcher.java       # Point d'entrée de contournement JPMS
│   │   └── Main.java           # Point d'entrée JavaFX
│   └── resources/coopain/
│       ├── vue/                # Fichiers d'interface graphique (tournee.fxml)
│       └── hibernate.cfg.xml   # Configuration de connexion à la base MySQL
└── test/
    └── java/coopain/modele/    # Tests unitaires JUnit (GestionTourneeTest)
```

## Installation et Démarrage Automatique

### 1. Prérequis
- Java JDK 17 (ou supérieur) installé.
- Maven installé et configuré.
- Un serveur MySQL local en cours d'exécution (ex: XAMPP, Laragon, WAMP).

### 2. Configuration de la Base de Données
1. Créez une base de données nommée `coopain` dans votre serveur MySQL.
2. Créez une table `TypePrestation` et insérez-y quelques données (ex: "Insémination", "Echographie").
3. Vérifiez les identifiants de connexion dans le fichier `src/main/resources/hibernate.cfg.xml`. Par défaut : utilisateur `root` et mot de passe vide.

### 3. Compilation et Exécution
Ouvrez un terminal à la racine du projet et exécutez les commandes Maven suivantes :
```bash
# Pour compiler les sources
mvn clean compile

# Pour exécuter les tests unitaires TDD
mvn test

# Pour lancer l'application (Interface JavaFX experte)
mvn javafx:run
```
*(Vous pouvez également importer directement ce projet Maven dans votre IDE favori comme IntelliJ IDEA ou Eclipse et lancer la classe `Launcher.java`)*.
