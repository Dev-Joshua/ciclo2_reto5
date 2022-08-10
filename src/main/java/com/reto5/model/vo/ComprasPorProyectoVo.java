package com.reto5.model.vo;

public class ComprasPorProyectoVo {
  //Atributos(Id, constructora, banco_vinculado)
  private Integer id;
  private String constructora;
  private String bancoVinculado;

  //Modificadores y consultores
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
  public String getBancoVinculado() {
    return bancoVinculado;
  }
  public void setBancoVinculado(String bancoVinculado) {
    this.bancoVinculado = bancoVinculado;
  }

  
}
