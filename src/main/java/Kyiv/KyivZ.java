package Kyiv;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class KyivZ {

    private static Document document;

    public static String[] getKyivZPagoda(String period) {



        if (period.equals("Завтра \ud83c\udf03")) {
            try {
                document = Jsoup.connect("https://pogodnik.com/1934-pogoda-v-kieve-ukraina/tomorrow").get();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        String[] info = new String[20];
        Elements KV1 = document.getElementsByClass("active");
        Elements KV2 = KV1.select("div[class=info clearfix]");
        Elements KV3 = KV2.select("div[class=date]");
////______________________________________

        Elements KV4 = document.getElementsByClass("top");
        Elements KV5 = KV4.select("div[class=min-max-temperature clearfix]");
        Elements KV6 = KV5.select("div[class=min]");
        Elements KV7 = KV5.select("div[class=max]");

        Elements KV8 = document.getElementsByClass("day-weather-detail__col-left");
        Elements KV9 = KV8.select("div[class=precipitation2]");
        Elements KV10= KV8.select("div[class=pressure]");
        Elements KV11= KV8.select("div[class=humidity]");
        Elements KV12= KV8.select("div[class=wind]");

        Elements KV13 = document.getElementsByClass("top");
        Elements KV14 = KV13.select("div[class=air-condition]");







        for (int i = 0; i<KV3.size(); i++ ){
            if(i < 20) {
                info[i] =
                        "Погода в Киеве :" + "\n"
                                + "" + KV3.get(i).text() + "\n\n\n"
                                + "Температура: " + KV6.get(i).text() + ""// макс
                                + "/ " + KV7.get(i).text() + "\n"  // мин
                                + "" + KV9.get(i).text() + "\u2602\ufe0f"+"\n" // осадки
                                + "" + KV10.get(i).text() + "\n"// давление
                                + "" + KV11.get(i).text() + "\ud83d\udca7"+"\n"// влажносьб
                                + "" + KV12.get(i).text() + "\ud83d\udca8"+"\n" // ветер
                                + "" + KV14.get(i).text() + "\n";// облака


            }

        }


        return info;
    }


}
