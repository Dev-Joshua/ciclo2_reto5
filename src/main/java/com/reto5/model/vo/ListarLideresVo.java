package com.reto5.model.vo;

public class ListarLideresVo {
  //Atributos(id,nombre,apellido,ciudad)
  private Integer id;
  private String nombre, apellido, ciudad;

  //Consultores
  public Integer getId() {
    return id;
  }
  public String getNombre() {
    return nombre;
  }
  public String getApellido() {
    return apellido;
  }
  public String getCiudad() {
    return ciudad;
  }
  
  
  //Modificadores
  public void setId(Integer id) {
    this.id = id;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public void setApellido(String apellido) {
    this.apellido = apellido;
  }
  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }
  
}
