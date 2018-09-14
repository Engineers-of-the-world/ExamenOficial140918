/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.controllerimpl.VentaCtrlImpl;
import com.mycompany.modell.Venta;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.mycompany.dao.VentaDAO;

/**
 *
 * @author ANDY
 */
@ManagedBean(name = "ventaCtrl")
@SessionScoped
public class VentaCtrl implements Serializable {

    private Venta selected;
    private boolean est;
    VentaDAO catdao;
    private ArrayList<Venta> list = new ArrayList<>();

    public VentaCtrl() {
        this.selected = new Venta();
        this.catdao = new VentaCtrlImpl();
    }

    public void createVenta() {        
        if (catdao.createVenta(selected)) {
            System.out.println("Error al momento de insertar");
        } else {
            System.out.println("Insertado");
        }
    }

    public ArrayList<Venta> getList() {
        list = catdao.readVenta();
        return list;
    }

    public void deleteVenta(String id){
        
        if (catdao.deleteVenta(id)) {
            System.out.println("Eliminado"+id);
        } else {
            System.out.println("Error al momento de eliminar");
        }
    }
    public Venta getSelected() {
        return selected;
    }

    public void setSelected(Venta selected) {
        this.selected = selected;
    }

}
