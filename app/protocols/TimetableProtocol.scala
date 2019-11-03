package protocols
import play.api.libs.json._

object TimetableProtocol {

  case class Group(requiredData: String)

  implicit val groupWrites: OWrites[Group] = Json.writes[Group]


}
