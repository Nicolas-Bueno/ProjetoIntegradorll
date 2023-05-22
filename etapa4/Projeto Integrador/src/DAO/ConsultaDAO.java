/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexoes.Conexao;
import Model.Consulta;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nicolas
 */
public class ConsultaDAO {

    Conexao conexao;
    Connection conn;

    public ConsultaDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public void cadastrarConsulta(Consulta consulta) {
        String sql = "INSERT INTO consulta (paciente_id, medico_id, atendente_id, data_consulta, observacoes) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, consulta.getPacienteId());
            stmt.setInt(2, consulta.getMedicoId());
            stmt.setInt(3, consulta.getAtendenteId());
            stmt.setTimestamp(4, Timestamp.valueOf(consulta.getDataConsulta()));
            stmt.setString(5, consulta.getObservacoes());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao(conn);
        }
    }

    public List<Consulta> listarConsultas() throws SQLException {
        List<Consulta> listaConsultas = new ArrayList<>();
        String sql = "SELECT c.id, p.nome as paciente, m.nome as medico, a.nome as atendente, c.data_consulta, c.observacoes "
                + "FROM consulta c "
                + "INNER JOIN paciente p ON c.paciente_id = p.id "
                + "INNER JOIN medico m ON c.medico_id = m.id "
                + "INNER JOIN atendente a ON c.atendente_id = a.id";
        try ( PreparedStatement stmt = conn.prepareStatement(sql);  ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt(1);
                String paciente = rs.getString(2);
                String medico = rs.getString(3);
                String atendente = rs.getString(4);
                String dataConsulta = rs.getString(5);
                String observacoes = rs.getString(6);
                Consulta consulta = new Consulta(id, paciente, medico, atendente, dataConsulta, observacoes);
                listaConsultas.add(consulta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao(conn);
        }
        return listaConsultas;
    }
    
    public void excluirConsulta(int idConsulta) {
    String sql = "DELETE FROM consulta WHERE id = ?";
    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idConsulta);
        stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        this.conexao.fecharConexao(conn);
    }
}


}
