package hr.assignment.rest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;

public class ExchangeRate {

    public static BigDecimal convertToUSD(BigDecimal valueEur) {

        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator(',');
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setDecimalFormatSymbols(symbols);
        decimalFormat.setParseBigDecimal(true);

        try {
            JSONObject data = fetch("https://api.hnb.hr/tecajn-eur/v3?valuta=USD");
            BigDecimal exchangeRate = (BigDecimal) decimalFormat.parse((String) data.get("srednji_tecaj"));
            return valueEur.divide(exchangeRate, 2, RoundingMode.HALF_UP);
        } catch (JSONException | IOException | NumberFormatException | ArithmeticException | ParseException e) {
            return BigDecimal.ZERO;
        }
    }

    public static JSONObject fetch(String url) throws IOException, JSONException {

        try (InputStream is = new URL(url).openStream()) {
            BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String jsonText = readAll(br);
            return new JSONObject(jsonText.replace("[", "").replace("]", ""));
        }
    }

    private static String readAll(Reader reader) throws IOException {

        StringBuilder sb = new StringBuilder();
        int i;
        while ((i = reader.read()) != -1) sb.append((char) i);
        return sb.toString();
    }
}
