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

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("select * from professor");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Professor professor = new Professor();
                professor.setId_professor(rs.getInt("id_professor"));
                professor.setNome(rs.getString("nome"));
                professor.setSobrenome(rs.getString("sobrenome"));
                professor.setCpf(rs.getString("cpf"));
                professor.setImagem(rs.getString("imagem"));
                professor.setDisciplina(
                        new DisciplinaDAO()
                        .lerDisciplinasProfessores
                        (rs.getInt("id_professor"))
                );
                professores.add(professor);
            }
            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return professores;

    }

    public void mostrarDisciplinas() {

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT \n"
                    + "    disciplina.nome_disciplina,\n"
                    + "    area.nome_area\n"
                    + "FROM \n"
                    + "    disciplina\n"
                    + "INNER JOIN \n"
                    + "    area ON disciplina.area_id = area.id_area;");
            rs = stmt.executeQuery();

            if (rs.next()) {
                Disciplina disciplinas = new Disciplina();
                disciplinas.setId_disciplina(rs.getInt("id_disciplias"));

            }
            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

}
