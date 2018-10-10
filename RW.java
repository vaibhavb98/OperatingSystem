import java.util.concurrent.Semaphore;

public class ReaderWirter {
   static int rc=0;
  static Semaphore S= new Semaphore(1);
    static Semaphore wrt =new Semaphore(1);
static class Reader implements Runnable{

        @Override
        public void run() {
            try {
                S.acquire();
                rc++;
                if(rc==1)
                    wrt.acquire();
                S.release();
                System.out.println(Thread.currentThread().getName()+" is reading");
                Thread.sleep(5000);
                System.out.println("reading finished!!!!");
                S.acquire();
                rc--;
                if(rc==0)
                    wrt.release();
                S.release();
            } catch (InterruptedException ex) {
                
            }
        }
}
static class Writer implements Runnable {

        @Override
        public void run() {
            try {
                wrt.acquire();
                System.out.println(Thread.currentThread().getName()+" is writing!!");
                Thread.sleep(5000);
                System.out.println("writer finished!!");
                wrt.release();
            } catch (Exception e) {
            }
        }
    }

    public static void main(String[] args) {
        while(true){
            Reader r = new Reader();
            Writer write = new Writer();
            Thread t1= new Thread(r);
            t1.setName("1T");
            Thread t2= new rT);
            t2.setName("2T");
            Thread t3= new Thread(r);
            t3.setName("3T");
            t1.start();
            t2.start();
            t3.start();
            Thread t4 = new Thread(write);
            t4.setName("4T");
            t4.start();
            Thread t5 = new Thread(write);
            t5.setName("5T");
            t5.start();
        } 
    }
    
}
