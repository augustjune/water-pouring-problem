import org.scalatest.WordSpec

class GlassSpec extends WordSpec {

  val maxCapacity = 10
  val glass = new Glass(maxCapacity, 3)

  "A Glass" when {
    "empty" must {
      "contain 0" in {
        assert(glass.empty.contains === 0)
      }
    }

    "full" must {
      "contain max capacity" in {
        assert(glass.full.contains === maxCapacity)
      }
    }

    "pour to another glass" must {
      "be empty if other glass has enough free space" in {
        val emptyGlass = new Glass(maxCapacity, 0)
        val (from, to) = glass.pourTo(emptyGlass)
        assert(from.contains === 0)
        assert(to.contains === glass.contains)
      }

      "stay untouched if other glass is full" in {
        val fullGlass = new Glass(3,3)
        val (from, to) = glass.pourTo(fullGlass)
        assert(from.contains === glass.contains)
        assert(to.contains === fullGlass.contains)
      }

      "pour only part which other glass can take" in {
        val maxCap = 5
        val initialCap = 4
        val partiallyFullGlass = new Glass(maxCap, initialCap)
        val (from, to) = glass.pourTo(partiallyFullGlass)
        assert(from.contains === glass.contains - (maxCap - initialCap))
        assert(to.contains === maxCap)
      }

    }
  }

}
