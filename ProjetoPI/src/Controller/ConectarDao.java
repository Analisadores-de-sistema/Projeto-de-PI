package Controller;

import java.sql.DriverManager; // Driver para abrir Conexão
import java.sql.SQLException; // Tratamento de Erros SQL
import java.sql.Connection; // Armazena a Conexão Aberta
import javax.swing.JOptionPane;
import javax.swing.*;
import java.sql.*;

public class ConectarDao {

    public Connection mycon = null;
    public String sql = null;
    Connection con;

    public ConectarDao() {
        String strcon = "jdbc:mysql://localhost:3306/midiagame";
        try { // Código que abre e armazena a 
            con = DriverManager.getConnection(
                    strcon, "root",
                    "");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro de Conexão com o"
                    + "MySQL ...\n" + err.getMessage());
        }
    }

    public void criarBanco() {
        sql = "CREATE TABLE IF NOT EXISTS USUARIO ("
                + "idUsuario int not null, "
                + "nome varchar(50) not null, "
                + "telefone varchar (50) not null, "
                + "endereço varchar (100) not null, "
                + "email varchar (50) not null, "
                + "cpf varchar (12) not null, "
                + "senha varchar (20) not null, "
                + "PRIMARY KEY (idUsuario) )";
    }
}
