(ns kws.t-tags.multi-methods)

(defmulti multi1 class)

(defmethod multi1 String [x]
  (class x))

(multi1 "a string")


(defmulti ^{:bar "baz"} ^:foo ^long multi2 class)

(defmethod multi2 String [x]
  (count x))

(multi2 "a string")
