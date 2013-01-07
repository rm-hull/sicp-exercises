/**
 * Exercise 1.6. Alyssa P. Hacker doesn't see why if needs to be provided as a
 * special form. "Why can't I just define it as an ordinary procedure in terms
 * of cond?" she asks. Alyssa's friend Eva Lu Ator claims this can indeed be
 * done, and she defines a new version of if:
 *
 *  (define (new-if predicate then-clause else-clause)
 *    (cond (predicate then-clause)
 *          (else else-clause)))
 *
 * Eva demonstrates the program for Alyssa:
 *
 *  (new-if (= 2 3) 0 5)
 *  5
 *
 *  (new-if (= 1 1) 0 5)
 *  0
 *
 * Delighted, Alyssa uses new-if to rewrite the square-root program:
 *
 *  (define (sqrt-iter guess x)
 *    (new-if (good-enough? guess x)
 *            guess
 *            (sqrt-iter (improve guess x)
 *                       x)))
 *
 * What happens when Alyssa attempts to use this to compute square roots?
 * Explain.
 */
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
