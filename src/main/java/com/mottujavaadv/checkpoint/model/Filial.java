package com.mottujavaadv.checkpoint.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

@Entity
public class Filial {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String estado;

    @NotBlank
    private String nome;

    @NotBlank
    private String cidade;

    @OneToMany(mappedBy = "filial", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Moto> motos;

    public List<Moto> getMotos() {
        return motos;
    }

    public void setMotos(List<Moto> motos) {
        this.motos = motos;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTamanhoPatio() {
        return tamanhoPatio;
    }

    public void setTamanhoPatio(String tamanhoPatio) {
        this.tamanhoPatio = tamanhoPatio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    private String pais;
    private String tamanhoPatio;



    //@OneToMany(mappedBy = "filial", cascade = CascadeType.ALL)
    //private List<Moto> motos;

    // Getters e Setters
    // Construtores (vazio e com argumentos)
}
