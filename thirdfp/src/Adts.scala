import scala.util.{Try, Failure, Success}
class Adts {
  /** Реализуйте следующие функции. 
   *
   * List(1, 2) match { 
   * case head :: tail => ??? 
   * case Nil          => ??? 
   * case l            => ??? 
   * } 
   *   
   * Option(1) match { 
   * case Some(a) => ??? 
   * case None    => ??? 
   * } 
   *   
   * Either.cond(true, 1, "right") match { 
   * case Left(i)  => ??? 
   * case Right(s) => ??? 
   * } 
   *
   * Try(impureExpression()) match { 
   * case Success(a)     => ??? 
   * case Failure(error) => ??? 
   * } 
   *   
   * Try(impureExpression()).toEither 
   *
   */ object Adts extends App {

    // a) Дан List[Int], верните элемент с индексом n 
    def getNth(list: List[Int], index: Int): Option[Int] = Some(list(index))

    // примените функцию из пункта (a) здесь, не изменяйте сигнатуру  
    def testGetNth(list: List[Int], n: Int): Option[Int] = getNth(list, n)

    //b) Напишите функцию, увеличивающую число в два раза.    
    def double(n: Option[Int]): Option[Int] = Some(n.get * 2)

    // примените функцию из пункта (b) здесь, не изменяйте сигнатуру 
    def testDouble(n: Option[Int]): Option[Int] = double(n)

    // c) Напишите функцию, проверяющую является ли число типа Int четным. Если так, верните Right.
    // В противном случае, верните Left("Нечетное число.").  
    def isEven(n: Int): Either[String, Int] = if (n % 2 == 0) Right(n) else Left("Нечетное число.")

    // примените функцию из пункта (c) здесь, не изменяйте сигнатуру 
    def testIsEven(n: Int): Either[String, Int] = isEven(n)

    // d) Напишите функцию, реализующую безопасное деление целых чисел.
    // Верните Right с результатом или Left("Вы не можете делить на ноль.").  
    def safeDivide(divisible: Int, divider: Int): Either[String, Int] =
      if (divider != 0) Right(divisible / divider)
      else Left("Вы не можете делить на ноль.")

    // примените функцию из пункта (d) здесь, не изменяйте сигнатуру 
    def testSafeDivide(a: Int, b: Int): Either[String, Int] = safeDivide(a, b)

    // e) Обработайте исключения функции с побочным эффектом вернув 0.   
    def goodOldJava(impure: String => Int, str: String): Try[Int] =
      Try(impure(str)) match {
        case Success(a) => Try(a)
        case Failure(e) => Try(0)
      }

    // примените функцию из пункта (e) здесь, не изменяйте сигнатуру 
    def testGoodOldJava(impure: String => Int, str: String):
    Try[Int] = goodOldJava(impure, str)

    println("Test for testGetNth(List(1, 1, 2, 3, 5, 8, 66, 4),2) :\t " + testGetNth(List(1, 1, 2, 3, 5, 8, 66, 4), 2));
    println("Test for testIsEven(3) :\t " + testIsEven(3));
    println("Test for testIsEven(2) :\t " + testIsEven(2));
    println("Test for testDouble(Some(2)) :\t " + testDouble(Some(2)));
    println("Test for testSafeDivide(2,0) :\t " + testSafeDivide(2, 0));
    println("Test for testSafeDivide(6,2) :\t " + testSafeDivide(4, 2));
    println("Test for testGoodOldJava((i:String) => i.toInt,\"4\") :\t " + testGoodOldJava((i: String) => i.toInt, "4"));
    println("Test for testGoodOldJava((i:String) => i.toInt,\"f\") :\t " + testGoodOldJava((i: String) => i.toInt, "f"));
  }
}
