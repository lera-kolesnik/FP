package exercise1

/* This task has no tests. It is an exercise for you to write different class structures.
 * 
 a) Создать класс Animal, который имеет следующие поля:
 *      - name: String (название)
 *      - species: String (вид)
 *      - food: String
 * 
 *    Синтаксис: class MyClass(val publicField: Int, privateField: String) {
 *              // остальные поля и методы
 *            }
 * 
 * b) Создайте объект-компаньон для класса Animal и добавьте следующие сущности как поля:
 *      - cat, mammal, meat
 *      - parrot, bird, vegetables
 *      - goldfish, fish, plants
 * 
 *    Синтаксис: object MyClass {
 *              // статические поля и методы
 *            }
 * 
 * c) Добавьте следующие метод в Animals:
 *      def eats(food: String): Boolean
 *    
 *     который проверяет ест ли животное определенную пищу
 * 
 * d) Переопределите ваш класс Animal как трейт и создайте объекты класса-образца для Mammals, Birds и Fishs.
 *    Вам все еще нужно поле `species`?
 * 
 * e) Добавьте следующие функции в объект-компаньон Animal:
 *      def knownAnimal(name: String): Boolean  // true если это имя одного из трех животных из (b)
 *      def apply(name: String): Option[Animal] // возвращает одно из трех животных в соответствии с именем (Some) или ничего (None), см. ниже
 * 
 * f) Создайте трейт Food со следующими классами-образцами:
 *      - Meat
 *      - Vegetables
 *      - Plants
 *   и добавьте это в определение Animal. Так же добавьте объект-компаньон с методом apply():
 *      def apply(food: String): Option[Food]
 */

  sealed trait Food
  case object Meat extends Food
  case object Vegetables extends Food
  case object Plants extends Food

  sealed trait  Animal {
  val name: String
    val food: Food
    def eats (food: Food): Boolean = this. food == food
}
case class Mammals (name: String, food: Food) extends  Animal
case class Birds (name: String, food: Food) extends  Animal
case class Fishes (name: String, food: Food) extends Animal

object Animal {
  val dog = Mammals("cat", Meat);
  val duck = Birds("duck", Vegetables);
  val goldfish = Fishes("goldfish, Plants");
  def knownAnimal(name: String): Boolean= {
    name match {
      case dog.name | duck.name | goldfish.name => true;
        case4 => false;
    }
  }
  def apply (name: String) : Option[Animal]= {
    name match {
      case dog.name => Some(dog);
      case duck.name => Some(duck);
      case goldfish.name => Some(goldfish);
      case4 => None;
    }
  }
}
  object Classes extends App {
    println("Test for Animal(\"dog\").get.eats(Meat) :\t " + Animal("dog").get.eats(Meat));
    println("Test for Animal.knownAnimal(\"fish\") :\t " + Animal.knownAnimal("fish"));
    println("Test for Animal.apply(\"goldfish\") :\t " + Animal.apply("goldfish"));
    println("Test for Animal.apply(\"fish\") :\t " + Animal.apply("fish"));
  }

