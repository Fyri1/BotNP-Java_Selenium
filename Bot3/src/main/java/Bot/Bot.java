package Bot;

import Donetsk.DonetskTr;
import Donetsk.DonetskY;
import Donetsk.DonetskZ;
import Gorlovka.GorlovkaTr;
import Gorlovka.GorlovkaY;
import Gorlovka.GorlovkaZ;
import Kyiv.KyivTr;
import Kyiv.KyivY;
import Kyiv.KyivZ;
import Top.Top;
import Top.TopCas;
import Top.TopTr;
import Top.Topz;
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
            keyboardFirstRow.add("В Белой Церкви \ud83c\udf07");
            keyboardFirstRow.add("В Киеве \ud83c\udf03");
            keyboardSecondRow.add("В Горловка \ud83c\udf87");
            keyboardSecondRow.add("В Донецке \ud83c\udf86");
            keyboard.add(keyboardFirstRow);
            keyboard.add(keyboardSecondRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Выберите Город: ";
        }

        if (lastMassage.equals("В Белой Церкви \ud83c\udf07")) {

            if (msg.equals("На сегодня \ud83c\udf07"  )) {
                System.out.print(getBLPagoda(Top.getBLPagoda(msg)));
            }
            if (msg.equals("Завтра \ud83c\udf07")) {
                return getBLPagodaz(Topz.getBLPagodaz(msg));
            }
            if (msg.equals("На 5 дней \ud83c\udf07")) {
                return getTopTr(TopTr.getTopTr(msg));
            }

        }
//------------------------------------------------------------------------//
        if (lastMassage.equals("В Киеве \ud83c\udf03")) {

            if (msg.equals("На сегодня \ud83c\udf03")) {
                System.out.print( getKVPagoda(KyivY.getKVPagoda(msg)));
            }
            if (msg.equals("Завтра \ud83c\udf03")) {
                return getKyivZPagoda(KyivZ.getKyivZPagoda(msg));
            }
            if (msg.equals("На 5 дней \ud83c\udf03")) {
                return getKyivTr(KyivTr.getKyivTr(msg));

            }
        }
//------------------------------------------------------------------------//
        if (lastMassage.equals("В Горловка \ud83c\udf87")) {

            if (msg.equals("На сегодня \ud83c\udf87")) {
                System.out.print( getGorlovkaY(GorlovkaY.getGorlovkaY(msg)));
            }
            if (msg.equals("Завтра \ud83c\udf87")) {
                return getGorlovkaZ(GorlovkaZ.getGorlovkaZ(msg));
            }
            if (msg.equals("На 5 дней \ud83c\udf87")) {
                return getGorlovkaTr(GorlovkaTr.getGorlovkaTr(msg));
            }
        }
//------------------------------------------------------------------------//

        if (lastMassage.equals("В Донецке \ud83c\udf86")) {

            if (msg.equals("На сегодня \ud83c\udf86")) {
                System.out.print( getDonetskY(DonetskY.getDonetskY(msg)));
            }
            if (msg.equals("Завтра \ud83c\udf86")) {
                return getDonetskZ(DonetskZ.getDonetskZ(msg));
            }
            if (msg.equals("На 5 дней \ud83c\udf86")) {
                return getDonetskTr(DonetskTr.getDonetskTr(msg));
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
                return getTopCas(TopCas.getTopCas(msg));
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
            return getKyivCas(Kyiv.KyivCas.getKyivCas(msg));
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
            return getGorlovkaCas(Gorlovka.GorlovkaCas.getGorlovkaCas(msg));
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
            return getDonetkCas(Donetsk.DonetskCas.getDonetkCas(msg));
        }
//============================================================================//




        if (msg.equals("В Белой Церкви \ud83c\udf07")) {
            lastMassage = msg;
            keyboard.clear();
            keyboardFirstRow.clear();
            keyboardFirstRow.add("На сегодня \ud83c\udf07");
            keyboardFirstRow.add("Завтра \ud83c\udf07");
            keyboardSecondRow.add("На 5 дней \ud83c\udf07");
            keyboardSecondRow.add("\ud83d\udd19");
            keyboard.add(keyboardFirstRow);
            keyboard.add(keyboardSecondRow);
            replyKeyboardMarkup.setKeyboard(keyboard);

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
            return "Привет Насть . Тыцкни кнопку :";
        }

        if (msg.equals("В Горловка \ud83c\udf87")){
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
            return "Привет Насть . Тыцкни кнопку :";
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
            return "Привет Насть . Тыцкни кнопку :";
        }


        else if (msg.equals("Максим"))
    {
        return "Привет Настя. Я не знаю как проходят события наши сейчас, но знаю одно точно. Я все так же сильно люблю тебя и надеюсь что у нвс с тобой все хорошо! Если что-то не так - найди меня  и обними. Я все прощу! P.S. Твой любимый Кис (10/12/2019) ";

        }



        else  return "Введите слово Погода";



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

    public String getTopCas(String[] text) {
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
    public String  getKyivCas(String[] text) {
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

    public String getDonetkCas(String[] text) {
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

    public String getGorlovkaCas(String[] text) {
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


    public String getBLPagoda(String[] text) {
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

    public String getBLPagodaz(String[] text) {
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



    public String getKVPagoda(String[] text) {
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
    public String getKyivZPagoda(String[] text) {
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



    public String getGorlovkaY(String[] text) {
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

    public String getGorlovkaZ(String[] text) {
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

    public String getDonetskY(String[] text) {
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
    public String getDonetskZ(String[] text) {
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

    public String getDonetskTr(String[] text) {
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


    public String getGorlovkaTr(String[] text) {
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

    public String getKyivTr(String[] text) {
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

