import java.util.Scanner;

public class RR {

    public static boolean isDone(int RBT[]) {
        for (int i : RBT) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
    
    public static int sum(int arr[]) {
        int res = 0;
        for(int i : arr){
            res += i;
        }
        return res;
    }
    
    static void printIt(int BT[], int WT[], int TAT[]) {
        System.out.println("BT\tWT\tTAT");
        for(int i = 0 ; i < WT.length ; i++) {
            System.out.println(BT[i]+"\t"+WT[i]+"\t"+TAT[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of Processes: ");
        int n_process = sc.nextInt();
        System.out.print("Enter Time Quantum: ");
        final int TQ = sc.nextInt();
        int BT[] = new int[n_process], RBT[] = new int[n_process], WT[] = new int[n_process], TAT[] = new int[n_process];
        System.out.print("Enter Burst Time of all Processes: ");
        for (int i = 0; i < n_process; i++) {
            BT[i] = sc.nextInt();
            RBT[i] = BT[i];
        }
        int t = 0;
        while(!isDone(RBT)){
            for(int i = 0 ; i < RBT.length ; i++){
                if(RBT[i] == 0) continue;
                if(RBT[i] > TQ) {
                    t += TQ;
                    RBT[i] -= TQ;
                } else {
                    t += RBT[i];
                    RBT[i] = 0;
                    WT[i] = t - BT[i];
                    TAT[i] = WT[i] + BT[i];
                }
            }
        }
        
        printIt(BT, WT, TAT);
        
        System.out.println("Average Wating Time: " + (float)sum(WT)/n_process);
        System.out.println("Average Turn Arround Time: " + (float)sum(TAT)/n_process);
        
       /*   OUTPUT
            run:
            Enter Number of Processes: 3
            Enter Time Quantum: 2
            Enter Burst Time of all Processes: 10 5 8
            BT	WT	TAT
            10	13	23
            5	10	15
            8	13	21
            Average Wating Time: 12.0
            Average Turn Arround Time: 19.666666
       */
        
    }
}
