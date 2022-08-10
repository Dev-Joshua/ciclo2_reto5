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
  public List<ListarLideresVo> listar() throws SQLException{
    ArrayList<ListarLideresVo> respuesta = new ArrayList<ListarLideresVo>();
    Connection conn = JDBCUtilities.getConnection();
    Statement stmt = null;
    ResultSet rs = null;
    //Consulta- Query
    String consulta = "SELECT ID_Lider AS id, Nombre, Primer_Apellido AS apellido, Ciudad_Residencia AS ciudad FROM Lider l ORDER BY Ciudad_Residencia;";
    
    //Realizo la consulta a la base de datos
  try {
      stmt = conn.createStatement();
      rs = stmt.executeQuery(consulta);
      while (rs.next()) {
        ListarLideresVo vo = new ListarLideresVo();
        vo.setId(rs.getInt("id"));
        vo.setNombre(rs.getString("Nombre"));
        vo.setApellido(rs.getString("apellido"));
        vo.setCiudad(rs.getString("ciudad"));
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
