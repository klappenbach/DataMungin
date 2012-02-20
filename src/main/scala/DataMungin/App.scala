package DataMungin

import io.Source

object App extends App {
  val filePath = args.head
  val statsLines = for (line <- Source.fromFile(filePath).getLines() if line.trim.nonEmpty && line.trim.head.isDigit ) yield line.trim()
  val spreadPerDay = for(line <- statsLines) yield (line.split("\\D+")(0).toInt, line.split("\\D+")(1).toInt - line.split("\\D+")(2).toInt)
  println(spreadPerDay.toList.sortWith( (x,y)  => x._2 < y._2).head._2 )
}
