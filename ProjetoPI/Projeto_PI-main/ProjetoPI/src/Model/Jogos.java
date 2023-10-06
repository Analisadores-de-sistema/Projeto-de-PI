/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class Jogos {
    private int idJogo;
    private String nome;
    private int idadeClassificada;
    private String anoLançamento;
    private String produtora;
    private String plataforma;
    private Loja loja;
    private TipoGenero tg;

     public Loja getLoja() {
       return loja;
    }

    public TipoGenero getTg() {
        return tg;
    }
      
    public int getIdJogo() {
        return idJogo;
    }


    public void setIdJogo(int idJogo) {
        this.idJogo = idJogo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdadeClassificada() {
        return idadeClassificada;
    }

    public void setIdadeClassificada(int idadeClassificada) {
        this.idadeClassificada = idadeClassificada;
    }

    public String getAnoLançamento() {
        return anoLançamento;
    }

    public void setAnoLançamento(String anoLançamento) {
        this.anoLançamento = anoLançamento;
    }

    public String getProdutora() {
        return produtora;
    }

    public void setProdutora(String produtora) {
        this.produtora = produtora;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }
    
}
