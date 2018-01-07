(ns kws.t-tags.protocols2
  (:require [kws.t-tags.protocols :as p]))

(extend-protocol p/Proto1
  String
  (proto-fn1 [this] this))

(defrecord Proto2Record [x]
  kws.t-tags.protocols/Proto2
  (proto-fn2 [_] (str x)))
