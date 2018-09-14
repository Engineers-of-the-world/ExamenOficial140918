/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.modell.Producto;
import java.util.ArrayList;


/**
 *
 * @author ANDY
 */

public interface ProductoDAO {
    public boolean createProducto(Producto cat);
    public ArrayList<Producto> readProducto();
    public boolean updateProducto(Producto cat);
    public boolean deleteProducto(String id);
    
}