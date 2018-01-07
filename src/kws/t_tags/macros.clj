(ns kws.t-tags.macros)

(defmacro a-defmacro-1 [])
(defmacro ^{:bar "baz"} ^:foo ^String a-defmacro-2 [] "dm2")
