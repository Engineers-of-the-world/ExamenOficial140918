
import com.mycompany.modell.Venta;
import com.mycompany.controllerimpl.VentaCtrlImpl;
import java.util.ArrayList;
import com.mycompany.dao.VentaDAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ANDY
 */
public class TestVenta {
    static ArrayList<Venta> list = new ArrayList<>();
    
    public static void main(String[] args) {
        VentaDAO catdao;
        catdao = new VentaCtrlImpl();
        /*list = catdao.readCategoria();
        for(Categoria item: list){
            System.out.println(""+item.getName_cat());
        }*/
        Venta cat = new Venta();
        cat.setId_venta("3");
        cat.setFecha("2019-02-02");
        cat.setConcepto("ss");
        cat.setIgv("2");
        cat.setTotal("12");
        cat.setSub_total("12");
        cat.setId_cliente_direccion("3");
         cat.setId_vendedor("3");
        if(catdao.createVenta(cat)){
            System.out.println("insertado");
        }else{
            System.out.println("error al momento de insertar");
        }
    }
    
}