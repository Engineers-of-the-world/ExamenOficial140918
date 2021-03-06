/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.controllerimpl.ProductoCtrlImpl;
import com.mycompany.modell.Producto;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.mycompany.dao.ProductoDAO;

/**
 *
 * @author ANDY
 */
@ManagedBean(name = "productoCtrl")
@SessionScoped
public class ProductoCtrl implements Serializable {

    private Producto selected;
    private boolean est;
    ProductoDAO catdao;
    private ArrayList<Producto> list = new ArrayList<>();

    public ProductoCtrl() {
        this.selected = new Producto();
        this.catdao = new ProductoCtrlImpl();
    }

    public void createProducto() {        
        if (catdao.createProducto(selected)) {
            System.out.println("Insertado");
        } else {
            System.out.println("Error al momento de insertar");
        }
    }

    public ArrayList<Producto> getList() {
        list = catdao.readProducto();
        return list;
    }

    public void deleteProducto(String id){
        
        if (catdao.deleteProducto(id)) {
            System.out.println("Eliminado"+id);
        } else {
            System.out.println("Error al momento de eliminar");
        }
    }
    public Producto getSelected() {
        return selected;
    }

    public void setSelected(Producto selected) {
        this.selected = selected;
    }

}
