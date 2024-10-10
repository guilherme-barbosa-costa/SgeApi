/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Area;
import model.bean.Disciplina;

/**
 *
 * @author Senai
 */
public class DisciplinaDAO {

    public List<Disciplina> lerDisciplinas() {
        List<Disciplina> lista = new ArrayList<>();

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("SELECT dis.id_disciplina, dis.nome_disciplina, area.id_area, area.nome AS nome_area, area.descricao AS descricao_area FROM disciplina AS dis INNER JOIN area ON dis.fk_id_area = area.id_area");
            ResultSet rs = stmt.executeQuery();
            
            
            
            while(rs.next()) {
                
                Disciplina dis = new Disciplina();
                
                dis.setId_disciplina(rs.getInt("id_disciplina"));
                dis.setNome_disciplina(rs.getString("nome_disciplina"));
                
                Area area = new Area();
                
                area.setId_area(rs.getInt("id_area"));
                area.setNome_area(rs.getString("nome_area"));
                area.setDescricao(rs.getString("descricao_area"));
                
                dis.setArea(area);
                
                lista.add(dis);
            }
            
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return lista;
        
    }
    
    public Disciplina disciplinaEspecifica(int id){
        Disciplina dis = new Disciplina();
        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conexao.prepareStatement("SELECT dis.id_disciplina, dis.nome_disciplina,\n"
                    + "area.id_area AS id_area, area.nome AS nome_area,\n"
                    + "area.descricao AS descricao_area\n"
                    + "FROM disciplina AS dis\n"
                    + "INNER JOIN area ON dis.fk_id_area = area.id_area "
                    + "WHERE dis.id_disciplina = ?");
            stmt.setInt(1, id);
           
            rs = stmt.executeQuery();
            
            if (rs.next()) {

                // Preenche os atributos da disciplina com os dados retornados da consulta
                dis.setId_disciplina(rs.getInt("id_disciplina")); // Define o ID da disciplina
                dis.setNome_disciplina(rs.getString("nome_disciplina")); // Define o nome da disciplina

                // Início do objeto Area
                Area area = new Area(); // Cria uma nova instância de Area
                area.setId_area(rs.getInt("id_area")); // Define o ID da área
                area.setNome_area(rs.getString("nome")); // Define o nome da área
                area.setDescricao(rs.getString("descricao")); // Define a descrição da área

                // Associa a área ao objeto disciplina
                dis.setArea(area);

            }
            
            rs.close();
            stmt.close();
            conexao.close();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return dis;
        
    }
    
    public List<Disciplina> lerDisciplinasProfessores(int id) {
        List<Disciplina> lista = new ArrayList<>();

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            
            stmt = conexao.prepareStatement("SELECT d.id_disciplina, d.nome_disciplina, a.id_area, a.nome, a.descricao FROM disciplina AS d INNER JOIN professor_disciplina AS pd ON pd.fk_id_disciplina = d.id_disciplina INNER JOIN area AS a ON a.id_area = d.fk_id_area WHERE pd.fk_id_professor = ?;");
            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();
          
            while(rs.next()) {
                
                Disciplina dis = new Disciplina();
                
                dis.setId_disciplina(rs.getInt("id_disciplina"));
                dis.setNome_disciplina(rs.getString("nome_disciplina"));
                
                Area area = new Area();
                
                area.setId_area(rs.getInt("id_area"));
                area.setNome_area(rs.getString("nome"));
                area.setDescricao(rs.getString("descricao"));
                
                dis.setArea(area);
                
                lista.add(dis);
            }
            
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return lista;
        
    }

}
