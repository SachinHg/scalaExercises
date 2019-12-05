import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn._

object GameOfLife extends App {

  def getStateOfCell(i: Int, j: Int): String = {
    return universe(i)(j)
  }

  def getNeighbors(universe: Array[Array[String]], row: Int, col: Int): Array[String] = {
    var neighborsArray = new ArrayBuffer[String](8)
    neighborsArray += universe(row-1)(col)
    neighborsArray += universe(row-1)(col-1)
    neighborsArray += universe(row-1)(col+1)
    neighborsArray += universe(row)(col-1)
    neighborsArray += universe(row)(col+1)
    neighborsArray += universe(row-1)(col-1)
    neighborsArray += universe(row+1)(col+1)
    return neighborsArray.filter(n => n == "X" || n == "-").toArray
  }

  def isCellDead(state: String): Boolean =
    return state == "X"

  def setNextStateOfDeadCell(neighbors: Array[String]): String = {
    val noOfAliveNeighbors = neighbors.filter(x => x == "-").length
    if(noOfAliveNeighbors == 3){
      return "-"
    }
    return "X"
  }

  def setNextStateOfLiveCell(neighbors: Array[String]): String = {
    val noOfAliveNeighbors = neighbors.filter(x => x == "-").length
    if(noOfAliveNeighbors < 2 && noOfAliveNeighbors > 3){
      return "X"
    }
    return "-"
  }

  def nextStateOfCell(row: Int, col: Int): String = {
    val state = getStateOfCell(row, col)
    var nextState = "X"
    val neighbors = getNeighbors(universe, row, col)
    if(isCellDead(state)){
      nextState = setNextStateOfDeadCell(neighbors)
    } else {
      nextState = setNextStateOfLiveCell(neighbors)
    }
    return nextState
  }

  println("Welcome to Game of Life!")
  println("Enter the dimensions of the universe")
  val length = readInt()
  val breadth = readInt()

  val boundLength = length + 2
  val boundBreadth = breadth + 2

  var universe = Array.ofDim[String](boundLength,boundBreadth)

  var universeNext = Array.ofDim[String](boundLength,boundBreadth)

  for (i <- 1 until boundLength-1){
    for (j <- 1 until boundBreadth-1){
      universe(i)(j) = readLine()
    }
  }

  for (i <- 1 until boundLength-1){
    for (j <- 1 until boundBreadth-1){
      print (universe(i)(j))
    }
    print("\n")
  }
//
  for (i <- 1 until boundLength-1){
    for (j <- 1 until boundBreadth-1){
      universeNext(i)(j) = nextStateOfCell(i, j)
    }
  }

  for (i <- 1 until boundLength-1){
    for (j <- 1 until boundBreadth-1){
      print(universeNext(i)(j))
    }
    print("\n")
  }
}


