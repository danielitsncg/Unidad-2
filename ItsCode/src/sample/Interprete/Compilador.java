package sample.Interprete;

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
              }else {
                  tipoToken= AMORTIGUADOR;}
              Token token = new Token(tipoToken,arreglo[1].trim());
              arrayToken.add(token);
          }else {
              this.consola.appendText("\n La pieza con el ID "+arreglo[1]+" ya esta asignada");
          }

      }else if (renglon.contains("buscar")){
          int i1=renglon.indexOf('(')+1;
          int i2=renglon.indexOf(')');
          String texto=renglon.substring(i1,i2);
          ImageView imageView = new ImageView("/sample/Imagenes/pollo.gif");
          pane.getChildren().add(imageView);
          consola.appendText("\n Buscando la pieza "+texto);

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

}
