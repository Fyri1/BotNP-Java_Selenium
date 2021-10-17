package Gorlovka;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class GorlovkaZ {

    private static Document document;

    public static String[] getGorlovkaZ(String period) {



        if (period.equals("Завтра \ud83c\udf87")) {
            try {
                document = Jsoup.connect("https://pogodnik.com/2375-pogoda-v-gorlovke-donetskaya-oblast-ukraina/tomorrow").get();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        String[] info = new String[20];
        Elements GR1 = document.getElementsByClass("active");
        Elements GR2 = GR1.select("div[class=info clearfix]");
        Elements GR3 = GR2.select("div[class=date]");
////______________________________________

        Elements GR4 = document.getElementsByClass("top");
        Elements GR5 = GR4.select("div[class=min-max-temperature clearfix]");
        Elements GR6 = GR5.select("div[class=min]");
        Elements GR7 = GR5.select("div[class=max]");

        Elements GR8 = document.getElementsByClass("day-weather-detail__col-left");
        Elements GR9 = GR8.select("div[class=precipitation2]");
        Elements GR10= GR8.select("div[class=pressure]");
        Elements GR11= GR8.select("div[class=humidity]");
        Elements R12 = GR8.select("div[class=wind]");

        Elements GR13 = document.getElementsByClass("top");
        Elements GR14 = GR13.select("div[class=air-condition]");







        for (int i = 0; i<GR3.size(); i++ ){
            if(i < 20) {
                info[i] =
                        "Погода в Горовке :" + "\n"
                                + "" + GR3.get(i).text() + "\n\n\n"
                                + "Температура: " + GR6.get(i).text() + ""// макс
                                + " / " + GR7.get(i).text() + "\n"  // мин
                                + "" + GR9.get(i).text() + "\u2602\ufe0f"+"\n" // осадки
                                + "" + GR10.get(i).text() + "\n"// давление
                                + "" + GR11.get(i).text() + "\ud83d\udca7"+"\n"// влажносьб
                                + "" + R12.get(i).text() + "\ud83d\udca8"+"\n" // ветер
                                + "" + GR14.get(i).text() + "\n";// облака


            }

        }


        return info;
    }

}
