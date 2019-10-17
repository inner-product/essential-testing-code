package stateful

import org.scalacheck._
import org.scalacheck.commands.Commands
import scala.util._

object ATMProperties extends Properties("ATM") {
  property("commands") = ATMCommands.property()
}

object ATMCommands extends Commands {
  import Prop._

  /** The set of *authorized* users. */
  type State = Set[User]

  type Sut = ATM

  def canCreateNewSut(newState: State, initSuts: Traversable[State],
    runningSuts: Traversable[Sut]): Boolean = true

  def initialPreCondition(state: State): Boolean = ???

  def newSut(state: State): Sut = new MutableATM(???, ???)

  def destroySut(sut: Sut): Unit = ()

  def genInitialState: Gen[State] = Gen.const(Set.empty)

  def genCommand(state: State): Gen[Command] = ???

  case class Authorize(user: User, pass: Password) extends Command {
    type Result = Nothing

    def run(sut: Sut): Result = ???
    def nextState(state: State): State = ???
    def preCondition(state: State): Boolean = ???
    def postCondition(state: State, result: Try[Result]): Prop = ???
  }

  case class Balance(user: User) extends Command {
    type Result = Nothing

    def run(sut: Sut): Result = ???
    def nextState(state: State): State = ???
    def preCondition(state: State): Boolean = ???
    def postCondition(state: State, result: Try[Result]): Prop = ???
  }

  case class Withdraw(user: User, amount: Double) extends Command {
    type Result = Nothing

    def run(sut: Sut): Result = ???
    def nextState(state: State): State = ???
    def preCondition(state: State): Boolean = ???
    def postCondition(state: State, result: Try[Result]): Prop = ???
  }
}