/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexoes.Conexao;
import Model.Funcionario;
import java.sql.*;

/**
 *
 * @author Nicolas
 */
public class LoginDAO {
    
    Conexao conexao;
    Connection conn;
    
    public LoginDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public Funcionario validarLogin(String login, String senha) {
    String sql = "SELECT * FROM atendente WHERE login = ? AND senha = ?";
    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, login);
        stmt.setString(2, senha);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            Funcionario funcionario = new Funcionario();
            funcionario.setId(rs.getInt(1));
            funcionario.setNome(rs.getString(2));
            funcionario.setCpf(rs.getString(3));
            funcionario.setEmail(rs.getString(4));
            funcionario.setLogin(rs.getString(5));
            funcionario.setSenha(rs.getString(6));
            return funcionario;
        } else {
            return null;
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    } finally {
        this.conexao.fecharConexao(this.conn);
    }
}


}
