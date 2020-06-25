class RecursiveData {

  /*  sealed trait List[A] 
  case class Cons[A](head: A, tail: List[A]) extends List[A] 
  case class Nil[A]() extends List[A] 
  */

  /* Напишите свои решения в виде функций. */
  object RecursiveData extends App {
    // a) Реализуйте функцию, определяющую является ли пустым `List[Int]`. 
    def listIntEmpty(list: List[Int]): Boolean = list.isEmpty

    // используйте функцию из пункта (a) здесь, не изменяйте сигнатуру 
    def testListIntEmpty(list: List[Int]): Boolean = listIntEmpty(list)

    // b) Реализуйте функцию, которая получает head `List[Int]`или возвращает -1 в случае если он пустой.  
    def listIntHead(list: List[Int]): Int = if (list.isEmpty) -1 else list.head

    // используйте функцию из пункта (a) здесь, не изменяйте сигнатуру 
    def testListIntHead(list: List[Int]): Int = listIntHead(list)

    // c) Можно ли изменить `List[A]` так чтобы гарантировать что он не является пустым?  
    def listIsNotEmpty[A](list: List[A], value: A): List[A] = if (list == Nil) list:+ value
    else list
    def testIsNotEmpty[A](list: List[A], value: A): List[A] = listIsNotEmpty(list, value)

    /* d) Реализуйте универсальное дерево (Tree) которое хранит значения в виде листьев и состоит из: 
   * node - левое и правое дерево (Tree) 
   * leaf - переменная типа A  */
    class Tree[A](ltNode: Tree[A], rNode: Tree[A], value: A)

    println("Test for testListIntEmpty(List()) :\t " + testListIntEmpty(List()));
    println("Test for testListIntEmpty(List(1, 11, 111)) :\t " + testListIntEmpty(List(1, 11, 111)));
    println("Test for testListIntHead(List()) :\t " + testListIntHead(List()));
    println("Test for testListIntHead(List(1, 11, 111)) :\t " + testListIntHead(List(1, 11, 111)));
    println("Test for testIsNotEmpty(List(),5.2) :\t " + testIsNotEmpty(List(), 5.2));
    println("Test for testIsNotEmpty(List(1.3, 3, 4),3.3) :\t " + testIsNotEmpty(List(1.3, 3, 4), 3.3));
  }
}