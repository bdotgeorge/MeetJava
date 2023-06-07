import java.util.ArrayList;
import java.util.Random;

public class HomeWork {
    public void first() {
        int i = generateIntInRange(0, 2000);
        int n = highBitNumber(i);
        int[] m1 = multiplicity(i, n, true);
        int[] m2 = multiplicity(i, n, false);

        System.out.println("Number bit = " + n + '\n' + "Number = " + i + '\n');
        for (int j : m1) {
            System.out.print("m1 = " + j + " ");
        }
        System.out.println('\n');
        for (int j : m2) {
            System.out.print("m2 = " + j + " ");
        }
    }

    private int generateIntInRange(int min, int max) {
        return new Random().nextInt(min, max);
    }

    private int highBitNumber(int value) {
        int c = 0;
        while (1 < value) {
            value >>= 1;
            c++;
        }
        return c;
    }

    private int[] multiplicity(int from, int n, boolean multiples) {
        ArrayList<Integer> result = new ArrayList<>();
        if (multiples) {
            for (int i = from; i < Short.MAX_VALUE; i++) {
                if (i % n == 0) result.add(i);
            }
        } else {
            for (int j = Short.MIN_VALUE; j < from; j++) {
                if (j % n != 0) result.add(j);
            }
        }
        int[] value = result.stream().mapToInt(Integer::intValue).toArray();
        return value;
    }
}
