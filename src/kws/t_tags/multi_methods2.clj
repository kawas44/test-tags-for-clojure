(ns kws.t-tags.multi-methods2
  (:require [kws.t-tags.multi-methods :as mm]))

(defmethod mm/multi1 Long [i]
  (class i))

(mm/multi1 42)


(defmethod kws.t-tags.multi-methods/multi2 Long [_]
  64)

(kws.t-tags.multi-methods/multi2 1)

