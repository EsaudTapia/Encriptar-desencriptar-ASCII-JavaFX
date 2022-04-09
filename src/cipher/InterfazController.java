package cipher;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.objects.NativeString.indexOf;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class InterfazController implements Initializable {

    @FXML
    private Button btnCerrar;
    @FXML
    private Button btnCodificar;
    @FXML
    private Button btnDecodificar;
    @FXML
    private TextField txtClave;
    @FXML
    private TextArea txtMensaje;

    double xOffset = 0;
    double yOffset = 0;
    Stage primaryStage;

    private ObservableList<String> acciones;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        int c = 0;

    }

    @FXML
    private void comprobarparaCodificar(ActionEvent event) {
        String clave, mensaje, resultado = "";
        clave = this.txtClave.getText();
        mensaje = this.txtMensaje.getText();

        if (!clave.equals("") && !mensaje.equals("")) {
            this.txtMensaje.setText(this.codificar(clave, mensaje, resultado));

        } else {
            JOptionPane.showMessageDialog(null, "Exiten campos vacios, no se puede codificar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    private void comprobarparaDecodificar(ActionEvent event) {
        String clave, mensaje, resultado = "";
        clave = this.txtClave.getText();
        mensaje = this.txtMensaje.getText();

        if (!clave.equals("") && !mensaje.equals("")) {
            this.txtMensaje.setText(this.decodificar(clave, mensaje, resultado));

        } else {
            JOptionPane.showMessageDialog(null, "Exiten campos vacios, no se puede decodificar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String codificar(String clave, String mensaje, String resultado) {

        char[] palabras = mensaje.toCharArray();
        char[] claveP = clave.toCharArray();
        char[] textoCifrado = new char[palabras.length];
        int aux;
        for (int i = 0; i < claveP.length; i++) {

            for (int j = 0; j < palabras.length; j++) {
                //Convertimos cada caracter del arreglo a su correspondiente número ASCII y le 
                //sumamos el desplazamiento por cada una de las letras de la clave.

                aux = Integer.valueOf(palabras[j]) + Integer.valueOf(claveP[i]);
                //Convertimos el número resultante a caracter y lo guardamos en el arreglo.
                textoCifrado[j] = (char) aux;

            }

        }
        for (int x = 0; x < textoCifrado.length; x++) {
            resultado += (textoCifrado[x]);
        }
       
        return resultado;
    }

    private String decodificar(String clave, String mensaje, String resultado) {
        char[] palabras = mensaje.toCharArray();
        char[] claveP = clave.toCharArray();
        char[] textoCifrado = new char[palabras.length];
        int aux;
        for (int i = 0; i < claveP.length; i++) {

            for (int j = 0; j < palabras.length; j++) {
                //Convertimos cada caracter del arreglo a su correspondiente número ASCII y le 
                //sumamos el desplazamiento por cada una de las letras de la clave.

                aux = Integer.valueOf(palabras[j]) - Integer.valueOf(claveP[i]);
                //Convertimos el número resultante a caracter y lo guardamos en el arreglo.
                textoCifrado[j] = (char) aux;

            }

        }
        for (int x = 0; x < textoCifrado.length; x++) {
            resultado += (textoCifrado[x]);
        }
       
        return resultado;
    }

    @FXML
    private void cerrarLog(ActionEvent event) {
        Stage ventana = (Stage) btnCerrar.getScene().getWindow();
        ventana.close();
    }

    @FXML
    private void MoverVentana(MouseEvent event) {
        primaryStage.setX(event.getScreenX() + xOffset);
        primaryStage.setY(event.getScreenY() + yOffset);
    }

    @FXML
    private void ObtenerXY(MouseEvent event) {
        primaryStage = (Stage) this.btnCerrar.getScene().getWindow();
        xOffset = primaryStage.getX() - event.getScreenX();
        yOffset = primaryStage.getY() - event.getScreenY();
    }

}
