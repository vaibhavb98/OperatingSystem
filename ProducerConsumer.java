/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oslab;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Producer_consumer {

    static int s = 1, empty = 10, full = 0;

    static int Wait(int x) {
        return --x;
    }

    static int Signal(int x) {
        return ++x;
    }

    static void Producer() {
        s = Wait(s);
        full = Signal(full);
        empty = Wait(empty);

        System.out.println("<!-- Producing -->");

        s = Signal(s);
    }

    static void Consume() {
        s = Wait(s);
        empty = Signal(empty);
        full = Wait(full);

        System.out.println("<!-- Consume -->");
        
        s = Signal(s);
    }
    
    public static void main(String[] args) {
        Scanner ic = new Scanner(System.in);
        
        while(true) {
            System.out.print("choose from\n1> P\n2> C\n3>Q \n:$ ");
            int input = ic.nextInt();
            
            switch (input) {
                case 1:
                    if(s==1 && empty!=0) Producer();
                    else System.out.println("<!-- Producer Waiting -->\n");
                    break;
                case 2: 
                    if(s==1 && full!=0) Consume();
                    else System.out.println("<!-- Consumer Waiting -->\n");
                    break;
                case 3: 
                    System.exit(0);
                    break;
            }
        }
    }
    /*
    OUTPUT: 
        choose from
        1> P
        2> C
        3>Q 
        :$ 2
        <!-- Consumer Waiting -->

        choose from
        1> P
        2> C
        3>Q 
        :$ 1
        <!-- Producing -->
        choose from
        1> P
        2> C
        3>Q 
        :$ 1
        <!-- Producing -->
        choose from
        1> P
        2> C
        3>Q 
        :$ 3
    */
}
