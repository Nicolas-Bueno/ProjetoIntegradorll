/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexoes;

import java.sql.*;
/**
 *
 * @author Nicolas
 */
public class Conexao {
    private Connection conn;
    private Statement stm;
    private ResultSet rs;
    
    private String servidor = "localhost:3306";
    private String nomeDoBanco = "projetoIntegrador";
    private String user = "root";
    private String password = "mysql";
    
    public Connection getConexao(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://" + servidor + "/" + nomeDoBanco;
            conn = DriverManager.getConnection(url, user, password);
            
        } catch (Exception e) {
            System.out.println("Erro na conexao ao Bando de Dados : " + e.getMessage());
        }
        
        return conn;
    }
    
    public void fecharConexao(Connection conn) {
    try {
        if (conn != null) {
            conn.close();
        }
    } catch (SQLException e) {
        System.out.println("Erro ao fechar a conexão com o banco de dados: " + e.getMessage());
    }
}

}
