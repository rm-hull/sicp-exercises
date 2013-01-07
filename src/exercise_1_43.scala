object Exercise_1_43 extends App {
  import Exercise_1_42._

  def repeated[T](f: T => T, n: Int): T => T = {
    if (n == 1) f
    else compose(f, repeated(f, n - 1))
  }

  println("((repeated square 2) 5) = " + repeated(square, 2)(5))
}
