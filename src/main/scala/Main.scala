
object Main extends App {

  // Basic
  // Hello World
  println("Basic exercises")
  println("-------------------------------------")
  println("Hello World")


  // Assignment
  var a = "Hello World"
  println("-------------------------------------")
  println("1. Assignment\n")

  println(a)

  // Parameters
  def parameters(name: String): Unit = println("My name is " + name)
  println("-------------------------------------")
  println("2. Parameters\n")

  parameters("Shirley")

  // Return types
  // below declares an anonymous function that takes a String argument and returns a String
  def returnString(firstName: String, lastName: String): String = {
    firstName + " " + lastName
  }
  println("-------------------------------------")
  println("3. Return Types\n")

  println(returnString("Bibi", "Fish"))


  // Type Inference
  // matching different types of argument
  def differentTypeReturn(x: Any): String = x match {
    case s: String => s + " is a String"
    case i: Int => i + " is an Int"
    case d: Double => d + " is a Double"
    case b: Boolean => b + " is a Boolean"
    case _ => "Unknown"
  }
  println("-------------------------------------")
  println("4. Type Inference\n")

  println(differentTypeReturn(null))


  // Strings
  def slice(word: String, num: Int): String = {
    word.substring(num - 1)
  }
  println("-------------------------------------")
  println("5. Strings\n")

  println("getting a substring: " + slice("hello", 3))

  // experimenting

  var word = "animal"
  var result = word.slice(2, 4)
  println(result)


  // Strings 2
  // if third appears in concate then fourth replaces all occurrences of third in concate --> map
  def joining(first: String, second: String, third: Char, fourth: Char): String = {
    val concate = first + second
    concate.map(b => if (b.equals(third)) fourth else b)
    // concate.replace(third, fourth)
  }
  println("-------------------------------------")
  println("6. Strings 2\n")

  println(joining("Ha", "llo", 'a', 'e'))
  println(joining("Fish", "ing", 'i', 'a'))

  // Operators
  def sum(numA: Int, numB: Int): Int = {
    numA + numB
  }
  println("-------------------------------------")
  println("7. Operators\n")

  println(sum(233, 545))

  // Conditionals
  def sum2(numA: Int, numB: Int, checkBoolean: Boolean): Int = {
    if (checkBoolean)
      numA + numB
    else
      numA * numB
  }
  println("-------------------------------------")
  println("8. Conditionals\n")

  println(sum2(23, 34, false))

  // Conditionals 2
  def sum3(numA: Int, numB: Int, checkBoolean: Boolean): Int = {
    if ((numA != 0) && (numB != 0)) {
      if (checkBoolean)
        numA + numB
      else
        numA * numB
    }
    else if (numA == 0)
      numB
    else if (numB == 0)
      numA
    else
      0
  }
  println("-------------------------------------")
  println("9. Conditionals 2\n")

  println(sum3(0, 0, false))

  // Iteration
  // repeat string by a given number and separating them each by newline
  def repeat(anything: String, num: Int): Unit = {
    List.fill(num)(println(anything))

  }
  println("-------------------------------------")
  println("10. Iteration\n")

  println(repeat("Hi", 3))

  // Iteration 2
  // like a matrix/ rectangle fashion
  def repeat2(anything: String, num: Int): Unit = {
    List.fill(num)(println(anything * num))
  }
  println("-------------------------------------")
  println("11. Iteration 2\n")

  println(repeat2("B", 6))

  // Iteration 3 - FizzBuzz
  def fizzBuzz(s1: String, s2: String, num: Int): Unit = {
    for (i <- 1 to num) {
      if ((i % 3 == 0) && (i % 5 == 0))
        println(s1 + s2)
      else if (i % 3 == 0)
        println(s1)
      else if (i % 5 == 0)
        println(s2)
      else
        println(i)
    }
  }
  println("-------------------------------------")
  println("12. Iteration 3 FizzBuzz\n")

  println(fizzBuzz("Fizz", "Buzz", 15))

  // Iteration 4
  def recursiveRepeat(s1: String, num: Int): Unit = {
    if (num == 1)
      println(s1)
    else {
      println(s1)
      recursiveRepeat(s1, num - 1)
    }
  }
  println("-------------------------------------")
  println("13. Iteration 4\n")

  recursiveRepeat("Hi", 3)

  // Pattern Matching 1
  def patMat(n1: Int, n2: Int, boo: Boolean) = (boo) match {
    case true => n1 + n2
    case false => n1 * n2
  }
  println("-------------------------------------")
  println("14. Pattern Matching 1\n")

  println(patMat(2, 7, false))

  // Pattern Matching 2
  def reverse(n1: Int, n2: Int) = (n1, n2) match {
    case (n1, n2) => n2 + ", " + n1
  }
  println("-------------------------------------")
  println("15. Pattern Matching 2\n")
  println(reverse(56, 93))

  def reverse2(x: Any): String = x match {
    case List(a, b) => "List is reversed as " + b + ", " + a //list
    case Array(a, b) => "Array is reversed as " + b + ", " + a // array
    case (a, b) => "Tuple is reversed as " + b + ", " + a // tuple
  }

  println("-------------------------------------")
  println("Through Lists, Arrays, Tuples\n")
  println(reverse2(List(4, 7)))
  println(reverse2(Array(2, 9)))
  println(reverse2((1, 8)))

  println()
  // Functional 1
//  println(java.util.TimeZone.getAvailableIDs.foreach(time => println(time)))
  println("-------------------------------------")
  print("16. Functional 1 \n\n")
  val tz = java.util.TimeZone.getAvailableIDs
       .map(str => str.split("/"))   // map to use lambda (inside the brackets is lambda function) to split "/" --> turns into array of strings
       .filter(str => str.length > 1)  // filter out array length that is <= 1
       .grouped(10)  // group the array into separate batches of 10, takes the array 1D into 2D i.e. an array of arrays,
                    // where the arrays contains strings
       .foreach(str => println(str(0)(1)))  // uses function as parameter in foreach method and iterates through collection
                                            // str(0)(1) takes the first thing of array and returns the second element
                                            // tells scala to print something


  // Intermediate
  // Blackjack
  var return_num = 0
  def blackjack (numA: Int, numB: Int): Int = {
    if ((numA > 21) & (numB > 21)) {
      return_num = 0
    }
    else if (numA > 21) {
      return_num = numB
    }
    else if (numA >= numB){
      return_num = numA
    }
    else if (numB > 21) {
      return_num = numA
    }
    else if (numB >= numA){
      return_num = numB
    }

    return return_num
  }

  println("\n" + blackjack(45, 50))

  // Unique Sum
  def uniqueSum(numA: Int, numB: Int, numC: Int): Int = {
    if (numA == numB && numB == numC) {
      0
    }
    else if (numA == numC)  {
      numB
    }
    else if (numB == numA)
      numC
    else
      numA + numB + numC
  }
  println(uniqueSum(3, 4, 2))

  def tooHot(temp: Int, check: Boolean): Boolean ={
    if (check)
    {
      (temp >= 60) && (temp <=100)
    }
    else
      (temp >= 60) && (temp <=90)
  }
  println(tooHot(95, false))



}
