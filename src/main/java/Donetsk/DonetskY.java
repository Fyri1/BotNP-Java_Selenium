package Donetsk;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class DonetskY {

    private static Document document;

    public static String[] getDonetskY(String period) {


        if (period.equals("На сегодня \ud83c\udf86")) {
            try {
                document = Jsoup.connect("https://pogodnik.com/3217-pogoda-v-donetske-ukraina").get();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String[] info = new String[20];
        Elements Dn = document.select("div[class=city-weather-info__bottom clearfix]");
        Elements Dn2 = Dn.select("div[class=col col-first]"); //
        Elements deg10 = Dn2.select("div[class=cur-time]"); // д

        Elements Dr = Dn.select("div[class=cur-air-condition]"); // Ясность

        Elements Dn3 = Dn.select("div[class=col col-second]"); //
        Elements Dn4 = Dn3.select("div[class=col col-second]"); // cur-temperature
        Elements deg11 = Dn4.select("div[class=cur-temperature]");


        Elements Dn5 = Dn.select("div[class=col col-third]"); //
        Elements Dn6 = Dn5.select("div[class=col col-third]"); //
        Elements deg12 = Dn6.select("div[class=cur-pressure]");

        Elements Dn7 = Dn.select("div[class=col col-third]"); //
        Elements deg13 = Dn7.select("div[class=cur-humidity]"); //


        Elements Dn8 = Dn.select("div[class=col col-third]"); //
        Elements deg14 = Dn8.select("div[class=cur-wind]");

        ///---------------------------------//





        for (int i = 0; i < deg10.size(); i++) {
            if(i < 20) {
                info[i] =
                        "Погода в Донецк :" + "\n"
                                + " " + deg10.get(i).text() + "\n\n"// сейчас
                                + "Температура:" + deg11.get(i).text() + "\n"
                                + "" + deg12.get(i).text() + "\n"
                                + "" + deg13.get(i).text() + "\n"
                                + "" + deg14.get(i).text() + "\n"
                                + "" + Dr.get(i).text()+"\n";



            }

        }


        return info;

    }
}
