package de.magoeke.bowlinggame

import org.scalatest.{BeforeAndAfterEach, FunSpec, FunSuite, WordSpec}
import org.scalatest.Matchers._


class BowlingGameTest extends FunSuite with BeforeAndAfterEach {

  override def beforeEach(): Unit = {
    val game = new BowlingGame
  }

  test("A game with only gutters should have the score 0") {
    val game = new BowlingGame
    for(i <- 0 until 20) { game.roll(0) }
    game.score shouldBe 0
  }


  test("A game with only ones should have the score 20") {
    val game = new BowlingGame
    for(i <- 0 until 20) { game.roll(1) }
    game.score shouldBe 20
  }

  test("A game with one spare and one 2 should be 14") {
    val game = new BowlingGame
    game.roll(6)
    game.roll(4)
    game.roll(2)
    for(i <- 0 until 17) { game.roll(0) }

    game.score shouldBe 14
  }

  test("A game with only spares and a 5 at the end should have the score 150") {
    val game = new BowlingGame
    for(i <- 0 until 20) { game.roll(5) }
    game.roll(5)

    game.score shouldBe 150
  }

  test("A game with a strike and two ones should have the score 14") {
    val game = new BowlingGame
    game.roll(10)
    game.roll(1)
    game.roll(1)
    for(i <- 0 until 16) { game.roll(0) }

    game.score shouldBe 14
  }

  test("A game with only strikes should have the score 300") {
    val game = new BowlingGame
    for(i <- 0 until 12) { game.roll(10) }

    game.score shouldBe 300
  }

}
