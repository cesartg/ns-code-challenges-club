import java.io.IOException;
import java.util.Scanner;

public class TruckTour {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] petrolAmounts = new int[n];
        int[] distances = new int[n];
        for (int i = 0; i < n; i++) {
            petrolAmounts[i] = in.nextInt();
            distances[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if (canCompleteTour(petrolAmounts, distances, i)) {
                System.out.print(i);
                break;
            }
        }
    }

    private static boolean canCompleteTour(int[] petrolAmount, int[] distances, int startIndex) {
        int carriedPetrol = 0;
        for (int i = startIndex; i < petrolAmount.length; i++) {
            carriedPetrol += petrolAmount[i];
            if (distances[i] > carriedPetrol){
                return false;
            }
            carriedPetrol -= distances[i];
        }
        for (int i = 0; i < startIndex; i++) {
            carriedPetrol += petrolAmount[i];
            if (distances[i] > carriedPetrol){
                return false;
            }
            carriedPetrol -= distances[i];
        }
        return true;
    }
}
