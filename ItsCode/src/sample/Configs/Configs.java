package sample.Configs;

import java.util.regex.Pattern;

public class Configs {
    public static final String[] KEYWORDS = new String[] {

            //modelos
            "Honda_Accord","Italika_250z","Nissan_Tsuru","Honda_CRF250","Nissan_March","Subaru_WRX",
            "Kawasaki_KLX_230R","Nissan_Altima","Nissan_Versa","Harley_Davidson_Road_King","Ford_Fiesta",
            "Yamaha_XTZ_150","Dodge_Durango","Honda_Civic_Coupe","BMW_F_900_XR","Nissan_370Z","Chevrolet_Spark",

            //piezas
            "puerta","puertas","llanta","llantas","parabrisa","parabrisas","rin","rines","amortiguador","amortiguadores","faro delantero",
            "faros delanteros","faro trasero","faros traseros",

            //color
            "negro","negros","negra","negras","naranja","naranjas","rojo","rojos","roja","rojas","azul","azules","amarillo","amarillos","amarilla",
            "amarillas","verde","verdes","rosa","rosas","dorado","dorados","dorada","doradas","blanco","blancos","blanca","blancas","cafe","cafes",
            "gris","grises",

            //estado
            "nueva","nuevo","nuevas","nuevos","seminueva","seminuevo",

            //cantidad
            "1","2","3","4","5","6","7","8","9","10",

            //palabras extra
            "y","de","color","como","modelo","print","ingresar","buscar",
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
            /*"2 x de modelo x",
            "3 rines x de modelo x",
            "1 faro delantero x",
            "4 llantas x de modelo Dodge_Durango",
            "1 parabrisa nuevo",
            "2 x de color x",
            "x amortiguadores x de modelo x",
            "2 x y 1 rin de modelo Nissan_Tsuru",
            "2 faros delanteros x",
            "1 puerta x de color x"*/

            "print(bienvenido a autopartes ncg)",
            "ingresar j324 como llanta",
            "buscar (puerta) de Dodge_Durango"
            //pendienton
    });
    public static String[] expresiones={
      /*"^(2) [\\w]+ (de) (modelo) [\\w]+",
            "[\\d]{1,} (rines) [\\w]{1,9} (de) (modelo) [\\w]+",
            "(1) [\\w ]+ [\\w]+",
            "[\\d]{1} (llantas) [\\w]+ (de modelo Dodge_Durango)",
            "^(1) [\\w]{9} (nuevo)",
            "^(2) [\\w]+ (de) (color) [\\w]",
            "[\\w]+ (amortiguadores) [\\w]+ (de) (modelo) [\\w]+",
            "^(2) [\\w]+ (y) [\\d]{1} [a-z]+ (de) (modelo) (Nissan_Tsuru)",
            "[\\d]{1} [a-z ]+ [\\w]+",
            "[\\d]{1} (puerta) [\\w]+ (de) (color) [\\w]+"*/
            "print[(][\\w ]+[)]",
            "ingresar [\\d\\w]+ como (llanta|amortiguador|puerta)",
            "buscar [(][\\w]+[)] (de) [\\w_]+"
    };
}
