package br.com.alura.agenda_alura.modelo;

/**
 * Created by italo on 20/12/17.
 */

public class Aluno {
    private long id;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private String loginGithub;
    private String genero;
    private Double nota;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public String getLoginGithub() {
        return loginGithub;
    }

    public void setLoginGithub(String loginGithub) {
        this.loginGithub = loginGithub;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return getId() + " - " + getNome();
    }
}
