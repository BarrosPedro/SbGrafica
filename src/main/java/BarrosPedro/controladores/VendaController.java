/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BarrosPedro.controladores;

import BarrosPedro.infraestrutura.repositorios.comportamentos.RepositorioGenerico;
import BarrosPedro.infraestrutura.repositorios.implementações.RepositorioVendaImplBD;
import BarrosPedro.negocio.Venda;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author josel
 */
@ManagedBean
@SessionScoped
public class VendaController {
    private RepositorioGenerico<Venda,Integer> repositorioVenda = null;
    private Venda vendaCadastro;
    private Venda selectedVenda;
    
    public VendaController(){
        this.repositorioVenda = new RepositorioVendaImplBD();
        this.vendaCadastro = new Venda();
        
    }
    
    public void inserir(){
        
        //String nome =((String)((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("advogadoController"));
        
        if(this.vendaCadastro.getDescrição().toLowerCase().contains("aralho")){
        FacesContext.getCurrentInstance().addMessage("formDialCadVenda:txtNome", 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro",
                            "Voce digitou um nome inválido"));
            
            return;
        }
        
        this.repositorioVenda.inserir(this.vendaCadastro);
        this.vendaCadastro = new Venda();
        
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso!","O venda foi cadastrado com sucesso!"));
    }
    
    public void alterar(Venda f){
        this.repositorioVenda.alterar(f);
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso!","O venda foi alterado com sucesso!"));
    }
    
    public Venda recuperarVenda(Integer codigo){
        return this.repositorioVenda.recuperar(codigo);
    }
    
    public void deletar(Venda f){
        this.repositorioVenda.deletar(f);
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso!","O venda foi deletado com sucesso!"));
    }
    
    public List<Venda> recuperarTodosVendas(){
        return this.repositorioVenda.recuperarTodos();
    }

    public Venda getVendaCadastro() {
        return vendaCadastro;
    }

    public void setVendaCadastro(Venda vendaCadastro) {
        this.vendaCadastro = vendaCadastro;
    }

    public Venda getSelectedVenda() {
        return selectedVenda;
    }

    public void setSelectedVenda(Venda selectedVenda) {
        this.selectedVenda = selectedVenda;
    }

    public RepositorioGenerico<Venda, Integer> getRepositorioVenda() {
        return repositorioVenda;
    }

    public void setRepositorioVenda(RepositorioGenerico<Venda, Integer> repositorioVenda) {
        this.repositorioVenda= repositorioVenda;
    }    
}
