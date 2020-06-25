class Compositions {
  /** Option представляет собой контейнер, который хранит какое-то значение  
    * или не хранит ничего совсем, указывает, вернула ли операция результат или нет.  
    * Это часто используется при поиске значений или когда операции могут потерпеть неудачу,  
    *  и вам не важна причина.   
    * Комбинаторы называются так потому, что они созданы, чтобы объединять результаты.  
    *  Результат одной функции часто используется в качестве входных данных для другой.  
    * Наиболее распространенным способом, является использование их со стандартными структурами данных. 
    * Функциональные комбинаторы `map` и` flatMap` являются контекстно-зависимыми.  
    *  map - применяет функцию к каждому элементу из списка, возвращается список с тем же числом элементов. 
    * flatMap берет функцию, которая работает с вложенными списками и объединяет результаты. */

  object Compositions extends App {
    // a) Используйте данные функции. Вы можете реализовать свое решение прямо в тестовой функции.   // Нельзя менять сигнатуры   
    def testCompose[A, B, C, D](f: A => B)
                               (g: B => C)
                               (h: C => D): A => D = f andThen (g andThen (h))

    // b) Напишите функции с использованием `map` и `flatMap`. Вы можете реализовать свое решение прямо в тестовой функции. 
    // Нельзя менять сигнатуры   
    def testMapFlatMap[A, B, C, D](f: A => Option[B])
                                  (g: B => Option[C])
                                  (h: C => D): Option[A] => Option[D] = _.flatMap(f).flatMap(g).map(h)

    // c) Напишите функцию используя for. Вы можете реализовать свое решение прямо в тестовой функции. 
    // Нельзя менять сигнатуры   
    def testForComprehension[A, B, C, D](f: A => Option[B])
                                        (g: B => Option[C])
                                        (h: C => D): Option[A] => Option[D] = {
      for {a <- _
           b <- f(a)
           c <- g(b)} yield h(c)
    }

    println("Test for testCompose((i:Int)=>i+5)((i:Int) =>i+2)((i:Int) => i*i)(4) :\t " +
      "" + testCompose((i: Int) => i + 5)((i: Int) => i + 2)((i: Int) => i * i)(4));
    println("Test for testMapFlatMap((i:Int)=> if (i<0) Some(-i) else None)((i:Int)=> " +
      "if (i>10) Some(5*i) else Some(i-1))((i:Int)=>i*i)(Some(-3)) :\t " +
      "" + testMapFlatMap((i: Int) => if (i < 0) Some(-i)
    else
      None)((i: Int) =>
      if (i > 10) Some(5 * i)
      else
        Some(i - 1))((i: Int) => i * i)(Some(-3)));
    println("Test for testMapFlatMap((i:Int)=> if (i<0) Some(-i) else None)" +
      "((i:Int)=> if (i>10) Some(5*i) else Some(i-1))((i:Int)=>i*i)(Some(5))) :\t " +
      "" + testMapFlatMap((i: Int) => if (i < 0) Some(-i)
    else None)((i: Int) => if (i > 10) Some(5 * i)
    else Some(i - 1))((i: Int) => i * i)(Some(5)));
    println("Test for testMapFlatMap((i:Int)=> if (i<0) Some(-i) else None)((i:Int)=> " +
      "if (i>10) Some(5*i) else Some(i-1))((i:Int)=>i*i)(Some(-30)) :\t " +
      "" + testMapFlatMap((i: Int) => if (i < 0) Some(-i)
    else None)((i: Int) =>
      if (i > 10) Some(5 * i)
      else Some(i - 1))((i: Int) => i * i)(Some(-30)));
    println("Test for testMapFlatMap((i:Int)=> if (i<0) Some(-i) else None)((i:Int)=> " +
      "if (i>10) Some(5*i) else Some(i-1))((i:Int)=>i*i)(Some(-3)) :\t " +
      "" + testMapFlatMap((i: Int) =>
      if (i < 0) Some(-i)
      else None)((i: Int) =>
      if (i > 10) Some(5 * i)
      else Some(i - 1))((i: Int) => i * i)(Some(-3)));
  }
}