package csci2020u.lab09;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class GetStock {
    private static String urlStock;
    private static float[] closingVal;

    GetStock (String stockSymbol) {
        urlStock = stockSymbol;
    }

    public static float[] getClosingVal() {
        return closingVal;
    }

    public static void downloadStockPrices() {
        String url = "https://query1.finance.yahoo.com/v7/finance/download/" + urlStock + "?period1=1262322000&period2=1451538000&interval=1mo&events=history&includeAdjustedClose=true";
        String line = "";
        int index = 0;

        try {
            URL csv = new URL(url);
            URLConnection urlConnection = csv.openConnection();
            Scanner input = new Scanner(urlConnection.getInputStream());

            String[][] data = new String[72][7];
            closingVal = new float[72];
            line = input.nextLine();

            while(input.hasNextLine()) {

                line = input.nextLine();
                String[] values = line.split(",");

                System.arraycopy(values, 0, data[index], 0, 7);
                closingVal[index] = Float.parseFloat(data[index][4]);
                index++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
