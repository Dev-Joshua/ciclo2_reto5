package com.reto5.controller;

import java.sql.SQLException;
import java.util.List;

import com.reto5.model.dao.ListarLideresDao;
import com.reto5.model.dao.ProyectoBancoDao;
import com.reto5.model.vo.ListarLideresVo;
import com.reto5.model.vo.ProyectoBancoVo;

public class ReportesController {
  private ProyectoBancoDao proyectoBancoDao;
  private ListarLideresDao listarLideresDao;


  public ReportesController() {
    proyectoBancoDao = new ProyectoBancoDao();
    
  }

  //Metodo para generar el listado de TotalProyectoBanco, otro metodo para listar las deudas, otro para listar los lidereslos lideres
  public List<ProyectoBancoVo> listaTotalProyectoBanco(String banco)throws SQLException {
    return proyectoBancoDao.listar(banco);    
  }

  //Metodo para listar lideres(Primer informe)
  public List<ListarLideresVo> listaTotalComprasLider()throws SQLException {
    return listarLideresDao.listar();    
  }

  // public List<DeudasPorProyectoVo> listaTotalDeudasProyecto(Double limite)throws SQLException {
  //   return deudasPorProyectoDao.listar(limite);    
  // }
}
