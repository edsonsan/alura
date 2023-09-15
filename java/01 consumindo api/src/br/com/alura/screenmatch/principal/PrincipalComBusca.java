package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite um filme para busca: ");
        var busca = leitura.nextLine();
        String urlbase = "https://www.omdbapi.com/?t=";
        String token = "&apikey=6585022c";
        URL endereco = new URL(urlbase + URLEncoder.encode(busca)+token);
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.valueOf(endereco)))
                .build();
            HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            System.out.println("Acessando: "+endereco);
            System.out.println(json);
            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
            TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
            System.out.println(meuTituloOmdb);
            Titulo meuTitulo = new Titulo(meuTituloOmdb);
            System.out.println("-".repeat(30));
            System.out.println(meuTitulo);
            FileWriter escrita = new FileWriter("filmes.txt");
            escrita.write(meuTitulo.toString());
            escrita.close();
        }catch (NumberFormatException e){
            System.out.println("Erro inesperado, MSG: "+e.getMessage());
        }catch (IllegalArgumentException e){
            System.out.println("Erro de Argumento na Busca, verifique o endereço. "+ e.getMessage());
        }

        System.out.println("Fim do Programa.");

    }
}
