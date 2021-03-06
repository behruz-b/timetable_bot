package telegrambot;

import org.openqa.selenium.WebDriver;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Audio;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class BotInitializer extends TelegramLongPollingBot {

  private final String botUserName;
  private final String botToken;
  private final String httpLink;
  private long chat_id;
  String lastMessage = "";
  String request = "";
  ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
  static WebDriver driver;

  public BotInitializer(final String botUserName, final String botToken, final String httpLink) {
    this.botUserName = botUserName;
    this.botToken = botToken;
    this.httpLink = httpLink;
  }

  @Override
  public void onUpdateReceived(Update update) {

    if (update.hasMessage() && update.getMessage().hasPhoto()) {
      update.getUpdateId();
      SendMessage message = new SendMessage().setParseMode("HTML").setChatId(update.getMessage().getChatId());
      chat_id = update.getMessage().getChatId();
      Audio message_text = update.getMessage().getAudio();
      String username = update.getMessage().getChat().getUserName();
      log.println("=============== getUserName:  " + username +  ": " + message_text +" ================");
      message.setReplyMarkup(replyKeyboardMarkup);// Create a message object object

      try {
        message.setText("Siz yuborgan suratni yaratuvchim albatta ko'radi. Mendan foydalanganingiz uchun raxmat");
        execute(message); // Sending our message object to user
      } catch (TelegramApiException e) {
        e.printStackTrace();
      }
    }
    // We check if the update has a message and the message has text
    else if (update.hasMessage() && update.getMessage().hasAudio()) {
      update.getUpdateId();
      SendMessage message = new SendMessage().setParseMode("HTML").setChatId(update.getMessage().getChatId());
      chat_id = update.getMessage().getChatId();
      Audio message_text = update.getMessage().getAudio();
      String username = update.getMessage().getChat().getUserName();
      log.println("=============== getUserName:  " + username +  ": " + message_text +" ================");
      message.setReplyMarkup(replyKeyboardMarkup);// Create a message object object

      try {
        message.setText("Siz yuborgan audio xabarga ertaga javob yuboramiz!");
        execute(message); // Sending our message object to user
      } catch (TelegramApiException e) {
        e.printStackTrace();
      }
    }
    else if (update.hasMessage() && update.getMessage().hasVoice()) {
      update.getUpdateId();
      SendMessage message = new SendMessage().setParseMode("HTML").setChatId(update.getMessage().getChatId());
      chat_id = update.getMessage().getChatId();
      Audio message_text = update.getMessage().getAudio();
      String username = update.getMessage().getChat().getUserName();
      log.println("=============== getUserName:  " + username +  ": " + message_text +" ================");
      message.setReplyMarkup(replyKeyboardMarkup);// Create a message object object

      try {
        message.setText("Siz yuborgan audio xabarga ertaga javob yuboramiz!");
        execute(message); // Sending our message object to user
      } catch (TelegramApiException e) {
        e.printStackTrace();
      }
    }
    else if (update.hasMessage() && update.getMessage().hasDocument()) {
      update.getUpdateId();
      SendMessage message = new SendMessage().setParseMode("HTML").setChatId(update.getMessage().getChatId());
      chat_id = update.getMessage().getChatId();
      Audio message_text = update.getMessage().getAudio();
      String username = update.getMessage().getChat().getUserName();
      log.println("=============== getUserName:  " + username +  ": " + message_text +" ================");
      message.setReplyMarkup(replyKeyboardMarkup);// Create a message object object

      try {
        message.setText("Siz yuborgan faylni yaratuchim albatta tekshiradi. Mendan foydalanganingiz uchun raxmat");
        execute(message); // Sending our message object to user
      } catch (TelegramApiException e) {
        e.printStackTrace();
      }
    }
    else if (update.hasMessage() && update.getMessage().hasAnimation()) {
      update.getUpdateId();
      SendMessage message = new SendMessage().setParseMode("HTML").setChatId(update.getMessage().getChatId());
      chat_id = update.getMessage().getChatId();
      Audio message_text = update.getMessage().getAudio();
      String username = update.getMessage().getChat().getUserName();
      log.println("=============== getUserName:  " + username +  ": " + message_text +" ================");
      message.setReplyMarkup(replyKeyboardMarkup);// Create a message object object

      try {
        message.setText("Yuborgan animatsiyangiz uchun raxmat");
        execute(message); // Sending our message object to user
      } catch (TelegramApiException e) {
        e.printStackTrace();
      }
    }
    else if (update.hasMessage() && update.getMessage().hasContact()) {
      update.getUpdateId();
      SendMessage message = new SendMessage().setParseMode("HTML").setChatId(update.getMessage().getChatId());
      chat_id = update.getMessage().getChatId();
      Audio message_text = update.getMessage().getAudio();
      String username = update.getMessage().getChat().getUserName();
      log.println("=============== getUserName:  " + username +  ": " + message_text +" ================");
      message.setReplyMarkup(replyKeyboardMarkup);// Create a message object object

      try {
        message.setText("Shu abanent bilan albatta bog'lanamiz");
        execute(message); // Sending our message object to user
      } catch (TelegramApiException e) {
        e.printStackTrace();
      }
    }
    else if (update.hasMessage() && update.getMessage().hasVideo()) {
      update.getUpdateId();
      SendMessage message = new SendMessage().setParseMode("HTML").setChatId(update.getMessage().getChatId());
      chat_id = update.getMessage().getChatId();
      Audio message_text = update.getMessage().getAudio();
      String username = update.getMessage().getChat().getUserName();
      log.println("=============== getUserName:  " + username +  ": " + message_text +" ================");
      message.setReplyMarkup(replyKeyboardMarkup);// Create a message object object

      try {
        message.setText("Video uchun raxmat");
        execute(message); // Sending our message object to user
      } catch (TelegramApiException e) {
        e.printStackTrace();
      }
    }
    else if (update.hasMessage() && update.getMessage().hasLocation()) {
      update.getUpdateId();
      SendMessage message = new SendMessage().setParseMode("HTML").setChatId(update.getMessage().getChatId());
      chat_id = update.getMessage().getChatId();
      Audio message_text = update.getMessage().getAudio();
      String username = update.getMessage().getChat().getUserName();
      log.println("=============== getUserName:  " + username +  ": " + message_text +" ================");
      message.setReplyMarkup(replyKeyboardMarkup);// Create a message object object

      try {
        message.setText("Qayerdasiz?");
        execute(message); // Sending our message object to user
      } catch (TelegramApiException e) {
        e.printStackTrace();
      }
    }
    else {
      update.getUpdateId();
      SendMessage message = new SendMessage().setParseMode("HTML").setChatId(update.getMessage().getChatId());
      chat_id = update.getMessage().getChatId();
      String message_text = update.getMessage().getText();
      String username = update.getMessage().getChat().getUserName();
      log.println("=============== getUserName:  " + username +  ": " + message_text +" ================");
      message.setReplyMarkup(replyKeyboardMarkup);// Create a message object object

      try {
        message.setText(getMessage(message_text));
        execute(message); // Sending our message object to user
      } catch (TelegramApiException e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public String getBotUsername() {
    return new BotInitializer(botUserName, botToken, httpLink).botUserName;
  }

  @Override
  public String getBotToken() {
    return new BotInitializer(botUserName, botToken, httpLink).botToken;
  }

  private String getMessage(String msg) {
    String tBotUser = new BotInitializer(botUserName, botToken, httpLink).botUserName;
    String tBotToken = new BotInitializer(botUserName, botToken, httpLink).botToken;
    String tHttpLink = new BotInitializer(botUserName, botToken, httpLink).httpLink;
    ArrayList<KeyboardRow> keyboard = new ArrayList<>();
    KeyboardRow keyboardFirstRow = new KeyboardRow();
    KeyboardRow keyboardSecondRow = new KeyboardRow();
    replyKeyboardMarkup.setSelective(true);
    replyKeyboardMarkup.setResizeKeyboard(true);
    replyKeyboardMarkup.setOneTimeKeyboard(true);

    if (msg.equals("/start") || msg.equals("/menu") || msg.equals("Menu")) {
      lastMessage = "";
      request = "";
      keyboard.clear();
      keyboardFirstRow.clear();
      keyboardFirstRow.add("O'quvchi");
      keyboardFirstRow.add("O'qituvchi");
      keyboardSecondRow.add("Bo'sh xonalar");
      keyboard.add(keyboardFirstRow);
      keyboard.add(keyboardSecondRow);
      replyKeyboardMarkup.setKeyboard(keyboard);
      return "Menu tanlang!";
    }
    if (msg.equals("O'quvchi")) {
      lastMessage = "student";
      request = "";
      keyboard.clear();
      keyboardFirstRow.clear();
      keyboardFirstRow.add("Bugun");
      keyboardFirstRow.add("Ertaga");
      keyboardFirstRow.add("Haftalik");
      keyboardSecondRow.add("Menu");
      keyboard.add(keyboardFirstRow);
      keyboard.add(keyboardSecondRow);
      replyKeyboardMarkup.setKeyboard(keyboard);
      return "Menu tanlang!";
    }
    if (msg.equals("O'qituvchi")) {
      lastMessage = "teacher";
      request = "";
      keyboard.clear();
      keyboardFirstRow.clear();
      keyboardFirstRow.add("Bugun");
      keyboardFirstRow.add("Haftalik");
      keyboardSecondRow.add("Menu");
      keyboard.add(keyboardFirstRow);
      keyboard.add(keyboardSecondRow);
      replyKeyboardMarkup.setKeyboard(keyboard);
      return "Menu tanlang!";
    }
    if (msg.equals("Bo'sh xonalar")) {
      lastMessage = "";
      keyboard.clear();
      request = "";
      keyboardFirstRow.clear();
      getImages(chat_id);
      return "Hozirda bo'sh xonalar";
    }
    if (msg.equals("Bugun")) {
      if (lastMessage.equals("teacher")) {
        lastMessage = lastMessage + "_" + "today";
        request = "";
        keyboard.clear();
        keyboardFirstRow.clear();
        keyboardFirstRow.add("Menu");
        keyboard.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
        return "O'qituvchi ismi sharifini kiriting.";
      } else if (lastMessage.equals("student")) {
        lastMessage = lastMessage + "_" + "today";
        request = "";
        keyboard.clear();
        keyboardFirstRow.clear();
        keyboardFirstRow.add("Menu");
        keyboard.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
        return "Guruh raqamini kiriting.";
      } else {
        return "Menu tanlang...";
      }
    }
    if (msg.equals("Ertaga")) {
      if (lastMessage.equals("student")) {
        lastMessage = lastMessage + "_" + "tomorrow";
        request = "";
        keyboard.clear();
        keyboardFirstRow.clear();
        keyboardFirstRow.add("Menu");
        keyboard.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
        return "Guruh raqamini kiriting.";
      } else {
        return "Menu tanlang...";
      }
    }
    if (msg.equals("Haftalik")) {
      if (lastMessage.equals("teacher")) {
        lastMessage = lastMessage + "_" + "week";
        request = "";
        keyboard.clear();
        keyboardFirstRow.clear();
        keyboardFirstRow.add("Menu");
        keyboard.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
        return "O'qituvchi ismi sharifini kiriting.";
      } else if (lastMessage.equals("student")) {
        lastMessage = lastMessage + "_" + "week";
        request = "";
        keyboard.clear();
        keyboardFirstRow.clear();
        keyboardFirstRow.add("Menu");
        keyboard.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
        return "Guruh raqamini kiriting.";
      } else {
        return "Menu tanlang...";
      }
    } else {
      if (lastMessage.equals("teacher_today")) {
        request = lastMessage + "_" + msg;
        keyboard.clear();
        keyboardFirstRow.clear();
        keyboardFirstRow.add("Menu");
        keyboard.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
        if (SendToServer.checkingResponse(tHttpLink + "text", request).equals("No")) {
          return "bugun " + msg + " ismli o'qituvchini darsi yo'q";
        }else {
          SendToServer.callApiAndSendMsg(request, tBotUser, tBotToken, tHttpLink  + "today/teacher", chat_id);
          return "O'qituvchi ismi sharifini kiriting.";
        }
      } else if (lastMessage.equals("student_today")) {
        request = lastMessage + "_" + msg;
        keyboard.clear();
        keyboardFirstRow.clear();
        keyboardFirstRow.add("Menu");
        keyboard.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
        if (SendToServer.checkingResponse(tHttpLink + "text", request).equals("No")) {
          return "bugun " + msg + " nomli guruhga dars yo'q";
        }else {
          SendToServer.callApiAndSendMsg(request, tBotUser, tBotToken, tHttpLink + "today/student", chat_id);
          return "Guruh raqamini kiriting!";
        }
//
      } else if (lastMessage.equals("student_tomorrow")) {
        request = lastMessage + "_" + msg;
        keyboard.clear();
        keyboardFirstRow.clear();
        keyboardFirstRow.add("Menu");
        keyboard.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
        if (SendToServer.checkingResponse(tHttpLink + "text", request).equals("No")) {
          return "ertaga " + msg + " nomli guruhga dars yo'q";
        }else {
          SendToServer.callApiAndSendMsg(request, tBotUser, tBotToken, tHttpLink  + "tomorrow/student", chat_id);
          return "Guruh raqamini kiriting!";
        }
      } else if (lastMessage.equals("student_week")) {
        request = lastMessage + "_" + msg;
        keyboard.clear();
        keyboardFirstRow.clear();
        keyboardFirstRow.add("Menu");
        keyboard.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
        if (SendToServer.checkingResponse(tHttpLink + "text", request).equals("No")) {
          return msg + " nomli guruh yo'q";
        }else {
          SendToServer.callApiAndSendMsg(request, tBotUser, tBotToken, tHttpLink  + "week/student", chat_id);
          return "Guruh raqamini kiriting!";
        }
      } else if (lastMessage.equals("teacher_week")) {
        request = lastMessage + "_" + msg;
        keyboard.clear();
        keyboardFirstRow.clear();
        keyboardFirstRow.add("Menu");
        keyboard.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
        if (SendToServer.checkingResponse(tHttpLink + "text", request).equals("No")) {
          return msg + " ismli o'qituvchi yo'q";
        }else {
          SendToServer.callApiAndSendMsg(request, tBotUser, tBotToken, tHttpLink  + "week/teacher", chat_id);
          return "O'qituvchi ismi sharifini kiriting.";
        }

      } else {
        return "Menu tanlang";
      }
    }
  }

  private void getImages(Long chat_id) {
    String tHttpLink = new BotInitializer(botUserName, botToken, httpLink).httpLink;

    String urls[] = new String[3];
    urls[0] = tHttpLink + "map/1-floor";
    urls[1] = tHttpLink + "map/2-floor";
    urls[2] = tHttpLink + "map/3-floor";
    for (int i = 0; i < 3; i++) {
      try {
        new TestImage().capturePage(urls[i]);
        sendImageFromUrl(chat_id);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public void sendImageFromUrl(Long chatId) {
    SendPhoto sendPhotoRequest = new SendPhoto();
    sendPhotoRequest.setChatId(chatId);
    sendPhotoRequest.setPhoto(new File("/tmp/screenshot.png"));
    try {
      execute(sendPhotoRequest);
    } catch (TelegramApiException e) {
      e.printStackTrace();
    }
  }
  public void sendFileFromUrl(Long chatId) {
    SendDocument sendDocumentRequest = new SendDocument();
    sendDocumentRequest.setChatId(chatId);
    sendDocumentRequest.setCaption("Haftalik dars jadvali");
    sendDocumentRequest.setDocument(new File("/tmp/screenshot.png"));
    try {
      execute(sendDocumentRequest);
    } catch (TelegramApiException e) {
      e.printStackTrace();
    }
  }


}
