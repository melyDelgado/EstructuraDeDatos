/**
 * <pre>
 * Clase ArregloPila
 * 
 * La clase ArregloPila implementa la interfaz PilaADT y representa una pila implementada mediante un arreglo de tipo genérico. Esta clase proporciona 
 * operaciones para agregar, remover y acceder a elementos en la pila.
 * </pre>
 * @version 1.0
 * @author Ana Sofía Conde Islas, Carmen Sofía Delgado Escobar, Maria Alejandra Galicia Almaraz, Leonardo García Bernal, Alejandro Salas Aguilar y Jimena San Germán Elizondo
 * @param <T> Tipo de elementos que puede recibir la pila.
 * @see PilaADT
 */
public class ArregloPila <T> implements PilaADT<T>{
    private T[] stack;
    private int top;
    private final int MAX = 20;

    /**
     * <pre>
     * Constructor que crea una pila de tamaño MAX, inicializada en 20 en los 
     * atributos. Inicializa la pila como un arreglo vacío y establece el índice 
     * de la cima en -1.
     * </pre>
     * @see #MAX
     */
    public ArregloPila() {
        stack = (T[]) new Object[MAX];
        top = -1;
    }

    /**
     * <pre>
     * Constructor que inicializa una pila de tamaño max, dado en el parámetro. 
     * Inicializa la pila como un arreglo vacío y establece el índice de la cima 
     * en -1.
     * </pre>
     * @param max Tamaño máximo de la pila.
     */
    public ArregloPila(int max) {
        stack = (T[]) new Object[max];
        top = -1;
    }
    
    /**
     * Compara esta pila con otro objeto.
     * @param obj Objeto a comparar.
     * @return <ul>
     * <li>True: Si el objeto es igual a esta pila.</li>
     * <li>False: En caso contrario.</li>
     * </ul>
     */
    public boolean equals(Object obj) {
        boolean resp = false;

        if (obj != null && this.getClass() == obj.getClass()) {
            if (this == obj)
                resp = true;

            else if (this.top == ((ArregloPila<?>) obj).top) {
                int i = 0;
                resp = true;

                while (resp && i < this.top) {
                    if (this.stack[i] != ((ArregloPila<?>) obj).stack[i])
                        resp = false;
                    i++;
                }
            }
        }

        return resp;
    }

    /**
     * Devuelve una representación en cadena de la pila.
     * @return una cadena representando la pila.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = stack.length - 1; i >= 0; i--) {
            if (stack[i] != null)
                sb.append(stack[i] + " <-- ");
        }
        sb.append("Null");

        return sb.toString();
    }
    
    /**
     * <pre>
     * Inserta un nuevo elemento, dado en el parámetro, en la cima de la pila. 
     * Si la pila está llena, se expande automáticamente su capacidad para 
     * permitir más elementos. Después de insertar el elemento, la cima de la 
     * pila se actualiza para señalar al nuevo elemento agregado.
     * </pre>
     * @param data El elemento a insertar, es de tipo genérico ya que la pila solo puede recibir genéricos.
     */
    public void push(T data) {
        if (top == stack.length - 1)
            expand();

        top++;
        stack[top] = data;
    }
    
    /**
     * <pre>
     * Expande el tamaño del arreglo de la pila al doble de su tamaño actual, 
     * copia los elementos del arreglo original al nuevo arreglo expandido y 
     * actualiza la referencia del arreglo original al nuevo arreglo expandido.
     * </pre>
     */
    private void expand() {
        T[] newStack = (T[]) new Object[stack.length * 2];

        for (int i = 0; i < stack.length; i++)
            newStack[i] = stack[i];

        stack = newStack;
    }

    /**
     * Elimina y devuelve el elemento en la cima de la pila, disminuyendo su
     * tamaño.
     * @return <ul>
     * <li>El elemento eliminado de la pila: si la pila no está vacía.</li>
     * <li>Null: Si la pila está vacía.</li>
     * </ul>
     */
    public T pop() {
        if (!(isEmpty())) {
            T resp = stack[top];
            stack[top] = null;
            top--;
            return resp;
        }
        return null;
    }

    
    /**
     * Verifica si la pila esta vacía.
     * @return <ul>
     * <li>True: si la pila está vacía.</li>
     * <li>False: Si la pila no está vacía.</li>
     * </ul>
     */
    public boolean isEmpty() {
        return top == -1;
    }
    
    /**
     * Devuelve el elemento en la cima de la pila sin eliminarlo.
     * @return <ul>
     * <li>El elemento en la cima de la pila: si la pila no está vacía.</li>
     * <li>Null: Si la pila está vacía.</li>
     * </ul>
     */
    public T peek() {
        if (!(isEmpty()))
            return stack[top];
        return null;
    }

    /**
     * <pre>
     * Elimina el número de elementos, dado en el parámetro, de la pilacomenzando 
     * en la cima. Si el número de elementos a eliminar es mayor que el tamaño 
     * actual de la pila, no se realiza ninguna operación.
     * </pre>
     * @param n número de elementos a eliminar.
     */
    public void multiPop(int n) {
        int i = 0;

        if (top >= n) {
            while (!(isEmpty()) && i < n) {
                pop();
                i++;
            }
        }
    }
}
