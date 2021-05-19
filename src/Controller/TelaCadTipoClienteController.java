/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.TypesDAO;
import Model.Type;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author thi_s
 */
public class TelaCadTipoClienteController implements Initializable {
    
    TypesDAO type;

    @FXML
    private Pane PaneCabecalho;
    @FXML
    private TextField tfnameType;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         type = new TypesDAO();
    }    

    @FXML
    private void recordNameType(ActionEvent event) {
        try{
            Type newType = new Type();
            newType.setName(tfnameType.getText());
            type.add(newType);
            System.out.println(newType);
        } catch (Exception ex) {
            Logger.getLogger(TelaCadUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
