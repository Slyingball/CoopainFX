package coopain;

public class Launcher {
    public static void main(String[] args) {
        // Contournement officiel JPMS (Modules Java 11+) pour lancer JavaFX sans module-info.java
        Main.main(args);
    }
}
