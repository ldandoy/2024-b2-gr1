public class Pairs {

    public static void main(String[] args) throws InterruptedException {
        for(int i=2; i < 20; i++) {
            if (i%2 == 0) {
                System.out.println("Compte: " + i);
                Thread.sleep(i*100);
            }
        }
    }
}