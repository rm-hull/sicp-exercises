object Exercise_1_41 extends App {

  def inc(i: Int): Int = i + 1

  def double[T](f: T => T) = {
    x: T => f(f(x))
  }

  println("((double inc) 5) = " + double(inc)(5))

  println("(((double (double double)) inc) 5) = " + double(double[Int => Int])(double[Int])(inc)(5))
}
