package BarrosPedro.infraestrutura.repositorios.implementações;

import BarrosPedro.infraestrutura.dao.PersistenceDao;
import BarrosPedro.infraestrutura.repositorios.comportamentos.RepositorioGenerico;
import BarrosPedro.negocio.Produto;
import java.util.List;
import javax.persistence.Persistence;
/**
 *
 * @author Vinícius Soares
 */
public class RepositorioProdutoImplBD implements RepositorioGenerico<Produto, Integer>{
     @Override
    public void inserir(Produto t) {
        PersistenceDao.getInstance().persist(t);
    }

    @Override
    public void alterar(Produto t) {
        PersistenceDao.getInstance().update(t);
    }

    @Override
    public Produto recuperar(Integer codigo) {
       try{
           return (Produto)PersistenceDao.getInstance().read("select a from Produto a where a.codigo="+codigo).get(0);
       }catch(IndexOutOfBoundsException index){
           return null;
       }
    }

    @Override
    public void deletar(Produto t) {
    PersistenceDao.getInstance().delete(t);
    
    }

    @Override
    public List<Produto> recuperarTodos() {
        return PersistenceDao.getInstance().read("select a from Produto a");

    }

    
}