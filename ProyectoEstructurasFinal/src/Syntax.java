
/**
 * <pre>
 * Clase Syntax
 * 
 * Clase para verificar la sintaxis de una expresión matemática en formato de cadena.
 * Permite determinar si la expresión cumple con ciertas reglas de sintaxis requeridas 
 * para ser evaluada correctamente.
 * </pre>
 * @version 1.0
 * @author Ana Sofía Conde Islas, Carmen Sofía Delgado Escobar, Maria Alejandra Galicia Almaraz, Leonargo García Bernal, Alejandro Salas Aguilar y Jimena San German Elizondo
 */
public class Syntax {

    /**
     * Constructor vacío de la clase.
     */
    public Syntax(){
        
    }
         
     /**
      * Verifica si una cadena puede ser convertida a un número double.
      * @param str La cadena a analizar.
      * @return <ul>
      * <li>True: Si la cadena puede ser convertida a un número double.</li>
      * <li>False: En caso contrario.</li>
      * </ul>
      */
    private static boolean analizandoNumero(String str){
        if(str==null)
            return false;
        else{
            try{
                double var=Double.parseDouble(str);
                return true;
            } catch(NumberFormatException var1){
                return false;
            }
        }
    }
    
    /**
     * <pre>
     * Verifica si un carácter es un comando válido en una expresión matemática.
     * Los comandos válidos incluyen operadores matemáticos, dígitos y caracteres 
     * especiales como paréntesis y punto decimal. Debido a que es una calculadora
     * sencilla, con funcionalidad básica, se asume que no se utilizan funciones
     * trigonométricas.
     * </pre>
     * @param chr El carácter a analizar.
     * @return <ul>
     * <li>True: Si el carácter es un comando válido.</li>
     * <li>False: En caso contrario.</li>
     * </ul>
     */
    private static boolean Comandos(char chr){
        boolean variable;
        switch(chr){
          
            case '%':
            case '(':
            case ')':
            case '*':
            case '+':
            case '-':
            case '.':
            case '/':
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            case '^':
                variable=true;
                break;
        //Como es una calculadora sencilla se asume que no se usaran funciones 
        //del tipo sin, cos o semejantes. Solo hara las funcionalidades básicas(por ahora)
            case '&':
            case '\'':
            case ',':
            case ':':
            case ';':
            case '<':
            case '=':
            case '>':
            case '?':
            case '@':
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
            case 'G':
            case 'H':
            case 'I':
            case 'J':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
            default:
                variable=false;
        }
        return variable;
    }
        
    /**
     * Verifica si una cadena representa una operación matemática válida.
     * @param str La cadena a analizar.
     * @return <ul>
     * <li>True: Si la cadena representa una operación matemática válida.</li>
     * <li>False: En caso contrario.</li>
     * </ul>
     */
    private static boolean operacionValida(String str){
        boolean num=false;
        boolean operador=false;
        boolean nom=false;
        
        for(int i=0; !nom && i<str.length();i++){
            char bol=str.charAt(i);
            if(Character.isDigit(bol)){
                if(num && operador){
                    nom=true;
                }else{
                    num=true;
                }
            } else if (bol=='+'|| bol=='-'|| bol=='*'|| bol=='/'|| bol=='^'|| bol=='(')
                operador=true;
        }
        return num && operador && nom;
    }

    /**
     * Verifica la sintaxis de una expresión matemática dada.
     * @param str La expresión matemática a analizar.
     * @return <ul>
     * <li>True: Si la expresión es sintácticamente válida.</li>
     * <li>False: En caso contrario.</li>
     * </ul>
     */
    public static boolean Syntax(String str){
        ArregloPila<Character> pila= new ArregloPila();
        boolean resp=true;
        if(str.length()>0){
            if(!analizandoNumero(str)){
                int i=0;
                boolean operador=false;
                
                for (boolean point=false; resp && i<str.length();i++){
                    if (str.charAt(i)!= ' '){
                        resp=Comandos(str.charAt(i));
                        if (Character.compare(str.charAt(i),'(')==0){
                            pila.push(str.charAt(i));
                        }
                        if (Character.compare(str.charAt(i), ')')==0){
                            if(!pila.isEmpty()){ 
                                pila.pop();
                            }else{
                                resp=false;
                            }
                        }
                        
                        if(str.charAt(i)!='+'&& str.charAt(i)!='-' && str.charAt(i)!='*'&& str.charAt(i)!='/' && str.charAt(i)!='^'){
                            operador=false;
                        } else if(operador){
                            resp=false;
                        } else{
                            operador=true; 
                        }
                        
                        if (str.charAt(i)=='%'){
                            if(i-1>=0 && !Character.isDigit(str.charAt(i-1))){
                                resp=false;
                            }
                            if(i+1<str.length() && Character.isDigit(str.charAt(i+1))){
                                resp=false;
                            }
                            
                        }
                        
                        if(!Character.isDigit(str.charAt(i))&& str.charAt(i)!='.'){
                            point= false;
                        } else if(str.charAt(i)=='.'){
                            if(point){
                                resp=false;
                            }else{
                                point=true; 
                            }
                        }
                        
                        if (i+1<str.length()&& str.charAt(i)=='('&& str.charAt(i+1)==')'){
                            resp=false;
                        }

                    }
                    
                    
                }
                if(!pila.isEmpty()){
                            resp=false;
                        }
                if(resp){
                    resp=operacionValida(str);
                }
                
            }
        } else{
            resp=false;
        }
        return resp;
        
    }
    
    
}
