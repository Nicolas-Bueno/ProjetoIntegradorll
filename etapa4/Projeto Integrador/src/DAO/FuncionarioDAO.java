/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexoes.Conexao;
import Model.Funcionario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nicolas
 */
public class FuncionarioDAO {
    Conexao conexao;
    Connection conn;
    

    public FuncionarioDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void cadastrarFuncionario(Funcionario funcionario) {
    String sql = "INSERT INTO atendente (nome, cpf, email, login, senha) VALUES (?, ?, ?, ?, ?)";
    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, funcionario.getNome());
        stmt.setString(2, funcionario.getCpf());
        stmt.setString(3, funcionario.getEmail());
        stmt.setString(4, funcionario.getLogin());
        stmt.setString(5, funcionario.getSenha());
        stmt.execute();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        this.conexao.fecharConexao(conn);
    }
}

    
    public List<Funcionario> getEspecialidade(String nome){
        String sql = "SELECT * FROM atendente WHERE nome LIKE ?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + nome + "%" );
            
            ResultSet rs = stmt.executeQuery();
            
            List<Funcionario> listaFuncionario = new ArrayList<>();
            
            while(rs.next()){
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getInt(1));
                funcionario.setNome(rs.getString(2));
                funcionario.setLogin(rs.getString(3));
                funcionario.setSenha(rs.getString(4));
                funcionario.setEmail(rs.getString(5));
                listaFuncionario.add(funcionario);
            }
            
            return listaFuncionario;
            
        } catch (Exception e) {
            return null;
        }
    }
    
    public void excluir(int id) {
        String sql = "DELETE FROM atendente WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            stmt.execute();
        } catch (Exception e) {
            System.out.println("Erro ao excluir funcionario: " + e.getMessage());
        }
    }
    
    public void alterar(Funcionario funcionario){
        String sql = "UPDATE atendente SET nome = ?, cpf = ?, email = ?, login = ?, senha = ?  WHERE id = ?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.setString(3, funcionario.getEmail());
            stmt.setString(4, funcionario.getLogin());
            stmt.setString(5, funcionario.getSenha());
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Erro ao editar dados funcionario: " + e.getMessage());
        } finally {
            this.conexao.fecharConexao(this.conn);
        }
    }
}
