import Moves._
import org.scalatest.WordSpec


class MovesSpec extends WordSpec {

  val before: State = Vector(new Glass(10, 3), new Glass(5, 1))

  "EmptyMove" should {
    "empty specific glass" in {
      val index = 0
      val after = Empty(index).perform(before)
      assert(after(index).contains === before(index).empty.contains)
    }
  }

  "FillMove" should {
    "full specific glass" in {
      val index = 1
      val after = Fill(index).perform(before)
      assert(after(index).contains === before(index).full.contains)
    }
  }

  "PourMove" should {
    "pour to specific glass" in {
      val (from, to) = (1, 0)
      val after = Pour(from, to).perform(before)
      assert(after(to).contains === (before(from).contains + before(to).contains))
      assert(after(from).contains === 0)
    }
  }
}
