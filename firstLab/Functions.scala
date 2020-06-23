package exercise1
/** Напишите отдельные функции, решающие поставленную задачу.
 *
 * Синтаксис:
 *   // метод
 *   def myFunction(param0: Int, param1: String): Double = // тело
 *
 *   // значение
 *   val myFunction: (Int, String) => Double (param0, param1) => // тело
 */

  object Functions extends App {
  /* a) Напишите функцию, которая рассчитывает площадь окружности
 *    r^2 * Math.PI
 */
  def circle(r: Double): Double = r * r * Math.PI;

  // примените вашу функцию из пункта (a) здесь, не изменяя сигнатуру
  def testCircle(r: Double): Double = circle(r);


  /* b) Напишите карированную функцию которая рассчитывает площадь прямоугольника a * b.
 */
  def rectangleArea(a: Double, b: Double): Double = a * b;

  // примените вашу функцию из пукта (b) здесь, не изменяя сигнатуру
  def testRectangleCurried(a: Double, b: Double): Double = rectangleArea(a, b);


  // c) Напишите не карированную функцию для расчета площади прямоугольника.

  def rectangleUc(a: Double, b: Double): Double = 0.5 * a * b;

  // примените вашу функцию из пункта (c) здесь, не изменяя сигнатуру
  def testRectangleUc(a: Double, b: Double): Double = rectangleUc(a, b);

  println("Testing testCircle(4):\t" + testCircle(4))
  println("Testing testRectangleCurried(4, 5):\t" + testCircle(4))
  println("Testing testRectangleUc(4, 4):\t" + testCircle(4))
}
