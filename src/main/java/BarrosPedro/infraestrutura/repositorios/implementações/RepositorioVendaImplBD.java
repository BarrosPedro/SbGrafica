/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BarrosPedro.infraestrutura.repositorios.implementações;

import BarrosPedro.infraestrutura.dao.PersistenceDao;
import BarrosPedro.infraestrutura.repositorios.comportamentos.RepositorioGenerico;
import BarrosPedro.negocio.Venda;
import java.util.List;
import javax.persistence.Persistence;

/**
 *
 * @author josel
 */
public class RepositorioVendaImplBD implements RepositorioGenerico<Venda, Integer> {
    
    @Override
    public void inserir(Venda t) {
        PersistenceDao.getInstance().persist(t);
    }

    @Override
    public void alterar(Venda t) {
        PersistenceDao.getInstance().update(t);
    }

    @Override
    public Venda recuperar(Integer codigo) {
       try{
           return (Venda)PersistenceDao.getInstance().read("select a from Venda a where a.codigo="+codigo).get(0);
       }catch(IndexOutOfBoundsException index){
           return null;
       }
    }

    @Override
    public void deletar(Venda t) {
    PersistenceDao.getInstance().delete(t);
    
    }

    @Override
    public List<Venda> recuperarTodos() {
        return PersistenceDao.getInstance().read("select a from Venda a");

    }
}
