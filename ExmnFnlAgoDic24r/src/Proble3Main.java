import ADTsException.ADTsException;
import Sets.*;
/**
 * @author EDg2
 */
public class Proble3Main {

    public static void main(String[] args) {        
        System.out.println("Carmen Sofía Delgado Escobar 208655\n");
        
        // Prueba 1: "frase" que contiene todas las letras del abecedario
        String frase1= "klmno uvwxyz abcde fghij pqrst";
        boolean b1= esAbecegrama( frase1 );
        System.out.println( "Frase1: " + frase1 + "   esAbecegrama? " + b1 + "\n" );

        // Prueba 2: "frase" que no contiene todas las letras del abecedario
        String frase2= "hola que tal como estan";
        boolean b2= esAbecegrama( frase2 );
        System.out.println( "Frase2: " + frase2 + "   esAbecegrama? " + b2);
        
        System.out.println("\n-- HASTA LUEGO 3. --\n");  
    }
    
    

    
    /* Problema 1: programar el metodo esAbecegrama de manera recursiva,
       así como los demas metodos recursivos que emplee aquí.
    */
    public static boolean esAbecegrama( String frase ){
        if(frase==null){
            throw new ADTsException("esAbecegrama: la frase ");
        }
        return esAbecegramaRv(frase.toLowerCase(), "abcdefghijklmnopqrstuvwxyz");
    }
  
    
    // Metodos auxiliares si los necesita...
    private static boolean esAbecegramaRv(String frase, String alfabeto) {
        boolean es;
        if(alfabeto.isEmpty()) { //Caso base
            es=true;
        }
        
        if(frase.isEmpty()) { //Caso base
            es=false;
        }
        
        char letra= frase.charAt(0);
        
        if(alfabeto.indexOf(letra) !=-1) {
            alfabeto= alfabeto.substring(0, alfabeto.indexOf(letra)) + alfabeto.substring(alfabeto.indexOf(letra)+1);
        }
        return esAbecegramaRv(frase.substring(1), alfabeto);
    }
    
}