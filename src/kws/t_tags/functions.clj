(ns kws.t-tags.functions
  (:require [kws.t-tags.util :as u]))

(defn a-defn-1 [])
(defn ^:foo ^{:bar "baz"} ^String a-defn-2 [] "df2")

(defn- a-defn--1 [])
(defn- ^String ^{:bar "baz"} ^:foo a-defn--2 [] "df-2")

(fn a-fn-1 [])
(fn ^String ^{:bar "baz"} ^:foo a-fn-2 [] "f2")

(let [a-fn-l1 (fn a-fn-in-let-1 [])
      a-fn-l2 (fn ^:foo ^{:bar "baz"} ^String a-fn-in-let-2 [] "fl2")]
  {:res1 (a-fn-l1)
   :res2 (a-fn-l2)
   :meta2 (meta a-fn-l2)})

(letfn [(a-letfn-1 [])
        (^:foo ^{:bar "baz"} a-letfn-2 [] "lf2")]
  {:res1 (a-letfn-1)
   :res2 (a-letfn-2)
   :meta2 (meta a-letfn-2)})
