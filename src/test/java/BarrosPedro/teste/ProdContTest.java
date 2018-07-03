/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BarrosPedro.teste;

import BarrosPedro.controladores.ProdutoController;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import BarrosPedro.negocio.Produto;
import BarrosPedro.negocio.Venda;
import static org.junit.Assert.*;

/**
 *
 * @author 20151D12GR0537
 */
public class ProdContTest {
    static ProdutoController prodContTest;
    static Produto produto;
    static Venda venda;
    
    public ProdContTest() {
        prodContTest = new ProdutoController();
    }
    
    @Before
    public void setUp() {
        produto = new Produto(934, "a", "a", 0, 0, 0, 0, 0, venda);
        prodContTest.setProdutoCadastro(produto);
        venda = new Venda();
    }
    
    @After
    public void tearDown() {
        prodContTest = null;
    }

    @Test
    public void deveInserirProduto() {
        prodContTest.inserir();
        assertEquals(produto, prodContTest.recuperarProduto(934));
    }
    
    @Test
    public void deveAlterarProduto() {
        prodContTest.setProdutoCadastro(produto);
        Produto novoproduto = new Produto(934, "B", "B", 0, 0, 0, 0, 0, venda);
        prodContTest.inserir();
        prodContTest.alterar(novoproduto);
        assertEquals(novoproduto, prodContTest.recuperarProduto(934));
    }
    
    @Test
    public void deveRecuperarProduto() {
        prodContTest.setProdutoCadastro(produto);
        prodContTest.alterar(produto);
        Produto recuperado = prodContTest.recuperarProduto(934);
        assertEquals(produto, recuperado);
    }
    
    @Test
    public void deveDeletarProduto() {
        prodContTest.setProdutoCadastro(produto);
        prodContTest.deletar(produto);
        assertEquals(null, prodContTest.recuperarProduto(934));
    }
}