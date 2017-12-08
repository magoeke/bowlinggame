package de.magoeke.bowlinggame

import scala.collection.mutable.ListBuffer

class BowlingGame extends Game {

  private val rolls = ListBuffer[Int]()
  private val spare = 10
  private val Strike = 10 // is a stable identifier -> stable identifier start with uppercase

  override def roll(pins: Int) = rolls += pins

  override def score: Int = score(rolls.toList)

  private def score(rolls: List[Int]): Int = rolls match {
    case Strike :: nextRoll :: afterNextRoll :: _ => Strike + nextRoll + afterNextRoll + score(rolls.tail) // Strike
    case firstRoll :: secondRoll :: _ if firstRoll + secondRoll < spare => firstRoll + secondRoll + score(rolls.tail.tail) // Normal roll
    case firstRoll :: secondRoll :: nextRoll :: _ if firstRoll + secondRoll == spare => spare + nextRoll + score(rolls.tail.tail) // spare
    case _ => 0
  }
}
