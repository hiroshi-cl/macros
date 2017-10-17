package scala.macros.core

// typed trees
trait TypedTrees { this: Universe =>
  val typed: typedApi
  trait typedApi {
    // No typed TypeTree, Type can be converted to type tree automatically
    type Tree
    type Term

    def treePosition(tree: Tree): Position
    def treeSyntax(tree: Tree): String
    def treeStructure(tree: Tree): String

    def typeOf(tree: Term): Type
    def ref(sym: Symbol): Term

    // only for terms, no extractor for type trees
    def NameUnapply(tree: Tree): Option[Denotation]

    def Select(tree: Term, name: String): Term
    def SelectUnapply(tree: Tree): Option[(Term, Symbol)]

    def Apply(fun: Term, args: List[Term]): Term
    def ApplyUnapply(tree: Tree): Option[(Term, List[Term])]
  }
}
