package sample.Interprete;

public class Token {
    private String pieza;
    private String modelo;
    private String color;
    private String estado;

    public Token(String pieza, String modelo, String color, String estado) {
        this.pieza = pieza;
        this.modelo = modelo;
        this.color = color;
        this.estado = estado;
    }

    public Token(String pieza, String modelo, String color) {
        this.pieza = pieza;
        this.modelo = modelo;
        this.color = color;
    }

    public Token(String pieza, String modelo) {
        this.pieza = pieza;
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPieza() {
        return pieza;
    }

    public void setPieza(String pieza) {
        this.pieza = pieza;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
