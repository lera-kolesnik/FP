class RecursiveFunctions {

  import scala.annotation.tailrec

  /** Реализуйте функции для решения следующих задач. 
   * Примечание: Попытайтесь сделать все функции с хвостовой рекурсией, используйте аннотацию для подстверждения. 
   * рекурсия будет хвостовой если: 
   * 1. рекурсия реализуется в одном направлении 
   * 2. вызов рекурсивной функции будет последней операцией перед возвратом  */

  object RecursiveFunctions extends App {
    /* def length[A](as: List[A]): Int = { 
    @tailrec 
     def loop(rem: List[A], agg: Int): Int = rem match { 
     case Cons(_, tail) => loop(tail, agg + 1) 
     case Nil()         => agg 
     }  
      loop(as, 0)   } */

    /* a) Напишите функцию которая записывает в обратном порядке список: 
     *        def reverse[A](list: List[A]): List[A] 
     */
    def reverse[A](list: List[A]): List[A] = {
      @tailrec
      def loop(list: List[A], reverseList: List[A]): List[A] =
        list match {
          case headOfList :: listWithOutHead => loop(listWithOutHead, headOfList +: reverseList);
          case Nil => reverseList
        }

      loop(list, Nil)
    }

    // используйте функцию из пункта (a) здесь, не изменяйте сигнатуру 
    def testReverse[A](list: List[A]): List[A] = reverse(list)

    /* b) Напишите функцию, которая применяет функцию к каждому значению списка: 
     * def map[A, B](list: List[A])(f: A => B): List[B] 
     */
    def map[A, B](list: List[A])(f: A => B): List[B] = {
      @tailrec
      def loop(list: List[A], newList: List[B])(f: A => B): List[B] =
        list match {
          case headOfList :: listWithOutHead => loop(listWithOutHead, newList :+ f(headOfList))(f);
          case Nil => newList
        }

      loop(list, Nil)(f)
    }

    // используйте функцию из пункта  (b) здесь, не изменяйте сигнатуру 
    def testMap[A, B](list: List[A], f: A => B): List[B] = map(list)(f)

    /* c) Напишите функцию, которая присоединяет один список к другому: 
     *    def append[A](l: List[A], r: List[A]): List[A] 
     */
    def append[A](l: List[A], r: List[A]): List[A] = {
      @tailrec
      def loop(list: List[A], gluingList: List[A]): List[A] =
        list match {
          case headOfList :: listWithOutHead => loop(listWithOutHead, gluingList :+ headOfList);
          case Nil => gluingList
        }

      loop(l, r)
    }

    // используйте функцию из пункта  (c) здесь, не изменяйте сигнатуру 
    def testAppend[A](l: List[A], r: List[A]): List[A] = append(r, l)

    /* d) Напишите функцию, которая применяет функцию к каждому значению списка: 
     * def flatMap[A, B](list: List[A])(f: A => List[B]): List[B] 
     *
     * она получает функцию, которая создает новый List[B] для каждого элемента типа A в  
     * списке. Поэтому вы создаете List[List[B]].  */
    def flatMap[A, B](list: List[A])(f: A => List[B]): List[List[B]] = {
      @tailrec
      def loop(list: List[A], resultListOfList: List[List[B]])(f: A => List[B]): List[List[B]] =
        list match {
          case headOfList :: listWithOutHead => loop(listWithOutHead, resultListOfList :+ f(headOfList))(f);
          case Nil => resultListOfList
        }

      loop(list, Nil)(f)
    }

    // используйте функцию из пункта  (d) здесь, не изменяйте сигнатуру 
    def testFlatMap[A, B](list: List[A], f: A => List[B]): List[List[B]] = flatMap(list)(f)

    /* e) Вопрос: Возможно ли написать функцию с хвостовой рекурсией для `Tree`s? Если нет, почему? */
    /** нет, т.к. для реализации считывания необходимо получить данные, а лишь после проводить
     * необходимые вычисления. **/
    println("Test for testReverse(List(1, 2, 11, 21)) :\t " + testReverse(List(1, 2, 11, 21)));
    println("Test for testReverse(List(\"SomeString\",2,'c',21)) :\t " + testReverse(List("SomeString", 2, 'c', 21)));
    println("Test for testMap(List(1, 2, 11, 21),(i:Int) => 2 * i)) :\t " + testMap(List(1, 2, 11, 21), (i: Int) => 2 * i));
    println("Test for testMap(List(\"SomeString\",2,'c',4),(i:Any) => i.toString*2) :\t "
      + testMap(List("SomeString",
      2, 'c', 21), (i: Any) => i.toString * 2));
    println("Test for testAppend(List(1, 2, 11, 21),List(22, 23, 24)) :\t " + testAppend(List(1, 2, 11, 21),
      List(22, 23, 24)));
    println("Test for testFlatMap(List(1,2,3,4,5),((i:Int) => if (i % 2 == 0) List(i) else List(i*i))) :" +
      "\t " + testFlatMap(List(1, 2, 11, 21, 22), ((i: Int) => if (i % 2 == 0) List(i) else List(i * i))));
  }
}
