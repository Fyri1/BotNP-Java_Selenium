package Lvov;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class LvovTr {

    private static Document document;

    public static String[] getTopTr(String period) {


        if (period.equals("На 5 дней \ud83c\udf07")) {
            try {
                document = Jsoup.connect("https://weather.com/ru-RU/weather/5day/l/9081424cb4d9fb2a62cd96aa04d1932ab80fe0079a646dd6c332158d04ebc24a").get();

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
                        "Погода в Белой Церкви на : " + "\n\n"
                                + "" + tab4.get(i).text() + "\n\n"
                                + "" + tab5.get(i).text() + "\n"
                                + "Температура:" + tab6.get(i).text() +"\ud83c\udf21" + "\n"
                                + "Вероятность осадков: " + tab7.get(i).text() + "\n"
                                + "Ветер: " + tab8.get(i).text() + "\n"
                                + "Влажность :" + tab9.get(i).text() +"\ud83d\udca7"+ "\n";

            }

        }



        return info;


    }
}