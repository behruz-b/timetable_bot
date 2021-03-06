package telegrambot

import play.api.libs.json.Json
import protocols.TimetableProtocol.Group
import scalaj.http.{Http, HttpOptions}

object SendToServer {
  def callApiAndSendMsg(text: String, tBotUser: String, tBotToken: String, tHttpLink: String, chat_id: Long): Unit = {
    Http(tHttpLink + "/" + text)
      .header("Content-Type", "application/json")
      .header("Charset", "UTF-8")
      .option(HttpOptions.readTimeout(10000)).asString.body.mkString("")
    try {
        new TestImage().capturePage(tHttpLink + "/" + text)
        val when = text.toString.split("_").toList.reverse.tail.head
        if (when == "week"){
          new BotInitializer(tBotUser, tBotToken, tHttpLink).sendFileFromUrl(chat_id)
        }else {
          new BotInitializer(tBotUser, tBotToken, tHttpLink).sendImageFromUrl(chat_id)
        }
    } catch {
      case e: Throwable =>
        e.printStackTrace
    }
  }

  def checkingResponse(httpLink: String, text: String) = {
    val data = Json.toJson(Group(text))
    Http(httpLink).postData(Json.stringify(data))
      .header("Content-Type", "application/json")
      .header("Charset", "UTF-8")
      .option(HttpOptions.readTimeout(10000)).asString.body.mkString("")
  }
}
