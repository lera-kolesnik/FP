class Maps {
  /** Напишите вашу реализацию в тестовые функции. 
   *
   * https://docs.scala-lang.org/overviews/collections/maps.html 
   */ 

  object Maps extends App {  
    case class User(name: String, age: Int)  
    /* a) В данной Seq[User] сгруппируйте пользователей по имени (`groupBy`) и
    вычислите средний возраст: `name -> averageAge` 
     * Вы можете реализовать ваше решение в теле тестовой функции. Не изменяйте сигнатуру. 
     */ 
    def testGroupUsers(users: Seq[User]): Map[String, Int] = { 
      users.groupBy(_.name).map(i => (i._1, i._2.foldLeft(0)(_ + _.age) / i._2.length)); 
    }  

    /* b) Дана `Map[String, User]` состоящая из имен пользователей `User`,
    сколько имен пользователей, содержащихся в Map, содержат подстроку "Adam"? 
    * Вы можете реализовать ваше решение в теле тестовой функции. Не изменяйте сигнатуру. 
    */ 
    def testNumberFrodos(map: Map[String, User]): Int = { 
      var countAdam = 0; 
      map.keys.foreach( i => if(map(i).name.indexOf("Adam") != -1) countAdam = countAdam+1) 
      countAdam 
    }
      
    /* c) Удалите всех пользователей возраст которых менее 35 лет. 
     * Вы можете реализовать ваше решение в теле тестовой функции. Не изменяйте сигнатуру. 
     */ 
    def testUnderaged(map: Map[String, User]): Map[String, User] = { 
      var map1: Map[String, User] = Map() 
      map.keys.foreach(i => if (map(i).age >= 35)
        map1 += i->User(map(i).name,map(i).age)) 
      map1 
    }
        println("Test for \ntestGroupUsers(Seq(User(\"name1\",3)," +
          "User(\"name1\",45),User(\"name1\",-1),User(\"name2\",100)," +
          "User(\"name3\",12),User(\"name2\",5))) :\t\n "+testGroupUsers(Seq(User("name1",3),
          User("name1",45),User("name1",-1),User("name2",100),User("name3",12),User("name2",5)))) 
    println("Test for \ntestNumberFrodos(Map((\"a\",User(\"name1\",5)),(\"b\"," +
      "User(\"name1Adam\",5)),(\"c\",User(\"Adam\",5)),(\"d\",User(\"name2\",5))," +
      "(\"e\",User(\"Adam\",5)),(\"f\",User(\"name3\",5)))) :\t\n "+testNumberFrodos(Map(("a",User("name1",5)),
      ("b",User("name1Adam",5)),("c",User("Adam",5)),("d",User("name2",5)),("e",User("Adam",5)),
      ("f",User("name3",5))))) 
    println("Test for \ntestUnderaged(Map((\"a\",User(\"name1\",55)),(\"b\",User(\"name1Adam\",5))," +
      "(\"c\",User(\"Adam\",5)),(\"d\",User(\"name2\",40)),(\"e\",User(\"Adam\",5))," +
      "(\"f\",User(\"name3\",5)))) :\t\n "+testUnderaged(Map(("a",User("name1",55)),
      ("b",User("name1Adam",5)),("c",User("Adam",5)),("d",User("name2",40)),("e",User("Adam",5)),
      ("f",User("name3",5))))) 
  }
}
