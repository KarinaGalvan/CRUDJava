package crud;

import Controlador.ControladorPrincipal;
import Controlador.ControladorProducto;
import Modelo.ConsultasProducto;
import Modelo.Producto;
import Vista.DiseñoPrincipal;
import Vista.DiseñoProducto;
import Modelo.conexion;


public class main {
    public static void main(String[] args) {
        Producto pro =new Producto();
        ConsultasProducto proC = new ConsultasProducto();
        DiseñoProducto frmPro = new DiseñoProducto();
        ControladorProducto ctrlPro = new   ControladorProducto(pro,frmPro,proC);
        DiseñoPrincipal frmPri =new  DiseñoPrincipal();
        ControladorPrincipal ctrlPri = new ControladorPrincipal (frmPri,frmPro);
        ctrlPri.inicar();
        frmPri.setVisible(true);     
              
        }
    
}