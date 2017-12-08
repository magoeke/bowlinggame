package de.magoeke.bowlinggame

trait Game {

  def roll(pins: Int): Unit

  def score(): Int

}
