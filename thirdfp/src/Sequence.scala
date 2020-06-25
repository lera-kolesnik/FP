import scala.annotation.tailrec
class Sequence {
      /* Напишите свои решения в тестовых функциях. 
     * Seq(1, 2) match { 
     * case head +: tail => ??? 
     * case Nil          => ??? 
     * case s            => ??? 
     * } 
     * https://www.scala-lang.org/api/2.12.0/scala/collection/Seq.html 
     */
   // Примечание: напишите функции с хвостовой рекурсией  
  object Sequence extends App{  
        /* a) Найдите последний элемент Seq. 
         *
         */ 
        def lastElement[A](seq: Seq[A]): Option[A] = { 
          @tailrec 
          def loop (seq: Seq[A]): Option[A] = 
            (seq.length) match  { 
              case 1 => Some(seq.head) 
              case _ => loop(seq.drop(1)) 
            } 
          loop(seq)  } 
        def testLastElement[A](seq: Seq[A]): Option[A] = lastElement(seq)  

        /* b) Объедините две Seqs (то есть Seq(1, 2) и Seq(3, 4) образуют
        Seq((1, 3), (2, 4))) - если Seq длиннее игнорируйте оставшиеся элементы. 
        *     
        */ 

        def zip[A](a: Seq[A], b: Seq[A]): Seq[(A, A)] = { 
          @tailrec 
          def loop (c: Seq[(A, A)],a: Seq[A], b: Seq[A]): Seq[(A, A)] = { 
            if (a.nonEmpty && b.nonEmpty)  { 
              loop(c:+(a.head,b.head),a.drop(1),b.drop(1)) 
            } 
            else  c 
          } 
          loop(Nil,a,b) 
        } 
        def testZip[A](a: Seq[A], b: Seq[A]): Seq[(A, A)] = zip(a,b)  

        /* c) Проверьте, выполняется ли условие для всех элементов в Seq. 
         *     
         */ 
        def forAll[A](seq: Seq[A])(cond: A => Boolean): Boolean = { 
          seq.forall(cond) 
        } 
        def testForAll[A](seq: Seq[A])(cond: A => Boolean): Boolean = forAll(seq)(cond)  

        /* d) Проверьте, является ли Seq палиндромом 
         *
         */ 
        def palindrom [A](seq: Seq[A]): Boolean = { 
          @tailrec 
          def loop (seq: Seq[A]): Boolean = { 
            if (seq.nonEmpty) 
              if (seq.head==seq.last) 
                loop(seq.drop(1).dropRight(1)) 
              else  false 
            else  true 
          } 
          loop(seq) 
        } 
        def testPalindrom[A](seq: Seq[A]): Boolean = palindrom(seq)  

        /* e) Реализуйте flatMap используя foldLeft. 
         *     
         */ 
        def flatMap[A, B](seq: Seq[A])(f: A => Seq[B]): Seq[B] =  seq.foldLeft(List[B]())((curr, acc) =>
          f(acc).foldLeft(curr)((inCurr, inAcc) => inAcc :: inCurr)).reverse 
        def testFlatMap[A, B](seq: Seq[A])(f: A => Seq[B]): Seq[B] =  flatMap(seq)(f) 
        println("Test for testLastElement(Seq(1,1,2,3,5,8,13,21)) :\t "+testLastElement(Seq(1,1,2,3,5,8,13,21))) 
        println("Test for testZip(Seq(1,1,2,3,8),Seq(1,1,2,3,8)) :\t "+testZip(Seq(1,1,2,3,5,8),Seq(1,1,2,3,8))) 
        println("Test for testForAll(Seq(1,1,2,3,8))(i =>{i%2==0}) :\t "+testForAll(Seq(1,1,2,3,8))(i =>{i%2==0})); 
        println("Test for testPalindrom(Seq(1,1,2,3,8)) :\t "+testPalindrom(Seq(1,1,2,3,8))); 
        println("Test for testPalindrom(Seq(1,2,3,4,2,1)) :\t "+testPalindrom(Seq(1,2,3,4,2,1))); 
        println("Test for testFlatMap(Seq(1,2,3,4,5))(i => Seq(i,i*2)) :\t "+testFlatMap(Seq(1,2,3,4,5))
        (i => Seq(i,i*2)));
       }

}
