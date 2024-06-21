import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    // Calculates the total distance to check how velocity needs to be changed.
    // If there is no need for a change in velocity, there is no change.
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("race.in"));
        PrintWriter pw = new PrintWriter("race.out");

        int K = sc.nextInt();
        int N = sc.nextInt();
        int[] x = new int[N];
        for (int i = 0; i < N; i++) {
            x[i] = sc.nextInt();
        }

        for (int i : x) {
            int t = getMinTime(i, K);
            pw.println(t);
        }

        pw.close();
    }
    static int getMinTime(int x, int K) {
        int time = 0;
        int vel = 0;
        int distance = 0;
        while (distance < K) {
            int chang = velocityCalc(x, K-distance, vel);
            vel += chang;
            distance += vel;
            time++;
        }
        return time;
    }

    static int velocityCalc(int x, int diff, int vel) {

        if (vel + 1 < x) {
            return 1;
        }

        int incLength = (vel + 1 + x) * (vel - x + 2) / 2;
        int norm = (vel + x) * (vel - x + 1) / 2;
        if (incLength <= diff) {
            return 1;
        } else if (norm <= diff) {
            return 0;
        } else {
            return -1;
        }
    }
}