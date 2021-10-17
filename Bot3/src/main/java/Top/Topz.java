package Top;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Topz {
    private static Document document;

    public static String[] getBLPagodaz(String period) {



        if (period.equals("Завтра \ud83c\udf07")) {
            try {
                document = Jsoup.connect("https://pogodnik.com/3229-pogoda-v-beloj-tserkvi-kievskaya-oblast-ukraina/tomorrow").get();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        String[] info = new String[20];
        Elements tab = document.getElementsByClass("active");
        Elements tab2 = tab.select("div[class=info clearfix]");
        Elements tab3 = tab2.select("div[class=date]");
////______________________________________air-condition

        Elements tab4 = document.getElementsByClass("top");
        Elements tab5 = tab4.select("div[class=min-max-temperature clearfix]");
        Elements tab6 = tab5.select("div[class=min]");
        Elements tab7 = tab5.select("div[class=max]");

        Elements tab8 = document.getElementsByClass("day-weather-detail__col-left");
        Elements tab9 = tab8.select("div[class=precipitation2]");
        Elements tab10= tab8.select("div[class=pressure]");
        Elements tab11= tab8.select("div[class=humidity]");
        Elements tab12= tab8.select("div[class=wind]");

        Elements tab13 = document.getElementsByClass("top");
        Elements tab14 = tab13.select("div[class=air-condition]");







        for (int i = 0; i<tab3.size(); i++ ){
            if(i < 20) {
                info[i] =
                        "Погода в Белоц Церкви :" + "\n"
                                + "" + tab3.get(i).text() + "\n\n\n"
                                + "Температура:" + tab6.get(i).text() + "" // макс
                                + " / " + tab7.get(i).text() + "\n"  // мин
                                + "" + tab9.get(i).text() + "\u2602\ufe0f"+"\n" // осадки
                                + "" + tab10.get(i).text() + "\n"// давление
                                + "" + tab11.get(i).text() + "\ud83d\udca7"+"\n"// влажносьб
                                + "" + tab12.get(i).text() + "\ud83d\udca8"+"\n" // ветер
                                + "" + tab14.get(i).text() + "\n";// облака


            }

        }


        return info;
    }




}

