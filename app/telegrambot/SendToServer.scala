package telegrambot

import scalaj.http.{Http, HttpOptions}

object SendToServer {
  def callApiAndSendMsg(text: String, tBotUser: String, tBotToken: String, tHttpLink: String, chat_id: Long): Unit = {
    Http(tHttpLink + text)
      .header("Content-Type", "application/json")
      .header("Charset", "UTF-8")
      .option(HttpOptions.readTimeout(10000)).asString.body.mkString("")
    try {
      new TestImage().capturePage(tHttpLink)
      new BotInitializer(tBotUser, tBotToken, tHttpLink).sendImageFromUrl(chat_id)
    } catch {
      case e: Throwable =>
        e.printStackTrace
    }
  }
}
