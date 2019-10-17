import org.scalacheck._

object DiamondKataSpec extends DiamondKataLaws("DiamondKata", DiamondKata.diamond)

// Note: must be `abstract`, otherwise `java.lang.NoSuchMethodException: diamond.DiamondKataLaws.<init>()`
abstract class DiamondKataLaws(name: String, diamond: Char => List[String]) extends Properties(name) {
  import Prop._

  property("oddNumberOfLines") =
    ???

  property("2n + 1 lines") =
    ???

  property("square") =
    ???

  property("top-bottom symmetry") =
    ???

  property("left-right symmetry") =
    ???
}