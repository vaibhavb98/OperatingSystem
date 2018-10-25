import java.util.ArrayList;
import java.util.Arrays;

public class SSTF {
    public static void main(String[] args) {
        ArrayList<Integer> pages = new ArrayList<Integer>(Arrays.asList(45, 21, 67, 90, 4, 89, 52, 61, 87, 25));
        int headPosition = 50;
        int size = pages.size();
        int nOfCylinders = 0;
        for (int i = 0; i < size; i++) {
            int min = Integer.MAX_VALUE, val = Integer.MIN_VALUE;
            for (Integer page : pages) {
                int diff = Math.abs(page - headPosition);
                if (diff < min) {
                    min = diff;
                    val = page;
                }
            }

            System.out.println("from " + headPosition + " to " + val);

            nOfCylinders += min;
            headPosition = val;
            pages.remove(new Integer(headPosition));
        }
        System.out.println("Number of Cylinders: " + nOfCylinders);
    }
}
