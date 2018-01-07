(ns kws.t-tags.util
  (:require [clojure.set :as set]))

(defn ext-meta [a-meta]
  (let [all-keys (set (keys a-meta))
        black-keys #{:ns :name :arglists :file :column :line}
        white-keys (set/difference all-keys black-keys)]
    (select-keys a-meta white-keys)))

(defmacro meta-infos [sym]
  `(let [obj# ~sym
         a-meta# (meta obj#)]
     (println (str (or (:name a-meta#) (str obj#)) \space (ext-meta a-meta#)))))
