object Exercise_1_34 extends App {

  def square(i: Int): Int = i * i

  def f(g: Int => Int) = g(2)

  println("(f square) = " + f(square))

  println("(f (lambda (z) (* z (+ z 1)))) = " + f(z => z * (z + 1)))

  // Trying to compile f(f) throws the following:
  //   [error]  found   : Int => Int => Int
  //   [error]  required: Int => Int
  //   [error]   f(f)
  //
}
