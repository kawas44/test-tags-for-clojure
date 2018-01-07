(ns kws.t-tags.defines)

(defonce once-1 "o1")
(defonce ^{:bar "baz"} ^String ^:foo once-2 "o2")

(def a-def-1 "d1")
(def ^String ^:foo ^{:bar "baz"} a-def-2 "d2")
