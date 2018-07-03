package BarrosPedro.infraestrutura.repositorios.implementações;

import BarrosPedro.infraestrutura.dao.PersistenceDao;
import BarrosPedro.infraestrutura.repositorios.comportamentos.RepositorioGenerico;
import BarrosPedro.negocio.Cliente;
import java.util.List;
import javax.persistence.Persistence;
/**
 *
 * @author Vinícius Soares
 */
public class RepositorioClienteImplBD implements RepositorioGenerico<Cliente, Integer>{
     @Override
    public void inserir(Cliente t) {
        PersistenceDao.getInstance().persist(t);
    }

    @Override
    public void alterar(Cliente t) {
        PersistenceDao.getInstance().update(t);
    }

    @Override
    public Cliente recuperar(Integer codigo) {
       try{
           return (Cliente)PersistenceDao.getInstance().read("select a from Cliente a where a.codigo="+codigo).get(0);
       }catch(IndexOutOfBoundsException index){
           return null;
       }
    }

    @Override
    public void deletar(Cliente t) {
    PersistenceDao.getInstance().delete(t);
    
    }

    @Override
    public List<Cliente> recuperarTodos() {
        return PersistenceDao.getInstance().read("select a from Cliente a");

    }
    
}