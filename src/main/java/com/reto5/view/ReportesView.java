package com.reto5.view;

import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.reto5.controller.ReportesController;
import com.reto5.model.vo.ComprasPorProyectoVo;
import com.reto5.model.vo.ListarLideresVo;
import com.reto5.model.vo.TipoDeProyectoVo;

//Extiende de la clase JFrame para hacer la interfaz
//De esta manera capturo los eventos del usuario para cambiar de informe(Implements ActionListener)
public class ReportesView extends JFrame implements ActionListener{
    //Atributos
    private static ReportesController controller;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem primerInforme, segundoInforme, tercerInforme;
    private JTable tabla;
    private DefaultTableModel modelo;                                      //Mostrar los elementos a traves de una tabla vinculada a un modelo(quien tiene los datos)
    private JLabel labelTitulo, labelConsulta;

    public ReportesView() {
      //Llamo los distintos metodosde la interfaz GUI
      controller = new ReportesController();
      menu();
      etiqueta1();
      etiqueta2();
      tabla();
    }
    
    public void menu() {
      //Creo la barra del menu
      menuBar = new JMenuBar();
      //Pongo el menu en mi JFrame
      setJMenuBar(menuBar);
      //Creo un menu que se llame Informes
      menu = new JMenu("Informes");
      //Añado el menu a la barra de menu
      menuBar.add(menu);

      //Creo 3 menu items
      primerInforme = new JMenuItem("Primer informe");
      segundoInforme = new JMenuItem("Segundo informe");
      tercerInforme = new JMenuItem("Tercer informe");
      //Los ánado al menu donde esta "Informes"
      menu.add(primerInforme);
      menu.add(segundoInforme);
      menu.add(tercerInforme);
      //Despues agrego el metodo ActionListener.(Asi capturo los eventos de mi usuario)
      primerInforme.addActionListener(this);
      segundoInforme.addActionListener(this);
      tercerInforme.addActionListener(this);
    }
    //Etiqueta1 nos va dar el titulo "Informe Reto 5", le doy un tamaño    
    public void etiqueta1() {
      labelTitulo = new JLabel("Reto 5 ---> Requerimientos");
      labelTitulo.setFont(new Font("Arial", Font.BOLD, 20));              //Le pongo Arial, negrilla de 20
      add(labelTitulo);
    }
    //Le doy las caracteristicas a la etiqueta2. Esta etiqueta va ir cambiando a medida que haga un informe diferente
    public void etiqueta2() {
      labelConsulta = new JLabel();
      labelConsulta.setPreferredSize(new Dimension(500, 30));
      labelConsulta.setFont(new Font("Arial", Font.BOLD, 14));
      add(labelConsulta);
    }
    //Crear tabla
    public void tabla() {
      //Creo el jTable, le vinculo el modelo a esa tabla.
      tabla = new JTable(modelo);
      tabla.setPreferredScrollableViewportSize(new Dimension(500, 200));                          //Permite tener un scroll a mi tabla
      add(tabla);                                                                                               //Añado la tabla
      JScrollPane pane = new JScrollPane(tabla);                                       //JScrollPane es una barra de desplazamiento que colocare al lado(vinculo con tabla)
      add(pane);
    }

    //Listar lideres
    //Cada que invoquen lideres llamo a este metodo para crear el modelo y actualizar el modelo a la tabla
    public void lideres() {
      try {
        //Traigo una lista de objeto LideresVo, donde cada objeto representara un registro de mi tabla
        List<ListarLideresVo> lideres = controller.listarLideres();
        //Creo modelo de mi tabla
        modelo = new DefaultTableModel();                             //El modelo son los datos que estan dentro de la tabla y los nombres de mis columnas(BD)
        modelo.addColumn("ID Lider");                     //Obtengo las 4 columnas mediante una consulta
        modelo.addColumn("Nombre"); 
        modelo.addColumn("Apellido");
        modelo.addColumn("Ciudad");
        //Recorro ListarLideresVo
        for(ListarLideresVo i:lideres){                               //lideres es una lista de LideresVo
          //Creo un array de Object fila y lo pongo en 4 columnas
          Object[] fila = new Object[4];                               //Cada fila va a tener 4 iileras
          fila[0] = i.getId();                                        //Por cada registro armo una fila
          fila[1] = i.getNombre();  
          fila[2] = i.getApellido();
          fila[3] = i.getCiudad();
          //Creo una fila para ir insertandola en mi tabla(modelo) por cada objetoVo(ListaLideresVo) que lea
          modelo.addRow(fila);  
        }                                      
        //Una vez termine el ciclo, el modelo se actualizara en la tabla
        tabla.setModel(modelo);
        modelo.fireTableDataChanged();
      }  
      catch (Exception ex) {
        System.err.println("Error: "+ex);
      }
    }

    //Listar proyectos
    public void proyectos() {
      try{
        //Traigo un registro de mi tabla
        List<TipoDeProyectoVo> proyectos = controller.listarProyectos();
        modelo = new DefaultTableModel();
        modelo.addColumn("ID Proyecto");
        modelo.addColumn("Constructora");
        modelo.addColumn("Habitaciones");
        modelo.addColumn("Ciudad");
        //la variable(i) itera elemento por elemento en proyectos. (i) tambien tendra los metodos get
        for(TipoDeProyectoVo i:proyectos){
          //Cada fila de 4 ileras(columnas)
          Object[] fila = new Object[4];
          fila[0] = i.getId();                                      //Le digo a fila que en la posicion 0 va tener el metodo getId()
          fila[1] = i.getConstructora();
          fila[2] = i.getHabitaciones();
          fila[3] = i.getCiudad();
          modelo.addRow(fila);                                      //Al final del for el modelo tendra todas las filas que quiero presentar
        }
        tabla.setModel(modelo);
        modelo.fireTableDataChanged();
      }catch(Exception ex){
        System.err.println("Error: "+ex);
      }
    }
  
    //Listar compras
    public void compras() {
      try {
        List<ComprasPorProyectoVo> proyectos = controller.listarCompras();
        modelo = new DefaultTableModel();
        modelo.addColumn("ID Compra");
        modelo.addColumn("Constructora");
        modelo.addColumn("Banco");
        for(ComprasPorProyectoVo i:proyectos){
          Object[] fila = new Object[3];
          fila[0] = i.getId();
          fila[1] = i.getConstructora();
          fila[2] = i.getBancoVinculado();
          modelo.addRow(fila);
        }
        tabla.setModel(modelo);
        modelo.fireTableDataChanged();
      } catch (Exception ex) {
        System.err.println("Error: "+ex);
      }
      }

    //Como ya implemente una interfaz(ACtionListener), le implemento el metodo a ReportesView
    @Override
    public void actionPerformed(ActionEvent e) {
      //Si! es primer informe entonces llamo a lideres para que actualice el informe
      if (e.getSource() == primerInforme) {
        lideres();
        labelConsulta.setText("Consulta de líderes");                                                       
      }
      if (e.getSource() == segundoInforme) {
        proyectos();
        labelConsulta.setText("Consulta de proyectos");
      }
      if (e.getSource() == tercerInforme) {
        compras();
        labelConsulta.setText("Consulta de compras");
      }
    }
}
