package DataMungin

import io.Source

object Weather extends App {
    val separator = "\\D+"

  val filePath = args.headOption.getOrElse("weather.dat")
  val lines = Source.fromFile(filePath).getLines().map(_.trim)
  val statsLines = lines.filter(s => s.nonEmpty && s.head.isDigit)
  val columns = statsLines map (_ split separator)

  val temperatureSpreadPerDay = columns map { cols => (cols(0), cols(1).toInt - cols(2).toInt) }

  val dayWithLowestTemperatureSpread = temperatureSpreadPerDay.toList.sortWith((x, y) => x._2 < y._2).head
  println("Day with lowest temperature spread: day " + dayWithLowestTemperatureSpread._1 + " (spread is " + dayWithLowestTemperatureSpread._2 + ")" )
}

object Football extends App {
    val separator = "\\s+"
  val filePath = args.headOption.getOrElse("football.dat")
  val lines = Source.fromFile(filePath).getLines().map(_.trim)
  val statsLines = lines.filter(s => s.nonEmpty && s.head.isDigit)
  val columns = statsLines map (_ split separator)


  val scoreDiffPerTeam = columns map { cols => (cols(1), math.abs(cols(6).toInt - cols(8).toInt)) }

  val teamWithLowestDiff = scoreDiffPerTeam.toList.sortWith((x, y) => x._2 < y._2).head
  println("Team with lowest diff for/against: " + teamWithLowestDiff._1 + " (diff is " + teamWithLowestDiff._2 + ")" )
  
}
