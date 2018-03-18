import shapeless.tag
import shapeless.tag.@@

package object shapelessx {

  object tagValue {
    def apply[T](t: T) = new TaggedValue[T](t)
    class TaggedValue[T](t: T) {
      def @@[U]: T @@ U = tag[U].apply[T](t)
    }
  }

}


