package com.reto5.model.vo;

public class ListarLideresVo {
  //Atributos(id,nombre,apellido,ciudad)
  private Integer id;
  private String nombre;
  private String apellido;
  private String ciudad;

  //Consultores y modificadores
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public String getApellido() {
    return apellido;
  }
  public void setApellido(String apelliido) {
    this.apellido = apelliido;
  }
  public String getCiudad() {
    return ciudad;
  }
  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

}
