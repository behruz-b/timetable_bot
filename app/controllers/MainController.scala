package controllers

import javax.inject.{Inject, Singleton}
import play.api.mvc.{BaseController, ControllerComponents}

import scala.concurrent.ExecutionContext

@Singleton
class TimetableController @Inject()(val controllerComponents: ControllerComponents)
                              (implicit val ec: ExecutionContext)
  extends BaseController {
  def index = Action {
    Ok("Bot is running")
  }
}
