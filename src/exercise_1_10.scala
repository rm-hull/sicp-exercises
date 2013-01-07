object Exercise_1_10 extends App {

  def ackermann(x: Int)(y: Int): Int =
    if      (y == 0) 0
    else if (x == 0) 2 * y
    else if (y == 1) 2
    else ackermann(x - 1)(ackermann(x)(y - 1))

  println("(A 1 10) = " + ackermann(1)(10))
  println("(A 2 4)  = " + ackermann(2)(4))
  println("(A 3 3)  = " + ackermann(3)(3))

  def f = ackermann(0)_
  def g = ackermann(1)_
  def h = ackermann(2)_

  println("(f n) = " + (0 to 20 map f)) // --> f(n) = 2n
  println("(g n) = " + (0 to 20 map g)) // --> f(n) = 0 when n = 0; 2^n when n > 0
  println("(h n) = " + (0 to 4 map h)) // --> f(n) = 0 when n = 0; tetration of 2 when n > 0
}
