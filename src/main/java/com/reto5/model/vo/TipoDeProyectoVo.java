package com.reto5.model.vo;

//Los archivos (vo) Van a contener los atributos de cada clase
public class TipoDeProyectoVo {
  private Integer id;
  private String constructora;
  private String habitaciones;
  private String ciudad;

  //Consultores y modificadores
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public String getConstructora() {
    return constructora;
  }
  public void setConstructora(String constructora) {
    this.constructora = constructora;
  }
  public String getHabitaciones() {
    return habitaciones;
  }
  public void setHabitaciones(String habitaciones) {
    this.habitaciones = habitaciones;
  }
  public String getCiudad() {
    return ciudad;
  }
  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  
  
}
