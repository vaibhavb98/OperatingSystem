package vaibhavb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class LRU {

    public static void main(String args[]) {
        int pages[] = {0, 9, 0, 1, 8, 1, 8, 7, 8, 7, 1, 2, 8, 2, 7, 8, 2, 8};
        int capacity = 3;
        ArrayList<Integer> requestStr = new ArrayList<>(capacity);
        HashMap<Integer, Integer> pageToCount = new HashMap<>();
        int page_faults = 0;
        for (int i = 0; i < pages.length; i++) {
            if (requestStr.size() < capacity) {
                if (!requestStr.contains(pages[i])) {
                    requestStr.add(pages[i]);
                    page_faults++;
                }
                pageToCount.put(pages[i], i);
            } else {
                if (!requestStr.contains(pages[i])) {
                    int lru = Integer.MAX_VALUE, val = Integer.MIN_VALUE;
                    Iterator<Integer> itr = requestStr.iterator();
                    while (itr.hasNext()) {
                        int temp = itr.next();
                        if (pageToCount.get(temp) < lru) {
                            lru = pageToCount.get(temp);
                            val = temp;
                        }
                    }
                    requestStr.remove(val);
                    requestStr.add(pages[i]);
                    page_faults++;
                }
                pageToCount.put(pages[i], i);
            }
            System.out.print("last frame state: ");
            for (Integer item : requestStr) {
                System.out.print(item + " ");
            }
        }

        System.out.println("");
        System.out.println("Total Page Faults: " + page_faults);
    }
}
