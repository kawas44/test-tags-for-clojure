(ns kws.t-tags.interfaces)

(definterface Interface1
  (^int method_1 []))

(defrecord Interface1Record1 [x]
  Interface1
  (^int method_1 [this] 11))


(definterface ^:foo ^{:bar "baz"} Interface2
  (^int method_2 []))

(defrecord Interface2Record1 [x]
  Interface2
  (^int method_2 [this] 21))
