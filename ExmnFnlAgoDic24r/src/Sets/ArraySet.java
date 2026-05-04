/**  
 * ArraySet represents an array implementation of a set.
 */

package Sets;
import java.util.Iterator;
import java.util.Random;
import ADTsException.*;

public class ArraySet<T> implements SetADT<T>, Iterable<T> {
    private static Random rand = new Random();
    private final int DEFAULT_CAPACITY = 100;
    private final int NOT_FOUND = -1;
    private int count;  // the current number of elements in the set collection
    private T[] set; 

    /**
    * Creates an empty set using the default capacity.
    */
    public ArraySet() {
        count = 0;
        set = (T[])(new Object[DEFAULT_CAPACITY]);
    }

    /**
    * Creates an empty set using the specified capacity.
    */
    public ArraySet(int initialCapacity) {
        count = 0;
        set = (T[])(new Object[initialCapacity]);
    }

    /**
    * Adds the specified element to the set if it is not already
    * present. Expands the capacity of the set array if necessary.
    */
    public void add(T element) throws ADTsException {
        if( element==null ) 
            throw new ADTsException("Sets.ArraySet.add(): element null.\n");

        if (!contains(element)) {       //Verifica que no esté el elemento.
            if (count == set.length)
                expandCapacity();           //Si el arreglo está lleno, lo aumenta.

            //Agrega el elemento.
            set[count]= element;
            count++;
        }
    }

    /**
    * Adds the contents of otherSet to this set.
    */
    public void addAll(SetADT<T> oSet) throws ADTsException {
        if( oSet==null ) 
            throw new ADTsException("Sets.ArraySet.addAll(): oSet null.\n");

        Iterator<T> iter= oSet.iterator();
        T element;

        while (iter.hasNext()) {
            element = iter.next();
            this.add(element);
        }
    }

    /**
    * Removes a random element from the set and returns it. Throws
    * an EmptyCollectionException if the set is empty.
    */
    public T removeRandom() throws ADTsException {
        T result = null;
        int index;

        if (isEmpty())
            throw new ADTsException("Sets.ArraySet.removeRandom(): Empty Set.\n");

        // Generates a random integer between [0,count-1].
        index = rand.nextInt(count);

        // Recovers the selected element.
        result= set[index];

        // Moves the last element to the place of the removed element.
        set[index]= set[count-1];
        set[count-1]= null;
        count--;

        return result;
    }

    /**
    * Removes the specified element from the set and returns it.
    * Throws an EmptyCollectionException if the set is empty and a
    * ElementNotFoundException if the element is not in the set.
    */
    public T remove (T element) throws ADTsException {
        if( element==null ) 
            throw new ADTsException("Sets.ArraySet.remove(): element null.\n");

        boolean found = false;   // Not found
        int index;

        if (isEmpty())
            throw new ADTsException("Sets.ArraySet.remove(): Empty Set.\n");

        // Look for the elemente inside this set.
        index = 0;
        while ( index<count && !found ) {
            found = set[index].equals(element);
            index++;      
        }

        // Was it found
        if ( !found )
            throw new ADTsException("Sets.ArraySet.remove(): Element Not Found.\n");   //No.

        //If it was found, recovers the element and erases from this set.
        T result= set[index-1];
        set[index-1]= set[count-1];
        set[count-1]= null;
        count--;

        return result;
    }

    /**
    * Returns a new set that is the union of this set and
    * otherSet.
    */
    public SetADT<T> union (SetADT<T> oSet) throws ADTsException {
        if( oSet==null ) throw new
                ADTsException("Sets.ArraySet.union(): oSet null.\n");

        ArraySet<T> result= new ArraySet<T>();    // Resultant set

        // Add all elements of this to result
        Iterator<T> iter= this.iterator();
        T element;
        while ( iter.hasNext() ) {
            element = iter.next();
            result.add(element);
        }

        // Add all elements of oSet to result
        iter= oSet.iterator();
        while( iter.hasNext() ) {
            element = iter.next();
            result.add(element);
        }
        /*    
        result.addAll(this);
        result.addAll(oSet);
        */  
        return result;
    }

  

    /** Returns the intersection of this set and the otherSet.
    */
    public SetADT<T> intersection(SetADT<T> oSet) throws ADTsException {
        if( oSet==null ) 
            throw new ADTsException("Sets.ArraySet.intersection(): oSet null.\n");

        ArraySet<T> result= new ArraySet<T>();
        //TO-DO
        Iterator<T> iter= this.iterator();
        T element;

        while (iter.hasNext()) {
            element= iter.next();
            if ( oSet.contains(element) )
                result.add(element);
        }

        return result;
    }


  
    /** Returns the difference of this set and the otherSet.
    */
    public SetADT<T> difference(SetADT<T> oSet) throws ADTsException {
        if( oSet==null ) 
            throw new ADTsException("Sets.ArraySet.difference(): oSet null.\n");

        ArraySet<T> result= new ArraySet<T>();
        //TO-DO
        Iterator<T> iter = this.iterator();
        T element;

        while (iter.hasNext()) {
            element = iter.next();
            if ( !oSet.contains(element) )
                result.add(element);
        }

        return result;    
    }



      
    /**
    * Returns true if this set contains the specified element.
    */
    public boolean contains (T element) throws ADTsException {
        if( element==null ) 
            throw new ADTsException("Sets.ArraySet.contains(): element null.\n");

        boolean found = false;  //Not found
        int index;

        index = 0;
        while (index<count && !found) {
            found = set[index].equals(element);
            index++;
        }

        return found;
    }

    /**
    * Returns true if this set contains exactly the same elements
    * as the otherSet.
    */
    public boolean equals (SetADT<T> oSet) throws ADTsException {
        if( oSet==null ) 
            throw new ADTsException("Sets.ArraySet.equals(): oSet null.\n");

        boolean identical= false;
        ArraySet<T> thisSet= new ArraySet<T>();
        T elem;
        
        // Primera condicion para ser equals, misma cantidad de elementos.
        if ( this.size() == oSet.size() )  {
            thisSet.addAll(this);    // copia de this        
            Iterator<T> oIter= oSet.iterator();    // foto de oSet
            while ( oIter.hasNext() ) {
                elem= oIter.next();   
                if ( thisSet.contains(elem) ) {
                    thisSet.remove(elem);
                }
            }
            identical = thisSet.isEmpty();
        }
        return identical;  
    }

    /**
    * Returns true if this set is empty and false otherwise.
    */
    public boolean isEmpty() {
        return (count == 0);
    }

    /**
    * Returns the number of elements currently in this set.
    */
    public int size() {
        return count;
    }

    /**
    * Returns an iterator for the elements currently in this set.
    */
    public Iterator<T> iterator() {
        return new ArrayIterator<T>(set,count);
    }

    /**
    * Returns a string representation of this set.
    */
    public String toString() {
        String result = "ArraySet(toString) is EMPTY.";
        if( !isEmpty() ) {
            result = "SET{#" + count + "/" + set.length + ":: ";
            for (int index=0; index < count; index++) {
                result = result + set[index].toString() + ", ";
            }
            result = result + "}";
        }        
        return result;
    }

    /**
    * Creates a new array to store the contents of the set with
    * twice the capacity of the old one.
    */
    private void expandCapacity() {
        T[] larger = (T[])(new Object[set.length*2]);

        for (int index = 0; index < set.length; index++)
            larger[index] = set[index];

        set = larger;
    }
        
    // MORE

}

