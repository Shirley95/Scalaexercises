import scala.util.control._

object AdvancedExercises extends App {
  val loop = new Breaks
  var counter = 0
  var isPrime = true

  def primeNumber(limit: Int): Unit = {
    if (limit >= 2) {
      println("2")
      counter+= 1
    }

    for (i<- 3 to limit) {

      isPrime = true
      var sqrt = Math.sqrt(i)

      loop.breakable {
        for (j <- 2 to sqrt.toInt) {
          if (i % j == 0) {
            isPrime = false
            loop.break()
          }
        }
      }
      if (isPrime) {
        println(i)
        counter += 1
      }
    }
    println("Number of prime numbers = " + counter)
  }

  //println(primeNumber(1000000)) // 78498
  println(primeNumber(3000000)) // 216816     Therefore difference = 138318

}
