package Donetsk;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class DonetskTr {
    private static Document document;

    public static String[] getDonetskTr(String period) {


        if (period.equals("На 5 дней \ud83c\udf86")) {
            try {
                document = Jsoup.connect("https://weather.com/ru-RU/weather/5day/l/09967a3efc295696927d2dfb04bfa3158dd01196d1224dd072bc6874666002c1").get();

            } catch (IOException e) {
                e.printStackTrace();


            }
        }

        String[] info = new String[20];
        Elements tab2 = document.getElementsByClass("region region-main");
        Elements tab3 = tab2.select("tr[class=clickable closed]");
        Elements tab4 = tab3.select("span[class=day-detail clearfix]"); // дата

        Elements tab5 = tab2.select("td[class=description]"); // Осадки

        Elements tab6 = tab2.select("td[class=temp]"); // Темп
        Elements tab7 = tab2.select("td[class=precip]"); // Осадки2
        Elements tab8 = tab2.select("td[class=wind]"); // дата
        Elements tab9 = tab2.select("td[class=humidity]"); // дПогодные условия






        for (int i = 0; i<tab4.size(); i++ ){
            if(i < 20) {
                info[i] =
                        "Погода в Донецке на : " + "\n\n"
                                + "" + tab4.get(i).text() + "\n\n"
                                + "" + tab5.get(i).text() + "\n"
                                + "Температура:" + tab6.get(i).text() +"\ud83c\udf21" + "\n"
                                + "Вероятность осадков:" + tab7.get(i).text() + "\n"
                                + "Ветер: " + tab8.get(i).text() + "\n"
                                + "Влажность :" + tab9.get(i).text() +"\ud83d\udca7"+ "\n";






            }

        }



        return info;


    }

}
