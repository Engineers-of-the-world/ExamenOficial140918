
import com.mycompany.modell.Producto;
import com.mycompany.controllerimpl.ProductoCtrlImpl;
import java.util.ArrayList;
import com.mycompany.dao.ProductoDAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ANDY
 */
public class TestProducto {
    static ArrayList<Producto> list = new ArrayList<>();
    
    public static void main(String[] args) {
        ProductoDAO catdao;
        catdao = new ProductoCtrlImpl();
        /*list = catdao.readCategoria();
        for(Categoria item: list){
            System.out.println(""+item.getName_cat());
        }*/
        Producto cat = new Producto();
        cat.setId_producto("3");
        cat.setId_categoria("2");
        cat.setId_unimed("2");
        cat.setNombre("andy");
        cat.setDescripcion("zapatos");
        cat.setCodigo("12345");
        if(catdao.createProducto(cat)){
            System.out.println("insertado");
        }else{
            System.out.println("error al momento de insertar");
        }
    }
    
}