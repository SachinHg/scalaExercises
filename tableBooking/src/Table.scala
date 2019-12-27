abstract class Table{
  def seats: Int
  var number: Int
}

object Table {

  private class TwoSeaterTable(var number: Int) extends Table{
    override def seats: Int = 2
  }

  private class FourSeaterTable(var number: Int) extends Table{
    override def seats: Int = 4
  }

  private class SixSeaterTable(var number: Int) extends Table{
    override def seats: Int = 6
  }

  def createTwoSeaterTable(number: Int): Table = {
    new TwoSeaterTable(number)
  }

  def createFourSeaterTable(number: Int): Table = {
    new FourSeaterTable(number)
  }

  def createSixSeaterTable(number: Int): Table = {
    new SixSeaterTable(number)
  }

}