package BarrosPedro.teste;

import BarrosPedro.infraestrutura.repositorios.implementações.RepositorioCliente;
import BarrosPedro.negocio.Cliente;
import BarrosPedro.negocio.Venda;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;

public class RepositorioClienteTest {

    RepositorioCliente repClientTest;
    Cliente clientTest;

    public RepositorioClienteTest() {
    }

    @Before
    public void setUp() {
        repClientTest = new RepositorioCliente();
        clientTest = new Cliente();
        clientTest.setCodigo(1);
        clientTest.setCPFCNPJ("A");
        clientTest.setEmail("A");
        clientTest.setIdade(11);
        clientTest.setNome("Junior");
        clientTest.setTelefone("12345");

    }

    @Test
    public void deveConferirSeClienteEstáSendoInserido() {
        repClientTest.inserir(clientTest);
        assertEquals(repClientTest.recuperarTodos().get(0).getCodigo(), clientTest.getCodigo());
    }

}
