
package BarrosPedro.teste;

import BarrosPedro.negocio.Produto;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;


public class CalculosDeProdutoTest {
    Produto produtoTest;
   
    public CalculosDeProdutoTest() {
    }
    
    @Before
    public void setUp(){
       produtoTest  = new Produto();
       produtoTest.setAltura(50);
       produtoTest.setLargura(1);
       produtoTest.setValorEntrada(300);
    }
    
    @Test
    public void deveCalcularÁreaTotalProdutoBruto() {
        double calcula = produtoTest.CalculaÁreaTotal();  
        assertEquals(50, calcula, 0.1);
    }
    
     @Test
    public void deveCalcularPreçoPorMetroQuadradoProdutoBruto() {
        double calcula = produtoTest.CalculaValorPorMetroQuadrado();  
        assertEquals(6, calcula, 0.1);
    }
   

}
 
