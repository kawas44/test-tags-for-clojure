(ns kws.t-tags.structs)

(defstruct Struct1 :a :b)
(struct Struct1 "a" "b")

(defstruct ^:foo ^{:bar "baz"} Struct2 :a :b)
(struct Struct2 "a" "b")
