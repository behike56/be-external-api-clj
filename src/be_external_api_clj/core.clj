(ns be-external-api-clj.core
  (:gen-class)
  (:require
   [cljapi.system :as system]))

(defn -main
  [& _args]
  (system/start))
