package BarrosPedro.teste;

import BarrosPedro.infraestrutura.repositorios.implementações.RepositorioCliente;
import BarrosPedro.infraestrutura.repositorios.implementações.RepositorioClienteImplBD;
import BarrosPedro.negocio.Cliente;
import BarrosPedro.negocio.Venda;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;

public class RepositorioClienteTest {

    RepositorioClienteImplBD repClientBDTest;
    Cliente clientTest;

    public RepositorioClienteTest() {
    }

    @Before
    public void setUp() {
        repClientBDTest = new RepositorioClienteImplBD();
        
        clientTest = new Cliente();
        clientTest.setCodigo(18);
        clientTest.setCPFCNPJ("A");
        clientTest.setEmail("A");
        clientTest.setIdade(11);
        clientTest.setNome("Junior");
        clientTest.setTelefone("12345");

    }

    @Test
    public void deveConferirSeClienteEstáSendoInserido() {
        repClientBDTest.inserir(clientTest);
        assertEquals(clientTest.getCodigo(), repClientBDTest.recuperar(Integer.SIZE).equals(this.clientTest.getCodigo()));
    }
    
    

}
