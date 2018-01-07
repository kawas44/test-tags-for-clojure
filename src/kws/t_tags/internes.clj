(ns kws.t-tags.internes)

(intern 'kws.t-tags 'an-interned-var-1)
(intern 'kws.t-tags ^:foo ^String ^{:bar "baz"} 'an-interned-var-2)
(intern 'kws.t-tags ^:foo ^String ^{:bar "baz"} 'an-interned-var-3 "iv3")
