package br.com.jfive.model;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: rodrigoalmeida
 * Date: 23/05/13
 * Time: 23:19
 * To change this template use File | Settings | File Templates.
 */
public class Endereco {

    private Integer id;
    private String endereco;
    private String cidade;
    private String estado;
    private List<Telefone> telefones;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }
}
