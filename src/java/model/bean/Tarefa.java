/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.util.Date;

/**
 *
 * @author Senai
 */
public class Tarefa {
    private int id_tarefa, disciplina_id;
    private String nome_tarefa, descricao;
    private Date data_entrega;

    public Tarefa() {
    }

    public Tarefa(int id_tarefa, int disciplina_id, String nome_tarefa, String descricao, Date data_entrega) {
        this.id_tarefa = id_tarefa;
        this.disciplina_id = disciplina_id;
        this.nome_tarefa = nome_tarefa;
        this.descricao = descricao;
        this.data_entrega = data_entrega;
    }

    public int getId_tarefa() {
        return id_tarefa;
    }

    public void setId_tarefa(int id_tarefa) {
        this.id_tarefa = id_tarefa;
    }

    public int getDisciplina_id() {
        return disciplina_id;
    }

    public void setDisciplina_id(int disciplina_id) {
        this.disciplina_id = disciplina_id;
    }

    public String getNome_tarefa() {
        return nome_tarefa;
    }

    public void setNome_tarefa(String nome_tarefa) {
        this.nome_tarefa = nome_tarefa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData_entrega() {
        return data_entrega;
    }

    public void setData_entrega(Date data_entrega) {
        this.data_entrega = data_entrega;
    }
    
    
}
