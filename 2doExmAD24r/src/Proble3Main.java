import ADTsException.*;

public class Proble3Main {

    public static void main(String[] args) {

        System.out.println("Carmen Sofía Delgado Escobar, 208655\n");
        double [] ad = {2.0, 5.0, 3.0, 1.0, 4.0};
        double [] rd = null;
        
        rd= creaOtroVector( ad );
        
        for(int i=0; i<rd.length; i++) {
            System.out.print(rd[i] + ", ");
        }
        System.out.println();
        
        System.out.println("HASTA LUEGO 3.");
    }
    
    public static double[] creaOtroVector(double[] arrd) {
        if (arrd == null || arrd.length == 0) {
            throw new ADTsExcpetion("El arreglo es null o esta vacío"); 
        }
        
        double[] nuevoArr = new double[arrd.length];

        creaOtroVectorRec(arrd, 0, nuevoArr, 0);

        return nuevoArr;
    }

    private static void creaOtroVectorRec(double[] arrd, int index, double[] nuevoArr, double suma) {
        if (index == arrd.length) {
            return;
        }

        if (index == 0) {
            suma = creaOtroVectorRec(arrd, 0);
        }

        nuevoArr[index] = suma;

        creaOtroVectorRec(arrd, index + 1, nuevoArr, suma + 1);
    }
    //Esta es la suma, no sabía si podía llamarse suma o tenía que llamarse igual como decía en las instrucciones del examen
    private static double creaOtroVectorRec(double[] arrd, int index) {
        double suma;
        if (index == arrd.length) {
            suma=0;
        }
        suma= arrd[index] + creaOtroVectorRec(arrd, index + 1);
        return suma;
    }


    }
