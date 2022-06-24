package Bot;


import Donetsk.DonetskTr;
import Donetsk.DonetskY;
import Donetsk.DonetskZ;
import Harkov.HarkovCas;
import Harkov.HarkovTr;
import Harkov.HarkovY;
import Harkov.HarkovZ;
import Kyiv.KyivTr;
import Kyiv.KyivY;
import Kyiv.KyivZ;
import Lvov.Lvov;
import Lvov.LvovCas;
import Lvov.LvovTr;
import Lvov.LvovZ;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;



public class Bot extends TelegramLongPollingBot {

    private long chat_id;
    String lastMassage = "";
    ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup(); // наша


    @Override
    public void onUpdateReceived(Update update) {
        update.getUpdateId();

        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
        chat_id = update.getMessage().getChatId();

        String text = update.getMessage().getText();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        try {
            sendMessage.setText(getMessage(text));
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "@weatherNP_Bot";
    }

    @Override
    public String getBotToken() {
        return "921672933:AAFLxugeQxwXJWMHJMDMc65tU6R0FA95Xro";
    }


    public String getMessage(String msg) {

        String today= "На сегодня \ud83c\udf07";
        ArrayList <KeyboardRow> keyboard = new ArrayList<KeyboardRow>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        KeyboardRow keyboardSecondRow = new KeyboardRow();

        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

            keyboard.clear();
            keyboardFirstRow.clear();
            keyboardFirstRow.add("Погода");
            keyboard.add(keyboardFirstRow);
            replyKeyboardMarkup.setKeyboard(keyboard);


        if (msg.equals("Погода") || msg.equals("\ud83d\udd19")) {
            keyboard.clear();
            keyboardFirstRow.clear();
            keyboardFirstRow.add("В Львове \ud83c\udf07");
            keyboardFirstRow.add("В Киеве \ud83c\udf03");
            keyboardSecondRow.add("В Харькове \ud83c\udf87");
            keyboardSecondRow.add("В Донецке \ud83c\udf86");
            keyboard.add(keyboardFirstRow);
            keyboard.add(keyboardSecondRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Выберите Город: ";
        }

        if (lastMassage.equals("В Львове \ud83c\udf07")) { // What can send the section "В Белой Церкви"

            if (msg.equals( today )) {
                System.out.print(getTopTr(Lvov.getBLPagoda(msg)));
            }
            if (msg.equals("Завтра \ud83c\udf07")) {
                return getTopTr(LvovZ.getBLPagodaz(msg));
            }
            if (msg.equals("На 5 дней \ud83c\udf07")) {
                return getTopTr(LvovTr.getTopTr(msg));
            }

        }
//------------------------------------------------------------------------//
        if (lastMassage.equals("В Киеве \ud83c\udf03")) { // What can send the section "В Киеве"

            if (msg.equals("На сегодня \ud83c\udf03")) {
                System.out.print( getTopTr(KyivY.getKVPagoda(msg)));
            }
            if (msg.equals("Завтра \ud83c\udf03")) {
                return getTopTr(KyivZ.getKyivZPagoda(msg));
            }
            if (msg.equals("На 5 дней \ud83c\udf03")) {
                return getTopTr(KyivTr.getKyivTr(msg));

            }
        }
//------------------------------------------------------------------------//
        if (lastMassage.equals("В Харькове \ud83c\udf87")) { // What can send the section "В Киеве"

            if (msg.equals("На сегодня \ud83c\udf87")) {
                System.out.print( getTopTr(HarkovY.getGorlovkaY(msg)));
            }
            if (msg.equals("Завтра \ud83c\udf87")) {
                return getTopTr(HarkovZ.getGorlovkaZ(msg));
            }
            if (msg.equals("На 5 дней \ud83c\udf87")) {
                return getTopTr(HarkovTr.getGorlovkaTr(msg));
            }
        }
//------------------------------------------------------------------------//

        if (lastMassage.equals("В Донецке \ud83c\udf86")) {

            if (msg.equals("На сегодня \ud83c\udf86")) {
                System.out.print( getTopTr(DonetskY.getDonetskY(msg)));
            }
            if (msg.equals("Завтра \ud83c\udf86")) {
                return getTopTr(DonetskZ.getDonetskZ(msg));
            }
            if (msg.equals("На 5 дней \ud83c\udf86")) {
                return getTopTr(DonetskTr.getDonetskTr(msg));
            }
        }

//======================== Подробнее БЦ ПОЧАСВО ===================================//
        if (msg.equals("На сегодня \ud83c\udf07")) {
            keyboard.clear();
            keyboardFirstRow.clear();

            keyboardFirstRow.add("Подробнее \ud83c\udf07");
            keyboardFirstRow.add("\ud83d\udd19");
            keyboard.add(keyboardFirstRow);

            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Выберите Город: ";
        }

        if (msg.equals("Подробнее \ud83c\udf07")) {
                return getTopTr(LvovCas.getTopCas(msg));
            }

// ======================== Погода в Киеве ПОЧАСВО ===================================//
        if (msg.equals("На сегодня \ud83c\udf03")) {
            keyboard.clear();
            keyboardFirstRow.clear();

            keyboardFirstRow.add("Подробнее \ud83c\udf03");
            keyboardFirstRow.add("\ud83d\udd19");
            keyboard.add(keyboardFirstRow);

            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Выберите Город: ";
        }

        if (msg.equals("Подробнее \ud83c\udf03")) {
            return getTopTr(Kyiv.KyivCas.getKyivCas(msg));
        }


// ======================== Погода в Горловке ПОЧАСВО ===================================//
        if (msg.equals("На сегодня \ud83c\udf87")) {
            keyboard.clear();
            keyboardFirstRow.clear();

            keyboardFirstRow.add("Подробнее \ud83c\udf87");
            keyboardFirstRow.add("\ud83d\udd19");
            keyboard.add(keyboardFirstRow);

            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Выберите Город: ";
        }

        if (msg.equals("Подробнее \ud83c\udf87")) {
            return getTopTr(HarkovCas.getGorlovkaCas(msg));
        }

// ======================== Погода в Донецк ПОЧАСВО ===================================//
        if (msg.equals("На сегодня \ud83c\udf86")) {
            keyboard.clear();
            keyboardFirstRow.clear();

            keyboardFirstRow.add("Подробнее \ud83c\udf86");
            keyboardFirstRow.add("\ud83d\udd19");
            keyboard.add(keyboardFirstRow);

            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Выберите Город: ";
        }

        if (msg.equals("Подробнее \ud83c\udf86")) {
            return getTopTr(Donetsk.DonetskCas.getDonetkCas(msg));
        }
//============================================================================//

        // что кнопка отображает, то и должна отправлять
        if (msg.equals("В Львове \ud83c\udf07")) {
            lastMassage = msg;
            keyboard.clear();
            keyboardFirstRow.clear();
            keyboardFirstRow.add(today); // отображение на клавиутре кнопок
            keyboardFirstRow.add("Завтра \ud83c\udf07");
            keyboardSecondRow.add("На 5 дней \ud83c\udf07");
            keyboardSecondRow.add("\ud83d\udd19");
            keyboard.add(keyboardFirstRow);
            keyboard.add(keyboardSecondRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Тыцкни кнопку:";
        }

        if (msg.equals("В Киеве \ud83c\udf03")){
            lastMassage = msg;
            keyboard.clear();
            keyboardFirstRow.clear();
            keyboardFirstRow.add("На сегодня \ud83c\udf03");
            keyboardFirstRow.add("Завтра \ud83c\udf03");
            keyboardSecondRow.add("На 5 дней \ud83c\udf03");
            keyboardSecondRow.add("\ud83d\udd19");
            keyboard.add(keyboardFirstRow);
            keyboard.add(keyboardSecondRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Тыцкни кнопку:";
        }

        if (msg.equals("В Харькове \ud83c\udf87")){
            lastMassage = msg;
            keyboard.clear();
            keyboardFirstRow.clear();
            keyboardFirstRow.add("На сегодня \ud83c\udf87");
            keyboardFirstRow.add("Завтра \ud83c\udf87");
            keyboardSecondRow.add("На 5 дней \ud83c\udf87");
            keyboardSecondRow.add("\ud83d\udd19");
            keyboard.add(keyboardFirstRow);
            keyboard.add(keyboardSecondRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Тыцкни кнопку:";
        }

        if (msg.equals("В Донецке \ud83c\udf86")){
            lastMassage = msg;
            keyboard.clear();
            keyboardFirstRow.clear();
            keyboardFirstRow.add("На сегодня \ud83c\udf86");
            keyboardFirstRow.add("Завтра \ud83c\udf86");
            keyboardSecondRow.add("На 5 дней \ud83c\udf86");
            keyboardSecondRow.add("\ud83d\udd19");
            keyboard.add(keyboardFirstRow);
            keyboard.add(keyboardSecondRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Тыцкни кнопку:";
        }

        else return "Привет!!";

    }

    public String getTopTr(String[] text) {
        SendMessage sendMessage = new SendMessage().setChatId(chat_id);
        for (int i = 0; i < text.length; i++) {
            try {
                sendMessage.setText(text[i]);
                execute(sendMessage);

            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
        return "";

    }

}

