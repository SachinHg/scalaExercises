
class Restaurant(val tables: List[Table]) {

  val TABLE_TYPES = List(2,4,6)

  def getEmptyNSeaterTables: Unit = {
    tables.foreach(table =>
      println(s"Empty tables with ${table.seats} are ${table.number}")
    )
  }

  private def getSeater(seats: Int): Table = {
    val nSeater =
      if (seats <= 2) tables.filter(t => t.seats == 2)
      else if (seats <= 4) tables.filter(t => t.seats == 4)
      else tables.filter(t => t.seats == 6)
    val seaterType = nSeater.head
    return seaterType
  }

  private def unableToAllotTable(): Unit = println(s"Unable to allocate table as all the tables are full.")

  private def allotNextAvailableTable(nextOption: Int): Unit = {
      if(nextOption == 2){
        unableToAllotTable()
        return
      }
      val nextEmptyTableType = getSeater(TABLE_TYPES(nextOption+1))
      if(nextEmptyTableType.number == 0){
        allotNextAvailableTable(nextOption+1)
      } else {
        nextEmptyTableType.number -= 1
      }
  }

  def allotNSeater(seats: Int) = {
    val seaterType = getSeater(seats)
    val emptyTablesAvailable = seaterType.number
    if (emptyTablesAvailable == 0) {
      val indexInGlobalList = TABLE_TYPES.indexOf(seats)
      allotNextAvailableTable(indexInGlobalList)
    }else{
      seaterType.number -= 1
    }
  }

  def emptyNSeater(seats: Int) = {
    val seaterType = getSeater(seats)
    seaterType.number += 1
  }

  override def toString: String = s"Tables are ${tables}"

}
