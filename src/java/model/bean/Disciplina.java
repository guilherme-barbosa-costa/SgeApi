/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.util.List;

/**
 *
 * @author Senai
 */
public class Disciplina {
    private int id_disciplina, area_id;
    private String nome_disciplina;
    private List<Area> areas;

    public Disciplina() {
    }

    public Disciplina(int id_disciplina, int area_id, String nome_disciplina, List<Area> areas) {
        this.id_disciplina = id_disciplina;
        this.area_id = area_id;
        this.nome_disciplina = nome_disciplina;
        this.areas = areas;
    }

    public int getId_disciplina() {
        return id_disciplina;
    }

    public void setId_disciplina(int id_disciplina) {
        this.id_disciplina = id_disciplina;
    }

    public int getArea_id() {
        return area_id;
    }

    public void setArea_id(int area_id) {
        this.area_id = area_id;
    }

    public String getNome_disciplina() {
        return nome_disciplina;
    }

    public void setNome_disciplina(String nome_disciplina) {
        this.nome_disciplina = nome_disciplina;
    }

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }
    
    
    
    
}
