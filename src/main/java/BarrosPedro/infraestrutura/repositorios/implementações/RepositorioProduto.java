package BarrosPedro.infraestrutura.repositorios.implementações;

import BarrosPedro.negocio.Produto;
import BarrosPedro.infraestrutura.repositorios.comportamentos.RepositorioGenerico;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Vinícius Soares
 */
public class RepositorioProduto implements RepositorioGenerico<Produto, Integer> {
    private List<Produto> produto = null;

    public RepositorioProduto() {
        this.produto = new ArrayList<>();
    }
    @Override
    public void inserir(Produto t){
        this.produto.add(t);
    }
    
    @Override
    public void alterar (Produto t){
        for (Produto e : this.produto){
            if (e.getCodigo()==( t.getCodigo())){
               e.setAltura(t.getAltura());
                e.setDescricaoUnica(t.getDescricaoUnica());
                e.setLargura(t.getLargura());
                e.setTipo(t.getTipo());
                e.setValorEntrada(t.getValorEntrada());
                return;
             }
        }
    }
    
    @Override
    public Produto recuperar(Integer codigo){
        for (Produto e : this.produto){
            if(e.getCodigo()== (codigo) ){
                return e;
            }
        }
        return null;
    }
    
    @Override
    public void deletar(Produto t){
        this.produto.remove(t);
    }
    
    @Override
    public List<Produto> recuperarTodos(){
        return this.produto;
    }

   

    
}