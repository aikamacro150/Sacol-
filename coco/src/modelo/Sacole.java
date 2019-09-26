/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Administrador
 */
public class Sacole {
    private Integer codigo;
     private String sabor;
      private String data_de_validade;
       private Double preco;
        private int nr_de_serie;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getData_de_validade() {
        return data_de_validade;
    }

    public void setData_de_validade(String data_de_validade) {
        this.data_de_validade = data_de_validade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public int getNr_de_serie() {
        return nr_de_serie;
    }

    public void setNr_de_serie(int nr_de_serie) {
        this.nr_de_serie = nr_de_serie;
    }

    @Override
    public String toString() {
        return "Sacole{" + "sabor=" + sabor + '}';
    }
}
