/**
 * Exercise 1.42. Let f and g be two one-argument functions. The composition f
 * after g is defined to be the function x  f(g(x)). Define a procedure compose
 * that implements composition. For example, if inc is a procedure that adds 1
 * to its argument,
 *
 *  ((compose square inc) 6)
 *  49
 */
object Exercise_1_42 extends App {

  def inc(i: Int): Int = i + 1

  def square(i: Int): Int = i * i

  def compose[T](f: T => T, g: T => T) = { x: T => f(g(x)) }

  // Also partial function
  //def compose2[T](f: T => T, g: T => T)(x: T) = { f(g(x)) }

  println("((compose square inc) 6) = " + compose(square, inc)(6))
}
