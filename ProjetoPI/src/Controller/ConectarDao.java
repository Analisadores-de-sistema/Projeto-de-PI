package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;

public class ConectarDao {

    public Connection mycon = null;
    public String sql = null;

    public ConectarDao() {
        String strcon = "jdbc:mysql://localhost:3306/midiagame";//cria a string de conexão ao servidor xaamp 
        try {

            mycon = DriverManager.getConnection(strcon, "root", "");
            this.criarBanco();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Conexão com Mysql não realizada!\n" + ex);
        }
    }

    public void criarBanco() {
        sql = " CREATE TABLE IF NOT EXISTS NIVEIS ("
                + "idNivel int not null AUTO_INCREMENT, "
                + "desNivel varchar(30) not null, "
                + "primary key (idNivel) ) ";

        try {
            PreparedStatement ps = mycon.prepareStatement(sql);
            ps.execute();
            ps.close();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao criar table Nivel!\n" + err.getMessage());
        }

        sql = " CREATE TABLE IF NOT EXISTS USUARIOS ("
                + "cpf varchar (30) not null, "
                + "nome varchar(50) not null, "
                + "email varchar(50) not null, "
                + "celular varchar(20) not null,"
                + "idNivel int not null, "
                + "senha varchar(20) not null,  "
                + "primary key (cpf) )";
        try {
            PreparedStatement ps = mycon.prepareStatement(sql);
            ps.execute();
            ps.close();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao criar tabela Usuarios \n" + err.getMessage());
        }

        sql = " CREATE TABLE IF NOT EXISTS CLIENTES ("
                + "cpf varchar (30) not null, "
                + "nome varchar(50) not null, "
                + "email varchar(50) not null, "
                + "celular varchar(20) not null,"
                + "endereco varchar(100) not null,"
                + "primary key (cpf) )";
        try {
            PreparedStatement ps = mycon.prepareStatement(sql);
            ps.execute();
            ps.close();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao criar tabela Clientes \n" + err.getMessage());
        }

        sql = " CREATE TABLE IF NOT EXISTS JOGOS ("
                + "idJogo int not null auto_increment, "
                + "nome varchar(50) not null, "
                + "tipo_genero varchar(50) not null,"
                + "produtora varchar(30) not null,"
                + "plataforma varchar(30) not null,"
                + "idade_indicativa varchar(50) not null, "
                + "primary key (idJogo) )";
        try {
            PreparedStatement ps = mycon.prepareStatement(sql);
            ps.execute();
            ps.close();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao criar tabela Jogos \n" + err.getMessage());
        }

    }

}
