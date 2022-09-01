package com.article.testandojavacmockito;

public class CustomerVO {

    private Long id;
    private String cpf;
    private String name;
    private Long rg;

    public CustomerVO(String cpf, String name, Long rg) {
        this.cpf = cpf;
        this.name = name;
        this.rg = rg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRg() {
        return rg;
    }

    public void setRg(Long rg) {
        this.rg = rg;
    }
}
