package BarrosPedro.infraestrutura.repositorios.implementações;

import BarrosPedro.negocio.Cliente;
import BarrosPedro.infraestrutura.repositorios.comportamentos.RepositorioGenerico;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Vinícius Soares
 */
public class RepositorioCliente implements RepositorioGenerico<Cliente, Integer> {
    private List<Cliente> clientes = null;

    public RepositorioCliente() {
        this.clientes = new ArrayList<>();
    }
    @Override
    public void inserir(Cliente t){
        this.clientes.add(t);
    }
    
    @Override
    public void alterar (Cliente t){
        for (Cliente e : this.clientes){
            if (e.getCodigo()==( t.getCodigo())){
                e.setNome(t.getNome());
                e.setCPFCNPJ(t.getCPFCNPJ());
                e.setEmail(t.getEmail());
                e.setIdade(t.getIdade());
                e.setTelefone(t.getTelefone());
                return;
             }
        }
    }
    
    @Override
    public Cliente recuperar(Integer codigo){
        for (Cliente e : this.clientes){
            if(e.getCodigo()== (codigo) ){
                return e;
            }
        }
        return null;
    }
    
    @Override
    public void deletar(Cliente t){
        this.clientes.remove(t);
    }
    
    @Override
    public List<Cliente> recuperarTodos(){
        return this.clientes;
    }

   

    
}