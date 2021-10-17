package Donetsk;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class DonetskZ {
    private static Document document;

    public static String[] getDonetskZ(String period) {



        if (period.equals("Завтра \ud83c\udf86")) {
            try {
                document = Jsoup.connect("https://pogodnik.com/3217-pogoda-v-donetske-ukraina/tomorrow").get();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        String[] info = new String[20];
        Elements DN1 = document.getElementsByClass("active");
        Elements DN2 = DN1.select("div[class=info clearfix]");
        Elements DN3 = DN2.select("div[class=date]");
////______________________________________

        Elements DN4 = document.getElementsByClass("top");
        Elements DN5 = DN4.select("div[class=min-max-temperature clearfix]");
        Elements DN6 = DN5.select("div[class=min]");
        Elements DN7 = DN5.select("div[class=max]");

        Elements DN8 = document.getElementsByClass("day-weather-detail__col-left");
        Elements DN9 = DN8.select("div[class=precipitation2]");
        Elements DN10= DN8.select("div[class=pressure]");
        Elements DN11= DN8.select("div[class=humidity]");
        Elements DN12 = DN8.select("div[class=wind]");

        Elements DN13 = document.getElementsByClass("top");
        Elements DN14 = DN13.select("div[class=air-condition]");







        for (int i = 0; i<DN3.size(); i++ ){
            if(i < 20) {
                info[i] =
                        "Погода в Донецк :" + "\n"
                                + "" + DN3.get(i).text() + "\n\n\n"
                                + "Температура:" + DN6.get(i).text() + ""// макс
                                + "/ " + DN7.get(i).text() + "\n"  // мин
                                + "" + DN9.get(i).text() + "\u2602\ufe0f"+"\n" // осадки
                                + "" + DN10.get(i).text() + "\n"// давление
                                + "" + DN11.get(i).text() + "\ud83d\udca7"+"\n"// влажносьб
                                + "" + DN12.get(i).text() + "\ud83d\udca8"+"\n" // ветер
                                + "" + DN14.get(i).text() + "\n";// облака


            }

        }


        return info;
    }

}
