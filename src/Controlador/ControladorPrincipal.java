package Controlador;

import Vista.DiseñoPrincipal;
import Vista.DiseñoProducto;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ControladorPrincipal implements ActionListener {
    private DiseñoPrincipal frmPri;
    private DiseñoProducto frmPro;

    public ControladorPrincipal(DiseñoPrincipal frmPri, DiseñoProducto frmPro) {
        this.frmPri = frmPri;
        this.frmPro = frmPro;
        this.frmPri.menu_productos.addActionListener(this);
        this.frmPri.menu_salir.addActionListener(this);        
    }
public void inicar(){
    frmPro.setTitle("Producto");
    frmPri.setTitle("Principal");
    frmPri.setLocationRelativeTo(null);
    frmPro.setLocationRelativeTo(null);
    
}
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==frmPri.menu_productos){
            frmPro.setVisible(true);
            //frmPri.dispose();
        }
        
        if(e.getSource()==frmPri.menu_salir){
        System.exit(0);
    }
    }
    
}