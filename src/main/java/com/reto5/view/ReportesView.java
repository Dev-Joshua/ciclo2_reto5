package com.reto5.view;

import java.util.List;

import javax.swing.JFrame;

import com.reto5.controller.ReportesController;
import com.reto5.model.vo.ListarLideresVo;
import com.reto5.model.vo.ProyectoBancoVo;

public class ReportesView extends JFrame{
  private static ReportesController controller;

  public ReportesView() {
    controller = new ReportesController();
  }
  
  

  public void proyectosFinanciadosPorBanco(String banco) {
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
  
  

  // public void totalAdeudadoPorProyectosSuperioresALimite(Double limiteInferior) {
  //     try {
  //       List<DeudasPorProyectoVo> proyectos = controller.listaTotalDeudasProyecto(limiteInferior);
  //       for(DeudasPorProyectoVo proyecto:proyectos){
  //         System.out.println(proyecto);
  //       }
  //     } catch (Exception ex) {
  //       System.err.println("Error: "+ex);
  //     }
      
  //   }
  


  public void lideresQueMasGastan() {
    try {
      List<ListarLideresVo> variable = controller.listaTotalComprasLider();
      for(ListarLideresVo proyecto:variable){
        System.out.println(proyecto);
      }
    } catch (Exception ex) {
      System.err.println("Error: "+ex);
    }
  }
}
