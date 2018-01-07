(ns kws.t-tags.protocols)

(defprotocol Proto1
  (proto-fn1 [this]))

(defrecord Proto1Record [x]
  Proto1
  (proto-fn1 [_] (str x)))


(defprotocol ^:bar ^{:foo "baz"} Proto2
  (proto-fn2 [this]))

(extend-protocol Proto2
  String
  (proto-fn1 [this] this))
