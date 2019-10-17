package stateful

trait ATM {
  /** Return true iff the password for the user is correct;
    * that user is then authorized for other requests. */
  def authorize(user: User, pass: Password): Boolean

  /** Return `Left(ATM.Error.Unauthorized)` if not previously authorized. */
  def balance(user: User): Either[ATM.Error, Amount]

  /** Return `Left(ATM.Error.Unauthorized)` if not previously authorized.
    * Return `Left(ATM.Error.NotEnoughFunds)` if the balance is less than 0. */
  def withdraw(user: User, amount: Double): Either[ATM.Error, Amount]
}

object ATM {
  sealed trait Error

  object Error {
    case object Unauthorized extends Error
    case object NotEnoughFunds extends Error
  }
}

case class User(name: String) extends AnyVal

case class Password(name: String) extends AnyVal

case class Amount(toDouble: Double) extends AnyVal {
  def -(d: Double): Amount = Amount(toDouble - d)
}

object Amount {
  implicit val ordering: Ordering[Amount] = Ordering.by(_.toDouble)
}

class MutableATM(passwords: Map[User, Password], initialBalances: Map[User, Amount]) extends ATM {
  import scala.math.Ordering.Implicits._

  var authorized = Set.empty[User]
  var balances = initialBalances

  def authorize(user: User, pass: Password): Boolean =
    passwords.get(user)
      .fold(false) { actualPass =>
        val result = actualPass == pass

        // WARNING: mutation!
        if (result) authorized = authorized + user

        result
      }

  def balance(user: User): Either[ATM.Error, Amount] =
    if (!authorized.contains(user)) Left(ATM.Error.Unauthorized)
    else Right(balances.getOrElse(user, Amount(0d)))

  def withdraw(user: User, amount: Double): Either[ATM.Error, Amount] =
    if (!authorized.contains(user)) Left(ATM.Error.Unauthorized)
    else {
      val balance = balances.getOrElse(user, Amount(0d)) - amount

      if (balance < Amount(0)) Left(ATM.Error.NotEnoughFunds)
      else {
        // WARNING: mutation!
        balances += user -> balance

        Right(balance)
      }
    }
}