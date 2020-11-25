package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {

    @FXML TextField txtTexto;
    @FXML ListView listaEjer;
    @FXML Label lblresultado;
    @FXML protected void initialize(){
        listaEjer.getItems().addAll("Ejercicio 1 ","Ejercicio 2 ","Validar Password","Una palabra que no comience con db-",
                "Una palabra termine con count","Validar que hayan escrito 2 nombres","Validar una MAC Address",
                "Validar que una palabra comience con mayuscula y termine con minuscula","Validar un numero binario de 8 digitos",
                "Validar que se haya escrito correctamente un numero hexadecimal","Validar operacion de 1 digito",
                "Validar que se ingrese correctamente el num de control del itsncg","Validar curp","Validar una cantidad de $",
                "Validar num de tarjeta de credito","Validar etiqueta html","Validar color hexadecimal","Validar un link",
                "Validar query insert de sql","Validar if","Validar frase con salto de linea","Validar url de video de youtube");
    }
    public void procesar(ActionEvent event){
        int seleccion = listaEjer.getSelectionModel().getSelectedIndex();
        String texto = txtTexto.getText();
        String expresion="";
        switch (seleccion){
            case 0:{
                expresion= "^[^_][^p]([a-zA-Z0-9]{3,})[q|w]$";
                break;
            }
            case 1:{
                expresion= "\\+[a-zA-Z]+";
                break;
            }
            case 2:{
                expresion= "[^1-9]([a-zA-Z0-9]{9,})";
                break;
            }
            case 3:{
                expresion="[^db-]([a-zA-Z]{8,})";
                break;
            }
            case 4:{
                expresion="([a-zA-Z]{5,}[(count)$])";
                break;
            }
            case 5:{
                expresion="[a-zA-Z]+ [a-zA-Z]+";
                break;
            }
            case 6: {
                expresion="[a-zA-Z0-9]{2}:[a-zA-Z0-9]{2}:[a-zA-Z0-9]{2}:[a-zA-Z0-9]{2}:[a-zA-Z0-9]{2}:[a-zA-Z0-9]{2}";
                break;
            }
            case 7: {
                expresion="^[A-Z][a-zA-Z]+[(a-z)$]";
                break;
            }
            case 8: {
                expresion="[0-1]{8}";
                break;
            }
            case 9: {
                expresion="[A-F0-9]+";
                break;
            }
            case 10: {
                expresion="[0-9]{1}[/|*|-|+][0-9]{1}";
                break;
            }
            case 11: {
                expresion="^[0-9]{2}(CG)[(0-9)$]{4}";
                break;
            }
            case 12: {
                expresion="[A-Z]{1}[AEIOU]{1}[A-Z]{1}[A-Z]{1}[0-9]{2}[0-9]{2}[0-9]{2}[H|M][A-Z]{2}[BCDFGHJKLMNÑPQRSTVWXYZ]{1}[BCDFGHJKLMNÑPQRSTVWXYZ]{1}[BCDFGHJKLMNÑPQRSTVWXYZ]{1}[0-9]{2}";
                break;
            }
            case 13: {
                expresion="^[$]([0-9]+)[.]([0-9]{2})(MXN$)";
                break;
            }
            case 14: {
                expresion="[0-9]{4} [0-9]{4} [0-9]{4} [0-9]{4}";
                break;
            }
            case 15: {
                //use esta "<html> <body> <h1>My First Heading</h1> <p>My first paragraph.</p> </body> </html>"
                expresion="^(<html>)[\\s](<body>)[\\s](<h1>)[\\w ]+(</h1>)[\\s](<p>)[\\w ]+[.](</p>)[\\s](</body>)[\\s](</html>)$";
                break;
            }
            case 16: {
                expresion="^(#)[a-fA-F\\d]{6}";
                break;
            }
            case 17: {
                expresion="^(http://)[a-z0-9]+[.](com)$";
                break;
            }
            case 18: {
                expresion="^(INSERT|insert) (INTO|into) [\\w]+ (VALUES|values) [(]['][\\w]+['][,][\\d]+[)][;]$";
            }
            case 19: {
                // "if (expresion!1) {System.out.println(Hola mundo)}else {System.out.println(Adios mundo)};"
                expresion="^(if)[\\s][(][\\w]+[=|==|!|<|>][\\w]+[)][\\s][{](System)[.](out)[.](println)[(][\\w ]+[)][}](else)[\\s][{](System)[.](out)[.](println)[(][\\w ]+[)][}][;]";
                break;
            }
            case 20: {
                expresion="[\\w]+[\\s](\\\\n)[\\s][\\w]+";
                break;
            }
            case 21: {
                //"https://www.youtube.com/watch?v=2V1fYJntoFA"
                expresion="^(https://)(www)[.](youtube)[.](com)[/](watch)[?](v)[=][\\w]+";
                break;
            }
        }
        Pattern patron= Pattern.compile(expresion);
        Matcher matcher = patron.matcher(texto);
        if (matcher.matches()){
            lblresultado.setText("Si Cumple");
        }else {
            lblresultado.setText("No cumple");
        }

    }
}

