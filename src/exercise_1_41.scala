/**
 * Exercise 1.41. Define a procedure double that takes a procedure of one
 * argument as argument and returns a procedure that applies the original
 * procedure twice. For example, if inc is a procedure that adds 1 to its
 * argument, then (double inc) should be a procedure that adds 2. What value
 * is returned by
 *
 *  (((double (double double)) inc) 5)
 */
object Exercise_1_41 extends App {

  def inc(i: Int): Int = i + 1

  def double[T](f: T => T) = {
    x: T => f(f(x))
  }

  println("((double inc) 5) = " + double(inc)(5))

  println("(((double (double double)) inc) 5) = " + double(double[Int => Int])(double[Int])(inc)(5))
}
