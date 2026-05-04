/**
 * ArrayIterator represents an iterator over the elements of an array.
 */

package Sets;
import java.util.Iterator;
import ADTsException.*;

public class ArrayIterator<T> implements Iterator<T> {
  private int count;    // the number of elements in the set collection
  private int current;  // the current position in the iteration
  private T[] items;    // elements
  
  /**
   * Sets up this iterator using the specified items.
   */
  public ArrayIterator (T[] collection, int size) {
    items = collection;
    count = size;
    current = 0;
  }
  
  /**
   * Returns true if this iterator has at least one more element
   * to deliver in the iteration.
   */
  public boolean hasNext() {
    return (current < count);
  }
  
  /**
   * Returns the next element in the iteration. If there are no
   * more elements in this iteration, a NoSuchElementException is
   * thrown.
   */
  public T next() throws ADTsException {
    T result= null;
    
    if (!hasNext())
      throw new ADTsException("Sets.ArrayIterator.next(): ElementNotFound.\n");
    
    result= items[current];
    current++;

    return result;
  }
  
  /**
   * The remove operation is not supported in this collection.
   */
  public void remove() throws ADTsException {
    throw new ADTsException("Sets.ArrayIterator.remove(): UnsupportedOperation");
  }
}
