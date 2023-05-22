/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexoes.Conexao;
import Model.Medico;
import Model.Especialidade;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Nicolas
 */
public class MedicoDAO {

    Conexao conexao;
    Connection conn;

    public MedicoDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public void cadastrarMedico(Medico medico) {
        String sql = "INSERT INTO medico (nome, crm, especialidade_id) VALUES " + "(?,?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, medico.getNome());
            stmt.setString(2, medico.getCrm());
            stmt.setInt(3, medico.getEspecialidadeId());
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao(conn);
        }
    }

    public List<Medico> listarMedicosPorEspecialidade(int idEspecialidade) throws SQLException {
    List<Medico> medicos = new ArrayList<>();
    String sql = "SELECT * FROM medico WHERE especialidade_id = ?";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setInt(1, idEspecialidade);
    ResultSet rs = stmt.executeQuery();
    while (rs.next()) {
        Medico medico = new Medico();
        medico.setId(rs.getInt(1));
        medico.setNome(rs.getString(2));
        medico.setCrm(rs.getString(3));
        // Aqui estamos criando uma nova instância de Especialidade e definindo apenas o ID,
        // que é o que precisamos para pesquisar os médicos pela especialidade
        Especialidade especialidade = new Especialidade();
        especialidade.setId(idEspecialidade);
        medico.setEspecialidade(especialidade);
        medicos.add(medico);
    }
    return medicos;
}


    public Medico buscarMedicoPorEspecialidade(String especialidade) {
        Medico medico = new Medico();
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM medico WHERE especialidade_id = ?");
            stmt.setString(1, especialidade);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                medico = new Medico();
                medico.setId(rs.getInt(1));
                medico.setNome(rs.getString(2));
                medico.setCrm(rs.getString(3));
                //medico.setEspecialidade(rs.getObject(4, Especialidade.class));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o medico. Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            this.conexao.fecharConexao(conn);
        }

        return medico;
    }
    
    public Medico buscarMedicoPorNome(String nome) {
        Medico medico = new Medico();
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM medico WHERE nome = ?");
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                medico = new Medico();
                medico.setId(rs.getInt(1));
                medico.setNome(rs.getString(2));
                medico.setCrm(rs.getString(3));
                //medico.setEspecialidade(rs.getObject(4, Especialidade.class));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o medico. Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            this.conexao.fecharConexao(conn);
        }

        return medico;
    }

    public void excluir(int id) {
        String sql = "DELETE FROM medico WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            stmt.execute();
        } catch (Exception e) {
            System.out.println("Erro ao excluir medico: " + e.getMessage());
        }
    }

    public void alterar(Medico medico) {
        String sql = "UPDATE medico SET nome = ?, crm = ?, especialidade_id = ? WHERE id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, medico.getNome());
            stmt.setString(2, medico.getCrm());
            stmt.setInt(3, medico.getEspecialidade().getId());
            stmt.setInt(4, medico.getId());
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Erro ao editar dados do médico: " + e.getMessage());
        } finally {
            this.conexao.fecharConexao(this.conn);
        }
    }
}
