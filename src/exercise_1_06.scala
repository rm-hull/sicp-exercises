object Exercise_1_06 extends App {

  def if_callByName[T](predicate: Boolean, thenClause: => T, elseClause: => T): T =
    if (predicate) thenClause else elseClause

  def if_callByValue[T](predicate: Boolean, thenClause: T, elseClause: T): T =
    if (predicate) thenClause else elseClause

  def sqrt(x: Double): Double = {
    def iter(guess: Double, x: Double): Double = {
      // With call-by-value, stack overflow occurs
      //if_callByValue(goodEnough(guess, x), guess, iter(improve(guess, x), x))
      if_callByName(goodEnough(guess, x), guess, iter(improve(guess, x), x))
    }
    iter(1.0, x)
  }

  def square(x: Double): Double = x * x

  def goodEnough(guess: Double, x: Double): Boolean =
    math.abs(square(guess) - x) < 0.001

  def improve(guess: Double, x: Double): Double =
    average(guess, x / guess)

  def average(x: Double, y: Double): Double =
    (x + y) / 2

  println("sqrt(54) = " + sqrt(54))
}
