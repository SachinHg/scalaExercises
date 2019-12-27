import Table._
object Main extends App {

  println("Table management for a restaurant")

  val twoSeater = createTwoSeaterTable(4)
  val fourSeater = createFourSeaterTable(3)
  val sixSeater = createSixSeaterTable(2)

  val restaurant = new Restaurant(List(twoSeater, fourSeater, sixSeater))
  println(restaurant.getEmptyNSeaterTables)

  restaurant.allotNSeater(2)
  restaurant.allotNSeater(2)
  restaurant.allotNSeater(2)
  restaurant.allotNSeater(2)
  restaurant.allotNSeater(2)
  println(restaurant.getEmptyNSeaterTables)
  restaurant.allotNSeater(2)
  restaurant.allotNSeater(3)
  restaurant.allotNSeater(2)
  restaurant.allotNSeater(4)
  restaurant.allotNSeater(6)
  println(restaurant.getEmptyNSeaterTables)
}
