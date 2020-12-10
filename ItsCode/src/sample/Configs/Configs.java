package sample.Configs;

import java.util.regex.Pattern;

public class Configs {
    public static final String[] KEYWORDS = new String[] {

            //modelos
            "Honda Accord 2010","Italika 250z 2015","Nissan Tsuru 1995","Honda CRF250 2018","Nissan March 2018","Subaru WRX STi 2008",
            "Kawasaki KLX 230R 2020","Nissan Altima 2005","Nissan Versa 2018","Harley Davidson Road King 2020","Ford Fiesta 2005",
            "Yamaha XTZ-150 2020","Dodge Durango 2012","Honda Civic Coupe 2018","BMW F 900 XR","Nissan 370Z Nismo 2020","Chevrolet Spark 2015",

            //piezas
            "puerta","puertas","llanta","llantas","parabrisa","parabrisas","rin","rines","amortiguador","amortiguadores","faro delantero",
            "faros delanteros","faro trasero","faros traseros",

            //color
            "Negro","Negros","Negra","Negras","Naranja","Naranjas","Rojo","Rojos","Roja","Rojas","Azul","Azules","Amarillo","Amarillos","Amarilla",
            "Amarillas","Verde","Verdes","Rosa","Rosas","Dorado","Dorados","Dorada","Doradas","Blanco","Blancos","Blanca","Blancas","Cafe","Cafes",
            "Gris","Grises",

            //estado
            "nueva","nuevo","nuevas","nuevos","seminueva","seminuevo",

            //cantidad
            "1","2","3","4","5","6","7","8","9","10",

            //palabras extra
            "y","de","color","modelo"
    };

    public static final String KEYWORD_PATTERN = "\\b(" + String.join("|", KEYWORDS) + ")\\b";
    public static final String PAREN_PATTERN = "\\(|\\)";
    public static final String BRACE_PATTERN = "\\{|\\}";
    public static final String BRACKET_PATTERN = "\\[|\\]";
    public static final String SEMICOLON_PATTERN = "\\;";
    public static final String STRING_PATTERN = "\"([^\"\\\\]|\\\\.)*\"";
    public static final String COMMENT_PATTERN = "//[^\n]*" + "|" + "/\\*(.|\\R)*?\\*/";

    public static final Pattern PATTERN = Pattern.compile(
            "(?<KEYWORD>" + KEYWORD_PATTERN + ")"
                    + "|(?<PAREN>" + PAREN_PATTERN + ")"
                    + "|(?<BRACE>" + BRACE_PATTERN + ")"
                    + "|(?<BRACKET>" + BRACKET_PATTERN + ")"
                    + "|(?<SEMICOLON>" + SEMICOLON_PATTERN + ")"
                    + "|(?<STRING>" + STRING_PATTERN + ")"
                    + "|(?<COMMENT>" + COMMENT_PATTERN + ")"
    );

    public static final String sampleCode = String.join("\n", new String[] {
            "2 x de modelo x",
            "3 rines x de modelo x",
            "1 faro delantero x",
            "4 llantas x de modelo Dodge Durango 2012",
            "1 parabrisa nuevo",
            "2 x de color x",
            "x amortiguadores x de modelo x",
            "2 x y 1 rin de modelo Nissan Tsuru 1995",
            "2 faros delanteros x",
            "1 puerta x de color x"
    });
    public static String[] expresiones={
      "^(2) [\\w]+ (de) (modelo) [\\w]+",
            "[\\d]{1,} (rines) [\\w]{1,9} (de) (modelo) [\\w]+",
            "(1) [\\w ]+ [\\w]+",
            "[\\d]{1} (llantas) [\\w]+ (de modelo Dodge Durango 2012)",
            "^(1) [\\w]{9} (nuevo)",
            "^(2) [\\w]+ (de) (color) [\\w]",
            "[\\w]+ (amortiguadores) [\\w]+ (de) (modelo) [\\w]+",
            "^(2) [\\w]+ (y) [\\d]{1} [a-z]+ (de) (modelo) (Nissan Tsuru 1995)",
            "[\\d]{1} [a-z ]+ [\\w]+",
            "[\\d]{1} (puerta) [\\w]+ (de) (color) [\\w]+"
    };
}
