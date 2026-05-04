import Sets.*;
import ADTsException.*;
import java.util.Iterator;

public class Proble2Main {

    public static void main(String[] args) {

        System.out.println("Carmen Sofía Delgado Escobar, 208655\n");
        
        // Pruebas de Problema 2.
        ArraySet<String> sstr1= new ArraySet(6);
        sstr1.add("tres");    sstr1.add("-a1b3");
        sstr1.add("saludos");    sstr1.add("cdmx");
        sstr1.add("-823");
        //System.out.println("sstr1 inicial: " + sstr1.toString());
        
        ArraySet<String> sstr2= new ArraySet(6);
        sstr2.add("hola");    sstr2.add("saludos");
        sstr2.add("-a1b3");    sstr2.add("cdmx");
        sstr2.add("911");
        //System.out.println("sstr2 inicial: " + sstr2.toString());
        
        ArraySet<String> rstr12= noPerte(sstr1, sstr2);
        System.out.println("sstr1 final: " + sstr1.toString());
        System.out.println("sstr2 final: " + sstr2.toString());
        System.out.println("rstr: " + rstr12.toString() + "\n");
        
        ArraySet<String> sstr4= new ArraySet(2);
        sstr4.add("tres");  
        //System.out.println("sstr4 inicial: " + sstr4.toString());
        
        ArraySet<String> sstr5= new ArraySet(2);
        sstr5.add("dos"); sstr5.add("uno");
        //System.out.println("sstr4 inicial: " + sstr4.toString());
        
        ArraySet<String> rstr13= noPerte(sstr4, sstr5);
        System.out.println("sstr1 final: " + sstr4.toString());
        System.out.println("sstr2 final: " + sstr5.toString());
        System.out.println("rstr: " + rstr13.toString() + "\n");
        
        ArraySet<String> sstr7= new ArraySet();  
        //System.out.println("sstr4 inicial: " + sstr4.toString());
        
        ArraySet<String> sstr8= new ArraySet(2);
        sstr8.add("dos"); sstr8.add("uno");
        //System.out.println("sstr4 inicial: " + sstr4.toString());
        
        ArraySet<String> rstr17= noPerte(sstr7, sstr8);
        System.out.println("sstr1 final: " + sstr7.toString());
        System.out.println("sstr2 final: " + sstr8.toString());
        System.out.println("rstr: " + rstr17.toString() + "\n");
        
        ArraySet<String> sstr10= new ArraySet();
        sstr10=null;
        //System.out.println("sstr4 inicial: " + sstr4.toString());
        
        ArraySet<String> sstr11= new ArraySet(3);
        sstr11.add("dos"); sstr11.add("uno"); 
        sstr11.add("treinta");
        //System.out.println("sstr4 inicial: " + sstr4.toString());
        
        ArraySet<String> rstr20= noPerte(sstr10, sstr11);
        System.out.println("sstr1 final: " + sstr10.toString());
        System.out.println("sstr2 final: " + sstr11.toString());
        System.out.println("rstr: " + rstr20.toString() + "\n");
        
        System.out.println("HASTA LUEGO 2.");
    }
    
    public static <T> ArraySet<T> noPerte(ArraySet<T> unum, ArraySet<T> duo) {
        // Validación: Si alguno de los conjuntos es nulo o tiene menos de 2 elementos.
        if (unum == null || duo == null || unum.isEmpty() || duo.isEmpty()) {
            throw new ADTsException("noPerte: Alguna de las colas son null o están vacías");
        }

        ArraySet<T> resultado = new ArraySet<>();
        Iterator<T> iterUnum = unum.iterator();
        Iterator<T> iterDuo = duo.iterator();

        if(unum.size()> 2 || duo.size()> 2) {

        while (iterUnum.hasNext()) {
            T elemento = iterUnum.next();
            if (!duo.contains(elemento)) {
                resultado.add(elemento);
            }
        }

        while (iterDuo.hasNext()) {
            T elemento = iterDuo.next();
            if (!unum.contains(elemento)) {
                resultado.add(elemento);
            }
        }
        }

        return resultado; 
    }
    
}
