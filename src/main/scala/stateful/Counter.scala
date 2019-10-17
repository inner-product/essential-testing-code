package stateful

class Counter {
  private var n = 0

  def inc()   = n += 1
  def dec()   =
    // n -= 1
    if (n > 3) n -= 2 else n -= 1  // Bug!
  def get()   = n
  def reset() = n = 0
}