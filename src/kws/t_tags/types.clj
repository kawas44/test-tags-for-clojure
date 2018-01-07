(ns kws.t-tags.types)

(deftype AType1 [a b])

;; invalid
;;(deftype ^{:bar "baz"} ^:foo AType2 [a b])
