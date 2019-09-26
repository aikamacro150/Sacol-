/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import dao.DaoSacole;
import javax.swing.JOptionPane;
import modelo.Sacole;
import tela.manutencao.ManutencaoSacole;


/**
 *
 * @author Administrador
 */
public class ControladorSacole {
public static void inserir(ManutencaoSacole man){
        Sacole objeto = new Sacole();
        objeto.setSabor(man.jtfsabor.getText());
        objeto.setData_de_validade(man.jtfdata_d_validade.getText());
        objeto.setPreco(Double.parseDouble(man.jtfpreco.getText()));
        objeto.setNr_de_serie(Integer.parseInt(man.jtfnm_d_serie.getText()));
        
        boolean resultado = DaoSacole.inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
}
   
    
}
