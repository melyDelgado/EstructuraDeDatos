
import ADTsException.ADTsException;
import Queues.*;

public class Proble1Main {

    public static void main(String[] args) {

        System.out.println("Carmen Sofía Delgado Escobar 208655\n");

        CArrayQueue<Double> qd = new CArrayQueue();
        qd.enqueue(10.0);    qd.enqueue(-30.0);
        qd.enqueue(50.0);    qd.enqueue(234.0);
        qd.enqueue(8.0);
        
        System.out.println("Cola Double inicial: \n" + qd.toString());
        cada2sCola(qd);
        System.out.println("Cola Double modificada: \n" + qd.toString());
        
        CArrayQueue<String> qs = new CArrayQueue();
        qs.enqueue("Uno");    qs.enqueue("Alfa");
        qs.enqueue("Ocho");    qs.enqueue("Delta");
        qs.enqueue("Tres");
        
        System.out.println("Cola String inicial: \n" + qs.toString());
        cada2sCola(qs);
        System.out.println("Cola String modificada: \n" + qs.toString());
        
        CArrayQueue<Integer> qa = new CArrayQueue();
        qa.enqueue(1);    qa.enqueue(2);
        qa.enqueue(3);    qa.enqueue(4);
        
        System.out.println("Cola Integer inicial: \n" + qa.toString());
        cada2sCola(qa);
        System.out.println("Cola Integer modificada: \n" + qa.toString());
        
        CArrayQueue<String> qt = new CArrayQueue();
        qt.enqueue("Hola");   
        
        System.out.println("Cola String>2 inicial: \n" + qt.toString());
        cada2sCola(qt);
        System.out.println("Cola String>2 modificada: \n" + qt.toString());
        
        CArrayQueue<String> qk = new CArrayQueue();
        qk=null;
        
        System.out.println("Cola Null inicial: \n" + qk.toString());
        cada2sCola(qk);
        System.out.println("Cola Null modificada: \n" + qk.toString());
        
        
        CArrayQueue<String> qz = new CArrayQueue();
        
        System.out.println("Cola Vacía inicial: \n" + qz.toString());
        cada2sCola(qz);
        System.out.println("Cola Vacía modificada: \n" + qz.toString());
        
    }

    public static <T> void cada2sCola(CArrayQueue<T> cola) {
        if (cola == null || cola.isEmpty()) {
            throw new ADTsException("cada2sCola: La cola está vacía o es nula");
        }

        if(cola.size()<2) {

        for (int i = 0; i < cola.size() / 2; i++) {
            T primero = cola.dequeue();
            T segundo = cola.dequeue();

            if ((primero instanceof String || primero instanceof Double) &&
                (segundo instanceof String || segundo instanceof Double)) {
                cola.enqueue(segundo);
                cola.enqueue(primero);
            }
        }
        if (cola.size() % 2 != 0) {
            cola.enqueue(cola.dequeue());
        }
        }
    }
        
}
