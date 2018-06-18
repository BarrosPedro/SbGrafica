/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BarrosPedro.infraestrutura.repositorios.implementações;

import BarrosPedro.infraestrutura.repositorios.comportamentos.RepositorioGenerico;
import BarrosPedro.negocio.Venda;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josel
 */
public class RepositorioVenda implements RepositorioGenerico<Venda, Integer> {
       private List<Venda> vendas = null;

    public RepositorioVenda() {
        this.vendas = new ArrayList<>();
    }
    @Override
    public void inserir(Venda t){
        this.vendas.add(t);
    }
    
    @Override
    public void alterar (Venda t){
        for (Venda e : this.vendas){
                if (e.getDescrição().equals( t.getDescrição())){
                e.setCodigo(t.getCodigo());
                e.setDataPedido(t.getDataEntrega());
                e.setAlturaSaida(t.getAlturaSaida());
                e.setLarguraSaida(t.getLarguraSaida());
                e.setQuantidade(t.getQuantidade());
                e.setValorPorMetro(t.getValorPorMetro());
                e.setValorTotal(t.getValorTotal());
                return;
             }
        }
    }
    
       @Override
    public Venda recuperar(Integer codigo){
        for (Venda e : this.vendas){
            if(e.getCodigo() == (codigo) ){
                return e;
            }
        }
        return null;
    }
    
    @Override
    public void deletar(Venda t){
        this.vendas.remove(t);
    }
    
    @Override
    public List<Venda> recuperarTodos(){
        return this.vendas;
    }

   
    

}
