package com.reto5.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.reto5.model.vo.TipoDeProyectoVo;
import com.reto5.util.JDBCUtilities;

//En esta clase TipoDeProyecto de la carpeta dao van a ir las consultas SQL
public class TipoDeProyectoDao {
  public List<TipoDeProyectoVo> listar()throws SQLException{
    ArrayList<TipoDeProyectoVo> respuesta = new ArrayList<TipoDeProyectoVo>();
    Connection conn = JDBCUtilities.getConnection();
    Statement stm = null;
    ResultSet rs = null;
    String consulta = "SELECT ID_Proyecto as id, Constructora, Numero_Habitaciones as habitaciones, Ciudad FROM Proyecto p WHERE Clasificacion  = 'Casa Campestre' AND ciudad IN('Santa Marta', 'Cartagena', 'Barranquilla');";
  try {
      stm = conn.createStatement();
      rs = stm.executeQuery(consulta);
      while(rs.next()) {
        TipoDeProyectoVo objetoVo = new TipoDeProyectoVo();
        objetoVo.setId(rs.getInt("id"));
        objetoVo.setConstructora(rs.getString("constructora"));
        objetoVo.setHabitaciones(rs.getString("habitaciones"));
        objetoVo.setCiudad(rs.getString("ciudad"));
        respuesta.add(objetoVo);
      }
    } finally{                                                                              //finally(catch) -> sirve para cerrar toda conexion
        if(rs != null){
          rs.close();
          }
          if(stm != null){
          stm.close();
          }
          if(conn != null){
          conn.close();
          }
    }
    return respuesta;
    
  }

}
