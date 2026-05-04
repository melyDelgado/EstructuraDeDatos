/**
 * <pre>
 * Clase pilaADT
 * 
 * Interfaz que define las operaciones básicas de una pila genérica.
 * </pre>
 * @version 1.0
 * @author Ana Sofía Conde Islas, Carmen Sofía Delgado Escobar, Maria Alejandra Galicia Almaraz, Leonardo García Bernal, Alejandro Salas Aguilar y Jimena San Germán Elizondo
 * @param <T> Tipo de elementos que contendrá la pila.
 */
public interface PilaADT <T>{
    

    /**
     * Inserta un nuevo elemento en la pila.
     * @param dato El elemento a insertar en la pila.
     */
    public void push(T dato);

    /**
     * Elimina y devuelve el elemento en la cima de la pila.
     * @return El elemento en la cima de la pila.
     */
    public T pop();

    /**
     * Verifica si la pila está vacía.
     * @return <ul>
     * <li>True: Si la pila está vacía.</li>
     * <li>False: Si la pila no está vacía.</li>
     * </ul>
     */
    public boolean isEmpty();

    /**
     * Devuelve el elemento en la cima de la pila sin eliminarlo.
     * @return El elemento en la cima de la pila.
     */
    public T peek();

    /**
     * <pre>
     * Elimina un número de elementos, especificado en el parámetro, de la pila 
     * comenzando desde la cima.
     * </pre>
     * @param n El número de elementos a eliminar.
     */
    public void multiPop(int n);

    /**
     * Compara esta pila con otro objeto para verificar si son iguales.
     * @param obj El objeto a comparar con esta pila.
     * @return <ul>
     * <li>True: Si el objeto es igual a esta pila.</li>
     * <li>False: En caso contrario.</li>
     * </ul>
     */
    public boolean equals(Object obj);
    
}
