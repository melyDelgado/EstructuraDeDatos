
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;


public class PruebaProyecto {
    
    //Prueba Sintaxis 
    public static void main(String[] args) {
        //Prueba Sintaxis 
        System.out.println("SINTAXIS");
        System.out.println("Prueba 1 (se espera que el resultado sea falso):" + Syntax.Syntax("175.0.1"));
        System.out.println("Prueba 2 (se espera que el resultado sea verdadero): "+ Syntax.Syntax("15.2+13.0"));
        System.out.println("Prueba 3 (se espera que el resultado sea verdadero): "+ Syntax.Syntax("8%*100"));
        System.out.println("Prueba 4 (se espera que el resultado sea falso): "+Syntax.Syntax("3%*"));
        System.out.println("Prueba 5 (se espera que el resultado sea falso):" + Syntax.Syntax("(8+9.0)+(10%*100"));
        System.out.println("Prueba 6 (se espera que el resultado sea verdadero): "+ Syntax.Syntax("(18%*500)+((25*9)+(4/2))"));
        System.out.println("Prueba 7 (se espera que el resultado sea falso): "+ Syntax.Syntax(""));
        System.out.println("Prueba 8 (se espera que el resultado sea falso): "+Syntax.Syntax("89+15@90"));
        System.out.println("Prueba 9 (se espera que el resultado sea falso): "+ Syntax.Syntax("25+18/2*(Prueba)")+ "\n");
        
        //Prueba Convertir
        System.out.println("CONVERTIR A POSTFIJO");
        System.out.println(Convertir.Convertir("3*((34+87)-3(45)+(46/52))"));
        System.out.println(Convertir.Convertir("8^2"));
        System.out.println(Convertir.Convertir("25%100"));
        System.out.println(Convertir.Convertir("(-25)*2+100") + "\n");
        
        //Prueba De Postfijo a Resultado
        DePostfijaAResultado prueba=new DePostfijaAResultado();
        System.out.println("DE POSTFIJA A RESULTADO");
        String resultado1=prueba.dePostfijaAResultado("((3+4)*5)");
        System.out.println("Expresion: (3+4)*5, Resultado: "+ resultado1);
        String resultado2=prueba.dePostfijaAResultado("((2^3)*4)");
        System.out.println("Resultado:" +resultado2);
        String resultado3=prueba.dePostfijaAResultado("25%*100");
        System.out.println("Resultado:" +resultado3);
        String resultado4=prueba.dePostfijaAResultado("7/0");
        System.out.println("Resultado:" + resultado4);
        String resultado5=prueba.dePostfijaAResultado("(-3.5)+(-4)*5");
        System.out.println("Resultado:" +resultado5);
        String resultado6=prueba.dePostfijaAResultado("(-3))+(4-5");
        System.out.println("Resultado:" +resultado6);
        
         // Crear la instancia de JFrame
        JFrame frame = new JFrame("Calculadora");
        
        // Crear la instancia de NewJPanel
        NewJPanel newJPanel = new NewJPanel();

        // Configurar el tamaño preferido de NewJPanel para que coincida con la calculadora 
        newJPanel.setPreferredSize(new Dimension(470, 450));
        
        
        // Establecer un borde vacío para crear un margen dentro del JFrame
        newJPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // margen de 10 píxeles
        
        // Configurar la operación de cierre para terminar la aplicación cuando se cierre la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Utilizar BorderLayout para agregar componentes
        frame.setLayout(new BorderLayout());
        
        // Agregar NewJPanel al centro del BorderLayout para que quede centrado en el JFrame
        frame.add(newJPanel, BorderLayout.CENTER);
        
        // Ajustar el tamaño de la ventana al contenido
        frame.pack();
        
        // Centrar la ventana en la pantalla
        frame.setLocationRelativeTo(null);
        
        // Hacer visible el JFrame
        frame.setVisible(true);
       
    }
    
}
