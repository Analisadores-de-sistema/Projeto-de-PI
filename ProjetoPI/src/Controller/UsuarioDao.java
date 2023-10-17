/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Usuario;
import java.sql.SQLException;
import java.sql.PreparedStatement; // Dentro da conexão permite executar comandos SQL
import javax.swing.JOptionPane;
import javax.swing.*;
import java.sql.*;

public class UsuarioDao extends ConectarDao { String sql;
PreparedStatement ps; // objeto para executar o sql

public UsuarioDao() { super(); }

/*public void criarBanco() {
try {

sql = "CREATE TABLE IF NOT EXISTS USUARIOS ("
+ "id_cliente varchar(12) not null ,"
+ "nome varchar(50) not null ,"
+ "email varchar(50) not null ,"
+ "celular varchar(20) not null ,"
+ "endereço varchar(100) not null "
+ "primary key (id_cliente) )";
ps = con.prepareStatement(sql); // prepara o objeto que irá executar o comando SQL
ps.execute(); // Executa o comando SQL

ps.close(); // Fecha o objeto
con.close(); // Fecha a conexão

JOptionPane.showMessageDialog(null, "Banco criado com sucesso...");
} catch (SQLException err) {
JOptionPane.showMessageDialog(null, "Erro ao criar banco de dados " + err.getMessage() );
}}}*/

public ResultSet validarLogin(String login, String senha){
    sql = "SELECT * from usuario where email='" + login+ "'"
            + " and senha = '" + senha + "'";
    
    try {
        PreparedStatement ps = (PreparedStatement)
                          mycon.prepareStatement(sql);
        ResultSet resul = ps.executeQuery();
        return resul;}
    catch (SQLException err){
    JOptionPane.showMessageDialog(null, err.getMessage());
            return null;
    }
}


public void incluir (Usuario obj){
    sql = "INSERT INTO USUARIO VALUES (?, ?, ?, ?, ?, ?, ?)";
    try{
    ps = mycon.prepareStatement(sql);
    ps.setInt(1, obj.getIdUsuario());
    ps.setString(2, obj.getNome());
    ps.setString(3, obj.getTelefone());
    ps.setString(4, obj.getEndereço());
    ps.setString(5, obj.getEmail());
    ps.setString(6, obj.getCpf());
    ps.setString(7, obj.getSenha());
    ps.execute();
    ps.close();
    
    JOptionPane.showMessageDialog(null, "Registro Incluido "
            + "com Sucesso!");
    } catch (SQLException err){
    JOptionPane.showMessageDialog(null, "Erro ao incluir "
            + "usuário" + err.getMessage());
    }
}

    public ResultSet buscar(Usuario Lu) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



}