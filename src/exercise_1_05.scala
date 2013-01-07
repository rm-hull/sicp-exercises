/**
 * Exercise 1.5. Ben Bitdiddle has invented a test to determine whether
 * the interpreter he is faced with is using applicative-order evaluation
 * or normal-order evaluation. He defines the following two procedures:
 *
 *  (define (p) (p))
 *
 *  (define (test x y)
 *    (if (= x 0)
 *        0
 *        y))
 *
 * Then he evaluates the expression
 *
 *  (test 0 (p))
 *
 * What behavior will Ben observe with an interpreter that uses applicative-
 * order evaluation? What behavior will he observe with an interpreter that
 * uses normal-order evaluation? Explain your answer. (Assume that the
 * evaluation rule for the special form if is the same whether the interpreter
 * is using normal or applicative order: The predicate expression is evaluated
 * first, and the result determines whether to evaluate the consequent or the
 * alternative expression.)
 */
object Exercise_1_05 extends App {

  def p: Int = p

  def test_callByName(x: => Int, y: => Int): Int = if (x == 0) 0 else y

  def test_callByValue(x: Int, y: Int): Int = if (x == 0) 0 else y

  println("test_callByName(0, p) = " + test_callByName(0, p))

  //  Above call doesn't evaluate p if it doesn't have to, whereas,
  //  this line below eagerly evaluates p regardless and hence runs
  //  on indefinitely
  //
  // println("test_callByValue(0, p) = " + test_callByValue(0, p))
}
