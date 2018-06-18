package BarrosPedro.negocio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cliente {

    @Id
    @GeneratedValue
    private int codigo;
    @Column(length = 50)
    private String nome;
    @Column(length = 30)
    private String CPFCNPJ;
    @Column(length = 3)
    private int idade;
    @Column(length = 15)
    private String telefone;
    @Column(length = 35)
    private String email;

    public Cliente(int codigo, String nome, String CPFCNPJ, int idade, String telefone, String email) {
        this.codigo = codigo;
        this.nome = nome;
        this.CPFCNPJ = CPFCNPJ;
        this.idade = idade;
        this.telefone = telefone;
        this.email = email;
    }

    public Cliente() {

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPFCNPJ() {
        return CPFCNPJ;
    }

    public void setCPFCNPJ(String CPFCNPJ) {
        this.CPFCNPJ = CPFCNPJ;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return CPFCNPJ == ((Cliente) obj).getCPFCNPJ();
    }

}