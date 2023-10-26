package Controller;

import Model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;

public class JogoDao extends ConectarDao {

    private PreparedStatement ps;

    public JogoDao() {
        super();
    }

    public void incluir(Usuario obj) {
        sql = "INSERT INTO USUARIOS VALUES (?, ?, ?, ?, ?, ?)";
        try {
            ps = mycon.prepareStatement(sql);
            ps.setString(1, obj.getCpf());
            ps.setString(2, obj.getNome());
            ps.setString(3, obj.getEmail());
            ps.setString(4, obj.getCelular());
            ps.setInt(5, obj.getIdNivel());
            ps.setString(6, obj.getSenha());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Registro Incluído com Sucesso!");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao incluir usuário!" + err.getMessage());
        }
    }

    public ResultSet validarLogin(String login, String senha) {

        sql = "SELECT * , if(idnivel = 1, 'Gerente', 'Operador') as nivel "
                + "FROM USUARIOS WHERE ucase(email) = ucase('" + login + "') "
                + "and senha = ucase('" + senha + "')";

        try {
            ps = mycon.prepareStatement(sql);
            return ps.executeQuery();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar usuário!" + err.getMessage());
            return null;
        }
    }

    public ResultSet buscartodos() {
        sql = "SELECT * FROM USUARIOS ORDER BY nome ";
        try {
            ps = mycon.prepareStatement(sql);
            return ps.executeQuery();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar usuário!"
                    + err.getMessage());
            return null;
        }
    }
    
    public ResultSet buscar(Usuario obj) {
// para buscar um registro especifico cria-se um sql com um parãmetro chave
// no caso a busca está sendo feita pelo cpf do usuario
        sql = "SELECT * FROM USUARIOS WHERE CPF = ?";
        try { // liga o sql com a conexão atraveś do objeto ps
            ps = mycon.prepareStatement(sql);
// configura o único parametro existente
            ps.setString(1, obj.getCpf());
// retorna o registro selecionado
            return ps.executeQuery();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar usuário!"
                    + err.getMessage());
            return null;
        }
    }
    
    public void excluir(String cpf) {
// configura o comando sql de exclusão delete por cpf
        sql = "DELETE FROM USUARIOS WHERE CPF = '" + cpf + "'";
        try { // envia o comando sql para dentro da conexão através deps 
            ps = mycon.prepareStatement(sql);
// executa o comando delete dentro do mysql
            ps.execute();
            ps.close(); // fecha o objeto usado para executar o comando sql
            JOptionPane.showMessageDialog(null,"Registro Excluido com Sucesso"
                    + "!");
} catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir usuário!"
                    + err.getMessage());
        }
    }
    


 
  }
    
    
   

