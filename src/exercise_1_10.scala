/**
 * Exercise 1.10. The following procedure computes a mathematical function
 * called Ackermann's function.
 *
 *  (define (A x y)
 *    (cond ((= y 0) 0)
 *          ((= x 0) (* 2 y))
 *          ((= y 1) 2)
 *          (else (A (- x 1)
 *                   (A x (- y 1))))))
 *
 * What are the values of the following expressions?
 *
 *  (A 1 10)
 *
 *  (A 2 4)
 *
 *  (A 3 3)
 *
 * Consider the following procedures, where A is the procedure defined above:
 *
 *  (define (f n) (A 0 n))
 *
 *  (define (g n) (A 1 n))
 *
 *  (define (h n) (A 2 n))
 *
 *  (define (k n) (* 5 n n))
 *
 * Give concise mathematical definitions for the functions computed by the
 * procedures f, g, and h for positive integer values of n. For example,
 * (k n) computes 5n^2.
 */
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
