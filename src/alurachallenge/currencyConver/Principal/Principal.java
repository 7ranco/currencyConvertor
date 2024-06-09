package alurachallenge.currencyConver.Principal;

import alurachallenge.currencyConver.Models.ConsultApi;
import alurachallenge.currencyConver.Models.Converter;
import alurachallenge.currencyConver.Models.Currency;
import alurachallenge.currencyConver.Models.FileGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ConsultApi consult = new ConsultApi();
        Scanner reader = new Scanner(System.in);
        String usd = "USD";
        List<String> history = new ArrayList<>();


        while (true){
            String firstCurrency="", secondCurrency="";
            System.out.println("************************");
            System.out.println("--Conversiones disponibles--");
            System.out.println("1. Dolares(USD) a Peso Argentino(ARG)");
            System.out.println("2. Peso Argentino(ARG) a Dolares(USD)");
            System.out.println("3. Dolares(USD) a Boliviano boliviano(BOB)");
            System.out.println("4. Boliviano boliviano(BOB) a Dolares(USD)");
            System.out.println("5. Dolares(USD) a Real brasileño(BRL)");
            System.out.println("6. Real brasileño(BRL) a Dolares(USD)");
            System.out.println("7. Dolares(USD) a Peso chileno(CLP)");
            System.out.println("8. Peso chileno(CLP) a Dolares(USD)");
            System.out.println("9. Dolares(USD) a Peso colombiano(COP)");
            System.out.println("10. Peso colombiano(COP) a Dolares(USD)");
            System.out.println("0. Salir");
            System.out.println("Elige una opción válida: ");
            int option = reader.nextInt();
            if(option == 0){
                break;
            }
            switch (option){
                case 1:
                    firstCurrency = usd;
                    secondCurrency = "ARG";
                case 2:
                    firstCurrency = "ARG";
                    secondCurrency = usd;
                case 3:
                    firstCurrency = usd;
                    secondCurrency = "BOB";
                case 4:
                    firstCurrency = "BOB";
                    secondCurrency = usd;
                case 5:
                    firstCurrency = usd;
                    secondCurrency = "BRL";
                case 6:
                    firstCurrency = "BRL";
                    secondCurrency = usd;
                case 7:
                    firstCurrency = usd;
                    secondCurrency = "CLP";
                case 8:
                    firstCurrency = "CLP";
                    secondCurrency = usd;
                case 9:
                    firstCurrency = usd;
                    secondCurrency = "COP";
                case 10:
                    firstCurrency = "COP";
                    secondCurrency = usd;
            }
            try{

                Currency currency = consult.getCurrencys(firstCurrency,secondCurrency);

                System.out.println("Ingresa el valor que deseas convertir: ");
                float valueToConvert = reader.nextFloat();

                Converter converter = new Converter(valueToConvert,currency.conversion_rate());

                converter.operation();

                String res = converter.drawHistory(firstCurrency, secondCurrency);

                System.out.println(res);

                history.add(res);
            }catch (Exception e){
                System.out.println("Oh! Ah ocurrido un error!");
            }
        }
        try {
            FileGenerator generator = new FileGenerator();

            generator.saveJson(history);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }catch (Exception e){
            System.out.println("Algo ha salido mal!!" + e);
        }

    }
}
