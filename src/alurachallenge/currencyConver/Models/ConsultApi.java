package alurachallenge.currencyConver.Models;

import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultApi {
    public Currency getCurrencys(String firstCurrency, String secondCurrency){
        URI directory =URI.create("https://v6.exchangerate-api.com/v6/e2cef618a992856d742907d4/pair/"+ firstCurrency +"/" +secondCurrency);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(directory)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Currency.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
