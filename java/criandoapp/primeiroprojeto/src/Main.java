import java.util.Arrays;
public class Main {
    public static void String (String[] args) {
                String separador = "-_";
        System.out.println("Esse é o Screen Match");
        System.out.println("Filme: Top Gun: Maverick");
        String nomeDoFilme ="Top Gun: Maverick";
        int anoDeLamcamento = 2022;
        System.out.println("Ano de lançamento: "+anoDeLamcamento);
        double notaDoFilme = 8.1;
        double[] notas = {notaDoFilme,9.8, 6.3,8.0} ;
        double mediaDaNotaDoFilme = (Arrays.stream(notas).sum()/notas.length);
        System.out.println("A soma do Array: "+mediaDaNotaDoFilme);
        System.out.println(separador.repeat(30));
        String textoUnificado ="""
                  Em um dia chuvoso, fui assistir o filme %s.
                  Um filme lançado em %s e com a nota de linkes: %.2f.
                                  Bom filme e aproveite o final de semana!!!
                """.formatted(nomeDoFilme, anoDeLamcamento, mediaDaNotaDoFilme);
        System.out.println(textoUnificado);
    }
}