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
import model.bean.Disciplina;
import model.bean.Professor;

/**
 *
 * @author Senai
 */
public class ProfessoresDAO {
   public List<Professor> lerProfessores() {
        List<Professor> professores = new ArrayList<>();
        
        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet   rs = null;
            
            stmt = conexao.prepareStatement("select * from professor");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Professor prof = new Professor();
                prof.setId_professor(rs.getInt("id_professor"));
                prof.setNome(rs.getString("nome"));
                prof.setSobrenome(rs.getString("sobrenome"));
                prof.setSenha(rs.getString("senha"));
                prof.setCpf(rs.getString("cpf"));
                prof.setImagem("imagem");
                
                
                
                professores.add(prof);
            }
            rs.close();
            stmt.close();
            conexao.close();
            
        }catch(SQLException e){
            e.printStackTrace();
            
        }
        return professores;
        
     }
   
   public void mostrarDisciplinas (){
       
        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet   rs = null;
            
            stmt = conexao.prepareStatement("SELECT \n" +
"    disciplina.nome_disciplina,\n" +
"    area.nome_area\n" +
"FROM \n" +
"    disciplina\n" +
"INNER JOIN \n" +
"    area ON disciplina.area_id = area.id_area;");
            rs = stmt.executeQuery();
            
            if(rs.next()){
                Disciplina disciplinas = new Disciplina();
                disciplinas.setId_disciplina(rs.getInt("id_disciplias"));
                
                
                
                
            }
            rs.close();
            stmt.close();
            conexao.close();
            
        }catch(SQLException e){
            e.printStackTrace();
            
        }
        
     }

}
