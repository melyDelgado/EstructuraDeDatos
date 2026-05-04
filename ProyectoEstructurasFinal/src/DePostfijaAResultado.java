
import java.util.ArrayList;


/**
 * <pre>
 * Clase DePostfijaAResultado
 * 
 * La clase DePostfijaAResultado proporciona métodos para evaluar una expresión 
 * matemática en notación postfija y obtener su resultado.
 * </pre>
 * @version 1.0
 * @author Ana Sofía Conde Islas, Carmen Sofía Delgado Escobar, Maria Alejandra Galicia Almaraz, Leonargo García Bernal, Alejandro Salas Aguilar y Jimena San German Elizondo
 */
public class DePostfijaAResultado {
        
    /**
     *Constructor vacío de la clase.
     */
    public DePostfijaAResultado(){
    }
    
    /**
     * <pre>
     * Realiza operaciones aritméticas basadas en el operador proporcionado y 
     * regresa el resultado en forma de cadena. 
     * Los operadores válidos incluyen suma (+), resta (-), multiplicación (*), 
     * división (/) y potencia (^).
     * </pre>
     * @param operador El operador aritmético.
     * @param num1 Primer número de la operación.
     * @param num2 Segundo número de la operación.
     * @return Una cadena que representa el resultado de la operación. 
     */
    private static String resuelveOperadores(String operador, String num1, String num2) {
      double d = 0;
      switch (operador) {
         case "*":
            d = Double.parseDouble(num1)*Double.parseDouble(num2);
            break;
         case "/":
            d = Double.parseDouble(num1)/Double.parseDouble(num2);
            break;
         case "^":
            d = Math.pow(Double.parseDouble(num1),Double.parseDouble(num2));
            break;
         case "+":
            d = Double.parseDouble(num1)+Double.parseDouble(num2);
            break;
         case "-":
            d = Double.parseDouble(num1)-Double.parseDouble(num2);
            break;
      }

      return Double.toString(d); //convierte el doble a cadena
   }//end resuelveOperadores
    
        
    /**
     * <pre>
     * Verifica si una cadena es un número válido. Para determinar si la cadena 
     * es un número válido, el método intenta convertir la cadena a un valor double.
     * </pre>
     * @param cadena Cadena a verificar.
     * @return <ul>
     * <li>True: Si la cadena es un número válido.</li>
     * <li>False: Si la cadena no es un número válido.</li>
     * </ul>
     */
    public static boolean esUnNumero(String cadena) {
        if (cadena==null || cadena.isEmpty()) // si está vacia
            return false;
        else{
            try{
                double cadenaADoble= Double.parseDouble(cadena); //trata de convertyir la cadena a double
                return true;
            }
            catch (NumberFormatException ex) { //NumberFormatException: excepcion en java cuando se intenta convertir de string a numero
            return false;
        }
        }
    }//end esUnNumero

    /**
     * <pre>
     * Convierte una expresión en notación infija a notación postfija y la evalúa 
     * para obtener el resultado.
     * La expresión debe estar en formato válido y contener operadores y operandos 
     * separados por espacios. Si la expresión contiene errores de sintaxis o no 
     * puede ser evaluada correctamente, se devolverá un mensaje de error.
     * En este método usamos métodos de la clase Syntax.
     * </pre>
     * @param expresion La expresión en notación infija a convertir y evaluar.
     * @return <ul>
     * <li>Una cadena que representa el resultado de la expresión.</li>
     * <li>"Error de sintaxis": si la expresión es incorrecta.</li>
     * <li>"Error: Expresión incorrecta": Indica que la expresión no se pudo evaluar 
     * correctamente debido a una falta de operandos o algún otro problema. </li>
     * <li>"Error: No se puede dividir entre cero."</li>
     * </ul>
     * @see Syntax
     */
    public String dePostfijaAResultado(String expresion) {
        ArregloPila<String> pila= new ArregloPila();
        String resultado = "";

        // 1) Verificar validez de la expresión
        if (Syntax.Syntax(expresion)) {
            
            // 2) Convertir a notación postfija
            if(!esUnNumero(expresion)){
                ArrayList<String> arrayList= Convertir.Convertir(expresion);
                // 3) Evaluar la expresión en notación postfija
                for (int i = 0; i < arrayList.size(); i++) {
                    String elemento = (String)arrayList.get(i);
                    if (esUnNumero(elemento)){
                        pila.push(elemento);
                    } else {
                        if (pila.isEmpty()) 
                            return "Error: Expresión incorrecta";
                        String num2 = pila.pop();
                        // Verificar de nuevo si hay suficientes operandos en la pila
                        if (pila.isEmpty()) 
                            return "Error: Expresión incorrecta";
                        String num1 = pila.pop();
                        // Realizar la operación y agregar el resultado a la pila
                        if ("/".equals(elemento) && Double.parseDouble(num2) == 0.0) 
                            return "Error: No se puede dividir entre cero";
                        else
                            pila.push(resuelveOperadores(elemento, num1, num2));
                    } 
                }
            }
            // Verificar si hay un solo resultado en la pila al final
            if (pila.isEmpty()) 
                return "Error: Expresión incorrecta";
            else 
                resultado = pila.peek();
        } else 
            return "Error de sintaxis";
        

        return resultado;
    }
      
}
    
    
