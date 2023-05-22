/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexoes.Conexao;
import Model.Especialidade;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author Nicolas
 */
public class EspecialidadeDAO {
    Conexao conexao;
    Connection conn;
    

    public EspecialidadeDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    
    public List<Especialidade> listarEspecialidades() throws SQLException {
    List<Especialidade> lista = new ArrayList<>();
    String sql = "SELECT * FROM especialidade";
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();
        while (rs.next()) {
            Especialidade especialidade = new Especialidade(rs.getInt(1), rs.getString(2));
            lista.add(especialidade);
        }
    } finally {
        if (rs != null) rs.close();
        if (stmt != null) stmt.close();
    }
    return lista;
}
    

    public Especialidade buscarEspecialidadePorNome(String nome) throws SQLException {
    String sql = "SELECT * FROM especialidade WHERE nome = ?";
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, nome);
        rs = stmt.executeQuery();
        if (rs.next()) {
            Especialidade especialidade = new Especialidade(rs.getInt(1), rs.getString(2));
            return especialidade;
        }
    } finally {
        if (rs != null) rs.close();
        if (stmt != null) stmt.close();
    }
    return null;
}



    
}
