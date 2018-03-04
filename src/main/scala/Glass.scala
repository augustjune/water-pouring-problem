class Glass(private val capacity: Int, val contains: Int) {
  def add(amount: Int): Glass = new Glass(capacity, contains + amount)

  def full: Glass = new Glass(capacity, capacity)

  def empty: Glass = new Glass(capacity, 0)

  def pourTo(to: Glass): (Glass, Glass) = {
    val amount = (to.capacity - to.contains) min this.contains
    (this.add(-amount), to.add(amount))
  }
}
