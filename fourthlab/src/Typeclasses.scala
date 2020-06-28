class Typeclasses {

  // a) Определите тайп-класс Reversable, который представляет в обратном порядке значения.  
  trait Reversable[T] {
    def reverse(line: T): T
  }

  // b) Реализуйте функцию Reverse для String. 
  object Reversable {

    implicit object RevesableString extends Reversable[String] {
      def reverse(line: String): String = line.reverse
    }

  }

  // примените тайп-класс-решение из пункта (a) здесь 
  def reversable[T](str: T)(implicit currentClass: Reversable[T]): T = currentClass.reverse(str)

  def testReversableString(str: String): String = reversable(str)

  // c) Определите тайп-класс Smash таким образом чтобы в нем была функция smash, которая выполняет операцию со значениями одного типа.  
  trait Smash[T] {
    def smash(a: T, b: T): T
  }

  // d) Реализуйте  функции Smash для типа Int и Double. 
  //    Используйте сложение для типа Int у умножение для типа Double. 
  // e) Реализуйте функцию Smash для типа String. Необходимо выполнить конкатенацию строк, которые будут получены в качестве параметра. 
  object Smash {

    implicit object SmashInt extends Smash[Int] {
      def smash(a: Int, b: Int): Int = a + b
    }

    implicit object SmashDouble extends Smash[Double] {
      def smash(a: Double, b: Double): Double = a * b
    }

    implicit object SmashString extends Smash[String] {
      def smash(a: String, b: String): String = a + b
    }

  }

  def smash[T](a: T, b: T)(implicit currentClass: Smash[T]): T = currentClass.smash(a, b)

  // примените тайп-класс-решение из пункта (d) здесь 
  def testSmashInt(a: Int, b: Int): Int = smash(a, b)

  // примените тайп-класс-решение из пункта (d) здесь 
  def testSmashDouble(a: Double, b: Double): Double = smash(a, b)

  // примените тайп-класс-решение из пункта (d) здесь 
  def testSmashString(a: String, b: String): String = smash(a, b)

  println("Test for testReversableString(\"SomeString\") :\t" + testReversableString("SomeString"))
  println("Test for testSmashInt(3, 7) :\t" + testSmashInt(3, 7))
  println("Test for testSmashDouble(3.3, 3) :\t" + testSmashDouble(3.3, 3))
  println("Test for testSmashString(\"Tom \",\"Rôvôn\") :\t" + testSmashString("Tom ", "Rôvôn"))

}

// Реализуйте тестовые функции с выводом на экран проверки разработанных функций.

