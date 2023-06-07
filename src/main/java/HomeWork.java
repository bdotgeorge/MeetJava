import java.util.List;
import java.util.Random;

public class HomeWork {
    public void first(){
        int i = generateIntInRange(0, 2000);
        int n = highBitNumber(i);
        System.out.println(n);
        System.out.println(i);

    }
    private int generateIntInRange(int min, int max){
        return new Random().nextInt(min, max);
    }
    private int highBitNumber(int value){
        int c = 0;
        while (1 < value) {
            value >>= 1;
            c++;
        }
        return c;
    }
    private int[] multiplicity(int from, int n, boolean multiples){
        List<int> result;
        for (int i = from; i < Short.MAX_VALUE; i++) {
            if(i % n == 0) result.add(i)
        }
    }
}
