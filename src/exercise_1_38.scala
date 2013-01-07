/**
 * Exercise 1.38. In 1737, the Swiss mathematician Leonhard Euler published a
 * memoir De Fractionibus Continuis, which included a continued fraction
 * expansion for e - 2, where e is the base of the natural logarithms. In this
 * fraction, the N[i] are all 1, and the D[i] are successively 1, 2, 1, 1, 4, 1,
 * 1, 6, 1, 1, 8, .... Write a program that uses your cont-frac procedure from
 * exercise 1.37 to approximate e, based on Euler's expansion.
 */
object Exercise_1_38 extends App {

  def contFrac(numer: Int => Double, denom: Int => Double, k: Int): Double = {
    def iter(counter: Int): Double = {
      if (k == counter) numer(counter) / denom(counter)
      else numer(counter) / (denom(counter) + iter(counter + 1))
    }
    iter(1)
  }

  def e(k: Int): Double = {
    val n = { i: Int => 1.0 }
    val d = { i: Int => if ((i + 1) % 3 == 0) 2 * (i + 1) / 3 else 1.0 }
    2 + contFrac(n, d, k)
  }

  println("e = " + e(20))
}
