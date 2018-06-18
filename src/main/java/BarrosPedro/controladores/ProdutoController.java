

package BarrosPedro.controladores;
import BarrosPedro.infraestrutura.repositorios.comportamentos.RepositorioGenerico;
import BarrosPedro.infraestrutura.repositorios.implementações.RepositorioProdutoImplBD;
import BarrosPedro.negocio.Produto;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
/**
 *
 * @author Vinícius Soares
 */
@ManagedBean
@SessionScoped
public class ProdutoController{
    
    private RepositorioGenerico<Produto,Integer> repositorioProduto = null;
    private Produto produtoCadastro;
    private Produto selectedProduto;
   
    Produto produto = new Produto();
    
    public ProdutoController(){
        this.repositorioProduto = new RepositorioProdutoImplBD();
        this.produtoCadastro = new Produto();
    }
    
    public void inserir(){
        
        this.repositorioProduto.inserir(this.produtoCadastro);
        this.produtoCadastro = new Produto();
        
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso!","O produto foi cadastrado com sucesso!"));
    }
    
    public void alterar(Produto c){
        this.repositorioProduto.alterar(c);
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso!","O produto foi alterado com sucesso!"));
    }
    
    public Produto recuperarProduto(int codigo){
        return this.repositorioProduto.recuperar(codigo);
    }
    
    public void deletar(Produto c){
        this.repositorioProduto.deletar(c);
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso!","O produto foi deletado com sucesso!"));
    }
    
    public List<Produto> recuperarTodosProdutos(){
        return this.repositorioProduto.recuperarTodos();
    }

    public Produto getProdutoCadastro() {
        return produtoCadastro;
    }

    public void setProdutoCadastro(Produto produtoCadastro) {
        this.produtoCadastro = produtoCadastro;
    }

    public Produto getSelectedProduto() {
        return selectedProduto;
    }

    public void setSelectedProduto(Produto selectedProduto) {
        this.selectedProduto = selectedProduto;
    }

    public RepositorioGenerico<Produto,Integer> getRepositorioProduto() {
        return repositorioProduto;
    }

    public void setRepositorioProduto(RepositorioGenerico<Produto, Integer> repositorioProduto) {
        this.repositorioProduto= repositorioProduto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    
}