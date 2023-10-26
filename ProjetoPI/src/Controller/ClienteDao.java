package Controller;

import Model.Cliente;
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

public class ClienteDao extends ConectarDao {

    private PreparedStatement ps;

    public ClienteDao() {
        super();
    }

    public void incluir(Cliente obj) {
        sql = "INSERT INTO CLIENTES VALUES (?, ?, ?, ?, ?)";
        try {
            ps = mycon.prepareStatement(sql);
            ps.setString(1, obj.getCpf());
            ps.setString(2, obj.getNome());
            ps.setString(3, obj.getEmail());
            ps.setString(4, obj.getTelefone());
            ps.setString(5, obj.getEndereco());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Registro Incluído com Sucesso!");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao incluir cliente!" + err.getMessage());
        }
    }

    public ResultSet validarLogin(String login, String senha) {

        sql = "SELECT * , if(idnivel = 1, 'Gerente', 'Operador') as nivel "
                + "FROM CLIENTES WHERE ucase(email) = ucase('" + login + "') "
                + "and senha = ucase('" + senha + "')";

        try {
            ps = mycon.prepareStatement(sql);
            return ps.executeQuery();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Cliente!" + err.getMessage());
            return null;
        }
    }

    public ResultSet buscartodos() {
        sql = "SELECT * FROM CLIENTES ORDER BY nome ";
        try {
            ps = mycon.prepareStatement(sql);
            return ps.executeQuery();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Cliente!"
                    + err.getMessage());
            return null;
        }
    }
    
    public ResultSet buscar(Cliente obj) {
// para buscar um registro especifico cria-se um sql com um parãmetro chave
// no caso a busca está sendo feita pelo cpf do usuario
        sql = "SELECT * FROM CLIENTES WHERE CPF = ?";
        try { // liga o sql com a conexão atraveś do objeto ps
            ps = mycon.prepareStatement(sql);
// configura o único parametro existente
            ps.setString(1, obj.getCpf());
// retorna o registro selecionado
            return ps.executeQuery();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Cliente!"
                    + err.getMessage());
            return null;
        }
    }
    
    public void excluir(String cpf) {
// configura o comando sql de exclusão delete por cpf
        sql = "DELETE FROM CLIENTES WHERE CPF = '" + cpf + "'";
        try { // envia o comando sql para dentro da conexão através deps 
            ps = mycon.prepareStatement(sql);
// executa o comando delete dentro do mysql
            ps.execute();
            ps.close(); // fecha o objeto usado para executar o comando sql
            JOptionPane.showMessageDialog(null,"Registro Excluido com Sucesso"
                    + "!");
} catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir Cliente!"
                    + err.getMessage());
        }
    }
    


 
  }
    
    
   

