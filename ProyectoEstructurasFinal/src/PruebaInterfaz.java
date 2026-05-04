/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
/**
 *
 * @author alega
 */
public class PruebaInterfaz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
