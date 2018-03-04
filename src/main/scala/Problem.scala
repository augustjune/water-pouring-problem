import Moves._

class Problem(glasses: Vector[Glass], target: Int) {
  def solution: Path = {
    val initialState: State = glasses

    val moves: Seq[Move] =
      (for (glass <- glasses.indices) yield Empty(glass)) ++
        (for (glass <- glasses.indices) yield Fill(glass)) ++
        (for (from <- glasses.indices; to <- glasses.indices if from != to) yield Pour(from, to))

    def possiblePathes(initial: (State, Path), history: List[Path]): Stream[(State, Path)] = ???

    Nil
  }

  private def isTargetState(state: State): Boolean = state.contains((g: Glass) => g.contains == target)
}
