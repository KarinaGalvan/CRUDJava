package Controlador;

import Modelo.ConsultasProducto;
import Modelo.Producto;
import Vista.DiseñoProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;



public class ControladorProducto implements ActionListener {
   private Producto pro;
   private DiseñoProducto frmpro;
   private ConsultasProducto proC;

    public ControladorProducto(Producto pro, DiseñoProducto frmpro, ConsultasProducto proC) {
        this.pro = pro;
        this.frmpro = frmpro;
        this.proC = proC;
        this.frmpro.btn_agregar.addActionListener((ActionListener) this);
        this.frmpro.btn_buscar.addActionListener((ActionListener) this);
        this.frmpro.btn_eliminar.addActionListener((ActionListener) this);
        this.frmpro.txt_panelPrincipal.addActionListener((ActionListener) this);
        this.frmpro.btn_modificar.addActionListener((ActionListener) this);
        this.frmpro.txt_panelPrincipal.addActionListener((ActionListener) this);        
    }   
    
    @Override

           
    public void actionPerformed(ActionEvent e) {
        /////// boton agregar//////
        if(e.getSource()==frmpro.btn_agregar){
            pro.setCodigo(frmpro.txt_Codigo.getText());
            pro.setNombre(frmpro.txt_nombre.getText());
            pro.setPrecio(Integer.parseInt(frmpro.txt_precio.getText()));
            if(proC.registrar(pro)){
                JOptionPane.showMessageDialog(null,"Producto agregado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null,"Error al agregar");
                limpiar();
            }
            
        }        
        /////// fin agregar //////
                
        /////// boton modificar //////
        if(e.getSource()==frmpro.btn_modificar){
            pro.setId(Integer.parseInt(frmpro.txt_id.getText()));
            pro.setCodigo(frmpro.txt_Codigo.getText());
            pro.setNombre(frmpro.txt_nombre.getText());
            pro.setPrecio(Integer.parseInt(frmpro.txt_precio.getText()));
            if(proC.modificar(pro)){
                JOptionPane.showMessageDialog(null,"Producto modificado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null,"Error al modificar");
                limpiar();
            }
        }
         /////// boton eliminar //////
        if(e.getSource()==frmpro.btn_eliminar){
            pro.setId(Integer.parseInt(frmpro.txt_id.getText()));
            if(proC.eliminar(pro)){
                JOptionPane.showMessageDialog(null,"Producto eliminado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null,"Error al eliminar");
                limpiar();
            }
        }
        /////// boton buscar //////
        if(e.getSource()==frmpro.btn_buscar){
            pro.setId(Integer.parseInt(frmpro.txt_id.getText()));
            if(proC.buscar(pro)){                
              frmpro.txt_id.setText(String.valueOf(pro.getId()));
              frmpro.txt_Codigo.setText(pro.getCodigo());
              frmpro.txt_nombre.setText(pro.getNombre());
              frmpro.txt_precio.setText(String.valueOf(pro.getPrecio()));              
            }else{
                JOptionPane.showMessageDialog(null,"Error al buscar");
                limpiar();
            }
        }// fin buscar/////
        
        ///Limpiar
        if(e.getSource()==frmpro.txt_panelPrincipal){
        limpiar();
        } 
    }// fin limpiar
         
    
    private void limpiar() {
       frmpro.txt_Codigo.setText(null);
       frmpro.txt_id.setText(null);
       frmpro.txt_nombre.setText(null);
       frmpro.txt_precio.setText(null);
       
    }
    }