/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BarrosPedro.negocio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author josel
 */
@Entity
public class Venda implements Serializable {
    
    @Id
    @GeneratedValue
    private int codigo;
    @Column(length = 35)
    private String descrição;   
    @Temporal(TemporalType.DATE)
    private Date dataPedido;
    @Temporal(TemporalType.DATE)    
    private Date dataEntrega;
    @Column(length = 30)
    private double alturaSaida;
    @Column(length = 15)
    private double larguraSaida;
    @Column(length = 35)
    private int quantidade;
    @Column(length = 35)
    private double valorPorMetro; 
    @Column(length = 35)
    private double valorTotal;
    @OneToOne
    private Produto produto;
    @ManyToOne
    private Cliente cliente;
    
   
    
    public Venda() {
    }

    public Venda(Produto produto, Cliente cliente) {
        this.produto = produto;
        this.cliente = cliente;
    }
   
    public Venda(int codigo, String descrição, Date dataPedido, Date dataEntrega, double alturaSaida, double larguraSaida, int quantidade, double valorPorMetro, double valorTotal, Cliente cliente, Produto produto) {
        this.codigo = codigo;
        this.descrição = descrição;
        this.dataPedido = dataPedido;
        this.dataEntrega = dataEntrega;
        this.alturaSaida = alturaSaida;
        this.larguraSaida = larguraSaida;
        this.quantidade = quantidade;
        this.valorPorMetro = valorPorMetro;
        this.valorTotal = valorTotal;
        this.cliente = cliente;
        this.produto = produto;    
    }
    
     public double CalculaValorTotal(){
      valorTotal = this.valorPorMetro*(this.alturaSaida*this.larguraSaida*this.quantidade);
        return valorTotal;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }


    public double getAlturaSaida() {
        return alturaSaida;
    }

    public void setAlturaSaida(double alturaSaida) {
        this.alturaSaida = alturaSaida;
    }

    public double getLarguraSaida() {
        return larguraSaida;
    }

    public void setLarguraSaida(double larguraSaida) {
        this.larguraSaida = larguraSaida;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorPorMetro() {
        return valorPorMetro;
    }

    public void setValorPorMetro(double valorPorMetro) {
        this.valorPorMetro = valorPorMetro;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
}
