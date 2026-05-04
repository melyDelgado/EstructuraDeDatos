import DLSLists.*;

public class Proble1Main {
    // Solucion al problema 2.

    public static void main(String[] args) {

        System.out.println("Carmen Sofía Delgado Escobar 208655\n");
        
        // Parte A), pruebas del metodo
        System.out.println("---- eliminaSegundo 1 ----");
        UnOrdList<String> listA1= new UnOrdList<String>();
        listA1.addLast("rojo");    listA1.addLast("verde");        

        System.out.println( "Estado INICIAL de listA1: " + listA1.toString() );
        String eliminado1 = listA1.eliminaSegundo();
        System.out.println("\nElemento eliminado: " + eliminado1);
        System.out.println( "Estado FINAL de listA1: " + listA1.toString() );
        
        //Prueba si es Null
        System.out.println("---- eliminaSegundo 2 ----");
        UnOrdList<Integer> listA2= new UnOrdList<Integer>();      

        System.out.println( "Estado INICIAL de listA1: " + listA2.toString() );
        Integer eliminado2 = listA2.eliminaSegundo();
        System.out.println("\nElemento eliminado: " + eliminado2);
        System.out.println( "Estado FINAL de listA1: " + listA2.toString() );
        
        //Prueba si  hay solo 1
        System.out.println("---- eliminaSegundo 2 ----");
        UnOrdList<String> listA3= new UnOrdList<String>();
        listA3.addLast("Hola");
        

        System.out.println( "Estado INICIAL de listA1: " + listA3.toString() );
        String eliminado3 = listA3.eliminaSegundo();
        System.out.println("\nElemento eliminado: " + eliminado3);
        System.out.println( "Estado FINAL de listA1: " + listA3.toString() );
        //Arreglar, quitó el único elemento
        
        System.out.println("\n-- HASTA LUEGO 1. --\n");  
    }

    
    
    
}
