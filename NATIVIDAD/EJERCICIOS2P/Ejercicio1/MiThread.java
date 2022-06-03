import java.util.Random;

public class MiThread extends Thread{
    private String message;
    
    public MiThread(String threadName){
        this.message = "Hola mundo desde " + threadName;
    }
    public void run(){
        Random r = new Random();
        System.out.println(message);
        int timeToSleep = r.nextInt(1000);
        try{
            this.sleep(timeToSleep);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    {
        System.out.println(message);
    }
    public void sleep(int millis)throws InterruptedException{
        Thread.sleep(millis);
    }
    public static void main(String args[]){
        MiThread h1 = new MiThread( "h1");
        MiThread h2 = new MiThread( "h2");
        MiThread[] h = new MiThread[10];
        for (int i = 0; i<h.length; i++){
            h[i]=new MiThread("h" + i);
            h[i].start();
        }

    h1.start();
        try{
            h1.sleep(500);
        }catch(InterruptedException iex){
            iex.printStackTrace();
        }
        h2.start();

    }
}
