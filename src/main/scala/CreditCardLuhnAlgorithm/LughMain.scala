object LuhnMain extends App {
  // Credit Card Luhn Algorithm
  def check(digits: String) = {
    val s = new StringBuilder

    for (i <- digits.length - 1 to 0 by -1)
      if (i % 2 == 1) {
        s.append(digits(i).asDigit * 2 )
      }
      else {
        s.append(digits(i))
      }
    if ((s.map(_+"").map(_.toInt).toList.sum) % 10 == 0) true else false
  }
  println(s"Credit card number is validated as ${check("49927398716")}")
}