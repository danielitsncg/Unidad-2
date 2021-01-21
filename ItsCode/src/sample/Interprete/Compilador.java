package sample.Interprete;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import static sample.Interprete.TiposToken.*;

public class Compilador {
    String texto="";
    private TextArea consola;
    private VBox pane;

    public Compilador(TextArea tx,VBox pane){
        this.consola=tx;
        this.pane=pane;
    }
    public boolean compilar(String renglon){
      boolean errores=false;
      if (renglon.contains("print")){
          int i1=renglon.indexOf('(')+1;
          int i2=renglon.length()-1;
          String texto=renglon.substring(i1,i2);
          this.consola.appendText("\n "+texto);
      }else if (renglon.contains("ingresar")){
          String[] arreglo=renglon.split(" ");
          System.out.println(renglon);
          if (!validar(arreglo[1].trim())){
              String tipoToken="";
              if (arreglo[3].equals("puerta")){
                  tipoToken = PUERTA;
              }else if (arreglo[3].contains("llanta")){
                  tipoToken= LLANTA;
              }else if (arreglo[3].contains("amortiguador")){
                  tipoToken= AMORTIGUADOR;
              }else if (arreglo[3].contains("rin")){
                  tipoToken= RIN;
              }
              Token token = new Token(tipoToken,arreglo[1].trim());
              arrayToken.add(token);
          }else {
              this.consola.appendText("\n La pieza con el ID "+arreglo[1]+" ya esta asignada");
          }

      }else if (renglon.contains("buscar")){
          int i1=renglon.indexOf('(')+1;
          int i2=renglon.indexOf(')');
          String texto=renglon.substring(i1,i2);
          if (validar(texto)){

              Token t1=buscarToken(texto);
              System.out.println(t1.getModelo());
              System.out.println(t1.getPieza());
              System.out.println(t1.getModelo());
              ImageView imageView = new ImageView("/sample/Imagenes/pollo.gif");
              Label label = new Label("Buscando la pieza "+ t1.getPieza());
              pane.getChildren().add(imageView);
              pane.getChildren().add(label);
          }else {
              ImageView imageView = new ImageView("/sample/Imagenes/vacio.gif");
              pane.getChildren().add(imageView);
              this.consola.appendText("\n la pieza con el nombre "+texto+" no se encuentra disponible");
          }

      }
      return errores;
    }
    public boolean validar(String nombre){
        boolean existe=false;
        for (int x=0;x<arrayToken.size();x++){
            if (arrayToken.get(x).getModelo().equals(nombre)){
                existe=true;
            }
        }
        return existe;
    }
    public Token buscarToken(String nombre){
        Token existe=null;
        for (int x=0;x<arrayToken.size();x++){
            if (arrayToken.get(x).getModelo().equals(nombre)){
             return arrayToken.get(x);
            }
        }
        return existe;
    }
}
