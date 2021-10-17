package Top;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;


public class Top {
    private static Document document;

    public static String[] getBLPagoda(String period) {


        if (period.equals("На сегодня \ud83c\udf07")) {
            try {
                document = Jsoup.connect("https://pogodnik.com/3229-pogoda-v-beloj-tserkvi-kievskaya-oblast-ukraina").get();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String[] info = new String[20];
        Elements tabl2 = document.select("div[class=city-weather-info__bottom clearfix]");
        Elements de2 = tabl2.select("div[class=col col-first]"); //
        Elements degree1 = de2.select("div[class=cur-time]"); // д

        Elements Dr = tabl2.select("div[class=cur-air-condition]");

        Elements mal = tabl2.select("div[class=col col-second]"); //
        Elements de3 = mal.select("div[class=col col-second]"); // cur-temperature
        Elements degree2 = de3.select("div[class=cur-temperature]");


        Elements dav3 = tabl2.select("div[class=col col-third]"); //
        Elements dav = dav3.select("div[class=col col-third]"); //
        Elements degree3 = dav.select("div[class=cur-pressure]");

        Elements dav4 = tabl2.select("div[class=col col-third]"); //
        Elements degree4 = dav4.select("div[class=cur-humidity]"); //


        Elements dav5 = tabl2.select("div[class=col col-third]"); //
        Elements degree5 = dav5.select("div[class=cur-wind]");

        ///---------------------------------//





        for (int i = 0; i < degree1.size(); i++) {
            if(i < 20) {
                info[i] =
                        "Погода в Белоц Церкви :" + "\n"
                                + " " + degree1.get(i).text() + "\n\n"
                                + "Температура:" + degree2.get(i).text() + "\n"
                                + "" + degree3.get(i).text() + "\n"
                                + "" + degree4.get(i).text() + "\n"
                                + "" + degree5.get(i).text() + "\n"
                                + "" + Dr.get(i).text()+"\n";




            }

            }


        return info;

        }




    }


