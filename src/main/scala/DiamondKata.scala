/**

 `diamond('C')` ==

   A
  B B
 C   C
  B B
   C

 */
object DiamondKata {
  def diamond(c: Char): List[String] =
    appendReversedTail(
      fromAUntil(c)
        .zipWithIndex
        .map(pad(c - 'A').tupled)
        .map(prefix => prefix + prefix.reverse.tail))

  private def appendReversedTail[A](as: List[A]): List[A] =
    as ::: as.reverse.tail

  private def fromAUntil(c: Char): List[Char] =
    ('A' to c).toList

  private def pad(width: Int) = (c: Char, lineNumber: Int) => {
    val leftPadding = " " * (width - lineNumber)
    val rightPadding = " " * lineNumber

    s"$leftPadding$c$rightPadding"
  }

  def main(args: Array[String]): Unit =
    println(diamond('C').mkString("\n"))
}