package com.reto5.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.reto5.model.vo.ComprasPorProyectoVo;
import com.reto5.util.JDBCUtilities;

//Clase que contendra mis consultas SQL
public class ComprasPorProyectoDao {
    public List<ComprasPorProyectoVo> listar()throws SQLException{
      ArrayList<ComprasPorProyectoVo> respuesta = new ArrayList<ComprasPorProyectoVo>();
      Connection conn = JDBCUtilities.getConnection();
      Statement stm = null;
      ResultSet rs = null;
      String consulta = "SELECT ID_Compra AS id, p.Constructora, p.Banco_Vinculado AS banco FROM Compra c JOIN Proyecto p ON c.ID_Proyecto  = p.ID_Proyecto WHERE Proveedor = 'Homecenter' AND p.Ciudad = 'Salento';";
    try {
        stm = conn.createStatement();
        rs = stm.executeQuery(consulta);
        while(rs.next()) {
          ComprasPorProyectoVo objetoVo = new ComprasPorProyectoVo();
          objetoVo.setId(rs.getInt("id"));
          objetoVo.setConstructora(rs.getString("constructora"));
          objetoVo.setBancoVinculado(rs.getString("banco"));
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
