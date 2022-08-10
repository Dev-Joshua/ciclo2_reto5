package com.reto5.view;

import java.util.List;

import com.reto5.controller.ReportesController;
import com.reto5.model.vo.ProyectoBancoVo;

public class ReportesView {
  private static ReportesController controller;

  public ReportesView() {
    controller = new ReportesController();
  }
  
  private static String repitaCaracter(Character caracter, Integer veces) {
    String respuesta = "";
    for (int i = 0; i < veces; i++) {
      respuesta += caracter;
    }
    return respuesta;
  }

  public void proyectosFinanciadosPorBanco(String banco) {
    System.out.println(repitaCaracter('=', 36) + " LISTADO DE PROYECTOS POR BANCO " + repitaCaracter('=', 37));
    if (banco != null && !banco.isBlank()) {
      System.out.println(String.format("%3s %-25s %-20s %-15s %-7s %-30s", "ID", "CONSTRUCTORA", "CIUDAD", "CLASIFICACION", "ESTRATO", "LIDER"));
      System.out.println(repitaCaracter('-', 105));
      try{
        List<ProyectoBancoVo> proyectos = controller.listaTotalProyectoBanco(banco);
        //proyecto es la variable que se va a mover(iterar) sobre los elementos que acabo de traer proyectos
        //Imprime la variable(proyecto) que itera elemento por elemento
        for(ProyectoBancoVo proyecto:proyectos){
          System.out.println(proyecto);
        }
      }catch(Exception ex){
        System.err.println("Error: "+ex);
      }
    }
  }
}
