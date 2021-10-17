package Gorlovka;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class GorlovkaY {

    private static Document document;

    public static String[] getGorlovkaY(String period) {


        if (period.equals("На сегодня \ud83c\udf87")) {
            try {
                document = Jsoup.connect("https://pogodnik.com/2375-pogoda-v-gorlovke-donetskaya-oblast-ukrainaa").get();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        String[] info = new String[20];
        Elements Gr = document.select("div[class=city-weather-info__bottom clearfix]");
        Elements Gr2 = Gr.select("div[class=col col-first]"); //
        Elements degr10 = Gr2.select("div[class=cur-time]"); // д

        Elements Dr = Gr.select("div[class=cur-air-condition]");

        Elements Gr3 = Gr.select("div[class=col col-second]"); //
        Elements Gr4 = Gr3.select("div[class=col col-second]"); // cur-temperature
        Elements degr11 = Gr4.select("div[class=cur-temperature]");


        Elements Gr5 = Gr.select("div[class=col col-third]"); //
        Elements Gr6 = Gr5.select("div[class=col col-third]"); //
        Elements degr12 = Gr6.select("div[class=cur-pressure]");

        Elements Gr7 = Gr.select("div[class=col col-third]"); //
        Elements degr13 = Gr7.select("div[class=cur-humidity]"); //


        Elements Gr8 = Gr.select("div[class=col col-third]"); //
        Elements degr14 = Gr8.select("div[class=cur-wind]");

        ///---------------------------------//





        for (int i = 0; i < degr10.size(); i++) {
            if(i < 20) {
                info[i] =
                        "Погода в Горловке :" + "\n"
                                + " " + degr10.get(i).text() + "\n\n"
                                + "Температура:" + degr11.get(i).text() + "\n"
                                + "" + degr12.get(i).text() + "\n"
                                + "" + degr13.get(i).text() + "\n"
                                + "" + degr14.get(i).text() + "\n"
                                + "" + Dr.get(i).text()+"\n";



            }

        }



        return info;

    }
}
