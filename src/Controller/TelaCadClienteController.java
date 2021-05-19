/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ClientsDAO;
import DAO.TypesDAO;
import Model.Client;
import Model.Type;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author thi_s
 */
public class TelaCadClienteController implements Initializable {

    ClientsDAO client;
    TypesDAO type;
    
    @FXML
    private Pane PaneCabecalho;
    @FXML
    private TextField tfString;
    @FXML
    private TextField tfname;
    @FXML
    private ComboBox<Type> cbTypeClient;
            
    ObservableList<Type> lsTypes;  // define a collections que manterá os usuários cadastrados
    Type  typeSel; // mantém o produto selecionado no combobox
    int indiceSel; // guarda o índice do combobox selecionado

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        type = new TypesDAO();
       
        lsTypes = FXCollections.observableArrayList(type.getAllTypes());
         
        System.out.println(lsTypes);
        cbTypeClient.setItems(lsTypes); // atribui a lista observável ao combobox
    }

    @FXML
    private void recordNewClient(ActionEvent event) {
        
        client = new ClientsDAO();
         try{
            Client newClient = new Client();
            newClient.setName(tfname.getText());
            newClient.setTypeId(typeSel);
            newClient.setString(tfString.getText());

            client.add(newClient);
        } catch (Exception ex) {
            Logger.getLogger(TelaCadUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void select(ActionEvent event) {
         typeSel = cbTypeClient.getSelectionModel().getSelectedItem();
         System.out.println(typeSel);
    }

      
    
}
