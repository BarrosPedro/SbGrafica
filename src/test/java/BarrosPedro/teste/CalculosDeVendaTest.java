
package BarrosPedro.teste;
import BarrosPedro.negocio.Venda;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;


public class CalculosDeVendaTest {
    Venda produtoTest;
   
    public CalculosDeVendaTest() {
    }
    
    @Before
    public void setUp(){
       produtoTest  = new Venda();
       produtoTest.setAlturaSaida(1);
       produtoTest.setLarguraSaida(1.20);
       produtoTest.setQuantidade(1);
       produtoTest.setValorPorMetro(60);
    }
    
    @Test
    public void deveCalcularMetrosQuadrados() {
        double calcula = produtoTest.CalculaMetrosQuadrados();  
        assertEquals(1.20, calcula, 0.1);
    }
    
    
    @Test
    public void deveCalcularValorTotalVenda() {
        double calcula = produtoTest.CalculaValorTotal();  
        assertEquals(72, calcula, 0.1);
    }
}
 