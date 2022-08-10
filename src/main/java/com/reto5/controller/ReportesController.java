package com.reto5.controller;

import java.sql.SQLException;
import java.util.List;

import com.reto5.model.dao.ComprasPorProyectoDao;
import com.reto5.model.dao.ListarLideresDao;
import com.reto5.model.dao.TipoDeProyectoDao;
import com.reto5.model.vo.ComprasPorProyectoVo;
import com.reto5.model.vo.ListarLideresVo;
import com.reto5.model.vo.TipoDeProyectoVo;

public class ReportesController {
  private TipoDeProyectoDao listarProyectosDao;
  private ListarLideresDao listarLideresDao;
  private ComprasPorProyectoDao listarComprasDao;



  public ReportesController() {
    //Creo la instancia de la clase
    listarProyectosDao = new TipoDeProyectoDao();
    listarLideresDao = new ListarLideresDao();
    listarComprasDao = new ComprasPorProyectoDao();
  }

  
  //Metodo para listar lideres(Primer informe)
  public List<ListarLideresVo> listarLideres() throws SQLException {
    return listarLideresDao.listar();    
  }
  
  //Metodo para listar proyectos(Segundo informe)
  public List<TipoDeProyectoVo> listarProyectos() throws SQLException {
    return listarProyectosDao.listar();    
  }

  //MEtodo para listar compras de proyectos como proveedor Homecenter(Tercer informe)
  public List<ComprasPorProyectoVo> listarCompras() throws SQLException {
    return listarComprasDao.listar();    
  }
}
