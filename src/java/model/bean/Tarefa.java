/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Senai
 */
public class Tarefa {

    private int id_tarefa;
    private String nome_tarefa, nome_turma, descricao;
    private Float notas;
    private Date data_entrega;
    private List<Aluno> aluno;
    private List<Disciplina> disciplina;

    public Tarefa() {
    }

    public Tarefa(int id_tarefa, String nome_tarefa, String nome_turma, String descricao, Float notas, Date data_entrega) {
        this.id_tarefa = id_tarefa;
        this.nome_tarefa = nome_tarefa;
        this.nome_turma = nome_turma;
        this.descricao = descricao;
        this.notas = notas;
        this.data_entrega = data_entrega;
    }

    public int getId_tarefa() {
        return id_tarefa;
    }

    public void setId_tarefa(int id_tarefa) {
        this.id_tarefa = id_tarefa;
    }

    public String getNome_tarefa() {
        return nome_tarefa;
    }

    public void setNome_tarefa(String nome_tarefa) {
        this.nome_tarefa = nome_tarefa;
    }

    public String getNome_turma() {
        return nome_turma;
    }

    public void setNome_turma(String nome_turma) {
        this.nome_turma = nome_turma;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getNotas() {
        return notas;
    }

    public void setNotas(Float notas) {
        this.notas = notas;
    }

    public Date getData_entrega() {
        return data_entrega;
    }

    public void setData_entrega(Date data_entrega) {
        this.data_entrega = data_entrega;
    }

}
