package telegrambot

import play.api.libs.json.Json
import protocols.TimetableProtocol.Group
import scalaj.http.{Http, HttpOptions}

object SendToServer {
  def callApiAndSendMsg(text: String, httpLink: String): String = {
    val data = Json.toJson(Group(text))
    Http(httpLink).postData(Json.stringify(data))
      .header("Content-Type", "application/json")
      .header("Charset", "UTF-8")
      .option(HttpOptions.readTimeout(10000)).asString.body.mkString("")
  }
}
