import DLSLists.*;

public class Proble2Main {
    // Solucion al problema 2.

    public static void main(String[] args) {

        System.out.println("Carmen Sofía Delgado Escobar 208655\n");
        
        // Parte A), pruebas del metodo
        System.out.println("---- pasaInicio ----");
        UnOrdList<Integer> listA1= new UnOrdList<Integer>();
        listA1.addLast(6);    listA1.addLast(7);
        System.out.println( "Estado INICIAL de listA1: " + listA1.toString() );
        listA1.pasaInicio(7);
        System.out.println( "Estado FINAL de listA1: " + listA1.toString() );
        
        //Otra prueba String
        System.out.println("---- pasaInicio ----");
        UnOrdList<String> listA2= new UnOrdList<String>();
        listA2.addLast("hola");    listA2.addLast("adiós");
        listA2.addLast("días");
        
        System.out.println( "Estado INICIAL de listA2: " + listA2.toString() );
        listA2.pasaInicio("días");
        System.out.println( "Estado FINAL de listA2: " + listA2.toString() );
        
        //Otra prueba Null
        System.out.println("---- pasaInicio ----");
        UnOrdList<String> listA3= new UnOrdList<String>();
        
        System.out.println( "Estado INICIAL de listA3: " + listA3.toString() );
        listA3.pasaInicio("días");
        System.out.println( "Estado FINAL de listA3: " + listA3.toString() );
        
        
        //Otra prueba donde ya está al inicio
        System.out.println("---- pasaInicio ----");
        UnOrdList<String> listA4= new UnOrdList<String>();
        listA4.addLast("uno"); listA4.addLast("dos");
        listA4.addLast("tres"); listA4.addLast("cuatro");
        
        System.out.println( "Estado INICIAL de listA3: " + listA3.toString() );
        listA2.pasaInicio("uno");
        System.out.println( "Estado FINAL de listA3: " + listA3.toString() );

        
        System.out.println("\n-- HASTA LUEGO 2. --\n");  
    }
    
}
