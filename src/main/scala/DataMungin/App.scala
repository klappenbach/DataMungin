package DataMungin

import io.Source

object App extends App {
  val filePath = args.headOption.getOrElse("weather.dat")
  val lines = Source.fromFile(filePath).getLines()
  val statsLines = lines.filter(s => s.trim.nonEmpty && s.trim.head.isDigit).map(_.trim)
  val intColumns = statsLines map (_  split ("\\D+") map (_.toInt))
  val temperatureSpreadPerDay = intColumns map { cols => (cols(0), cols(1) - cols(2)) }

  val dayWithLowestTemperatureSpread = temperatureSpreadPerDay.toList.sortWith((x, y) => x._2 < y._2).head._1
  println(dayWithLowestTemperatureSpread )
}
