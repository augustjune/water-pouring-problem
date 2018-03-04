object Moves {

  trait Move {
    def perform(state: State): State

    def change(state: State)(glass: GlassId, f: Glass => Glass): State = state.updated(glass, f(state(glass)))
  }

  case class Empty(glass: GlassId) extends Move {
    def perform(state: State): State = change(state)(glass, _.empty)
  }

  case class Fill(glass: GlassId) extends Move {
    def perform(state: State): State = change(state)(glass, _.full)
  }

  case class Pour(from: GlassId, to: GlassId) extends Move {
    def perform(state: State): State = {
      val (source, dest) = state(from).pourTo(state(to))
      change(change(state)(from, _ => source))(to, _ => dest)
    }
  }

  type GlassId = Int
  type State = Vector[Glass]

  type Path = List[Move]
}
