package DataMungin

import io.Source

object App extends App {
  val filePath = args.headOption.getOrElse("weather.dat")
  val lines = Source.fromFile(filePath).getLines()
  val statsLines = lines.filter(s => s.trim.nonEmpty && s.trim.head.isDigit).map(_.trim)
  val spreadPerDay = statsLines.map(line => {
    val split = line.split("\\D+")
    val temperatureSpreadOfDay = split(1).toInt - split(2).toInt
    (split(0).toInt, temperatureSpreadOfDay)
  })
  println(spreadPerDay.toList.sortWith( (x,y)  => x._2 < y._2).head._2 )
}
