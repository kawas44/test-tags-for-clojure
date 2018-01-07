(ns kws.t-tags
  (:require [kws.t-tags.util :as u]
            [kws.t-tags.defines :as defines]
            [kws.t-tags.functions :as functions]
            [kws.t-tags.inlines :as inlines]
            [kws.t-tags.interfaces :as interfaces]
            [kws.t-tags.internes :as internes]
            [kws.t-tags.macros :as macros]
            [kws.t-tags.multi-methods :as multi-methods]
            [kws.t-tags.namespaces :as namespaces]
            [kws.t-tags.protocols :as protocols]
            [kws.t-tags.records :as records]
            [kws.t-tags.structs :as structs]
            [kws.t-tags.types :as types])
  (:import [kws.t_tags.records ARecord2]
           [kws.t_tags.interfaces Interface2])
  (:gen-class))


(defn -main
  "app entry point"
  [& args]
  (println "Test code execution")
  (u/meta-infos #'defines/once-2)
  (u/meta-infos #'defines/a-def-2)

  (u/meta-infos #'functions/a-defn-2)
  (u/meta-infos #'functions/a-defn--2)

  (u/meta-infos #'inlines/a-definline-2)

  (u/meta-infos Interface2)

  (u/meta-infos #'an-interned-var-2)
  (u/meta-infos #'an-interned-var-3)

  (u/meta-infos #'macros/a-defmacro-2)

  (u/meta-infos #'multi-methods/multi2)

  (u/meta-infos (find-ns 'a-ns-2))

  (u/meta-infos #'protocols/Proto2)

  (u/meta-infos ARecord2)

  (u/meta-infos #'structs/Struct2))

#_(-main)
