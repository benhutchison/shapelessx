import shapeless.tag
import shapeless.tag.@@

package object shapelessx {

  object tagValue {
    def apply[T](t: T) = new TaggedValue[T](t)
    class TaggedValue[T](t: T) {
      def @@[U]: T @@ U = tag[U].apply[T](t)
    }
  }


  implicit def taggedIntOrdering[Tag]: Ordering[Int @@ Tag] = Ordering.by(_.toInt)

  implicit def taggedLongOrdering[Tag]: Ordering[Long @@ Tag] = Ordering.by(_.toLong)

  implicit def taggedDoubleOrdering[Tag]: Ordering[Double @@ Tag] = Ordering.by(_.toDouble)

}


