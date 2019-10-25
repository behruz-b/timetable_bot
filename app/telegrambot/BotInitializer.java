package telegrambot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;

public class BotInitializer extends TelegramLongPollingBot {

  private final String botUserName;
  private final String botToken;
  private final String httpLink;
  private long chat_id;
  String lastMessage = "";
  String request = "";
  ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

  public BotInitializer(final String botUserName, final String botToken, final String httpLink) {
    this.botUserName = botUserName;
    this.botToken = botToken;
    this.httpLink = httpLink;
  }

  @Override
  public void onUpdateReceived(Update update) {

    // We check if the update has a message and the message has text
    if (update.hasMessage() && update.getMessage().hasText()) {

      update.getUpdateId();
      SendMessage message = new SendMessage().setParseMode("HTML").setChatId(update.getMessage().getChatId());

      chat_id = update.getMessage().getChatId();
      String message_text = update.getMessage().getText();
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

  public String getMessage(String msg) {
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
      return "Menu tanlang...";
    }
    if (msg.equals("O'quvchi")) {
      lastMessage = msg;
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
      return "Menu tanlang...";
    }
    if (msg.equals("O'qituvchi")) {
      lastMessage = msg;
      request = "";
      keyboard.clear();
      keyboardFirstRow.clear();
      keyboardFirstRow.add("Bugun");
      keyboardFirstRow.add("Haftalik");
      keyboardSecondRow.add("Menu");
      keyboard.add(keyboardFirstRow);
      keyboard.add(keyboardSecondRow);
      replyKeyboardMarkup.setKeyboard(keyboard);
      return "Menu tanlang...";
    }
    if (msg.equals("Bo'sh xonalar")) {
      lastMessage = "";
      keyboard.clear();
      request = msg;
      keyboardFirstRow.clear();
      return "Bo'sh xonalar";
    }
    if (msg.equals("Bugun")) {
      if (lastMessage.equals("O'qituvchi")) {
        lastMessage = lastMessage + "/" + msg;
        request = "";
        keyboard.clear();
        keyboardFirstRow.clear();
        keyboardFirstRow.add("Menu");
        keyboard.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
        return "O'qituvchi ismi...";
      } else if (lastMessage.equals("O'quvchi")) {
        lastMessage = lastMessage + "/" + msg;
        request = "";
        keyboard.clear();
        keyboardFirstRow.clear();
        keyboardFirstRow.add("Menu");
        keyboard.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
        return "Guruh raqami...";
      } else {
        return "Menu tanlang...";
      }
    }
    if (msg.equals("Ertaga")) {
      if (lastMessage.equals("O'quvchi")) {
        lastMessage = lastMessage + "/" + msg;
        request = "";
        keyboard.clear();
        keyboardFirstRow.clear();
        keyboardFirstRow.add("Menu");
        keyboard.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
        return "Guruh raqami...";
      } else {
        return "Menu tanlang...";
      }
    }
    if (msg.equals("Haftalik")) {
      if (lastMessage.equals("O'qituvchi")) {
        lastMessage = lastMessage + "/" + msg;
        request = "";
        keyboard.clear();
        keyboardFirstRow.clear();
        keyboardFirstRow.add("Menu");
        keyboard.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
        return "O'qituvchi ismi...";
      } else if (lastMessage.equals("O'quvchi")) {
        lastMessage = lastMessage + "/" + msg;
        request = "";
        keyboard.clear();
        keyboardFirstRow.clear();
        keyboardFirstRow.add("Menu");
        keyboard.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
        return "Guruh raqami...";
      } else {
        return "Menu tanlang...";
      }
    } else {
      if (lastMessage.equals("O'qituvchi/Bugun")) {
        request = lastMessage + "/" + msg;
        keyboard.clear();
        keyboardFirstRow.clear();
        keyboardFirstRow.add("Menu");
        keyboard.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
        return SendToServer.callApiAndSendMsg(request, new BotInitializer(botUserName, botToken, httpLink).httpLink);
      } else if (lastMessage.equals("O'quvchi/Bugun")) {
        request = lastMessage + "/" + msg;
        keyboard.clear();
        keyboardFirstRow.clear();
        keyboardFirstRow.add("Menu");
        keyboard.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
        return SendToServer.callApiAndSendMsg(request, new BotInitializer(botUserName, botToken, httpLink).httpLink);
//
      } else if (lastMessage.equals("O'quvchi/Ertaga")) {
        request = lastMessage + "/" + msg;
        keyboard.clear();
        keyboardFirstRow.clear();
        keyboardFirstRow.add("Menu");
        keyboard.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
        return SendToServer.callApiAndSendMsg(request, new BotInitializer(botUserName, botToken, httpLink).httpLink);

      } else if (lastMessage.equals("O'quvchi/Haftalik")) {
        request = lastMessage + "/" + msg;
        keyboard.clear();
        keyboardFirstRow.clear();
        keyboardFirstRow.add("Menu");
        keyboard.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
        return SendToServer.callApiAndSendMsg(request, new BotInitializer(botUserName, botToken, httpLink).httpLink);
      } else if (lastMessage.equals("O'qituvchi/Haftalik")) {
        request = lastMessage + "/" + msg;
        keyboard.clear();
        keyboardFirstRow.clear();
        keyboardFirstRow.add("Menu");
        keyboard.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
        return SendToServer.callApiAndSendMsg(request, new BotInitializer(botUserName, botToken, httpLink).httpLink);

      } else {
        return "Menu tanlang";
      }
    }
  }

}
