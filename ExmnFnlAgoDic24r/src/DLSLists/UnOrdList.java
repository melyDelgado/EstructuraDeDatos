package DLSLists;

import java.util.Iterator;    // Iterator
import ADTsException.*;

/*
Represents a doubly linked implementation of a list. 
The front of the list is kept by "head" and the rear by "tail". 
It uses two sentinel nodes and will be extended to create concrete lists.
*/
public class UnOrdList<T> implements Iterable<T>
{    
    private LnrDblNd<T> head,tail;
    private int count;

    public UnOrdList() {
        head = new LnrDblNd<T>();    // head sentinel node
        tail = new LnrDblNd<T>();    // tail sentinel node
        tail.setPrevious(head);
        head.setNext(tail);
        count = 0;    }
 
    /**
     * Adds the specified element to the front/head of this structure.
    */
    public void addFirst(T elem){
        if (elem==null) throw new ADTsException ("DblyLnkSctr addFirst(): null element");
        
        LnrDblNd<T> newnd= new LnrDblNd<T>();
        newnd.setElement(elem);    // Node with element inside    
        addNd(head, head.getNext(), newnd);    // count could be >=0
    }    
 
    // Adding node adnd, coming with element inside.
    private void addNd(LnrDblNd<T> prv, LnrDblNd<T> nxt, LnrDblNd<T> adnd) {        
        adnd.setNext(nxt);
        adnd.setPrevious(prv);
        
        prv.setNext(adnd);
        nxt.setPrevious(adnd);
        count++;
    }    

     /**
     * Adds the specified element to the rear of this list.
     */
    public void addLast(T elem) {
        if (elem==null) throw new ADTsException ("DblyLnkSctr addLast(): null element");
        
        LnrDblNd<T> newnd= new LnrDblNd<T>();
        newnd.setElement(elem);    // Node with element inside          
        addNd(tail.getPrevious(), tail, newnd);    // count could be >=0
    }
    
    public T first() throws ADTsException {
        if (isEmpty()) throw new ADTsException ("DblyLnkSctr first(): structure is Empty"); 
        
        LnrDblNd<T> first = head.getNext();
        return first.getElement();
    }

    public T last() throws ADTsException {
        if (isEmpty()) throw new ADTsException ("DblyLnkSctr first(): structure is Empty"); 

        LnrDblNd<T> last = tail.getPrevious();
        return last.getElement();
    }
    
    public T removeFirst() throws ADTsException {
        if (isEmpty()) throw new ADTsException ("DblyLnkSctr removeFirst(): structure is Empty"); 

        T result = first();
        removeNd(head.getNext());
        return result;
    }

    // Unlink node ndelm, keeping inside the references to the element, the
    //    the next, and the previous.
    private void removeNd(LnrDblNd<T> ndelm) {
        LnrDblNd<T> prv, nxt;   
        prv = ndelm.getPrevious();       
        nxt = ndelm.getNext();
        
        prv.setNext(nxt); 
        nxt.setPrevious(prv);
        count--;
    }    

    public T removeLast () throws ADTsException {
        if (isEmpty()) throw new
            ADTsException ("DblyLnkSctr removeLast(): structure is Empty"); 

        T result = last();
        removeNd(tail.getPrevious());
        return result;
    }

    /**
     * Encuentra en la dls la primera ocurrencia del elemento.
     * Regresa su nodo, o null si no está en la dls.
     */
    public LnrDblNd<T> find(T elem) {
        int tam= size();
        int i= 1;
        LnrDblNd<T> fnd= null;
        LnrDblNd<T> current= head.getNext();

        while( i<=tam ) {
            if( current.getElement().equals(elem) ) {
                fnd= current;
                i= tam+1;
            }
            current= current.getNext();
            i++;
        }
        return fnd;
    }
        
    public boolean contains (T elem) {
        if (isEmpty()) throw new
            ADTsException ("DblyLnkSctr removeLast(): structure is Empty"); 
        return ( find(elem) != null );
    }

    public Iterator<T> iterator() {
        return new LnrDblNdItrtr<T> (head.getNext(),count);
    }
    
    
    public int size() {
        return count;
    }
   
    public boolean isEmpty() {
        return (count == 0);
    }

    @Override
    public String toString() {
        String result = "{UnOrdList: c" + count + ":";

        if( isEmpty() ) {
            result = result + " EMPTY";
        } else {
            LnrDblNd<T> current = head.getNext();

            while (current.getNext() != null) {
                result = result + ", " + current.getElement().toString();
                current = current.getNext();
            }
        }
        result = result + "}";
        return result;
    }   
    
    public T remove(T elem) {
        if( elem==null ) throw new
            ADTsException("remove(..): elem null.\n");
        
        LnrDblNd<T> ndaux= this.find(elem);
        if( ndaux==null ) throw new
            ADTsException("remove(..): elem does not exist.\n");
        else
            this.removeNd(ndaux);
        
        return elem;
    }

    
    
    //+=+=+=+= EXAMEN FINAL Ago-dic 2024

    
    // Solución del problema 2
    public T eliminaSegundo(){
        T dato;
        
        if (head==null || head.getNext()==null) {
        throw new ADTsException ("eliminaSegundo: Es null o no hay segundo nodo para eliminar");
    }
        dato=head.getElement();
        head.setNext(head.getNext().getNext());
      
        return dato;
    }    
    
    // Solución del problema 2
    /*public void pasaInicio(T dato){
        if(head==null || (head.getElement() != null && head.getElement().equals(dato))) {
            return;
        }
        
        LnrDblNd<T> actual=head;
        LnrDblNd<T> previo =null;
        
        while(actual!= null && (actual.getElement() != null && !actual.getElement().equals(dato))) {
            previo=actual;
            actual= actual.getNext();
    }
        if (actual == null) {
            return;
    }
        if(previo!=null) {
           previo.setNext(actual.getNext());
           actual.setNext(head);
           head=actual;
        }


    }*/
    
    public void pasaInicio(T dato) {
    if (head == null || (head.getElement() != null && head.getElement().equals(dato))) {
        return;
    }
    LnrDblNd<T> actual = head;
    LnrDblNd<T> previo = null;

    while (actual != null) {
        if ((head.getElement() != null && head.getElement().equals(dato))) {
            if (previo != null) {
                previo.setNext(actual.getNext());
                actual.setNext(head);             
                head = actual;                    
            }
            else {
                actual = actual.getNext();
                continue;
            }
        }
        previo = actual;
        actual = actual.getNext();
    }
}


}
