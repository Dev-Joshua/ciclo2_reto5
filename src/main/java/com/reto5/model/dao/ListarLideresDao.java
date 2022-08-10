package com.reto5.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.reto5.model.vo.ListarLideresVo;
import com.reto5.util.JDBCUtilities;

public class ListarLideresDao {
  //Hago mi conexion por medio de JBCUtilities, extraigo  el resultado de la consulta de la clase <ListarLideresVo>. 
  //respuesta sera un nuevo objeto del ArrayList<>

  public List<ListarLideresVo> listar() throws SQLException{
    ArrayList<ListarLideresVo> respuesta = new ArrayList<ListarLideresVo>();
    Connection conn = JDBCUtilities.getConnection();
    //Utilizo Statement ya que la consulta es fija.
    Statement stmt = null;
    //Con rs obtengo los datos de columna correspondientes a una fila
    ResultSet rs = null;
    //Consulta- Query
    String consulta = "SELECT ID_Lider AS id, Nombre, Primer_Apellido AS apellido, Ciudad_Residencia AS ciudad FROM Lider l ORDER BY Ciudad_Residencia;";
    
  try {
      //Preparo la conexion
      stmt = conn.createStatement();
      //obtengo la consulta mientras hayan registros por recorrer(rs.next)
      rs = stmt.executeQuery(consulta);
      while (rs.next()) {
        ListarLideresVo vo = new ListarLideresVo();
        //seteo la consulta
        vo.setId(rs.getInt("id"));
        vo.setNombre(rs.getString("Nombre"));
        vo.setApellido(rs.getString("apellido"));
        vo.setCiudad(rs.getString("ciudad"));
        //Agrego el objeto vo(listarLideres) a respusta(ArraList<ListarLideresVo>)
        respuesta.add(vo);
      }

    } finally {                                                                              //finally(catch) -> sirve para cerrar toda conexion
        if(rs != null){
          rs.close();
          }
          if(stmt != null){
          stmt.close();
          }
          if(conn != null){
          conn.close();
          }
    }
    return respuesta;

  }
}
