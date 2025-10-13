/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onibus.view;

import onibus.control.Controller;

/**
 *
 * @author eduardo
 */
public class Principal {
    public static void main(String[] args) {
        Controller controlador = new Controller();
        SistemaView view = new SistemaView(controlador);
        
        view.exibirMenu();     
    }
}
