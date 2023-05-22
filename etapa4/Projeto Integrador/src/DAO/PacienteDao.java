/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexoes.Conexao;
import Model.Paciente;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Nicolas
 */
public class PacienteDao {

    Conexao conexao;
    Connection conn;

    public PacienteDao() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public void cadastrarPaciente(Paciente paciente) {
        String sql = "INSERT INTO paciente (nome, cpf, data_nascimento, telefone) VALUES " + "(?,?,?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, paciente.getNome());
            stmt.setString(2, paciente.getCpf());
            stmt.setString(3, paciente.getDataNascimento());
            stmt.setString(4, paciente.getTelefone());
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao(conn);
        }
    }

    public List<Paciente> getPacienteNome(String nome) {
        String sql = "SELECT * FROM paciente WHERE nome LIKE ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + nome + "%");

            ResultSet rs = stmt.executeQuery();

            List<Paciente> listaPaciente = new ArrayList<>();

            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setId(rs.getLong(1));
                paciente.setNome(rs.getString(2));
                paciente.setCpf(rs.getString(3));
                paciente.setDataNascimento(rs.getString(4));
                listaPaciente.add(paciente);
            }

            return listaPaciente;

        } catch (Exception e) {
            return null;
        }
    }

    public Paciente buscarPacientePorCPF(String cpf) {
        Paciente paciente = new Paciente();
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM paciente WHERE cpf = ?");
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                paciente = new Paciente();
                paciente.setId(rs.getLong(1));
                paciente.setNome(rs.getString(2));
                paciente.setCpf(rs.getString(3));
                paciente.setDataNascimento(rs.getString(4));
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o paciente. Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            this.conexao.fecharConexao(conn);
        }

        return paciente;
    }

    public void excluir(int id) {
        String sql = "DELETE FROM paciente WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            stmt.execute();
        } catch (Exception e) {
            System.out.println("Erro ao excluir paciente: " + e.getMessage());
        }
    }

    public void alterar(Paciente paciente) {
        String sql = "UPDATE paciente SET nome = ?, cpf = ?, dataNascimento = ?, telefone = ? WHERE id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, paciente.getNome());
            stmt.setString(2, paciente.getCpf());
            stmt.setString(3, paciente.getDataNascimento());
            stmt.setString(4, paciente.getTelefone());
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Erro ao editar dados paciente: " + e.getMessage());
        } finally {
            this.conexao.fecharConexao(this.conn);
        }
    }

}
