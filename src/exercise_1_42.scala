object Exercise_1_42 extends App {

  def inc(i: Int): Int = i + 1

  def square(i: Int): Int = i * i

  def compose[T](f: T => T, g: T => T) = { x: T => f(g(x)) }

  // Also partial function
  //def compose2[T](f: T => T, g: T => T)(x: T) = { f(g(x)) }

  println("((compose square inc) 6) = " + compose(square, inc)(6))
}
