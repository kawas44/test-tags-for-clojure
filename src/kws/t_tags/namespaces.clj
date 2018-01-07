(ns kws.t-tags.namespaces)

(create-ns 'a-ns-1)

(create-ns ^:foo ^{:bar "baz"} 'a-ns-2)
