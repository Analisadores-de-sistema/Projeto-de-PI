package Controller;

import Model.Jogo;
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

    public void incluir(Jogo obj) {
        sql = "INSERT INTO JOGOS VALUES (?, ?, ?, ?, ?, ?)";
        try {
            ps = mycon.prepareStatement(sql);
            ps.setInt(1, obj.getIdJogo());
            ps.setString(2, obj.getNome());
            ps.setString(3, obj.getTg());
            ps.setString(4, obj.getProdutora());
            ps.setString(5, obj.getPlataforma());
            ps.setString(6, obj.getIdadeClassificada());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Registro Incluído com Sucesso!");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao incluir jogo!" + err.getMessage());
        }
    }

    public ResultSet buscartodos() {
        sql = "SELECT * FROM JOGOS ORDER BY nome ";
        try {
            ps = mycon.prepareStatement(sql);
            return ps.executeQuery();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar jogo!"
                    + err.getMessage());
            return null;
        }
    }

    public ResultSet buscar(Jogo obj) {
// para buscar um registro especifico cria-se um sql com um parãmetro chave
// no caso a busca está sendo feita pelo cpf do usuario
        sql = "SELECT * FROM JOGOS WHERE id = ?";
        try { // liga o sql com a conexão atraveś do objeto ps
            ps = mycon.prepareStatement(sql);
// configura o único parametro existente
            ps.setString(1, obj.getNome());
// retorna o registro selecionado
            return ps.executeQuery();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar jogo!"
                    + err.getMessage());
            return null;
        }
    }

    public void excluir(String id) {
// configura o comando sql de exclusão delete por id
        sql = "DELETE FROM USUARIOS id id = '" + id + "'";
        try { // envia o comando sql para dentro da conexão através deps 
            ps = mycon.prepareStatement(sql);
// executa o comando delete dentro do mysql
            ps.execute();
            ps.close(); // fecha o objeto usado para executar o comando sql
            JOptionPane.showMessageDialog(null, "Registro Excluido com Sucesso"
                    + "!");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir jogo!"
                    + err.getMessage());
        }
    }

}
