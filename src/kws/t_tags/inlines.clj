(ns kws.t-tags.inlines)

(definline a-definline-1 [])
(definline ^{:bar "baz"} ^String ^:foo a-definline-2 [] "di2")
