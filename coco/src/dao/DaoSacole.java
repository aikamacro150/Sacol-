/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Sacole;

/**
 *
 * @author Administrador
 */
public class DaoSacole {
     public static boolean inserir(Sacole objeto) {
        String sql = "INSERT INTO sacole (sabor, data_d_validade, preco, nr_d_serie) VALUES (?, ?)";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getSabor());
            ps.setString(2, objeto.getData_de_validade());
            ps.setDouble(3, objeto.getPreco());
            ps.setInt(4, objeto.getNr_de_serie());
            ps.setDate(5, Date.valueOf(objeto.getData_de_validade()));
            
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
     public static void main(String[] args) {
        Sacole objeto = new Sacole();
        objeto.setSabor("Escuro");
        objeto.setData_de_validade("10/2/2019");
        objeto.setNr_de_serie(344);
        objeto.setPreco(3.2);
        
        
        boolean resultado = inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
}
