package com.reto5;

import javax.swing.JFrame;
import java.awt.*;

import com.reto5.view.ReportesView;

//Desde aqui realizo el layout de mi programaa
public class App 
{
    public static void main( String[] args )
    {   
        //Creo la ventana del menu principal
        //Llamo a la clase ReportesView para ejecutar la interfaz
        ReportesView reportesView = new ReportesView();
        reportesView.setLayout(new FlowLayout());                     //La ventana tiene un tamaño fijo, el contenido se va ir colocando uno debajo del otro 
        // reportesView.setBounds(100, 100, 200, 300);
        reportesView.setSize(600, 400);                 //Le indico el tamaño de la ventana
        reportesView.setVisible(true);
        reportesView.setResizable(false);                  //No se puede cambiar
        reportesView.setTitle("Reto 5");
        reportesView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //Cerrar programa en x
        reportesView.setLocationRelativeTo(null);                   //Ubico la ventana en el centro de la pantalla
    }
}
