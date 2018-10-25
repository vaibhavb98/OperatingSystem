import java.util.ArrayList;
import java.util.HashMap;

class LRU {

    public static void main(String args[]) {
        int pages[] = {0, 9, 0, 1, 8, 1, 8, 7, 8, 7, 1, 2, 8, 2, 7, 8, 2, 8};
        int capacity = 3;
        ArrayList<Integer> frames = new ArrayList<>(capacity);
        HashMap<Integer, Integer> pageToCount = new HashMap<>();
        int page_faults = 0;
        for (int i = 0; i < pages.length; i++) {
            if (frames.size() < capacity) {
                if (!frames.contains(pages[i])) {
                    frames.add(pages[i]);
                    page_faults++;
                }
                pageToCount.put(pages[i], i);
            } else {
                if (!frames.contains(pages[i])) {
                    int lru = Integer.MAX_VALUE, val = Integer.MIN_VALUE;
                    for (Integer page : frames) {
                        if (pageToCount.get(page) < lru) {
                            lru = pageToCount.get(page);
                            val = page;
                        }
                    }
                    frames.remove(new Integer(val));
                    frames.add(pages[i]);
                    page_faults++;
                }
                pageToCount.put(pages[i], i);
            }
            System.out.print("Frame State: ");
            for (Integer item : frames) {
                System.out.print(item + " ");
            }
            System.out.println();
        }

        System.out.println("Total Page Faults: " + page_faults);
    }
}
