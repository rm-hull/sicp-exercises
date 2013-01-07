object Exercise_1_05 extends App {

  def p: Int = {
    p
  }

  def test_callByName(x: => Int, y: => Int): Int = if (x == 0) 0 else y

  def test_callByValue(x: Int, y: Int): Int = if (x == 0) 0 else y

  println("test_callByName(0, p) = " + test_callByName(0, p))

  //  Above call doesn't evaluate p if it doesn't have to, whereas,
  //  this line below eagerly evaluates p regardless and hence runs
  //  on indefinitely
  //
  // println("test_callByValue(0, p) = " + test_callByValue(0, p))


}
