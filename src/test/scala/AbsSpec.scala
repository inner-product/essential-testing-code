import org.scalacheck._
import org.scalacheck.Prop.forAll

object AbsSpec extends Properties("Abs") {
  property("non-negative") = forAll { (x: Int) =>
    Abs.abs(x) >= 0
  }
}
