package model;

import java.sql.Date;

/**
 * @author fsens
 */
public class Produto {

    private int codigo;
    private String nome;
    private float peso;
    private Date validade;
    private boolean disponivel;
    private String tipo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "\nCódigo: " + codigo 
                + "\nNome: " + nome 
                + "\nTipo: " + tipo 
                + "\nPeso: " + peso 
                + "\nDisponivel: " + isDisponivel();     
    }
    
    

}
