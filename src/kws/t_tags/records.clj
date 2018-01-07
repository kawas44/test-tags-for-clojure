(ns kws.t-tags.records)

(defrecord ARecord1 [a])
(defrecord ^{:foo "baz"} ^:bar ARecord2 [a])

(ARecord1. 1)
(->ARecord1 11)
(map->ARecord1 {:a 111})
(meta ARecord1)


(ARecord2. 2)
(->ARecord2 22)
(map->ARecord2 {:a 222})
(meta ARecord2)



;; test stuff defined in line comments [should not be in tags]
;(defrecord ^{:foo "baz"} ^:bar ARecord_BAD [a])
;  (defrecord ^{:foo "baz"} ^:bar ARecord_BAD [a])
  ;(defrecord ^{:foo "baz"} ^:bar ARecord_BAD [a])
  ;  (defrecord ^{:foo "baz"} ^:bar ARecord_BAD [a])
(defrecord ^{:foo ";baz"} ^:bar ARecord_ok [a])
