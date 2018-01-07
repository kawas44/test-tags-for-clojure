(defproject clj-test-tags "0.1.0-SNAPSHOT"
  :description "Dummy project to test tag tools"
  :license {:name "MIT License"
            :url "https://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot kws.t-tags
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
