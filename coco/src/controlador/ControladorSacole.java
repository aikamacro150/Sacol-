/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import dao.DaoSacole;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import modelo.Sacole;
import tela.manutencao.ManutencaoSacole;
import java.util.List;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrador
 */
public class ControladorSacole {
public static void inserir(ManutencaoSacole man){
        Sacole objeto = new Sacole();
        objeto.setSabor(man.jtfsabor.getText());
        objeto.setData_de_validade(LocalDate.parse(man.jtfdata_d_validade.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        objeto.setPreco(Double.parseDouble(man.jtfpreco.getText()));
        objeto.setNr_de_serie(Integer.parseInt(man.jtfnm_d_serie.getText()));
        
        boolean resultado = DaoSacole.inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
}

public static void alterar(ManutencaoSacole man){
        Sacole objeto = new Sacole();
        //definir todos os atributos
        objeto.setCodigo(Integer.parseInt(man.jtfcodigo.getText()));
        objeto.setSabor(man.jtfsabor.getText());
        objeto.setPreco(Double.parseDouble(man.jtfpreco.getText()));
        objeto.setData_de_validade(LocalDate.parse(man.jtfdata_d_validade.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        objeto.setNr_de_serie(Integer.parseInt(man.jtfnm_d_serie.getText()));
        
        boolean resultado = DaoSacole.alterar(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }    
public static void excluir(ManutencaoSacole man){
        Sacole objeto = new Sacole();
        objeto.setCodigo(Integer.parseInt(man.jtfcodigo.getText())); //só precisa definir a chave primeira
        
        boolean resultado = DaoSacole.excluir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
public static void atualizarTabela(JTable tabela) {
        DefaultTableModel modelo = new DefaultTableModel();
        //definindo o cabeçalho da tabela
        modelo.addColumn("Codigo");
        modelo.addColumn("sabor");
        modelo.addColumn("Numero_de_serie");
        modelo.addColumn("Preco");
        modelo.addColumn("Data_de_validade");
        List<Sacole> resultados = DaoSacole.consultar();
        for (Sacole objeto : resultados) {
            Vector linha = new Vector();
            
            //definindo o conteúdo da tabela
            linha.add(objeto.getCodigo());
            linha.add(objeto.getPreco());
            linha.add(objeto.getSabor());
            linha.add(objeto.getNr_de_serie());
            linha.add(objeto.getData_de_validade());
            modelo.addRow(linha); //adicionando a linha na tabela
        }
        tabela.setModel(modelo);
    }
}
