/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.ProdutoDAO;
import java.util.ArrayList;
import model.Produto;

/**
 *
 * @author 94616
 */
public class Main {

    public static void main(String[] args) {
        /*Produto otoPoduto = new Produto();
        otoPoduto.setNome("omo");
        otoPoduto.setPeso(2.30f);
        otoPoduto.setTipo("Limpeza");
        otoPoduto.setDisponivel(true);
        new ProdutoDAO().inserir(otoPoduto);
        
        ArrayList<Produto> produtos= new ProdutoDAO().retornarTodos();
        for (Produto produto : produtos ){
            System.out.println(produto.getCodigo()+" - " + produto.getNome());*/

       Produto produto = new ProdutoDAO().buscarPorId(1);
        System.out.println(produto.toString());
        
        Produto uva = new Produto();
        uva.setCodigo(1);
        uva.setNome("uva");
        uva.setPeso(2.600f);
        uva.setTipo("Frutinha");
        uva.setDisponivel(false);
        new ProdutoDAO().alterar(uva);
        
        /*produto = new ProdutoDAO().buscarPorId(1);
        System.out.println(produto.toString());
        
        
        new ProdutoDAO().excluir(5);

        ArrayList<Produto> produtos = new ProdutoDAO().retornarTodos();
        for (Produto produto : produtos) {
            System.out.println(produto.getNome());*/

        }
    }


