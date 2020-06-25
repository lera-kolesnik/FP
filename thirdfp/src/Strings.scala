class Strings {
  /** Напишите ваши решения в тестовых функциях. 
   *
   * https://www.scala-lang.org/api/2.12.3/scala/collection/immutable/StringOps.html 
   */
   object Strings extends App{  
    /* a) Преобразуйте все символы типа Char в верхний регистр
    (не используйте заглавные буквы). 
    *     
    */ 
    def upperCase(line: String): String = line.toUpperCase; 
    def testUppercase(str: String): String = upperCase(str)  

    /* b) Вставьте следующие значения в строку: 
     * Hi my name is <name> and I am <age> years old. 
     *      
     */ 
    def interpolations(name:String,age:Int) :
    String = s"Hi my name is $name and I am $age years old." 
    def testInterpolations(name: String, age: Int): String =
      interpolations(name,age)  

    /* c) Добавьте два числа в следующую строку: 
     * Hi, 
     * now follows a quite hard calculation. We try to add: 
     * a := <value of a> 
     * b := <value of b> 
     *   
     * result is <a + b> 
     *
     */ 
    def computation(a: Int, b: Int): String = s"Hi,\nnow follows a quite hard calculation. " +
      s"We try to add:\n\ta := $a \n\tb := $b \n\nresult is ${a + b}" 
    def testComputation(a: Int, b: Int): String = computation(a, b)  

    /* d) Если длина строки равна 2, верните всю строку, иначе верните первые два символа строки. */ 
    def takeTwo(line: String): String = if (line.length==2) line else line.substring(0,2) 
    def testTakeTwo(str: String): String = takeTwo(str) 
    println("Test for testUppercase(\"Name534FSDhfgd&\") " +
      ":\t "+testUppercase("Name534FSDhfgd&")); 
    println("Test for testInterpolations(\"Name\", 4) :\t " + testInterpolations("Name",4)); 
    println("Test for testComputation(2,4) :\t "+testComputation(2, 4)); 
    println("Test for testTakeTwo(\"2,4\") :\t "+testTakeTwo("2, 4")); 
    println("Test for testTakeTwo(\"ss\") :\t "+testTakeTwo("ss")); 
  }
}
