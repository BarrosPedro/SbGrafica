/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BarrosPedro.negocio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author josel
 */
@Entity
public class Produto {
    @Id
    @GeneratedValue
    private int codigo;
    @Column (length = 50)
    private String descricaoUnica;
    @Column(length = 50)
    private String tipo;
    @Column(length = 30)
    private double altura = 50;
    @Column(length = 15)
    private double largura;
    @Column(length = 35)
    private double áreaTotal;
    @Column(length = 35)
    private double valorEntrada;
     @Column(length = 35)
    private double valorPorMetro;
     
    public Produto(int codigo, String descricaoUnica, String tipo, double altura, double largura,double áreaTotal, double valorEntrada, double valorPorMetro) {
        this.codigo = codigo;
        this.descricaoUnica = descricaoUnica;
        this.tipo = tipo;
        this.altura = altura;
        this.largura = largura;
        this.áreaTotal = áreaTotal;
        this.valorEntrada = valorEntrada;
        this.valorPorMetro = valorPorMetro;
    }
      public Produto(int codigo, String descricaoUnica, String tipo, double altura, double largura, double valorEntrada) {
        this.codigo = codigo;
        this.descricaoUnica = descricaoUnica;
        this.tipo = tipo;
        this.altura = altura;
        this.largura = largura;
        this.valorEntrada = valorEntrada;
       
    }

    public Produto() {

    }
    
    public double CalculaÁreaTotal(){
      áreaTotal = this.altura*this.largura;
        return áreaTotal;
    }
    public double CalculaValorPorMetroQuadrado(){
        valorPorMetro = valorEntrada/CalculaÁreaTotal();
        return valorPorMetro;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricaoUnica() {
        return descricaoUnica;
    }

    public void setDescricaoUnica(String descricaoUnica) {
        this.descricaoUnica = descricaoUnica;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getÁreaTotal() {
        return áreaTotal;
    }

    public void setÁreaTotal(double áreaTotal) {
        this.áreaTotal = áreaTotal;
    }
    

    public double getValorEntrada() {
        return valorEntrada;
    }

    public void setValorEntrada(double valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

    public double getValorPorMetro() {
        return valorPorMetro;
    }

    public void setValorPorMetro(double valorPorMetro) {
        this.valorPorMetro = valorPorMetro;
    }

}