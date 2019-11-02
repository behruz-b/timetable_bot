package telegrambot

import play.api.libs.json.Json
import protocols.TimetableProtocol.Group
import scalaj.http.{Http, HttpOptions}

object SendToServer {
  def callApiAndSendMsg(text: String, tBotUser: String, tBotToken: String, tHttpLink: String, chat_id: Long): Unit = {
    val data = Json.toJson(Group(text))
    Http(tHttpLink).postData(Json.stringify(data))
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
