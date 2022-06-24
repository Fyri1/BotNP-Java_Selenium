package Kyiv;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class KyivY {

    private static Document document;

    public static String[] getKVPagoda(String period) {


        if (period.equals("На сегодня \ud83c\udf03")) {
            try {
                document = Jsoup.connect("https://pogodnik.com/1934-pogoda-v-kieve-ukraina").get();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        String[] info = new String[20];
        Elements KiV = document.select("div[class=city-weather-info__bottom clearfix]");
        Elements KiV2 = KiV.select("div[class=col col-first]"); //
        Elements degree10 = KiV2.select("div[class=cur-time]"); // д

        Elements Dr = KiV.select("div[class=cur-air-condition]");


        Elements KiV3 = KiV.select("div[class=col col-second]"); //
        Elements KiV4 = KiV3.select("div[class=col col-second]"); // cur-temperature
        Elements degree11 = KiV4.select("div[class=cur-temperature]");


        Elements KiV5 = KiV.select("div[class=col col-third]"); //
        Elements KiV6 = KiV5.select("div[class=col col-third]"); //
        Elements degree12 = KiV6.select("div[class=cur-pressure]");

        Elements KiV7 = KiV.select("div[class=col col-third]"); //
        Elements degree13 = KiV7.select("div[class=cur-humidity]"); //


        Elements dKiV8 = KiV.select("div[class=col col-third]"); //
        Elements degree14 = dKiV8.select("div[class=cur-wind]");

        ///---------------------------------//








        for (int i = 0; i < degree10.size(); i++) {
            if(i < 20) {
                info[i]  =
                        "Погода в Киеве :" + "\n"
                                + " " + degree10.get(i).text() + "\n\n"
                                + "Температура:" + degree11.get(i).text() + "\n"
                                + "" + degree12.get(i).text() + "\n"
                                + "" + degree13.get(i).text() + "\n"
                                + "" + degree14.get(i).text() + "\n"
                                + "" + Dr.get(i).text()+"\n";




            }

        }



        return info;

    }
}
