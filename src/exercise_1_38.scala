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
