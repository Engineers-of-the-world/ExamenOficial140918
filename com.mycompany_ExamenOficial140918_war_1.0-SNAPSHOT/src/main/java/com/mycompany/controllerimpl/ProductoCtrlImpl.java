/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllerimpl;

import com.mycompany.modell.Producto;
import com.mycompany.configbd.Conexionbd;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mycompany.dao.ProductoDAO;

/**
 *
 * @author ANDY
 */
public class ProductoCtrlImpl implements ProductoDAO {

    Conexionbd cx;
    String sql;
    ResultSet rs;
    ArrayList<Producto> listDatos;

    public ProductoCtrlImpl() {
        cx = new Conexionbd();
    }

    @Override
    public boolean createProducto(Producto cat) {
        sql = "INSERT INTO public.producto(id_producto, id_categoria, id_unimed, nombre, descripcion, codigo) "
                + "VALUES("+cat.getId_producto()+",'"+cat.getId_categoria()+"', '"+cat.getId_unimed()+"','"+cat.getNombre()+"','"+cat.getDescripcion()+"','"+cat.getCodigo()+"')";
        return cx.executeInsertUpdate(sql);
    }

    @Override
    public ArrayList<Producto> readProducto() {
        listDatos = new ArrayList<>();
        sql = "SELECT id_producto, id_categoria, id_unimed, nombre, descripcion, codigo "
                + "    FROM public.producto";
        rs = cx.executeQuery(sql);
        try {
            while (rs.next()) {
                listDatos.add(new Producto(rs.getString("id_producto"),rs.getString("id_categoria"), rs.getString("id_unimed"), rs.getString("nombre"), rs.getString("descripcion"), rs.getString("codigo")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductoCtrlImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listDatos;
    }

    @Override
    public boolean updateProducto(Producto cat) {
        sql = "UPDATE public.producto SET "
                + " id_categoria = '"+cat.getId_categoria()+"', id_unimed = '"+cat.getId_unimed()+"', nombre = '"+cat.getNombre()+"', descripcion = '"+cat.getDescripcion()+"', codigo = '"+cat.getCodigo()+"' "
                + "WHERE id_producto = "+cat.getId_producto()+" ";
        return cx.executeInsertUpdate(sql);
    }

    @Override
    public boolean deleteProducto(String id) {
        sql = "DELETE FROM public.producto "
                + "WHERE id_producto = "+id+" ";
        return cx.executeInsertUpdate(sql);
    }

}
