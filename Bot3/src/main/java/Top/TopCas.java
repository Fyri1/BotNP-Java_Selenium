package Top;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class TopCas {
    private static Document document;

    public static String[] getTopCas(String period) {



        if (period.equals("Подробнее \ud83c\udf07")) {
            try {
                document = Jsoup.connect("https://world-weather.ru/pogoda/ukraine/bila_tserkva/24hours/").get();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        String[] info = new String[8];
        Elements GR1 = document.getElementsByClass("weather-today");  // дата на сегодня

////______________________________________


        Elements GR2 = GR1.select("tbody");
        Elements GR33 = GR2.select("tr[class=day hourly-1]");

        Elements GR4 = GR33.select("td[class=weather-day]");// время


        Elements GR5 = GR33.select("td[class=weather-temperature]");// температура
        Elements GR6 = GR33.select("td[class=weather-probability]");// осадки
        Elements GR7 = GR33.select("td[class=weather-humidity]");// давление

















        for (int i = 0; i<GR4.size(); i++ ){
            if(i < 8) {
                info[i] =
                        "Погода в В Белой Церкви :" + "\n"
                                + "" + GR4.get(i).text() + "\n\n"
                                + "Температура\ud83c\udf21" + GR5.get(i).text() + "\n"
                                + "Вер-ость осадков:" + GR6.get(i).text() + "\n"
                                + "Влажность\ud83d\udca7" + GR7.get(i).text() + "\n";







            }

        }


        return info;
    }

}


