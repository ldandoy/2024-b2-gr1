import java.util.Arrays;

public class DataManipulation {
    public static void main(String[] args) {
        // Crée un tableau de nombres entiers.
        int[] data = {3, 5, 7, 2, 8, 10, 11, 1, 6, 4};

        // Calcule la moyenne, la médiane et l'écart-type des valeurs du tableau.
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
