package com.reto5.controller;

import java.sql.SQLException;
import java.util.List;

import com.reto5.model.dao.ListarLideresDao;
import com.reto5.model.dao.TipoDeProyectoDao;
import com.reto5.model.vo.ListarLideresVo;
import com.reto5.model.vo.TipoDeProyectoVo;

public class ReportesController {
  private TipoDeProyectoDao listarProyectosDao;
  private ListarLideresDao listarLideresDao;


  public ReportesController() {
    //Creo la instancia de la clase
    listarProyectosDao = new TipoDeProyectoDao();
    listarLideresDao = new ListarLideresDao();
  }

  //Metodo para generar el listado de TotalProyectoBanco, otro metodo para listar las deudas, otro para listar los lidereslos lideres
  public List<TipoDeProyectoVo> listarProyectos() throws SQLException {
    return listarProyectosDao.listar(null);    
  }

  //Metodo para listar lideres(Primer informe)
  public List<ListarLideresVo> listarLideres() throws SQLException {
    return listarLideresDao.listar();    
  }

  // public List<DeudasPorProyectoVo> listaTotalDeudasProyecto(Double limite)throws SQLException {
  //   return deudasPorProyectoDao.listar(limite);    
  // }
}
