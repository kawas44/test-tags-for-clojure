(ns kws.t-tags.interfaces2
  (:import [kws.t_tags.interfaces Interface1]))

(defrecord Interface1Record2 [x]
  Interface1
  (^int method_1 [this] 12))

(defrecord Interface2Record2 [x]
  kws.t_tags.interfaces.Interface2
  (^int method_2 [this] 22))
