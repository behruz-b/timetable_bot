package protocols
import play.api.libs.json._

object TimetableProtocol {

  case class Group(group: String)

  implicit val groupWrites: OWrites[Group] = Json.writes[Group]


}
