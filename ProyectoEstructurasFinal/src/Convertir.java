import java.util.ArrayList;
/**
 * <pre>
 * Clase Convertidor
 * 
 * La clase Convertir proporciona métodos para convertir una expresión 
 * matemática en notación infija a notación posfija. También incluye un 
 * método privado para determinar la jerarquía de las operaciones.
 * </pre>
 * @version 1.0
 * @author Ana Sofía Conde Islas, Carmen Sofía Delgado Escobar, Maria Alejandra Galicia Almaraz, Leonargo García Bernal, Alejandro Salas Aguilar y Jimena San German Elizondo
 */
public class Convertir {
    
    /**
     * Constructor vacío de la clase convertir.
     */
    public Convertir() {

    }
        
    /**
     * <pre>
     * Determina la jerarquía de una operación específica en una expresión matemática 
     * y asigna un nivel de jerarquía a cada operación aritmética basado en su tipo.
     * </pre>
     * <ul>
     * <li>Las operaciones de multiplicación (*) y división (/) tienen un nivel de jerarquía 2.</li>
     * <li>Las operaciones de suma (+) y resta (-) tienen un nivel de jerarquía 1.</li>
     * <li>La operación de potenciación (^) tiene el nivel de jerarquía más alto, 3.</li>
     * <li>Para cualquier otro carácter, el nivel de jerarquía se establece en -1.</li>
     * </ul>
     * @param chr Recibe un caractér cualquiera.
     * @return Regresa la jerarquía del orden de ejecución de operadores aritméticos
     * por convención si el peramétro es un operador,sino es operador regresa -1.
     */
    private static int JerarquiaOperaciones(char chr) {
        byte var;
        switch (chr) {
            case '*':
            case '/':
                var = 2;
                break;
            case '+':
            case '-':
                var = 1;
                break;
            case '^':
                var = 3;
                break;
            default:
                var = -1;

        }
        return var;
    }
        
    /**
    * <pre>
    * Convierte una expresión matemática en notación infija a notación posfija. 
    * El algoritmo funciona iterando sobre cada carácter de la expresión de entrada 
    * y procesándolos según las reglas de la notación posfija:
    * </pre>
    * <ul>
    * <li>Los operandos se agregan directamente a la salida.</li>
    * <li>Los operadores se colocan en una pila temporal, con ciertas reglas de precedencia.</li>
    * <li>Los paréntesis se utilizan para agrupar operaciones y controlar el orden de evaluación.</li>
    * </ul>
    * 
    * @param str Recibe la cadena de caracteres que contiene la operación aritmética que se quiere
    * convertir a postfia.
    * @return Regresa un ArrayList de los caracteres individuales del String dado como parámetro ordenados
    * en forma posfija.
    */
    public static ArrayList<String> Convertir(String str) {
        ArrayList<String> arrayList = new ArrayList();
        ArregloPila<Character> pila = new ArregloPila();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                String aux;
                if (str.charAt(i) == '-' && (i == 0 || str.charAt(i - 1) == '(')) {
                    // Si hay un '-' al principio o después de '('
                    aux = new String("");
                    aux = aux + str.charAt(i);
                    i++;

                    while (i < str.length() && (Character.isLetterOrDigit(str.charAt(i)) || str.charAt(i) == '.')) {
                        aux = aux + str.charAt(i);
                        i++;
                    }
                    arrayList.add(aux);
                    i--;
                } else if (Character.isLetterOrDigit(str.charAt(i))) {
                    for (aux = new String(""); i < str.length() && (Character.isLetterOrDigit(str.charAt(i)) || str.charAt(i) == '.'); i++) {
                        aux = aux + str.charAt(i);
                    }

                    if (i < str.length() && str.charAt(i) == '%') {
                        aux = Double.toString(Double.parseDouble(aux) / 100.0);
                        i++;
                    }

                    arrayList.add(aux);
                    i--;
                } else if (i - 1 >= 0 && Character.isLetterOrDigit(str.charAt(i - 1)) && str.charAt(i) == '(') {
                    pila.push('*');
                    pila.push('(');
                } else if (str.charAt(i) == '(') {
                    pila.push(str.charAt(i));
                } else if (str.charAt(i) == ')') {
                    while (!pila.isEmpty() && (Character) pila.peek() != '(') {
                        arrayList.add("" + pila.pop());
                    }

                    pila.pop();
                } else {
                    while (!pila.isEmpty() && JerarquiaOperaciones(str.charAt(i)) <= JerarquiaOperaciones((Character) pila.peek())) {
                        arrayList.add("" + pila.pop());
                    }

                    pila.push(str.charAt(i));
                }
            }
        }
        while (!pila.isEmpty()) {
            arrayList.add("" + pila.pop());
        }
        return arrayList;
    }
}
